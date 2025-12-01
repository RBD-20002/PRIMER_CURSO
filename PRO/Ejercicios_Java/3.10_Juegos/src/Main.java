import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestionJuegos GJ = new GestionJuegos();
        Scanner sc = new Scanner(System.in);

        int opcion = -1;
        do{
            try{
                InfoMenu.menu();
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion){
                    case 1 -> GJ.agregarJuego();
                    case 2 -> GJ.modificarJuego();
                    case 3 -> GJ.eliminarJuego();
                    case 4 -> GJ.buscarJuego();
                    case 5 -> GJ.listarJuego();
                    case 6 -> GJ.buscarPorConsola();
                    case 7 -> GJ.buscarPorPrecio();
                    case 8 -> System.out.println("HASTA LUEGO.....");
                    default -> System.out.println("OPCION INVALIDO");
                }
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        }while(opcion != 8);
    }
}
