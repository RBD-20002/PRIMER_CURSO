import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class GestionPropiedad {

    private static Scanner sc = new Scanner(System.in);
    public static final String FICHERO = "configuracion.properties";
    private static Properties propiedades;

    public GestionPropiedad() {
        propiedades = new Properties();
        cargarPropiedades();
    }

    private static void cargarPropiedades() {
        File fichero = new File(FICHERO);
        if(!fichero.exists()){
            crearPropiedadesDefecto();
        }
        try(FileInputStream entrada = new FileInputStream(fichero)){
            propiedades.load(entrada);
        }catch (IOException e){
            System.out.println("ERROR: FALLO AL CARGAR");
        }
    }

    private static void crearPropiedadesDefecto() {
        propiedades.setProperty("idioma","ES");
        propiedades.setProperty("tema","claro");
        propiedades.setProperty("tamaño_fuente","14");
        propiedades.setProperty("mostrar_tutorial","true");

        guardarPropiedades();
    }

    public static void mostrarConf(){
        System.out.println("CONFIGURACIONES:");
        propiedades.forEach((k,v) -> System.out.println(k+" : "+v));
    }
    public static void modificarConf() {
        InfoMenu.menu2();
        int opcion;
        do{
            opcion = EntradaDatos.leerNumero();
            switch (opcion){
                case 1:
                    String nuevoIdioma = EntradaDatos.leerDato("idioma");
                    propiedades.setProperty("idioma",nuevoIdioma);
                    return;
                case 2:
                    String nuevoTema = EntradaDatos.leerDato("tema");
                    propiedades.setProperty("tema",nuevoTema);
                    return;
                case 3:
                    String nuevoTamaño = EntradaDatos.leerDato("tamaño de letra");
                    propiedades.setProperty("tamaño_fuente",nuevoTamaño);
                    return;
                case 4:
                    String nuevoTutorial = EntradaDatos.leerDato("tutorial");
                    propiedades.setProperty("mostral_tutorial",nuevoTutorial);
                    return;
                case 5:
                    System.out.println("VOLVIENDO AL INICIO");
                    return;
            }
        }while (opcion != 4);
    }

    public static void restaurarConf() {
        crearPropiedadesDefecto();
        System.out.println("LAS PROPIEDADES RESTAURADAS");
    }

    private static void guardarPropiedades() {
        try(FileOutputStream entrada = new FileOutputStream(FICHERO)) {
            propiedades.store(entrada,"CONFIGURACION DE APLICACION");
        }catch (IOException e){
            System.out.println("ERROR: FALLO AL GUARDAR");
        }
    }

}
