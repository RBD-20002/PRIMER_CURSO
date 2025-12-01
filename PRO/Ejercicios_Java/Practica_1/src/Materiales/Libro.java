package Materiales;

public class Libro extends Material {

    private String ISBN;
    private int numPaginas;
    private String editorial;

    public Libro(String titulo, String autor, int anoPublicacion, Estado disponible, String ISBN, int numPaginas, String editorial) {
        super(titulo, autor, anoPublicacion, Estado.DISPONIBLE);
        this.ISBN = ISBN;
        this.numPaginas = numPaginas;
        this.editorial = editorial;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    @Override
    public double calcularMulta(int diaAtrasado) {
        return diaAtrasado * 0.50;
    }

    @Override
    public String toString() {
        return "Libro:" +
                "\n -ISBN:'" + ISBN +
                "\n -numPaginas: " + numPaginas +
                "\n -editorial: " + editorial;
    }
}
