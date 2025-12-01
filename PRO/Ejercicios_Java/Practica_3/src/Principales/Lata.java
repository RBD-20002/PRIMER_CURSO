package Principales;

public class Lata extends Producto {

    private String cantidad;

    public Lata(String nombre, double precio, Tipo tipo, String cantidad) {
        super(nombre, precio, tipo);
        this.cantidad = cantidad;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Nombre: " + getNombre() + " | " + "Cantidad: " + cantidad + " | " + "Precio: " + getPrecio();
    }
}
