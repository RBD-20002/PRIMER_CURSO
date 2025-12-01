import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class GestionUsuarios {
    public static final Path fichero = Paths.get("3.1_Usuarios_FILES", "Usuarios.txt");

    public static void agregarUsuarios() {
        String nombre = EntradaDatos.leerString("NOMBRE");
        int edad = EntradaDatos.leerInt("EDAD");
        String ciudad = EntradaDatos.leerString("CIUDAD");
        String nuevoUsuario = nombre + ";" + edad + ";" + ciudad + "\n";

        try {
            if (!Files.exists(fichero.getParent())) {
                Files.createDirectories(fichero.getParent());
            }
            Files.write(fichero, nuevoUsuario.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("ERROR: FALLO AL ESCRIBIR");
        }
    }

    public static void mostrarUsuarios() {
        try {
            if (Files.notExists(fichero) || Files.size(fichero) == 0) {
                System.out.println("EL FICHERO ESTA VACIO");
                return;
            }

            List<String> lineas = Files.readAllLines(fichero);
            for (String linea : lineas) {
                String[] datos = linea.split(";");
                System.out.println("NOMBRE: " + datos[0] + " | EDAD: " + datos[1] + " | CIUDAD: " + datos[2]);
            }
        } catch (IOException e) {
            System.out.println("ERROR: FALLO AL LEER");
        }
    }

    public static void eliminarUsuarios() {
        try {
            if (Files.notExists(fichero)) {
                System.out.println("EL FICHERO NO EXISTE");
                return;
            }

            String usuarioEliminar = EntradaDatos.leerString("USUARIO A ELIMINAR");
            List<String> lineas = Files.readAllLines(fichero);

            List<String> lineasActualizadas = lineas.stream()
                    .filter(linea -> {
                        String[] datos = linea.split(";");
                        return datos.length > 0 && !datos[0].equalsIgnoreCase(usuarioEliminar);
                    })
                    .collect(Collectors.toList());

            if (lineas.size() == lineasActualizadas.size()) {
                System.out.println("USUARIO NO ENCONTRADO");
                return;
            }

            Files.write(fichero, lineasActualizadas, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("USUARIO ELIMINADO");

        } catch (IOException e) {
            System.out.println("ERROR: FALLO AL PROCESAR EL FICHERO");
        }
    }

    public static void buscarUsuarios() {
        try {
            if (Files.notExists(fichero) || Files.size(fichero) == 0) {
                System.out.println("EL FICHERO ESTA VACIO");
                return;
            }

            String buscarUsuario = EntradaDatos.leerString("USUARIO A BUSCAR");
            List<String> lineas = Files.readAllLines(fichero);

            boolean encontrado = false;
            for (String linea : lineas) {
                String[] datos = linea.split(";");
                if (datos[0].equalsIgnoreCase(buscarUsuario)) {
                    System.out.println("NOMBRE: " + datos[0] + " | EDAD: " + datos[1] + " | CIUDAD: " + datos[2]);
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("NO HAY USUARIO ALMACENADO CON EL NOMBRE " + buscarUsuario);
            }

        } catch (IOException e) {
            System.out.println("ERROR: FALLO AL LEER FICHERO");
        }
    }
}