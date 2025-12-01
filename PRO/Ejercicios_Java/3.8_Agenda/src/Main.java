import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestionAgenda ga = new GestionAgenda();
        Scanner sc = new Scanner(System.in);

        int opcion = -1;
        do{
            try{
                InfoMenu.menu();
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion){
                    case 1 -> ga.agregarContacto();
                    case 2 -> ga.modificarContacto();
                    case 3 -> ga.eliminarContacto();
                    case 4 -> ga.listarContactos();
                    case 5 -> ga.buscarPorNombre();
                    case 6 -> ga.buscarPorTelefono();
                    case 7 -> System.out.println("HASTA LUEGO.....");
                    default -> System.out.println("OPCION INVALIDA");
                }
            }catch (NumberFormatException | SQLException e){
                System.out.println("ERROR: DATO INTRODUCIDO INVALIDO");
            }
        }while(opcion != 7);

    }
}
