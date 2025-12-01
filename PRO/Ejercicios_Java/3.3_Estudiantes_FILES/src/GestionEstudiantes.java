import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class GestionEstudiantes {
    public static final Path fichero = Paths.get("3.3_Estudiantes_FILES", "Estudiantes.txt");
    private static Scanner sc = new Scanner(System.in);

    public static void agregarAlumno() {
        String nombre = EntradaDatos.leerTexto("NOMBRE");
        try {
            // Crear directorio si no existe
            if (Files.notExists(fichero.getParent())) {
                Files.createDirectories(fichero.getParent());
            }

            // Añadir alumno al fichero principal
            Files.write(fichero, (nombre + "\n").getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);

            // Crear fichero de notas
            Path notasPath = obtenerFicheroNotas(nombre);
            if (Files.notExists(notasPath)) {
                Files.createFile(notasPath);
            } else {
                System.out.println("EL FICHERO DE NOTAS YA EXISTE");
            }

            System.out.println("ALUMNO AGREGADO CORRECTAMENTE");
        } catch (IOException e) {
            System.out.println("ERROR: FALLO AL ESCRIBIR");
        }
    }

    private static Path obtenerFicheroNotas(String nombre) {
        return fichero.getParent().resolve("notas_" + nombre + ".txt");
    }

    public static void agregarNotaAlumno() {
        mostrarTodosEstudiantes();
        String alumno = EntradaDatos.leerTexto("NOMBRE ALUMNO");
        Path ficheroNotaAlumno = obtenerFicheroNotas(alumno);

        try {
            // Verificar si el alumno existe
            boolean encontrado = Files.lines(fichero)
                    .anyMatch(linea -> linea.equalsIgnoreCase(alumno));

            if (!encontrado) {
                System.out.println("EL ALUMNO NO ESTA REGISTRADO");
                return;
            }

            // Agregar la nueva nota
            int nota = EntradaDatos.leerNumero();
            String asignatura = EntradaDatos.leerTexto("ASIGNATURA");
            String lineaNueva = asignatura + ": " + nota + "\n";

            Files.write(ficheroNotaAlumno, lineaNueva.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);

        } catch (IOException e) {
            System.out.println("ERROR: FALLO AL PROCESAR LAS NOTAS");
        }
    }

    public static void mostrarNotaEstudiante() {
        try {
            if (Files.notExists(fichero) || Files.size(fichero) == 0) {
                System.out.println("EL FICHERO ESTA VACIO O NO EXISTE");
                return;
            }

            String alumno = EntradaDatos.leerTexto("ALUMNO");
            Path notas = obtenerFicheroNotas(alumno);

            if (Files.notExists(notas)) {
                System.out.println("NO HAY NOTAS REGISTRADAS PARA ESTE ALUMNO");
                return;
            }

            System.out.println("-".repeat(20) + "\nNOTAS DE " + alumno + ":");
            Files.lines(notas)
                    .map(linea -> linea.split(":"))
                    .forEach(datos -> System.out.println(datos[0] + ":" + datos[1]));

        } catch (IOException e) {
            System.out.println("ERROR: FALLO AL LEER");
        }
    }

    public static void mostrarTodosEstudiantes() {
        try {
            if (Files.notExists(fichero) || Files.size(fichero) == 0) {
                System.out.println("EL FICHERO ESTA VACIO O NO EXISTE");
                return;
            }

            System.out.println("-".repeat(24) + "\nALUMNOS ALMACENADOS:");
            List<String> alumnos = Files.readAllLines(fichero);

            IntStream.range(0, alumnos.size())
                    .forEach(i -> System.out.println((i+1) + ". " + alumnos.get(i)));

            System.out.println("-".repeat(24));
        } catch (IOException e) {
            System.out.println("ERROR: FALLO AL LEER");
        }
    }
}