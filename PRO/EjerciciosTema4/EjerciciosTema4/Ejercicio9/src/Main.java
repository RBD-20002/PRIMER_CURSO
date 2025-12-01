import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final String[] nombresDePrueba = {"Dani", "Paco", "Luís", "Ana", "Laura", "Fer", "Susana"};

    public static void main(String[] args) {
        Pelicula pelicula = new Pelicula("Harry Potter y el Cáliz de Fuego", 157, 12, "Mike Newell");
        System.out.println(pelicula);
        SalaCine sala = new SalaCine(5, 6, 11, pelicula);
        System.out.println(sala);
        Random random = new Random();
        int numEspectadores = random.nextInt(45) + 1;
        for (int i = 0; i < numEspectadores && sala.hayButacaDisponible(); i++) {
            Espectador e = new Espectador(
                    nombresDePrueba[random.nextInt(nombresDePrueba.length)],
                    random.nextInt(45),
                    random.nextDouble(50));
            System.out.println("Espectador creado:");
            System.out.println(e);
            if (!sala.puedeSentarse(e)) {
                System.out.println(e.getNombre() + " no puede sentarse.");
                continue;
            }
            int fila;
            char columna;
            do {
                fila = random.nextInt(sala.getFilas());
                columna = (char) random.nextInt('A', 'A' + sala.getColumnas());
                if (!sala.butacaDisponible(fila, columna)){
                    System.out.println("Se intentó sentar al espectador en " + columna + " " + fila + " pero está ocupada");
                }
            } while (!sala.butacaDisponible(fila, columna));
            sala.ocuparButaca(e, fila, columna);
            System.out.println(e.getNombre() + " se ha sentado en " + columna + " " + fila);
        }
        System.out.println();
        System.out.println(sala);
        System.out.println("FIN");
    }
}
