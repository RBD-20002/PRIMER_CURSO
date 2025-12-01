import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class GestionConexion {

    public static final Path fichero = Paths.get("3.2_Login_FILES", "Logs.txt");
    private static LocalDateTime fecha = LocalDateTime.now();
    private static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public static void registrarConexion(String accion) {
        String usuario = EntradaDatos.leerDato("NOMBRE USUARIO");
        String fechaFormateada = fecha.format(formato);
        String lineaNueva = "[" + fechaFormateada + "] " + accion + " -> USUARIO = " + usuario + "\n";

        try {
            // Crear directorios si no existen
            if (Files.notExists(fichero.getParent())) {
                Files.createDirectories(fichero.getParent());
            }

            // Escribir en el archivo (crea si no existe, añade si existe)
            Files.write(fichero, lineaNueva.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);

            System.out.println("SE REGISTRO LA CONEXION");
        } catch (IOException e) {
            System.out.println("ERROR: FALLO AL ESCRIBIR");
        }
    }

    public static void mostrarLog() {
        try {
            if (Files.notExists(fichero) || Files.size(fichero) == 0) {
                System.out.println("EL FICHERO ESTA VACIO");
                return;
            }

            System.out.println("LOGS: ");
            List<String> lineas = Files.readAllLines(fichero);
            lineas.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println("ERROR: FALLO AL LEER");
        }
    }
}