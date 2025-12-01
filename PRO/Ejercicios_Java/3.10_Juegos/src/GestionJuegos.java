import SQLite.Juego;
import SQLite.JuegoDAO;

import java.sql.SQLException;
import java.util.List;

public class GestionJuegos {
    private final JuegoDAO juegoDAO;

    public GestionJuegos() {
        try{
            juegoDAO = new JuegoDAO();
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }

    public void agregarJuego(){
        try {
            String titulo = EntradaDatos.leerString("titulo");
            String consola = EntradaDatos.leerString("consola");
            int anoPub = EntradaDatos.leerAnoPub("año publicacion");
            double precio = EntradaDatos.leerPrecio("precio");
            Juego nuevo = new Juego(0, titulo, consola, anoPub, precio);

            juegoDAO.insertJuego(nuevo);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void modificarJuego(){
        try{
            int id = EntradaDatos.leerEntero("id");
            Juego juego = juegoDAO.selectJuego(id);

            if(juego == null){
                System.out.println("JUEGO NO ENCONTRADO");
                return;
            }

            String titulo = EntradaDatos.leerString("titulo");
            String consola = EntradaDatos.leerString("consola");
            int anoPub = EntradaDatos.leerAnoPub("año publicacion");
            double precio = EntradaDatos.leerPrecio("precio");

            juego.setTitulo(titulo);
            juego.setConsola(consola);
            juego.setAnoPub(anoPub);
            juego.setPrecio(precio);

            juegoDAO.updateJuego(juego);
            System.out.println("JUEGO MODIFICADO");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void eliminarJuego(){
        try{
            int id = EntradaDatos.leerEntero("id");
            Juego juego = juegoDAO.selectJuego(id);

            if(juego == null){
                System.out.println("JUEGO NO ECONTRADO");
                return;
            }

            juegoDAO.deleteJuego(id);
            System.out.println("JUEGO ELIMINADO");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void buscarJuego(){
        try{
            int id = EntradaDatos.leerEntero("id");
            Juego juego = juegoDAO.selectJuego(id);

            if(juego == null){
                System.out.println("JUEGO NO ENCONTRADO");
                return;
            }
            System.out.println("JUEGO ENCONTRADO: ");
            System.out.println(juego);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void listarJuego(){
        try{
            List<Juego> juegos = juegoDAO.selectAllJuegos();
            if(juegos == null){
                System.out.println("NO HAY JUEGOS ALMACENADOS");
                return;
            }
            System.out.println("JUEGOS");
            for(Juego juego : juegos){
                System.out.println(juego);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void buscarPorConsola(){
        try{
            String consola = EntradaDatos.leerString("consola");
            List<Juego> juegos = juegoDAO.selectByConsola(consola);

            if(juegos == null){
                System.out.println("NO HAY JUEGOS");
                return;
            }
            System.out.println("JUEGOS:");
            for(Juego juego : juegos){
                System.out.println(juego);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void buscarPorPrecio(){
        try{
            double min = EntradaDatos.leerPrecio("precio");
            double max = EntradaDatos.leerPrecio("precio");
            List<Juego> juegos = juegoDAO.selectByPrecio(min,max);

            if(juegos == null){
                System.out.println("NO HAY PRECIO EN ESE RANGO");
                return;
            }
            System.out.println("JUEGOS:");
            juegoDAO.selectByPrecio(min,max);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
