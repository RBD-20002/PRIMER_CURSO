import SQL.BancoDAO;
import SQL.Movimiento;
import SQL.Usuario;
import java.sql.SQLException;
import java.util.List;

public class GestionBanco {
    private final BancoDAO bancoDAO;

    public GestionBanco() {
        try{
            bancoDAO = new BancoDAO();
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }

    public void agregarCliente() {
        try{
            int dni = EntradaDatos.leerInt("dni");
            String nombre = EntradaDatos.leerString1("nombre");
            String apellido1 = EntradaDatos.leerString1("primer apellido");
            String apellido2 = EntradaDatos.leerString2("segundo apellido");
            String direccion = EntradaDatos.leerString1("direccion");
            double saldo = EntradaDatos.leerDouble("saldo");
            Usuario nuevo = new Usuario(0,dni,nombre,apellido1,apellido2,direccion,saldo);

            bancoDAO.insertUsuario(nuevo);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void eliminarCliente() {
        try{
            int id = EntradaDatos.leerInt("id");
            Usuario usuario = bancoDAO.selectUsuario(id);

            if(usuario == null){
                System.out.println("NO HAY CLIENTES PARA ELIMINAR");
                return;
            }

            bancoDAO.deleteUsuario(id);
            System.out.println("CLIENTE ELIMINADO");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void modificarCliente() {
        try{
            int id = EntradaDatos.leerInt("id");
            Usuario usuario = bancoDAO.selectUsuario(id);
            if(usuario == null){
                System.out.println("NO HAY CLIENTE CON ESE ID");
                return;
            }

            InfoMenu.menu2();
            int opcion = EntradaDatos.leerInt("opcion");
            switch (opcion){
                case 1: {
                    String apellido1 = EntradaDatos.leerString1("primer apellido");
                    String apellido2 = EntradaDatos.leerString2("segundo apellido");
                    usuario.setApellido1(apellido1);
                    usuario.setApellido2(apellido2);
                    bancoDAO.updateUsuario(usuario);
                    System.out.println("APELLIDOS MODIFICADOS");
                    break;
                }
                case 2: {
                    String direccion = EntradaDatos.leerString1("direccion");
                    usuario.setDireccion(direccion);
                    bancoDAO.updateUsuario(usuario);
                    System.out.println("DIRECCION MODIFICADO");
                    break;
                }
                case 3:
                    System.out.println("VOLVIENDO ATRAS....");
                    break;
                default:
                    System.out.println("OPCION INVALIDA");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void listarCliente() {
       try{
           List<Usuario> clientes = bancoDAO.selectAllUsuario();
           if(clientes == null){
               System.out.println("NO HAY CLIENTES ALMACENADOS");
               return;
           }
           System.out.println("CLIENTES");
           for(Usuario cliente : clientes){
               System.out.println(cliente);
           }
       }catch (SQLException e){
           System.out.println(e.getMessage());
       }
    }

    public void listarMovimientos() {
        try{
            List<Movimiento> movimientos = bancoDAO.selectAllMovimientos();
            if(movimientos == null) throw new SQLException("NO HAY MOVIMIENTOS REGISTRADOS");
            System.out.println("MOVIMIENTOS:");
            for(Movimiento movimiento : movimientos){
                System.out.println(movimiento);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void buscarPorCliente() {
        try{
            String nombre = EntradaDatos.leerString1("cliente");
            List<Usuario> clientes = bancoDAO.selectByNombre(nombre);

            if(clientes == null){
                System.out.println("NO HAY CLIENTES QUE CONTENGAN "+nombre.toUpperCase());
                return;
            }

            System.out.println("CLIENTES:");
            for(Usuario cliente : clientes){
                System.out.println(cliente);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void hacerTransferencia() {
        try{
            int id1 = EntradaDatos.leerInt("id origen");
            Usuario u1 = bancoDAO.selectUsuario(id1);

            int id2 = EntradaDatos.leerInt("id destino");
            Usuario u2 = bancoDAO.selectUsuario(id2);

            double monto = EntradaDatos.leerDouble("monto");
            bancoDAO.procedureTransaccion(u1,u2,monto);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
