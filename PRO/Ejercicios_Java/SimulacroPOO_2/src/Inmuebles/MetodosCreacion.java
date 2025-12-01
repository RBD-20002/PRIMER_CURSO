package Inmuebles;

import java.util.Scanner;

// Clase creada especificamente para los metodos que se implementaran en la creacion de OBJETOS
public class MetodosCreacion {
    Scanner sc = new Scanner(System.in);

    //Metodo para validar el nombre de un inmueble que no sea casa ni piso
    public static String leerNombre(Scanner sc) {
        while (true) {
            System.out.println("Introduce el nombre del inmueble: ");
            String nombre = sc.nextLine();
            if (!nombre.isBlank()) return nombre;
            else System.out.println("El nombre no puede estar en blanco");
        }
    }

    //Metodo para validar el metraje de los inmuebles
    public static double leerMetraje(Scanner sc) {
        while (true) {
            try {
                System.out.println("Introduce el metraje: ");
                double metraje = Double.parseDouble(sc.nextLine());
                if (metraje >= 1) return metraje;
                else System.out.println("Metraje invalido");
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Dato introducido invalido");
            }
        }
    }

    //Metodo para validar el número de habitaciones
    public static int leerHabitacion(Scanner sc) {
        while (true) {
            try {
                System.out.println("Introduce el número de habitaciones: ");
                int habitaciones = Integer.parseInt(sc.nextLine());
                if (habitaciones >= 0) return habitaciones;
                else System.out.println("Habitaciones invalidas");
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Dato introducido invalido");
            }
        }
    }

    //Metodo para declarar si el inmueble tiene o no garaje
    public static boolean leerGaraje(Scanner sc) {
        boolean valor = false;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.println("¿Tiene garaje? S/N: ");
            String entrada = sc.nextLine().toUpperCase();
            if (entrada.equalsIgnoreCase("S")) return true;
            else if (entrada.equalsIgnoreCase("N")) return false;
            else System.out.println("Entrada no valida");
        }
        return valor;
    }

    //Metodo para validar la direccion de un inmueble
    public static String leerDireccion(Scanner sc) {
        while (true) {
            System.out.println("Ingresa la direccion: ");
            String direccion = sc.nextLine();
            if (!direccion.isBlank()) return direccion;
            else System.out.println("La direccion no puede estar en blanco");
        }
    }

    //Metodo para validar en que planta se encuentra el inmueble
    public static int leerPlanta(Scanner sc) {
        while (true) {
            try {
                System.out.println("Introduce el numero de planta o plantas:  ");
                int plantas = Integer.parseInt(sc.nextLine());
                if (plantas >= 1) return plantas;
                else System.out.println("Planta o plantas invalida");
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Dato introducido invalido");
            }
        }
    }

    //Metodo para declarar si el inmueble tiene o no piscina
    public static boolean leerPiscina(Scanner sc) {
        boolean valor = false;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.println("¿Tiene piscina? S/N: ");
            String entrada = sc.nextLine();
            if (entrada.equalsIgnoreCase("S")) return true;
            else if (entrada.equalsIgnoreCase("N")) return false;
            else System.out.println("Entrada no valida");
        }
        return valor;
    }

    //Metodo para validar la letra de un piso cuando se crea, los valores de la letra declárado en su clase
    public static String leerLetra(Scanner sc) {
        while (true) {
            System.out.print("Introduce la letra del piso [A,B,C,D,E,F]: ");
            String letra = sc.nextLine().trim().toUpperCase();
            if (letra.matches("[A-F]")) { // Verifica si es una sola letra entre A y F
                return letra;
            } else {
                System.out.println("Error: La letra debe ser entre A y F (en mayúsculas o minúsculas)");
            }
        }
    }
}
