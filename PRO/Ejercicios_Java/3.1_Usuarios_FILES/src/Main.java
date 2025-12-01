import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion;
        do{
            try{
                InfoMenu.menu();
                System.out.println("INTRODUCE UNA OPCION: ");
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion){
                    case 1 -> GestionUsuarios.agregarUsuarios();
                    case 2 -> GestionUsuarios.mostrarUsuarios();
                    case 3 -> GestionUsuarios.eliminarUsuarios();
                    case 4 -> GestionUsuarios.buscarUsuarios();
                    case 5 -> System.out.println("HASTA LUEGO.....");
                    default -> System.out.println("OPCION INVALIDA");
                }
            }catch(NumberFormatException e){
                System.out.println("ERROR: DATO INTRODUCIDO INVALIDO");
                opcion = -1;
            }
        }while(opcion != 5);
    }
}
