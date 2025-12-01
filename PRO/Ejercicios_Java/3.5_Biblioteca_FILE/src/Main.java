import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner sc = new Scanner(System.in);

        int opcion = -1;
        do{
            try{
                InfoMenu.menu();
                System.out.println("ELIGE UNA OPCION:");
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion){
                    case 1 -> Biblioteca.agregarLibro();
                    case 2 -> Biblioteca.listarLibro();
                    case 3 -> Biblioteca.buscarLibro();
                    case 4 -> Biblioteca.eliminarLibro();
                    case 5 -> System.out.println("HASTA LUEGO.....");
                    default -> System.out.println("OPCION INVALIDA");
                }
            }catch (NumberFormatException e){
                System.out.println("ERROR: DATO INTRODUCIDO INVALIDO");
            }
        }while (opcion != 5);
    }
}
