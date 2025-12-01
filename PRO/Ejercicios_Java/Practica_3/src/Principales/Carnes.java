package Principales;

public class Carnes extends Producto {

    private String FechaCaducidad;

    public Carnes(String nombre, double precio, Tipo tipo, String fechaCaducidad) {
        super(nombre, precio, tipo);
        FechaCaducidad = fechaCaducidad;
    }

    public String getFechaCaducidad() {
        return FechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        FechaCaducidad = fechaCaducidad;
    }

    @Override
    public String toString() {
        return "Nombre: " + getNombre() + " | " + "Caducidad: " + FechaCaducidad + " | " + " Precio: " + getPrecio();
    }
}
