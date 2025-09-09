import java.util.InputMismatchException;
import java.util.Scanner;

public class Nif {
    private static final char[] LETRAS = {
            'T','R','W','A','G','M','Y','F','P','D','X','B',
            'N','J','Z','S','Q','V','H','L','C','K','E'
    };

    private int dni;
    private char letra;

    public Nif() {}

    public Nif(int dni) {
        this.dni = dni;
        this.letra = obtenerLetra();
    }

    public void leer() {
        Scanner sc = new Scanner(System.in);
        boolean numCorrecto = false;
        while(!numCorrecto) {
            try {
                System.out.println("Introduzca el número del dni (sin letra)");
                dni = Integer.parseInt(sc.nextLine()); // numero = int(input("Introduzca un número") así era en Python
                if (Integer.toString(dni).length() <= 8) {
                    numCorrecto = true;
                }
            } catch (NumberFormatException exc) {
                System.out.println("Debe introducir un número de dni correcto (sin la letra)");
            }
        }
        letra = obtenerLetra();
        sc.close();
    }

    /**
     * Este método accede al array de letras que tiene las letras correspondientes al resultado de la
     * operación del módulo de 23, dividimos el número del dni entre 23 y el resto nos da la posición
     * del array correspondiente a la letra del cálculo
     * @return letra del dni
     */
    private char obtenerLetra() {
        return LETRAS[ dni % 23 ];
    }

    /**
     * Versión static de obtener letra
     * @return letra del dni
     */
    private static char obtenerLetra(int dni) {
        return LETRAS[ dni % 23 ];
    }

    @Override
    public String toString() {
        String toret = dni + "-" + letra;
        while(toret.length() < 10) toret = "0" + toret;
        return toret;
    }
}
