public class Album {

    private String titulo;
    private String artistas;
    private int anoPublicacion;
    private int numCanciones;
    private Estado estado;
    public Album(String titulo, String artistas, int anoPublicacion, int numCanciones, Estado estado) {
        this.titulo = titulo;
        this.artistas = artistas;
        this.anoPublicacion = anoPublicacion;
        this.numCanciones = numCanciones;
        this.estado = Estado.NORMAL;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtistas() {
        return artistas;
    }

    public void setArtistas(String artistas) {
        this.artistas = artistas;
    }

    public int getAnoPublicacion() {
        return anoPublicacion;
    }

    public void setAnoPublicacion(int anoPublicacion) {
        this.anoPublicacion = anoPublicacion;
    }

    public int getNumCanciones() {
        return numCanciones;
    }

    public void setNumCanciones(int numCanciones) {
        this.numCanciones = numCanciones;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Album{" +
                "titulo='" + titulo + '\'' +
                ", artistas='" + artistas + '\'' +
                ", anoPublicación=" + anoPublicacion +
                ", numCanciones=" + numCanciones +
                ", estado=" + estado +
                '}';
    }

    public enum Estado {FAVORITOS, NORMAL}
}
