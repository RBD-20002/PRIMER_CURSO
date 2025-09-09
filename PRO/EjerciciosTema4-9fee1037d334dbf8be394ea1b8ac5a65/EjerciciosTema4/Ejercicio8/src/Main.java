import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Persona> personas = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        leerPersonas();
        System.out.println("Número de personas introducidas: " + numeroDePersonas());
        System.out.println("Personas introducidas:");
        mostrar();
        System.out.println("Persona de mayor edad:");
        System.out.println(personaMayorEdad());
        System.out.println("Número de personas que viven en Vigo: " + cuantasPersonasVivenEn("Vigo"));
        System.out.println("Número de personas mayores de edad: " + personasMayoresDeEdad());
    }

    private static String leerDatoString(String nombreDato) {
        String dato = "";
        do {
            System.out.println("Introduzca " + nombreDato + " de la persona: ");
            dato = sc.nextLine();
            if (dato.isBlank()) System.out.println(nombreDato.substring(0,1).toUpperCase() +
                    nombreDato.substring(1).toLowerCase() + " debe tener contenido.");
        } while (dato.isBlank());
        return dato;
    }

    private static void leerPersonas() {
        int numPersonas = 0;
        String nombre = "", direccion = "", ciudad = "", codPostal = "";
        Fecha fecha = new Fecha();
        do {
            try {
                System.out.println("Introduzca el número de personas a añadir:");
                numPersonas = Integer.parseInt(sc.nextLine());
                if (numPersonas <= 0) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("El valor introducido debe ser un número positivo.");
            }
        } while (numPersonas <= 0);
        for (int i = 0; i < numPersonas; i++) {
            nombre = leerDatoString("el nombre");
            ciudad = leerDatoString("la ciudad");
            direccion = leerDatoString("la dirección");
            codPostal = leerDatoString("el código postal");
            do {
                try {
                    System.out.println("Introduzca la fecha de nacimiento:");
                    System.out.println("Día de nacimiento:");
                    int dia = Integer.parseInt(sc.nextLine());
                    System.out.println("Mes de nacimiento:");
                    int mes = Integer.parseInt(sc.nextLine());
                    System.out.println("Año de nacimiento:");
                    int year = Integer.parseInt(sc.nextLine());
                    fecha.setDia(dia);
                    fecha.setMes(mes);
                    fecha.setAnio(year);
                } catch (NumberFormatException e) {
                    System.out.println("Debe introducir números válidos.");
                }
                if (!Fecha.fechaCorrecta(fecha)) System.out.println("La fecha debe ser correcta.");
            } while (!Fecha.fechaCorrecta(fecha));
            personas.add(new Persona(nombre, direccion, ciudad, codPostal, new Fecha(fecha)));
            System.out.println("Persona " + personas.get(i) + " añadida.");
        }
        System.out.println("Fin del proceso de añadir personas.");
    }

    private static int personasMayoresDeEdad() {
        int cont = 0;
        for (Persona persona: personas) if (persona.esMayorDeEdad()) cont++;
        return cont;
    }

    private static int cuantasPersonasVivenEn(String ciudad) {
        int cont = 0;
        for (Persona persona: personas) if (persona.getCiudad().equals(ciudad)) cont++;
        return cont;
    }

    private static Persona personaMayorEdad() {
        if (personas.isEmpty()) return null;
        else {
            Persona aux = personas.getFirst();
            for (int i = 1; i < numeroDePersonas(); i++) {
                if (!personas.get(i).getFechaNacimiento().esMayorQue(aux.getFechaNacimiento())) {
                    aux = personas.get(i);
                }
            }
            return aux;
        }
    }

    private static void mostrar() {
        for (Persona persona: personas) {
            System.out.println(persona);
        }
    }

    private static int numeroDePersonas() {
        return personas.size();
    }
}
