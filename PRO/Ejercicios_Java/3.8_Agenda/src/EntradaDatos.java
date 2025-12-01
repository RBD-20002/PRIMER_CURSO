import java.util.Scanner;

public class EntradaDatos {

    private static final Scanner SC = new Scanner(System.in);

    public static String leerDato(String nombre){
        while (true){
            System.out.println("INTRODUCE DATO |"+nombre.toUpperCase()+"|:");
            String dato = SC.nextLine();
            if(!dato.isEmpty()) return dato;
            else System.out.println("EL DATO STRING ES INVALIDO");
        }
    }

    public static int leerInteger(String nombre) {
        while (true){
            try{
                System.out.println("INTRODUCE DATO |"+nombre.toUpperCase()+"|:");
                int dato = Integer.parseInt(SC.nextLine());
                if(dato > 0) return dato;
                else System.out.println("EL DATO ENTERO ES INVALIDO");
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
