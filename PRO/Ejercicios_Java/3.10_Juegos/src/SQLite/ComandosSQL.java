package SQLite;
import java.sql.SQLException;
import java.util.List;

public interface ComandosSQL {
    void insertJuego(Juego juego) throws SQLException;
    void updateJuego(Juego juego) throws SQLException;
    void deleteJuego(int id) throws SQLException;
    Juego selectJuego(int id) throws SQLException;
    List<Juego> selectAllJuegos() throws SQLException;
    List<Juego> selectByConsola(String consola) throws SQLException;
    List<Juego> selectByPrecio(double min, double max) throws SQLException;
}
