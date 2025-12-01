import SQL.Libro;
import SQL.LibroDAO;
import java.sql.SQLException;
import java.util.List;

public class GestionLibros {
    private final LibroDAO libroDAO;

    public GestionLibros(){
        try {
            libroDAO = new LibroDAO();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void agregarLibro(){
        String titulo = EntradaDatos.leerString("titulo");
        String autor = EntradaDatos.leerString("autor");
        int anoPub = EntradaDatos.leerAnoPub();
        double precio = EntradaDatos.leerDouble();
        Libro nuevo = new Libro(0,titulo,autor,anoPub,precio);
        try{
            libroDAO.insertLibro(nuevo);
        }catch (SQLException e){
            System.out.println("ERROR: FALLO AGREGAR");
        }
    }

    public void modificarLibro(){
        try {
            int id = EntradaDatos.leerInteger("id");
            Libro libro = libroDAO.selectLibro(id);

            if (libro == null) {
                System.out.println("LIBRO NO ENCONTRADO");
                return;
            }

            String titulo = EntradaDatos.leerString("titulo");
            String autor = EntradaDatos.leerString("autor");
            int anoPub = EntradaDatos.leerAnoPub();
            double precio = EntradaDatos.leerDouble();

            libro.setTitulo(titulo);
            libro.setAutor(autor);
            libro.setAnoPub(anoPub);
            libro.setPrecio(precio);

            libroDAO.updateLibro(libro);
            System.out.println("LIBRO MODIFICADO");

        } catch (SQLException e) {
            System.err.println("ERROR: FALLO MODIFICAR");
        }
    }

    public void borrarLibro(){
        try{
            int id = EntradaDatos.leerInteger("id");
            Libro libro = libroDAO.selectLibro(id);

            if(libro == null){
                System.out.println("LIBRO NO ENCONTRADO");
                return;
            }

            libroDAO.deleteLibro(id);
            System.out.println("LIBRO ELIMINADO");
        }catch (SQLException e){
            System.out.println("ERRO: FALLO ELIMINAR");
        }
    }

    public void buscarPorId(){
        try{
            int id = EntradaDatos.leerInteger("id");
            Libro libro = libroDAO.selectLibro(id);

            if (libro == null){
                System.out.println("LIBRO NO ENCONTRADO");
                return;
            }
            System.out.println("LIBRO ENCONTRADO:");
            System.out.println(libro);
        }catch (SQLException e){
            System.out.println("ERROR: FALLO BUSCAR ID");
        }
    }

    public void listarLibros(){
        try{
            List<Libro> libros = libroDAO.selectAllLibro();
            if(libros == null){
                System.out.println("NO HAY LIBROS POR MOSTRAR");
                return;
            }
            System.out.println("LIBROS:");
            for(Libro libro : libros){
                System.out.println(libro);
            }
        }catch (SQLException e){
            System.out.println("ERROR: FALLO AL MOSTRAR");
        }
    }

    public void buscarPorPrecio(){
        try{
            double precio1 = EntradaDatos.leerDouble();
            double precio2 = EntradaDatos.leerDouble();
            List<Libro> libros = libroDAO.selectBeetwenPrecio(precio1,precio2);

            if(libros == null){
                System.out.println("NO HAY PRECIO ENTRE ESE RANGO");
                return;
            }
            System.out.println("LIBROS");
            libroDAO.selectBeetwenPrecio(precio1,precio2);
        }catch (SQLException e){
            System.out.println("ERROR: FALLO BUSCAR POR PRECIO");
        }
    }

    public void buscarPorAutor(){
        try{
            String autor = EntradaDatos.leerString("autor");
            List<Libro> libros = libroDAO.selectLikeAutor(autor);

            if(libros == null){
                System.out.println("NO HAY LIBROS CON ESE AUTOR");
                return;
            }
            System.out.println("LIBROS:");
            libroDAO.selectLikeAutor(autor);
        }catch (SQLException e){
            System.out.println("ERROR: FALLO BUSCAR POR AUTOR");
        }
    }
}
