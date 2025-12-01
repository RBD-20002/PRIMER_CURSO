import java.util.Scanner;
public class EntradaDatos {

    private static Scanner sc = new Scanner(System.in);

    public static String leerDato(String entrada) {
        while(true){
            System.out.println("INTRODUCE DATO |"+entrada.toUpperCase()+"|:");
            String dato = sc.nextLine();
            if(!dato.isEmpty()) return dato;
            else System.out.println("EL DATO ES INVALIDO");
        }
    }

    public static int leerNumero(){
        while(true){
            try{
                int numero = Integer.parseInt(sc.nextLine());
                if(numero > 1) return numero;
                else System.out.println("DATO INVALIDO");
            }catch (NumberFormatException e){
                System.out.println("ERROR: DATO INTRODUCIDO INVALIDO");
            }
        }
    }
}
