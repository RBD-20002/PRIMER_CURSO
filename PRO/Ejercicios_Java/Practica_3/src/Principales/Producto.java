package Principales;

public class Producto {

    private String nombre;
    private double precio;
    private Tipo tipo;
    public Producto(String nombre, double precio, Tipo tipo) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
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

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Producto: " + nombre + "|" + " Precio: " + precio + "|" + " Tipo: " + tipo;
    }

    public enum Tipo {CARNICOS, VERDURAS, ENLATADOS}
}
