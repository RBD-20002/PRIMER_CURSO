import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class GestorTareas {
    public static final Path fichero = Paths.get("3.4_Tareas_FILES", "Tareas.txt");
    private static Scanner sc = new Scanner(System.in);
    private static LocalDateTime fecha = LocalDateTime.now();
    private static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm");

    public static void agregarTarea() {
        String tarea = EntradaDatos.leerTarea();
        int contador = obtenerUltimoIdTarea() + 1;
        String nuevaLinea = contador + "_TAREA | " + tarea + "\n";

        try {
            // Crear directorio si no existe
            if (Files.notExists(fichero.getParent())) {
                Files.createDirectories(fichero.getParent());
            }

            Files.write(fichero, nuevaLinea.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
            System.out.println("SE REGISTRO TAREA");
        } catch (IOException e) {
            System.out.println("ERROR: FALLO AL ESCRIBIR");
        }
    }

    public static void mostrarTarea() {
        try {
            if (Files.notExists(fichero) || Files.size(fichero) == 0) {
                System.out.println("EL FICHERO ESTA VACIO O NO EXISTE");
                return;
            }

            System.out.println("TAREAS:");
            Files.lines(fichero).forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("ERROR: FALLO AL LEER");
        }
    }

    public static void eliminarTarea() {
        mostrarTarea();
        int idEliminar = EntradaDatos.leerNumero();

        try {
            List<String> lineas = Files.readAllLines(fichero);
            List<String> lineasActualizadas = new ArrayList<>();
            boolean encontrado = false;

            for (String linea : lineas) {
                String[] datos = linea.split("_");
                if (datos.length > 0) {
                    int idComparacion = Integer.parseInt(datos[0]);
                    if (idEliminar != idComparacion) {
                        lineasActualizadas.add(linea);
                    } else {
                        encontrado = true;
                    }
                }
            }

            if (!encontrado) {
                System.out.println("TAREA INVALIDA");
                return;
            }

            Files.write(fichero, lineasActualizadas);
            System.out.println("TAREA ELIMINADA");
        } catch (IOException e) {
            System.out.println("ERROR: FALLO AL PROCESAR TAREAS");
        }
    }

    public static void crearCopiaSeguridad() {
        try {
            if (Files.notExists(fichero) || Files.size(fichero) == 0) {
                System.out.println("EL FICHERO NO EXISTE O ESTA VACIO");
                return;
            }

            String fechaFormateada = fecha.format(formato);
            Path copiaSeguridad = fichero.getParent().resolve(fechaFormateada + "_backupTareas.txt");
            Files.copy(fichero, copiaSeguridad, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("COPIA DE SEGURIDAD CREADA");
        } catch (IOException e) {
            System.out.println("ERROR: FALLO AL CREAR COPIA");
        }
    }

    private static int obtenerUltimoIdTarea() {
        try {
            if (Files.notExists(fichero) || Files.size(fichero) == 0) {
                return 0;
            }

            Optional<String> ultimaLinea = Files.lines(fichero)
                    .filter(line -> !line.trim().isEmpty())
                    .reduce((first, second) -> second);

            if (!ultimaLinea.isPresent()) return 0;

            String[] partes = ultimaLinea.get().split("_");
            return Integer.parseInt(partes[0]);
        } catch (Exception e) {
            System.out.println("ERROR: FALLO AL LEER ID");
            return 0;
        }
    }
}