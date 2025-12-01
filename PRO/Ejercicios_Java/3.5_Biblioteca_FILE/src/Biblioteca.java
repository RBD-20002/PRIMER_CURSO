import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private static List<Libro> libros;
    public static final String ARCHIVO = "biblioteca.dat";

    public Biblioteca() {
        libros = cargarLibros();
    }

    private List<Libro> cargarLibros() {
        List<Libro> lista = new ArrayList<>();
        File fichero = new File("3.5_Biblioteca_FILE",ARCHIVO);

        if(fichero.exists()){
            try(ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(ARCHIVO))){
                lista = (List<Libro>) entrada.readObject();
            }catch (IOException | ClassNotFoundException e){
                System.out.println("ERROR: FALLO AL CARGAR");
            }
        }
        return lista;
    }

    private static void guardarLibros() {
        try(ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(ARCHIVO))){
            salida.writeObject(libros);
        }catch (IOException e){
            System.out.println("ERROR: FALLO AL GUARDAR");
        }
    }

    public static void agregarLibro() {
        String titulo = EntradaDatos.leerDato("titulo");
        String autor = EntradaDatos.leerDato("autor");
        String codigo = EntradaDatos.leerDato("codigo");
        int anoPub = EntradaDatos.leerNumero("año de publicacion");
        Libro nuevoLibro = new Libro(codigo,titulo,autor,anoPub);

        libros.add(nuevoLibro);
        guardarLibros();
        System.out.println("LIBRO AGREGADO");
    }

    public static void listarLibro() {
        if(libros.isEmpty()){
            System.out.println("LA BIBLIOTECA ESTA VACIA");
        }
        for(Libro libro : libros){
            System.out.println(libro);
        }
    }

    public static void buscarLibro() {
        if(libros.isEmpty()){
            System.out.println("NO HAY LIBROS QUE BUSCAR");
        }
        String buscarCodigo = EntradaDatos.leerDato("codigo");
         for(Libro libro : libros){
             if(libro.getCodigo().contains(buscarCodigo)){
                 System.out.println("LIBRO ENCONTRADO:\n"+libro.getTitulo());
             }
         }
    }

    public static void eliminarLibro() {
        if(libros.isEmpty()){
            System.out.println("NO HAY LIBROS QUE ELIMINAR");
        }
        String codigoEliminar = EntradaDatos.leerDato("CODIGO DEL LIBRO A ELIMINAR");
        boolean eliminado = libros.removeIf(libro -> libro.getCodigo().equalsIgnoreCase(codigoEliminar));
        if(eliminado){
            System.out.println("LIBRO ELIMINADO CORRECTAMENTE");
            guardarLibros();
        }else System.out.println("LIBRO NO ENCONTRADO");
    }
}
