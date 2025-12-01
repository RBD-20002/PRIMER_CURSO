import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestionProductos {
    private final String nombreFichero = "productos.csv";

    private final String[] productosIniciales = {
            "1;Manzana;0.50;100",
            "2;Leche;1.20;50",
            "3;Pan;0.80;75",
            "4;Arroz;1.50;30",
            "5;Carne;5.00;20"
    };

    public GestionProductos() {
        crearFichero();
    }

    private void crearFichero() {
        File fichero = new File(nombreFichero);
        if (!fichero.exists()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichero))) {
                for (String producto : productosIniciales) {
                    bw.write(producto);
                    bw.newLine();
                }
            } catch (IOException e) {
                System.out.println("ERROR AL CREAR EL ARCHIVO.");
                System.err.println(e.getMessage());
            }
        }
    }

    public void mostrarProductos() {
        List<Producto> productos = cargarProductos();
        System.out.println(" ----- Lista de productos ----- ");
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

    public List<Integer> recuperarIds() {
        List<Producto> productos = cargarProductos();
        List<Integer> ids = new ArrayList<>();
        for (Producto producto : productos) {
            ids.add(producto.getId());
        }
        return ids;
    }

    private List<Producto> cargarProductos() {
        List<Producto> toret = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] partes = line.split(Producto.getSEPARADOR());
                int id = Integer.parseInt(partes[0]);
                String nombre = partes[1];
                double precio = Double.parseDouble(partes[2]);
                int stock = Integer.parseInt(partes[3]);

                toret.add(new Producto(id, stock, nombre, precio));
            }
        } catch (IOException e) {
            System.out.println("ERROR AL LEER EL ARCHIVO");
            System.err.println(e.getMessage());
        } catch (NullPointerException | NumberFormatException e) {
            System.out.println("FICHERO CORRUPTO");
            System.err.println(e.getMessage());
        }
        return toret;
    }

    public void addProducto(Producto producto) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero, true))) {
            bw.write(producto.toCSV());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("ERROR AL INSERTAR UN NUEVO PRODUCTO.");
            System.err.println(e.getMessage());
        }
    }

    private void escribirProductos(List<Producto> productos) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero))) {
            for (Producto producto : productos) {
                bw.write(producto.toCSV());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("ERROR AL MODIFICAR EL ARCHIVO.");
            System.err.println(e.getMessage());
        }
    }

    public void eliminarProducto(int id) {
        List<Producto> productos = cargarProductos();

        // boolean eliminado = productos.removeIf(p -> p.getId() == id);
        boolean eliminado = false;
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                productos.remove(producto);
                eliminado = true;
                break;
            }
        }

        if (eliminado) {
            escribirProductos(productos);
            System.out.println("Producto eliminado.");
        } else {
            System.out.println("No existe un producto con ese id.");
        }
    }

    public void modificarStock(int id, int nuevoStock) {
        List<Producto> productos = cargarProductos();

        boolean encontrado = false;
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                producto.setStock(nuevoStock);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            escribirProductos(productos);
            System.out.println("Producto modificado.");
        } else {
            System.out.println("No existe un producto con ese id.");
        }
    }
}
