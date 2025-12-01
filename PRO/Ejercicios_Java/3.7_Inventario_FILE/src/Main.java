import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static GestionProductos gp = new GestionProductos();


    public static void main(String[] args) {
        String opcion = "";
        do {
            mostrarMenu();
            opcion = sc.nextLine();
            switch (opcion) {
                case "1" -> gp.mostrarProductos();
                case "2" -> addProducto();
                case "3" -> modificarStock();
                case "4" -> eliminarProducto();
                case "0" -> System.out.println("Fin del programa.");
                default -> System.out.println("Seleccione una opción válida (0-4).");
            }
        } while (!opcion.equalsIgnoreCase("0"));
        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println(" ---- Menú del Gestor de Productos ---- ");
        System.out.println("1. Mostrar productos.");
        System.out.println("2. Añadir producto.");
        System.out.println("3. Modificar stock.");
        System.out.println("4. Eliminar producto.");
        System.out.println("0. Pulse '0' para salir.");
        System.out.println("Seleccione una opicón válida (0-4): ");
    }

    private static void addProducto() {
        System.out.println("Introduzca el ID del producto: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Introduzca el nombre del producto: ");
        String nombre = sc.nextLine();
        System.out.println("Introduzca el precio del producto: ");
        double precio = Double.parseDouble(sc.nextLine());
        System.out.println("Introduzca el stock del producto: ");
        int stock = Integer.parseInt(sc.nextLine());

        Producto producto = new Producto(id, stock, nombre, precio);
        gp.addProducto(producto);
    }

    private static void modificarStock() {
        gp.mostrarProductos();
        System.out.println("Seleccione un ID para modificar su stock: ");
        int id = Integer.parseInt(sc.nextLine());
        if (gp.recuperarIds().contains(id)) {
            System.out.println("Introduzca el nuevo stock: ");
            int stock = Integer.parseInt(sc.nextLine());
            gp.modificarStock(id, stock);
        } else {
            System.out.println("No existe un producto para ese ID.");
        }
    }

    private static void eliminarProducto() {
        gp.mostrarProductos();
        System.out.println("Seleccione un ID para modificar su stock: ");
        int id = Integer.parseInt(sc.nextLine());
        gp.eliminarProducto(id);
    }

}
