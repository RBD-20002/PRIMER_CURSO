import Gestion.Biblioteca;
import Gestion.InfoMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Biblioteca bi = new Biblioteca();
        InfoMenu info = new InfoMenu();
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        do {
            try {
                info.menu1();
                System.out.println("Elige una opcion: ");
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion) {
                    case 1:
                        bi.agregarMaterialesUsuarios();
                        break;
                    case 2:
                        bi.registrarPrestamo();
                        break;
                    case 3:
                        bi.calcularMultas();
                        break;
                    case 4:
                        bi.filtrarMateriales();
                        break;
                    case 5:
                        bi.listarMaterialesUsuarios();
                        break;
                    case 6:
                        System.out.println("Adios, vuelva pronto");
                    default:
                        System.out.println("Opcion invalida");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Dato introducido invalido");
                opcion = -1;
            }
        } while (opcion != 6);
    }
}