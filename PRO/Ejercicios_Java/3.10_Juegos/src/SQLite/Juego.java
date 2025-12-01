package SQLite;

public class Juego {

     private int id;
    private String titulo;
    private String consola;
    private int anoPub;
    private double precio;

    public Juego(int id, String nombre, String consola, int anoPub, double precio) {
        this.id = id;
        this.titulo = nombre;
        this.consola = consola;
        this.anoPub = anoPub;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConsola() {
       return consola;
    }
    public void setConsola(String consola) {
        this.consola = consola;
    }

    public int getAnoPub() {
        return anoPub;
    }
    public void setAnoPub(int anoPub) {
        this.anoPub = anoPub;
    }

    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString(){
        return "ID: "+id+" | NOMBRE: "+ titulo +" | CONSOLA: "+consola+" | AÑO PUBLICACION: "+anoPub+" | PRECIO: "+precio;
    }
}
