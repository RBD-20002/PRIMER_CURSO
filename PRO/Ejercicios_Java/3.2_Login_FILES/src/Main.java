import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion = -1;
        do{
            try{
                InfoMenu.menu();
                System.out.println("INTRODUCE UNA OPCION: ");
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion){
                    case 1 -> GestionConexion.registrarConexion("Login");
                    case 2 -> GestionConexion.registrarConexion("Logout");
                    case 3 -> GestionConexion.mostrarLog();
                    case 4 -> System.out.println("HASTA LUEGO.....");
                    default -> System.out.println("OPCION INVALIDA");
                }
                System.out.println();
            }catch (NumberFormatException e){
                System.out.println("ERROR: DATO INTRODUCIDO INVALIDO");
            }
        }while (opcion != 4);
    }
}
