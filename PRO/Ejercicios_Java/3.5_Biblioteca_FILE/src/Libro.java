import java.io.Serializable;

public class Libro implements Serializable {

    private static final Long serialVersionID = 1L;
    private String codigo;
    private  String titulo;
    private String autor;
    private int anoPub;

    public Libro(String codigo, String titulo, String autor, int anoPub) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPub = anoPub;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    @Override
    public String toString() {
        return "CODIGO: "+codigo+" | LIBRO: "+titulo+" | AUTOR: "+autor+" | AÑO PUBLICACION: "+anoPub;
    }
}
