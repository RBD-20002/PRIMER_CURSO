import java.time.LocalDateTime;
import java.util.Scanner;

public class EntradaDatos {
    private static Scanner sc = new Scanner(System.in);

    public static String leerDato(String nombre){
        while(true){
            System.out.println("INTRODUCE DATO|"+nombre.toUpperCase()+"|:");
            String dato = sc.nextLine();
            if(!dato.isEmpty()) return dato;
            else System.out.println("EL DATO NO PUEDE ESTAR VACIO");
        }
    }

    public static int leerNumero(String nombre) {
        while(true){
            System.out.println("INTRODUCE DATO |"+nombre.toUpperCase()+"|:");
            int dato = Integer.parseInt(sc.nextLine());
            if(dato >= 1500 && dato <= LocalDateTime.now().getYear()) return dato;
            else System.out.println("EL DATO ES INVALIDO");
        }
    }
}
