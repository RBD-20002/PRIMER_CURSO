package SQL;
import java.sql.SQLException;
import java.util.List;

public interface ComandosSQL {
    void insertLibro(Libro libro) throws SQLException;
    void updateLibro(Libro libro) throws SQLException;
    void deleteLibro(int id) throws SQLException;
    Libro selectLibro(int id) throws SQLException;
    List<Libro> selectAllLibro() throws SQLException;
    List<Libro> selectBeetwenPrecio(double precio1, double precio2) throws SQLException;
    List<Libro> selectLikeAutor(String autor) throws SQLException;
}
