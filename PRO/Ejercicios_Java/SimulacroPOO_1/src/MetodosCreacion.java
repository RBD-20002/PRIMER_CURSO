import java.util.Scanner;

public class MetodosCreacion {

    //Metódo para validar la entrada del titulo
    public static String leerTitulo(Scanner sc) {
        while (true) {
            System.out.println("Introduce el titulo del album: ");
            String titulo = sc.nextLine();
            if (!titulo.isBlank()) return titulo;
            else System.out.println("EL titulo no puede estar en blanco");
        }
    }

    //Metodo para validar el nombre del artista
    public static String leerArtista(Scanner sc) {
        while (true) {
            System.out.println("Introduce el nombre del artista: ");
            String artistas = sc.nextLine();
            if (!artistas.isBlank()) return artistas;
            else System.out.println("Los artistas no pueden estar vacio");
        }
    }

    //Metodo para validar el año de publicacion el año de publicacion del album
    public static int leerAnoPub(Scanner sc) {
        while (true) {
            try {
                System.out.println("Ingresa el año de publicacion: ");
                int anoPublicacion = Integer.parseInt(sc.nextLine());
                if (anoPublicacion > 1800 && anoPublicacion < 2026) return anoPublicacion;
                else System.out.println("El año es invalido debe estar entre 1800-2026");
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Dato introducido invalido");
            }
        }
    }

    //Metodo para validar la cantidad de canciones del album
    public static int leerNumCanciones(Scanner sc) {
        while (true) {
            try {
                System.out.println("Introduce el numero de canciones del album: ");
                int numCanciones = Integer.parseInt(sc.nextLine());
                if (numCanciones >= 1) return numCanciones;
                else System.out.println("El numero de canciones no puede ser negativo");
            } catch (RuntimeException e) {
                System.out.println("ERROR: Dato introducido invalido");
            }
        }
    }

}
