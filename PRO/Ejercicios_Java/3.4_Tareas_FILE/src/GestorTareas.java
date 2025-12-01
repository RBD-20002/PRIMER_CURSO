import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorTareas {

    public static final File fichero = new File("3.4_Tareas_FILE","Tareas.txt");
    private static Scanner sc = new Scanner(System.in);
    private static LocalDateTime fecha = LocalDateTime.now();
    private static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm");

    public static void agregarTarea() {
        String tarea = EntradaDatos.leerTarea();
        int contador = obtenerUltimoIdTarea()+1;
        String nuevaLinea = contador++ +"_TAREA | "+tarea+"\n";
        try(BufferedWriter escribir = new BufferedWriter(new FileWriter(fichero,true))){
            escribir.write(nuevaLinea);
            System.out.println("SE REGISTRO TAREA");
        }catch (IOException e){
            System.out.println("ERROR: FALLO AL ESCRIBIR");
        }
    }

    public static void mostrarTarea() {
        if(!fichero.exists() || fichero.length() == 0){
            System.out.println("EL FICHERO ESTA VACIO O NO EXISTE");
        }else{
            try(BufferedReader lee = new BufferedReader(new FileReader(fichero))){
                String linea;
                System.out.println("TAREAS:");
                while((linea = lee.readLine()) != null){
                    System.out.println(linea);
                }
            }catch (IOException e){
                System.out.println("ERROR: FALLO AL LEER");
            }
        }
    }

    public static void eliminarTarea() {
        mostrarTarea();
        List<String> temporal = new ArrayList<>();
        int idEliminar = EntradaDatos.leerNumero();
        boolean encontrado = false;

        try (BufferedReader lee = new BufferedReader(new FileReader(fichero))) {
            String linea;
            while ((linea = lee.readLine()) != null) {
                String[] datos = linea.split("_");
                if (datos.length > 0) {
                    int idComparacion = Integer.parseInt(datos[0]);
                    if (idEliminar == idComparacion) {
                        encontrado = true;
                        System.out.println("TAREA ELIMINADA");
                    } else {
                        temporal.add(linea);
                    }
                }
            }
            if (!encontrado) {
                System.out.println("TAREA INVALIDA");
                return;
            }
        } catch (IOException e) {
            System.out.println("ERROR: FALLO AL LEER");
        }

        try (BufferedWriter escribe = new BufferedWriter(new FileWriter(fichero))) {
            for (String linea : temporal) {
                escribe.write(linea + "\n");
            }
        } catch (IOException e) {
            System.out.println("ERROR: FALLO AL ESCRIBIR");
        }
    }

    public static void crearCopiaSeguridad() {
        if(!fichero.exists() || fichero.length() == 0){
            System.out.println("EL FICHERO NO EXISTE O ESTA VACIO");
        }
        String fechaFormateada = fecha.format(formato);
        File copiaSeguridad = new File("3.4_Tareas_FILE",fechaFormateada+"_backupTareas.txt");
        try(BufferedReader leer = new BufferedReader(new FileReader(fichero));
            BufferedWriter escribir = new BufferedWriter(new FileWriter(copiaSeguridad))){

            String linea;
            while((linea = leer.readLine()) != null){
                escribir.write(linea+"\n");
            }
        }catch (IOException e){
            System.out.println("ERROR: FALLO AL LEER");
        }
    }

    private static int obtenerUltimoIdTarea() {
        if (!fichero.exists() || fichero.length() == 0) {
            return 0; // Si el archivo está vacío
        }

        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String ultimaLinea = "", lineaActual;
            while ((lineaActual = br.readLine()) != null) {
                if (!lineaActual.trim().isEmpty()) {
                    ultimaLinea = lineaActual;
                }
            }
            if (ultimaLinea.isEmpty()) return 0;

            String[] partes = ultimaLinea.split("_");
            return Integer.parseInt(partes[0]);
        } catch (Exception e) {
            System.out.println("ERROR: FALLO AL LEER ID");
            return 0;
        }
    }
}
