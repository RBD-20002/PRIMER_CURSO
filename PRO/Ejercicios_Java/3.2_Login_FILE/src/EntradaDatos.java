import java.util.Scanner;

public class EntradaDatos {

    private static Scanner sc = new Scanner(System.in);

    public static String leerDato(String tipo) {
        while (true) {
            System.out.println("INTRODUCE DATO |" + tipo + "|:");
            String dato = sc.nextLine();
            if (!dato.isEmpty()) return dato;
            else System.out.println("EL DATO ES INVALIDO");
        }
    }
}
