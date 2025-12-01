package SQLite;
import java.io.*;
import java.sql.*;
import java.util.*;

public class JuegoDAO implements ComandosSQL{
    private final Connection connection;

    public JuegoDAO() throws SQLException{
        Properties propiedades = new Properties();
        String propFichero = "juego_config.properties";
        File fichero = new File(propFichero);

        try{
            if(!fichero.exists()){
                crearArchivoPorDefecto(fichero);
            }

            try(FileInputStream entrada = new FileInputStream(fichero)){
                propiedades.load(entrada);
            }

            String url = propiedades.getProperty("db.url");
            if(url == null){
                throw new SQLException("La propiedad 'db.url' no esta definida");
            }

            this.connection = DriverManager.getConnection(url);
            crearTablaSiNoExiste();
        }catch (IOException e){
            throw new SQLException("ERROR: FALLO PROPIEDADES");
        }
    }

    public void crearArchivoPorDefecto(File archivoDestino) throws IOException{
        Properties prop = new Properties();
        prop.setProperty("db.url","jdbc:sqlite:juegos.db");
        prop.setProperty("db.user","");
        prop.setProperty("db.password","");

        try(FileOutputStream salida = new FileOutputStream(archivoDestino)){
            prop.store(salida, "Configuracion de la base de datos de juegos hecha");
        }
    }

    public void crearTablaSiNoExiste() throws SQLException{
        String sql = """
                CREATE TABLE IF NOT EXISTS juegos(
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                titulo TEXT NOT NULL,
                consola TEXT NOT NULL,
                anoPub INTEGER NOT NULL,
                precio DECIMAL(8,2) NOT NULL
                )""";
        try(Statement st = connection.createStatement()){
            st.execute(sql);
        }
    }

    @Override
    public void insertJuego(Juego juego) throws SQLException{
        String sql = "INSERT INTO juegos (titulo, consola, anoPub, precio) VALUES (?,?,?,?)";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, juego.getTitulo());
            ps.setString(2, juego.getConsola());
            ps.setInt(3, juego.getAnoPub());
            ps.setDouble(4, juego.getPrecio());
            ps.executeUpdate();
        }
    }

    @Override
    public void updateJuego(Juego juego) throws SQLException{
        String sql = "UPDATE juegos SET titulo=?, consola=?, anoPub=?, precio=? WHERE id=?";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, juego.getTitulo());
            ps.setString(2, juego.getConsola());
            ps.setInt(3, juego.getAnoPub());
            ps.setDouble(4, juego.getPrecio());
            ps.setInt(5, juego.getId());
            ps.executeUpdate();
        }
    }

    @Override
    public void deleteJuego(int id) throws SQLException{
        String sql = "DELETE FROM juegos WHERE id=?";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public Juego selectJuego(int id) throws SQLException{
        String sql = "SELECT * FROM juegos WHERE id=?";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Juego(rs.getInt("id"),rs.getString("titulo"),rs.getString("consola"),rs.getInt("anoPub"),rs.getDouble("precio"));
            }
        }
        return null;
    }

    @Override
    public List<Juego> selectAllJuegos() throws SQLException{
        List<Juego> juegos = new ArrayList<>();
        String sql = "SELECT * FROM juegos";
        try(PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                Juego nuevo = new Juego(rs.getInt("id"),rs.getString("titulo"),rs.getString("consola"),rs.getInt("anoPub"),rs.getDouble("precio"));
                juegos.add(nuevo);
            }
        }
        return juegos;
    }

    @Override
    public List<Juego> selectByConsola(String consola) throws SQLException{
        List<Juego> juegos = new ArrayList<>();
        String sql = "SELECT * FROM juegos WHERE consola=?";
        try(PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                Juego nuevo = new Juego(rs.getInt("id"),rs.getString("titulo"),rs.getString("consola"),rs.getInt("anoPub"),rs.getDouble("precio"));
                juegos.add(nuevo);
            }
        }
        return juegos;
    }

    @Override
    public List<Juego> selectByPrecio(double min, double max) throws SQLException{
        List<Juego> juegos = new ArrayList<>();
        String sql = "SELECT * FROM juegos WHERE precio BETWEEN min=? ADN max=?";
        try(PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                Juego nuevo = new Juego(rs.getInt("id"),rs.getString("titulo"),rs.getString("consola"),rs.getInt("anoPub"),rs.getDouble("precio"));
                juegos.add(nuevo);
            }
        }
        return juegos;
    }
}
