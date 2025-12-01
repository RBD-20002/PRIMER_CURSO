package Materiales;

public abstract class Material {

    private String titulo;
    private String autor;
    private int anoPublicacion;
    private Estado estado;
    public Material(String titulo, String autor, int anoPublicacion, Estado estado) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacion = anoPublicacion;
        this.estado = Estado.DISPONIBLE;
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

    public int getAnoPublicacion() {
        return anoPublicacion;
    }

    public void setAnoPublicacion(int anoPublicacion) {
        this.anoPublicacion = anoPublicacion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public abstract double calcularMulta(int diasAtrasado);

    @Override
    public String toString() {
        return "Materiales.Material{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anoPublicacion=" + anoPublicacion +
                ", disponible=" + estado +
                '}';
    }


    public enum Estado {DISPONIBLE, OCUPADO}
}
