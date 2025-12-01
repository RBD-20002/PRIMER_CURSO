import java.util.Scanner;

public class EntradaDatos {

    private static final Scanner SC = new Scanner(System.in);

    public static String leerString1(String nombre){
        while(true){
            System.out.println("INTRODUCE DATO |"+nombre.toUpperCase()+"|:");
            String dato = SC.nextLine();
            if(!dato.isEmpty()) return dato;
            else System.out.println("DATO "+nombre.toUpperCase()+" INVALIDO");
        }
    }

    public static String leerString2(String nombre){
        System.out.println("INTRODUCE DATO |"+nombre.toUpperCase()+"|:");
        return SC.nextLine();

    }

    public static int leerInt(String nombre){
        while (true){
            try{
                System.out.println("INTRODUCE DATO |"+nombre.toUpperCase()+"|:");
                int dato = Integer.parseInt(SC.nextLine());
                if(dato > 0) return dato;
                else System.out.println("DATO "+nombre.toUpperCase()+" INVALIDO");
            }catch (NumberFormatException e){
                System.out.println("DATO "+nombre.toUpperCase()+" INVALIDO");
            }
        }
    }

    public static double leerDouble(String nombre){
        while (true){
            try{
                System.out.println("INTRODUCE DATO |"+nombre.toUpperCase()+"|:");
                double dato = Double.parseDouble(SC.nextLine());
                if(dato >= 0) return dato;
                else System.out.println("DATO "+nombre.toUpperCase()+" INVALIDO");
            }catch (NumberFormatException e){
                System.out.println("DATO "+nombre.toUpperCase()+" INVALIDO");
            }
        }
    }
}
