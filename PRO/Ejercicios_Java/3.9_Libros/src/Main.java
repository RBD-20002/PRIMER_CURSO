import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestionLibros gl = new GestionLibros();
        Scanner sc = new Scanner(System.in);

        int opcion = -1;
        do{
            try{
                InfoMenu.menu();
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion){
                    case 1 -> gl.agregarLibro();
                    case 2 -> gl.modificarLibro();
                    case 3 -> gl.borrarLibro();
                    case 4 -> gl.buscarPorId();
                    case 5 -> gl.listarLibros();
                    case 6 -> gl.buscarPorPrecio();
                    case 7 -> gl.buscarPorAutor();
                    case 8 -> System.out.println("HASTA LUEGO.....");
                    default -> System.out.println("OPCION INVALIDA");
                }
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        }while(opcion != 8);
    }
}
