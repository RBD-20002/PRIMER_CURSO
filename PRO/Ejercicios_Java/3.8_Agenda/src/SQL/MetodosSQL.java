package SQL;
import java.sql.SQLException;
import java.util.List;

public interface MetodosSQL {
    void insertContacto(Contacto contacto) throws SQLException;
    void updateContacto(Contacto contacto) throws SQLException;
    void deleteContacto(int id) throws SQLException;
    List<Contacto> selectAllContacto() throws SQLException;
    Contacto selectPorId(int id) throws SQLException;
    List<Contacto> selectPorNombre(String nombre) throws SQLException;
    List<Contacto> selectPorTelefono(String telefono) throws SQLException;
}
