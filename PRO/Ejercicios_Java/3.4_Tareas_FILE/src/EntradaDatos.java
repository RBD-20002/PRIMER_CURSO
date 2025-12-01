import java.util.Scanner;

public class EntradaDatos {

    private static final Scanner sc = new Scanner(System.in);

    public static String leerTarea() {
        while(true){
            System.out.println("INTRODUCE LA TAREA: ");
            String tarea = sc.nextLine();
            if(!tarea.isEmpty()) return tarea;
            else System.out.println("LA TAREA NO PUEDE ESTAR VACIA");
        }
    }

    public static int leerNumero() {
        while (true) {
            try {
                System.out.println("INTRODUCE EL NUMERO: ");
                int numero = Integer.parseInt(sc.nextLine());
                if (numero > 0) return numero;
                else System.out.println("EL NUMERO NO PUEDE SER NEGATIVO");
            }catch (NumberFormatException e){
                System.out.println("ERROR: DATO INVALIDO INTRODUCIDO");
            }
        }
    }
}
