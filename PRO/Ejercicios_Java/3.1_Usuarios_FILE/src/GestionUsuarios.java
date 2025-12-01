import java.io.*;
import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.List;

public class GestionUsuarios {
    public static final File fichero = new File("3.1_Usuarios_FILE","Usuarios.txt");

    public static void agregarUsuarios(){
        String nombre = EntradaDatos.leerString("NOMBRE");
        int edad = EntradaDatos.leerInt("EDAD");
        String ciudad = EntradaDatos.leerString("CIUDAD");
        String nuevoUsuario = nombre+";"+edad+";"+ciudad+"\n";

        try(BufferedWriter escribir = new BufferedWriter(new FileWriter(fichero,true))){
            escribir.write(nuevoUsuario);
        }catch (IOException e){
            System.out.println("ERROR: FALLO AL ESCRIBIR");
        }
    }

    public static void mostrarUsuarios(){
        if(fichero.length() == 0 || !fichero.exists()) {
            System.out.println("EL FICHERO ESTA VACIO");
        }else{
            try(BufferedReader leer = new BufferedReader(new FileReader(fichero))){
                String lineas;
                while((lineas = leer.readLine()) != null){
                    String[] datos = lineas.split(";");
                    System.out.println("NOMBRE: "+datos[0]+" | EDAD: "+datos[1]+" | CIUDAD: "+datos[2]);
                }
            }catch (IOException e){
                System.out.println("ERROR: FALLO AL LEER");
            }
        }
    }

    public static void eliminarUsuarios(){
        List<String> temporal = new ArrayList<>();

        try(BufferedReader leer = new BufferedReader(new FileReader(fichero))){

            String usuarioEliminar = EntradaDatos.leerString("USUARIO A ELIMINAR");
            String linea;
            boolean encontrado = false;

            while((linea = leer.readLine()) != null){
                String[] datos = linea.split(";");
                if(datos.length > 0 && !datos[0].equalsIgnoreCase(usuarioEliminar)){
                    temporal.add(linea);
                }else if (datos[0].equalsIgnoreCase(usuarioEliminar)){
                    encontrado = true;
                }
            }
            if(!encontrado){
                System.out.println("USUARIO NO ENCONTRADO");
                return;
            }
        }catch (IOException e){
            System.out.println("ERROR: FALLO AL LEER EL FICHERO");
        }
        try(BufferedWriter escribir = new BufferedWriter(new FileWriter(fichero,false))){
            for(String linea : temporal){
                escribir.write(linea+"\n");
            }
            System.out.println("USUARIO ELIMINADO");
        }catch (IOException e){
            System.out.println("ERROR: FALLO AL VOLVER ESCRIBIR EN EL FICHERO");
        }
    }

    public static void buscarUsuarios(){
        if(!fichero.exists() && fichero.length() == 0){
            System.out.println("EL FICHERO ESTA VACIO");
        }else{
            try(BufferedReader leer = new BufferedReader(new FileReader(fichero))){
                String lineas;
                String buscarUsuario = EntradaDatos.leerString("USUARIO A BUSCAR");
                while((lineas = leer.readLine()) != null){
                    String[] datos = lineas.split(";");
                    if(datos[0].equalsIgnoreCase(buscarUsuario)){
                        System.out.println("NOMBRE: "+datos[0]+" | EDAD: "+datos[1]+" | CIUDAD: "+datos[2]);
                        return;
                    }else{
                        System.out.println("NO HAY USUARIO ALMACENADO CON EL NOMBRE "+buscarUsuario);
                        return;
                    }
                }
            }catch (IOException e){
                System.out.println("ERROR: FALLO AL LEER FICHERO");
            }
        }
    }
}