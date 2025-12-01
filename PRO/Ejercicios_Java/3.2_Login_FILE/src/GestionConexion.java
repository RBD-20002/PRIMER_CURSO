import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GestionConexion {

    public static final File fichero = new File("3.2_Login_FILE","Logs.txt");
    private static LocalDateTime fecha = LocalDateTime.now();
    private static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");


    public static void registrarConexion(String accion){
        String usuario = EntradaDatos.leerDato("NOMBRE USUARIO");
        String fechaFormateada = fecha.format(formato);
        String lineaNueva = "["+fechaFormateada+"] "+accion+" -> USUARIO = "+usuario+"\n";

        try(BufferedWriter escribir = new BufferedWriter(new FileWriter(fichero,true))){
            escribir.write(lineaNueva);
            System.out.println("SE REGISTRO LA CONEXION");
        }catch (IOException e){
            System.out.println("ERROR: FALLO AL ESCRIBIR");
        }
    }

    public static void mostrarLog() {
        if(!fichero.exists() || fichero.length() == 0) {
            System.out.println("EL FICHERO ESTA VACIO");
        }else{
            try(BufferedReader leer = new BufferedReader(new FileReader(fichero))){
                String linea;
                System.out.println("LOGS: ");
                while((linea = leer.readLine()) != null){
                    System.out.println(linea);
                }
            }catch (IOException e){
                System.out.println("ERROR: FALLO AL LEER");
            }
        }
    }
}
