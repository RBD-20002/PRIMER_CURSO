import SQL.*;
import java.sql.SQLException;
import java.util.List;

public class GestionAgenda {
    private ContactoDAO contactoDAO;

    public GestionAgenda() {
        try {
            contactoDAO = new ContactoDAO();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void agregarContacto() {
        String nombre = EntradaDatos.leerDato("nombre");
        String apellido = EntradaDatos.leerDato("apellido");
        String telefono = EntradaDatos.leerDato("telefono");
        String email = EntradaDatos.leerDato("email");
        Contacto nuevo = new Contacto(0,nombre,apellido,telefono,email);
        try{
            contactoDAO.insertContacto(nuevo);
        }catch (SQLException e){
            System.out.println("ERROR: AGREGAR GA");
        }
    }

    public void modificarContacto() throws SQLException {
        int id = EntradaDatos.leerInteger("id");
        Contacto contacto = contactoDAO.selectPorId(id);

        if(contacto == null){
            System.out.println("CONTACTO NO ENCONTRADO");
            return;
        }
        String nombre = EntradaDatos.leerDato("nombre");
        String apellido = EntradaDatos.leerDato("apellido");
        String telefomo = EntradaDatos.leerDato("telefono");
        String email = EntradaDatos.leerDato("email");

        contacto.setNombre(nombre);
        contacto.setApellido(apellido);
        contacto.setTelefono(telefomo);
        contacto.setEmail(email);

        contactoDAO.updateContacto(contacto);
        System.out.println("CONTACTO MODIFICADO");
    }

    public void eliminarContacto() throws SQLException {
        int id = EntradaDatos.leerInteger("id");
        Contacto contacto = contactoDAO.selectPorId(id);

        if(contacto == null){
            System.out.println("CONTACTO NO ENCONTRADO");
            return;
        }
        contactoDAO.deleteContacto(id);
        System.out.println("CONTACTO ELIMINADO");
    }

    public void listarContactos() throws SQLException {
        System.out.println("CONTACTOS:");
        List<Contacto> contactos = contactoDAO.selectAllContacto();
        for(Contacto contacto : contactos){
            System.out.println(contacto);
        }
    }

    public void buscarPorNombre() throws SQLException {
        String nombre = EntradaDatos.leerDato("nombre");
        List<Contacto> contactos = contactoDAO.selectPorNombre(nombre);

        if(contactos.isEmpty()){
            System.out.println("NO SE ENCONTRARON CONTACTOS");
            return;
        }
        for(Contacto contacto : contactos){
            System.out.println(contacto);
        }
    }

    public void buscarPorTelefono() throws SQLException {
        String telefono = EntradaDatos.leerDato("telefono");
        List<Contacto> contactos = contactoDAO.selectPorTelefono(telefono);

        if(contactos.isEmpty()){
            System.out.println("NO SE ENCONTRARON TELEFONOS");
            return;
        }
        for(Contacto contacto : contactos){
            System.out.println(contacto);
        }
    }
}
