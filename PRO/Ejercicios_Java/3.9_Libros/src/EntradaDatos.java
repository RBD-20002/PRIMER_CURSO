import java.time.LocalDateTime;
import java.util.Scanner;

public class EntradaDatos {

    private static final Scanner SC = new Scanner(System.in);

    public static String leerString(String nombre){
        while(true){
            System.out.println("INTRODUCE DATO |"+nombre.toUpperCase()+"|:");
            String dato = SC.nextLine();
            if(!dato.isEmpty()) return dato;
            else System.out.println(nombre+" INVALIDO");
        }
    }

    public static int leerInteger(String nombre){
        while(true){
            try{
                System.out.println("INTRODUCE DATO |"+nombre.toUpperCase()+"|:");
                int dato = Integer.parseInt(SC.nextLine());
                if(dato > 0) return dato;
                else System.out.println(nombre+" INVALIDO");
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double leerDouble(){
        while(true){
            try{
                System.out.println("INTRODUCE DATO |PRECIO|: ");
                double precio = Double.parseDouble(SC.nextLine());
                if(precio > 0) return precio;
                else System.out.println("PRECIO INVALIDO");
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int leerAnoPub(){
        while(true){
            try{
                System.out.println("INTRODUCE DATO |AÑO PUBLICACION|: ");
                int dato = Integer.parseInt(SC.nextLine());
                if(dato > 1450 && dato < LocalDateTime.now().getYear()) return dato;
                else System.out.println("AÑO INVALIDO");
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
