import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcion = -1;
        do {
            try{
                InfoMenu.menu();
                System.out.println("INTRODUCE LA OPCION: ");
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion){
                    case 1 -> GestorTareas.agregarTarea();
                    case 2 -> GestorTareas.mostrarTarea();
                    case 3 -> GestorTareas.eliminarTarea();
                    case 4 -> GestorTareas.crearCopiaSeguridad();
                    case 5 -> System.out.println("HASTA LUEGO........");
                    default -> System.out.println("DATO INVALIDO");
                }
            }catch (NumberFormatException e) {
                System.out.println("ERROR: DATO INTRODUCIDO INVALIDO");
            }
        }while(opcion != 5);
    }
}
