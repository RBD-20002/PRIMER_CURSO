import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestionPropiedad propiedades = new GestionPropiedad();

        int opcion = -1;
        do{
            try{
                InfoMenu.menu();
                System.out.println("INTRODUCE LA OPCION: ");
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion){
                    case 1 -> GestionPropiedad.mostrarConf();
                    case 2 -> GestionPropiedad.modificarConf();
                    case 3 -> GestionPropiedad.restaurarConf();
                    case 4 -> System.out.println("HASTA LUEGO....");
                    default -> System.out.println("OPCION INVALIDA");
                }
            }catch (NumberFormatException e){
                System.out.println("ERROR: DATO INTRODUCIDO INVALIDO");
            }
        }while (opcion != 4);
    }
}
