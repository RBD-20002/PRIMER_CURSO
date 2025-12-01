package Principales;

public class Vegetales extends Producto {

    private String caducidad;
    private Clase clase;
    public Vegetales(String nombre, double precio, Producto.Tipo tipo, String caducidad, Clase clase) {
        super(nombre, precio, tipo);
        this.caducidad = caducidad;
        this.clase = clase;
    }

    public String getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(String caducidad) {
        this.caducidad = caducidad;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    @Override
    public String toString() {
        return "Nombre: " + getNombre() + " | " + "Clase: " + clase + " | " + "Caducidad: " + caducidad + " | " + "Precio: " + getPrecio();
    }

    public enum Clase {LEGUMBRES, VERDES, TUBERCULOS, HONGOS, FRUTOS}
}
