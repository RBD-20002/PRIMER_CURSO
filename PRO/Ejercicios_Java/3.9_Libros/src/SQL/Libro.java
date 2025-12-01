package SQL;

public class Libro {

    private int id;
    private String titulo;
    private String autor;
    private int anoPub;
    private double precio;

    public Libro(int id, String nombre, String autor, int anoPub, double precio) {
        this.id = id;
        this.titulo = nombre;
        this.autor = autor;
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
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
    public String toString() {
        return "ID: "+id+" | TITULO: "+titulo+" | AUTOR: "+autor+" | AÑO PUBLICACION: "+anoPub+" | PRECIO: "+precio;
    }
}
