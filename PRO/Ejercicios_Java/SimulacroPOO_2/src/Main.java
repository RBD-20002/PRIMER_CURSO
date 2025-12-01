import Menus.Gestion;
import Menus.InfoMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        InfoMenu menuP = new InfoMenu();
        Gestion gest = new Gestion();
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        do {
            InfoMenu.menu1();
            try {
                System.out.println("Elige una opcion: ");
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion) {
                    case 1 -> gest.RegistrarInmueble();
                    case 2 -> gest.PonerVenta();
                    case 3 -> gest.PonerAlquiler();
                    case 4 -> gest.ListarInmuebles();
                    case 5 -> gest.EliminarInmueble();
                    case 6 -> System.out.println("Hasta Luego");
                    default -> System.out.println("Opcion invalida");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Dato introducido invalido");
                opcion = -1;
            }
        } while (opcion != 6);
    }
}