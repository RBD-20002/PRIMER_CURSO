package SQL;
import java.io.*;
import java.sql.*;
import java.util.*;

public class ContactoDAO implements MetodosSQL {
    private Connection connection;

    public ContactoDAO() throws SQLException {
        Properties propiedades = new Properties();
        InputStream input = null;

        try {
            // 1. Intento cargar desde classpath
            input = getClass().getClassLoader().getResourceAsStream("propiedades.properties");

            // 2. Si no existe, crearlo en ubicación segura
            if (input == null) {
                System.out.println("Archivo no encontrado, creando uno nuevo...");

                // Ubicación segura en el directorio de trabajo actual
                File propFile = new File("3.8_Agenda/agenda_config.properties");

                crearArchivoPropiedadesPorDefecto(propFile);
                System.out.println("Archivo creado en: " + propFile.getAbsolutePath());

                input = new FileInputStream(propFile);
            }

            // Cargar propiedades
            propiedades.load(input);

            // Verificar propiedad esencial
            String url = propiedades.getProperty("db.url");
            if (url == null) {
                throw new SQLException("La propiedad 'db.url' no está definida");
            }

            // Establecer conexión
            this.connection = DriverManager.getConnection(url,
                    propiedades.getProperty("db.user", ""),
                    propiedades.getProperty("db.password", ""));

            crearTablaSiNoExiste();

        } catch (IOException e) {
            throw new SQLException("Error al manejar propiedades: " + e.getMessage(), e);
        }
    }

    private void crearArchivoPropiedadesPorDefecto(File archivoDestino) throws IOException {
        // Versión segura que evita NullPointerException
        if (archivoDestino.getParent() != null) {
            new File(archivoDestino.getParent()).mkdirs();
        }

        Properties prop = new Properties();
        prop.setProperty("db.url", "jdbc:sqlite:agenda.db");
        prop.setProperty("db.user", "");
        prop.setProperty("db.password", "");

        try (OutputStream output = new FileOutputStream(archivoDestino)) {
            prop.store(output, "Configuración automática generada");
        }
    }

    private void crearTablaSiNoExiste() throws SQLException {
        String sql = """
        CREATE TABLE IF NOT EXISTS contactos (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            nombre TEXT NOT NULL,
            apellido TEXT,
            telefono TEXT NOT NULL,
            email TEXT
        )""";  // Quité la coma extra y corregí la sintaxis

        try(Statement st = connection.createStatement()) {
            st.execute(sql);
        }
    }

    @Override
    public void insertContacto(Contacto contacto) throws SQLException{
        String sql = "INSERT INTO contactos (nombre,apellido,telefono,email) VALUES (?,?,?,?)";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, contacto.getNombre());
            ps.setString(2, contacto.getApellido());
            ps.setString(3, contacto.getTelefono());
            ps.setString(4, contacto.getEmail());
            ps.executeUpdate();
        }
    }

    @Override
    public void updateContacto(Contacto contacto) throws SQLException{
        String sql = "UPDATE contactos SET nombre=?, apellido=?, telefono=?, email=? WHERE id=?";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, contacto.getNombre());
            ps.setString(2, contacto.getApellido());
            ps.setString(3, contacto.getTelefono());
            ps.setString(4, contacto.getEmail());
            ps.setInt(5, contacto.getId());
            ps.executeUpdate();
        }
    }

    @Override
    public void deleteContacto(int id) throws SQLException{
        String sql = "DELETE FROM contactos WHERE id=?";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public List<Contacto> selectAllContacto() throws SQLException{
        List<Contacto> contactos = new ArrayList<>();
        String sql = "SELECT * FROM contactos";
        try(Statement st = connection.createStatement(); ResultSet rs = st.executeQuery(sql)){
            while(rs.next()){
                Contacto nuevo = new Contacto(rs.getInt("id"),rs.getString("nombre"),rs.getString("apellido"),rs.getString("telefono"),rs.getString("email"));
                contactos.add(nuevo);
            }
        }
        return contactos;
    }

    @Override
    public Contacto selectPorId(int id) throws SQLException{
        String sql = "SELECT * FROM contactos WHERE id=?";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) return new Contacto(rs.getInt("id"),rs.getString("nombre"),rs.getString("apellido"),rs.getString("telefono"),rs.getString("email"));
        }
        return null;
    }

    @Override
    public List<Contacto> selectPorNombre(String nombre) throws SQLException{
        List<Contacto> contactos = new ArrayList<>();
        String sql = "SELECT * FROM contactos WHERE nombre=?";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, "%"+nombre+"%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Contacto nuevo = new Contacto(rs.getInt("id"),rs.getString("nombre"),rs.getString("apellido"),rs.getString("telefono"),rs.getString("email"));
                contactos.add(nuevo);
            }
        }
        return contactos;
    }

    @Override
    public List<Contacto> selectPorTelefono(String telefono) throws SQLException{
        List<Contacto> contactos = new ArrayList<>();
        String sql = "SELECT * FROM contactos WHERE telefono=?";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, "%"+telefono+"%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Contacto contacto = new Contacto(rs.getInt("id"),rs.getString("nombre"),rs.getString("apellido"),rs.getString("telefono"),rs.getString("email"));
            }
        }
        return contactos;
    }
}
