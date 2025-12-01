package Gestion;

import Materiales.Libro;
import Materiales.Revista;
import Materiales.Tesis;
import Usuarios.Usuario;

import java.util.Scanner;

public class MetodosCreacion {

    public static String leerDatoString(Scanner sc) {
        while (true) {
            System.out.println("Introduce el dato: ");
            String titulo = sc.nextLine();
            if (!titulo.isBlank()) return titulo;
            else System.out.println("Lo introducido no es valido");
        }
    }

    public static int leerDatoEntero(Scanner sc) {
        while (true) {
            try {
                System.out.println("Introduce el dato: ");
                int entero = Integer.parseInt(sc.nextLine());
                if (entero >= 1) return entero;
                else System.out.println("Lo introducido no es valido");
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Dato introducido invalido");
            }
        }
    }

    public static int leerAnoPublicacion(Scanner sc) {
        while (true) {
            try {
                System.out.println("Introduce el dato: ");
                int anoPublicacion = Integer.parseInt(sc.nextLine());
                if (anoPublicacion >= 1500) return anoPublicacion;
                else System.out.println("El año no puede ser menor de 1500");
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Dato introducido invalido");
            }
        }
    }

    public static boolean leerEstado(Scanner sc) {
        boolean estado = false;
        boolean estadoValido = false;

        while (!estadoValido) {
            System.out.println("¿Esta disponible? S/N: ");
            String dato = sc.nextLine().toUpperCase();
            if (dato.equalsIgnoreCase("S")) return true;
            else if (dato.equalsIgnoreCase("N")) return false;
            else System.out.println("Estado no valido");
        }
        return estado;
    }

    public static Libro crearLibro(Scanner sc) {
        System.out.println("-".repeat(20));
        System.out.println("TITULO: ");
        String titulo = leerDatoString(sc);

        System.out.println("-".repeat(20));
        System.out.println("AUTOR: ");
        String autor = leerDatoString(sc);

        System.out.println("-".repeat(20));
        System.out.println("AÑO PUBLICACION: ");
        int anoPub = leerAnoPublicacion(sc);

        System.out.println("-".repeat(20));
        System.out.println("ISBN: ");
        String ISBN = leerDatoString(sc);

        System.out.println("-".repeat(20));
        System.out.println("NUMERO PAGINAS: ");
        int numPaginas = leerDatoEntero(sc);

        System.out.println("-".repeat(20));
        System.out.println("EDITORIAL: ");
        String editorial = leerDatoString(sc);

        System.out.println("-".repeat(20));
        System.out.println("Creado correctamente");
        System.out.println("-".repeat(20));
        return new Libro(titulo, autor, anoPub, Libro.Estado.DISPONIBLE, ISBN, numPaginas, editorial);
    }

    public static Revista crearRevista(Scanner sc) {
        System.out.println("-".repeat(20));
        System.out.println("TITULO: ");
        String titulo = leerDatoString(sc);

        System.out.println("-".repeat(20));
        System.out.println("AUTOR: ");
        String autor = leerDatoString(sc);

        System.out.println("-".repeat(20));
        System.out.println("AÑO PUBLICACION: ");
        int anoPub = leerAnoPublicacion(sc);

        System.out.println("-".repeat(20));
        System.out.println("NUMERO DE REVISTA: ");
        int numero = leerDatoEntero(sc);

        System.out.println("-".repeat(20));
        System.out.println("IMPRENTA: ");
        String imprenta = leerDatoString(sc);

        System.out.println("-".repeat(20));
        System.out.println("Creado correctamente");
        System.out.println("-".repeat(20));
        return new Revista(titulo, autor, anoPub, Revista.Estado.DISPONIBLE, numero, imprenta);
    }

    public static Tesis crearTesis(Scanner sc) {
        System.out.println("-".repeat(20));
        System.out.println("TITULO: ");
        String titulo = leerDatoString(sc);

        System.out.println("-".repeat(20));
        System.out.println("AUTOR: ");
        String autor = leerDatoString(sc);

        System.out.println("-".repeat(20));
        System.out.println("AÑO PUBLICACION: ");
        int anoPub = leerAnoPublicacion(sc);

        System.out.println("-".repeat(20));
        System.out.println("UNIVERSIDAD: ");
        String universidad = leerDatoString(sc);

        System.out.println("-".repeat(20));
        System.out.println("DEPARTAMENTO: ");
        String departamento = leerDatoString(sc);

        System.out.println("-".repeat(20));
        System.out.println("Creado correctamente");
        System.out.println("-".repeat(20));
        return new Tesis(titulo, autor, anoPub, Tesis.Estado.DISPONIBLE, universidad, departamento);
    }

    public static Usuario crearUsuario(Scanner sc) {
        System.out.println("-".repeat(20));
        System.out.println("NOMBRE: ");
        String nombre = leerDatoString(sc);

        System.out.println("-".repeat(20));
        System.out.println("APELLIDO: ");
        String apellido = leerDatoString(sc);

        System.out.println("-".repeat(20));
        System.out.println("Creado correctamente");
        System.out.println("-".repeat(20));
        return new Usuario(Usuario.getCodigo(), nombre, apellido);
    }
}
