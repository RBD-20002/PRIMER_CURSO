import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Gestion gt = new Gestion();

        int opcion = -1;
        do {
            InfoMenus.menu1();
            try {
                System.out.println("Elige un opcion para ejecutar: ");
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion) {
                    case 1 -> gt.listarAlbums();
                    case 2 -> gt.registrarAlbum();
                    case 3 -> gt.editarAlbum();
                    case 4 -> gt.eliminarAlbum();
                    case 5 -> System.out.println("Hasta luego");
                    default -> System.out.println("Opcion invalida");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Dato introducido invalido");
            }
        } while (opcion != 5);
    }
}