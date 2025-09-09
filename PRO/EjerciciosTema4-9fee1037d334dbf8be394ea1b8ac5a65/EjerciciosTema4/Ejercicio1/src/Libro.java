import java.util.Objects;

public class Libro {
    private String titulo;
    private String autor;
    private String isbn;
    private int numPaginas;

    public Libro(String titulo, String autor, String isbn, int numPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.numPaginas = numPaginas;
    }

    public Libro() {
        this.titulo = "Titulo por definir";
        this.autor = "Autor por deifnir";
        this.isbn = "";
    }

    public Libro(Libro libroACopiar) {
        this.titulo = libroACopiar.getTitulo();
        this.autor = libroACopiar.autor;
        this.isbn = libroACopiar.isbn;
        this.numPaginas = libroACopiar.getNumPaginas();
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNumPaginas() {
        return this.numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    @Override
    public String toString() {
        return "El libro " + getTitulo() + " con ISBN " + getIsbn() + " creado por el autor/a "
                + getAutor() + " tiene " + getNumPaginas() + " páginas.";
    }

    public boolean equals(Libro libro) {
        return this.autor.equals(libro.getAutor()) && this.numPaginas == libro.getNumPaginas() && this.isbn.equals(libro.getIsbn())
                && this.titulo.equals(libro.getTitulo());
    }

    private static class IsbnFormatter {
        private static final char SEPARADOR = '-';

        private static String formating(String isbn) {
            if (isbn.length() == 12) {
                return isbn.substring(0, 4) + SEPARADOR + isbn.substring(4, 8) + SEPARADOR + isbn.substring(8, 12);
            }
            else {
                return isbn;
            }
        }


    }
}
