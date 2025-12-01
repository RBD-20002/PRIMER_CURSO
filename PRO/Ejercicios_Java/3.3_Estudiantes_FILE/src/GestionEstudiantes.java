import java.io.*;
import java.util.Scanner;

public class GestionEstudiantes {
    public static final File fichero = new File("3.3_Estudiantes_FILE","Estudiantes.txt");
    private static Scanner sc = new Scanner(System.in);

    public static void agregarAlumno(){
        String nombre = EntradaDatos.leerTexto("NOMBRE");
        try(BufferedWriter escribir = new BufferedWriter(new FileWriter(fichero,true))){
            escribir.write(nombre+"\n");

            File notas = obtenerFicheroNotas(nombre);
            if(!notas.createNewFile()) System.out.println("EL FICHERO DE NOTAS YA EXISTE");

            System.out.println("ALUMNO AGREGADO CORRECTAMENTE");
        }catch (IOException e){
            System.out.println("ERROR: FALLO AL ESCRIBIR");
        }
    }

    private static File obtenerFicheroNotas(String nombre) {
        return new File(fichero.getParent(),"notas_"+nombre+".txt");
    }

    public static void agregarNotaAlumno(){
        mostrarTodosEstudiantes();
        String alumno = EntradaDatos.leerTexto("NOMBRE ALUMNO");
        boolean encontrado = false;
        File ficheroNotaAlumno = obtenerFicheroNotas(alumno);

        try(BufferedReader leer = new BufferedReader(new FileReader(fichero))){
            String linea;
            while((linea = leer.readLine()) != null){
                if(linea.equalsIgnoreCase(alumno)) encontrado = true;
            }
        }catch (IOException e){
            System.out.println("ERROR: FALLO AL LEER");
            return;
        }

        if(!encontrado){
            System.out.println("EL ALUMNO NO ESTA REGISTRADO");
            return;
        }else {
            try (BufferedWriter escribir = new BufferedWriter(new FileWriter(ficheroNotaAlumno, true))) {
                int nota = EntradaDatos.leerNumero();
                String asignatura = EntradaDatos.leerTexto("ASIGNATURA");
                String lineaNueva = asignatura + ": " + nota + "\n";
                escribir.write(lineaNueva);
            } catch (IOException e) {
                System.out.println("ERROR: FALLO AL ESCRIBIR LA NOTA");
            }
        }
    }

    public static void mostrarNotaEstudiante(){
        if(fichero.length() == 0 || !fichero.exists()){
            System.out.println("EL FICHERO ESTA VACIO O NO EXISTE");
        }else{
            String alumno = EntradaDatos.leerTexto("ALUMNO");
            File notas = obtenerFicheroNotas(alumno);
            try(BufferedReader leer = new BufferedReader(new FileReader(notas))){
                String linea;
                while((linea = leer.readLine()) != null){
                    String[] datos = linea.split(":");
                    System.out.println("-".repeat(20)+"\nNOTAS DE "+alumno+":");
                    System.out.println(datos[0]+":"+datos[1]);
                }
            }catch(IOException e){
                System.out.println("ERROR: FALLO AL LEER");
            }
        }
    }

    public static void mostrarTodosEstudiantes(){
        if(fichero.length() == 0 || !fichero.exists()){
            System.out.println("EL FICHERO ESTA VACIO O NO EXISTE");
        }else{
            try(BufferedReader leer = new BufferedReader(new FileReader(fichero))){
                String linea;
                int contador = 1;
                System.out.println("-".repeat(24)+"\nALUMNOS ALMACENADOS:");
                while((linea = leer.readLine()) != null){
                    System.out.println(contador++ +". "+ linea);
                }
                System.out.println("-".repeat(24));
            }catch (IOException e){
                System.out.println("ERROR: FALLO AL LEER");
            }
        }
    }
}
