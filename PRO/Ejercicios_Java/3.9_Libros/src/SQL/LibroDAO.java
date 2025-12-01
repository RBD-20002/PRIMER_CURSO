package SQL;
import java.io.*;
import java.sql.*;
import java.util.*;

public class LibroDAO implements ComandosSQL{
    private final Connection connection;

    public LibroDAO() throws SQLException {
        Properties propiedades = new Properties();
        String propFileName = "libro_config.properties";
        File propFile = new File(propFileName);

        try {
            // Si el archivo no existe, créalo
            if (!propFile.exists()) {
                crearArchivoPropiedadesPorDefecto(propFile);
            }

            // Cargar propiedades
            try (FileInputStream input = new FileInputStream(propFile)) {
                propiedades.load(input);
            }

            String url = propiedades.getProperty("db.url");
            if (url == null) {
                throw new SQLException("La propiedad 'db.url' no está definida");
            }

            this.connection = DriverManager.getConnection(url);
            crearTablaSiNoExiste();

        } catch (IOException e) {
            throw new SQLException("Error al manejar propiedades: " + e.getMessage(), e);
        }
    }

    private void crearArchivoPropiedadesPorDefecto(File archivoDestino) throws IOException {
        Properties prop = new Properties();
        prop.setProperty("db.url", "jdbc:sqlite:libros.db");
        prop.setProperty("db.user", "");
        prop.setProperty("db.password", "");

        try (FileOutputStream output = new FileOutputStream(archivoDestino)) {
            prop.store(output, "Configuración de la base de datos de libros");
        }
    }

    public void crearTablaSiNoExiste() throws SQLException{
        String sql = """
        CREATE TABLE IF NOT EXISTS libros(
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            titulo TEXT NOT NULL,
            autor TEXT NOT NULL,
            anoPub INTEGER NOT NULL,
            precio DOUBLE NOT NULL
        )""";

        try(Statement st = connection.createStatement()){
            st.execute(sql);
        }
    }

    @Override
    public void insertLibro(Libro libro) throws SQLException{
        String sql = "INSERT INTO libros (titulo,autor,anoPub,precio) VALUES (?,?,?,?)";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setInt(3, libro.getAnoPub());
            ps.setDouble(4, libro.getPrecio());
            ps.executeUpdate();
        }
    }

    @Override
    public void updateLibro(Libro libro) throws SQLException{
        String sql = "UPDATE libros SET titulo=?, autor=?, anoPub=?, precio=? WHERE id=?";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setInt(3, libro.getAnoPub());
            ps.setDouble(4, libro.getPrecio());
            ps.setInt(5, libro.getId());
            ps.executeUpdate();
        }
    }

    @Override
    public void deleteLibro(int id) throws SQLException{
        String sql = "DELETE FROM libros WHERE id=?";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public Libro selectLibro(int id) throws SQLException{
        String sql = "SELECT * FROM libros WHERE id=?";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return new Libro(rs.getInt("id"),rs.getString("titulo"),rs.getString("autor"),rs.getInt("anoPub"),rs.getDouble("precio"));
            }
        }
        return null;
    }

    @Override
    public List<Libro> selectAllLibro() throws SQLException{
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM libros";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Libro nuevo = new Libro(rs.getInt("id"),rs.getString("titulo"),rs.getString("autor"),rs.getInt("anoPub"),rs.getDouble("precio"));
                libros.add(nuevo);
            }
        }
        return libros;
    }

    @Override
    public List<Libro> selectBeetwenPrecio(double precio1, double precio2) throws SQLException{
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM libros WHERE precio BETWEEN ? AND ?";
        try(PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()){
            ps.setDouble(1, precio1);
            ps.setDouble(2, precio2);
            while(rs.next()){
                Libro nuevo = new Libro(rs.getInt("id"),rs.getString("titulo"),rs.getString("autor"),rs.getInt("anoPub"),rs.getDouble("precio"));
                libros.add(nuevo);
            }
        }
        return libros;
    }

    @Override
    public List<Libro> selectLikeAutor(String autor) throws SQLException{
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM libros WHERE autor=?";
        try(PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()){
            ps.setString(1, autor);
            while(rs.next()){
                Libro nuevo = new Libro(rs.getInt("id"),rs.getString("titulo"),rs.getString("autor"),rs.getInt("anoPub"),rs.getDouble("precio"));
                libros.add(nuevo);
            }
        }
        return libros;
    }

}
