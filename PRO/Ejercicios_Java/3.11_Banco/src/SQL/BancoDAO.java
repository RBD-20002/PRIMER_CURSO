package SQL;
import java.io.*;
import java.sql.*;
import java.util.*;

public class BancoDAO implements ComandosSQL {
    private final Connection connection;

    public BancoDAO() throws SQLException{
        Properties properties = new Properties();
        String propertiesFichero = "banco_config.properties";
        File fichero = new File(propertiesFichero);

        try{
            if(!fichero.exists()){
                crearPropiedadesPorDefecto(fichero);
            }

            try(FileInputStream fis = new FileInputStream(fichero)){
                properties.load(fis);
            }

            String url = properties.getProperty("db.url");
            if(url == null){
                throw new SQLException("La propiedad 'db.url' no esta definida");
            }

            this.connection = DriverManager.getConnection(url);
            crearTablaClienteSiNoExiste();
            crearTablaMovimientoSiNoExiste();
        }catch (IOException e){
            throw new SQLException("ERROR: FALLO PROPIEDADES");
        }


    }

    public void crearPropiedadesPorDefecto(File archivoDestino) throws IOException{
        Properties propiedades = new Properties();
        propiedades.setProperty("db.url","jdbc:sqlite:banco.db");
        propiedades.setProperty("db.user","");
        propiedades.setProperty("db.password","");

        try(FileOutputStream salida = new FileOutputStream(archivoDestino)){
            propiedades.store(salida,"Configuracion de BASE DATOS hecho");
        }
    }

    public void crearTablaClienteSiNoExiste() throws SQLException{
        String sql = """
                CREATE TABLE IF NOT EXISTS clientes(
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                dni INTEGER NOT NULL,
                nombre TEXT NOT NULL,
                apellido1 TEXT NOT NULL,
                apellido2 TEXT NULL,
                direccion TEXT NOT NULL,
                saldo DOUBLE(8,2) DEFAULT 0.0
                )""";
        try(Statement st = connection.createStatement()){
            st.execute(sql);
        }
    }

    public void crearTablaMovimientoSiNoExiste() throws SQLException{
        String sql = """
                CREATE TABLE IF NOT EXISTS movimientos(
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                idOrigen INTEGER NOT NULL,
                idDestino INTEGER NOT NULL,
                monto DOUBLE(8,2) NOT NULL,
                fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                FOREIGN KEY (idOrigen) REFERENCES clientes(id),
                FOREIGN KEY (idDestino) REFERENCES clientes(id)
                )""";
        try(Statement st = connection.createStatement()){
            st.execute(sql);
        }
    }

    @Override
    public void insertMovimientos(int idOrigen, int idDestino, double monto) throws SQLException {
        String sql = "INSERT INTO movimientos (idOrigen, idDestino, monto) VALUES (?,?,?)";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1, idOrigen);
            ps.setInt(2, idDestino);
            ps.setDouble(3, monto);
            ps.executeUpdate();
        }
    }

    @Override
    public void insertUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO clientes (dni,nombre,apellido1,apellido2,direccion,saldo) VALUES (?,?,?,?,?,?)";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1, usuario.getDni());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getApellido1());
            ps.setString(4, usuario.getApellido2());
            ps.setString(5, usuario.getDireccion());
            ps.setDouble(6, usuario.getSaldo());
            ps.executeUpdate();
        }
    }

    @Override
    public void updateUsuario(Usuario usuario) throws SQLException{
        String sql = "UPDATE clientes SET dni=?, nombre=?, apellido1=?, apellido2=?, direccion=?, saldo=? WHERE id=?";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1, usuario.getDni());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getApellido1());
            ps.setString(4, usuario.getApellido2());
            ps.setString(5, usuario.getDireccion());
            ps.setDouble(6, usuario.getSaldo());
            ps.setInt(7, usuario.getId());
            ps.executeUpdate();
        }
    }

    @Override
    public void deleteUsuario(int id) throws SQLException{
        String sql = "DELETE FROM clientes WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public void procedureTransaccion(Usuario origen, Usuario destino, double monto) throws SQLException{
        if(origen == null || destino == null) throw new SQLException("LOS USUARIOS NO PUEDEN SER NULL");
        if(monto <= 0) throw new SQLException("EL MONTO NO PUEDE SER NEGATIVO O IGUAL A 0");
        if(origen.getSaldo() < monto) throw new SQLException("SALDO INSUFICIENTE PARA TRANSFERIR, CUENTAS CON "+origen.getSaldo());

        try{
            connection.setAutoCommit(false);

            String sqlRestar = "UPDATE clientes SET saldo = saldo - ? WHERE id=?";
            try(PreparedStatement ps1 = connection.prepareStatement(sqlRestar)){
                ps1.setDouble(1, monto);
                ps1.setInt(2, origen.getId());
                ps1.executeUpdate();
            }

            String sqlSumar = "UPDATE clientes SET saldo = saldo + ? WHERE id=?";
            try(PreparedStatement ps2 = connection.prepareStatement(sqlSumar)){
                ps2.setDouble(1, monto);
                ps2.setInt(2, destino.getId());
                ps2.executeUpdate();
            }

            insertMovimientos(origen.getId(), destino.getId(), monto);
            connection.commit();
        }catch (SQLException e){
            connection.rollback();
            throw new SQLException("ERROR: FALLO LA TRANSACCION");
        }finally {
            connection.setAutoCommit(true);
        }
    }

    @Override
    public Usuario selectUsuario(int id) throws SQLException {
        String sql = "SELECT * FROM clientes WHERE id=?";
        try(PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()) {  // ← Ejecutar después de setInt
                if(rs.next()){
                    return new Usuario(rs.getInt("id"), rs.getInt("dni"), rs.getString("nombre"), rs.getString("apellido1"), rs.getString("apellido2"), rs.getString("direccion"), rs.getDouble("saldo"));
                }
            }
        }
        return null;
    }

    @Override
    public List<Movimiento> selectAllMovimientos() throws SQLException{
        List<Movimiento> movimientos = new ArrayList<>();
        String sql = "SELECT * FROM movimientos ORDER BY fecha DESC";
        try(PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                Movimiento mv = new Movimiento(rs.getInt("id"), rs.getInt("idOrigen"), rs.getInt("idDestino"), rs.getDouble("monto"), rs.getTimestamp("fecha").toLocalDateTime());
                movimientos.add(mv);
            }
        }
        return movimientos;
    }

    @Override
    public List<Usuario> selectAllUsuario() throws SQLException{
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        try(PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while(rs.next()){
                Usuario nuevo = new Usuario(rs.getInt("id"),rs.getInt("dni"),rs.getString("nombre"),rs.getString("apellido1"),rs.getString("apellido2"),rs.getString("direccion"),rs.getDouble("saldo"));
                usuarios.add(nuevo);
            }
        }
        return usuarios;
    }

    @Override
    public List<Usuario> selectByNombre(String nombre) throws SQLException{
        List<Usuario> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes WHERE nombre LIKE ?";
        try(PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                Usuario nuevo = new Usuario(rs.getInt("id"),rs.getInt("dni"),rs.getString("nombre"),rs.getString("apellido1"),rs.getString("apellido2"),rs.getString("direccion"),rs.getDouble("saldo"));
                clientes.add(nuevo);
            }
        }
        return clientes;
    }
}
