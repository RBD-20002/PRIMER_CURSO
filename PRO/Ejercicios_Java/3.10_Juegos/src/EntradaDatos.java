import java.time.LocalDateTime;
import java.util.Scanner;

public class EntradaDatos {

    private static final Scanner SC = new Scanner(System.in);

    public static String leerString(String nombre){
        while(true){
            System.out.println("INTRODUCE DATO |"+nombre.toUpperCase()+"|:");
            String dato = SC.nextLine();
            if(!dato.isEmpty()) return dato;
            else System.out.println("DATO TEXTO INVALIDO");
        }
    }

    public static int leerEntero(String nombre){
        while (true){
            try{
                System.out.println("INTRODUCE DATO |"+nombre.toUpperCase()+"|:");
                int dato = Integer.parseInt(SC.nextLine());
                if(dato > 0) return dato;
                else System.out.println("DATO ENTERO INVALIDO");
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int leerAnoPub(String nombre){
        while(true){
            try{
                System.out.println("INTRODUCE DATO |"+nombre.toUpperCase()+"|:");
                int dato = Integer.parseInt(SC.nextLine());
                if(dato > 1982 && dato < LocalDateTime.now().getYear()) return dato;
                else System.out.println("DATO AÑO INVALIDO");
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double leerPrecio(String nombre){
        while(true){
            try{
                System.out.println("INTRODUCE DATO |"+nombre.toUpperCase()+"|:");
                double dato = Double.parseDouble(SC.nextLine());
                if(dato > 0) return dato;
                else System.out.println("DATO FLOTANTE INVALIDO");
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        }
    }

}
