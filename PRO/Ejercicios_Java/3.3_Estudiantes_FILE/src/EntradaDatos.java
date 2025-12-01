import java.util.Scanner;

public class EntradaDatos {

    private static Scanner sc = new Scanner(System.in);

    public static String leerTexto(String datos){
        while(true){
            System.out.println("INTRODUCE DATO |"+datos+"|:");
            String dato = sc.nextLine();
            if(!dato.isEmpty()) return dato;
            else System.out.println("EL DATO ES INVALIDO");
        }
    }

    public static int leerNumero(){
        while(true){
            System.out.println("INTRODUCE LA NOTA");
            int nota = Integer.parseInt(sc.nextLine());
            if(nota >= 0 && nota <= 10) return nota;
            else System.out.println("LA NOTA ES INVALIDA");
        }
    }
}
