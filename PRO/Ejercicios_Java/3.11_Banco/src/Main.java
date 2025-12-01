import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestionBanco GB = new GestionBanco();

        int opcion;
        do {
            try{
                InfoMenu.menu1();
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion){
                    case 1 -> GB.agregarCliente();
                    case 2 -> GB.eliminarCliente();
                    case 3 -> GB.modificarCliente();
                    case 4 -> GB.listarCliente();
                    case 5 -> GB.listarMovimientos();
                    case 6 -> GB.buscarPorCliente();
                    case 7 -> GB.hacerTransferencia();
                    case 8 -> System.out.println("HASTA LUEGO......");
                    default -> System.out.println("OPCION INVALIDA");
                }
            }catch (NumberFormatException e){
                throw new NumberFormatException("ERROR: DATO INTRODUCIDO INVALO");
            }
        }while (opcion != 7);
    }
}
