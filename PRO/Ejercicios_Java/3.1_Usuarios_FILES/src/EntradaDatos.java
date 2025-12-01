import java.util.Scanner;

public class EntradaDatos {

    private static Scanner sc = new Scanner(System.in);

    public static String leerString(String palabra) {
        while(true){
            System.out.println("INTRODUCE DATO |"+palabra+"|:");
            String dato = sc.nextLine();
            if(!dato.isEmpty()) return dato;
            else System.out.println("EL DATO ES INVALIDO");
        }
    }

    public static int leerInt(String palabra) {
        while(true){
            System.out.println("INTRODUCE DATO |"+palabra+"|:");
            int dato = Integer.parseInt(sc.nextLine());
            if(dato > 0)return dato;
            else System.out.println("EL DATO ES INVALIDO");
        }
    }
}
