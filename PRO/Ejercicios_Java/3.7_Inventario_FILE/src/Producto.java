public class Producto {
    private int id, stock;
    private String nombre;
    private double precio;

    private static String SEPARADOR = ";";

    public static String getSEPARADOR() {
        return SEPARADOR;
    }

    public static void setSEPARADOR(String SEPARADOR) {
        Producto.SEPARADOR = SEPARADOR;
    }

    public Producto(int id, int stock, String nombre, double precio) {
        this.id = id;
        this.stock = stock;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Nombre: " + nombre +
                " | Precio: " + precio + "€" +
                " | Stock: " + stock + " unidades";
    }

    public String toCSV() {
        return id + SEPARADOR + nombre + SEPARADOR + precio + SEPARADOR + stock;
    }
}
