public class Main {
    public static void main(String[] args) {
        Libro libro1 = new Libro("La mala costumbre", "Alana S. Portero", "ABCD-1234-ASDF", 300);
        Libro libro2 = new Libro();
        System.out.println(libro1);
        System.out.println(libro2);

        libro2.setAutor("Brandon Sanderson");
        libro2.setTitulo(("Elantris"));
        libro2.setIsbn("QEWR-1324-1234");
        libro2.setNumPaginas(800);

        System.out.println(libro2);

        System.out.println("Me gustan los libros de " + libro2.getAutor());

        libro1 = new Libro();
        libro2 = new Libro();

        if (libro1 == libro2) {
            System.out.println("Son el mismo libro");
        } else System.out.println("No son el mismo libro");

        if (libro1.equals(libro2)) {
            System.out.println("Son iguales");
        } else System.out.println("Son distintos");

        Libro libro3 = new Libro(libro2);
        Libro libro4 = libro2;
    }
}
