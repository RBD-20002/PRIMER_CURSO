package SQL;
import java.sql.SQLException;
import java.util.List;

public interface ComandosSQL {
    void insertMovimientos(int idOrigen, int idDestino, double monto) throws SQLException;
    void insertUsuario(Usuario usuario) throws SQLException;
    void updateUsuario(Usuario usuario) throws SQLException;
    void deleteUsuario(int id) throws SQLException;
    void procedureTransaccion(Usuario origen, Usuario destino, double monto) throws SQLException;
    Usuario selectUsuario(int id) throws SQLException;
    List<Movimiento> selectAllMovimientos() throws SQLException;
    List<Usuario> selectAllUsuario() throws SQLException;
    List<Usuario> selectByNombre(String nombre) throws SQLException;
}
