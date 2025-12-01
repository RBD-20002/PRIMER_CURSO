package Inmuebles;

public class Inmueble {

    private String nombre;
    private double metraje;
    private int numHabit;
    private boolean garaje;
    private String direccion;
    private Estado estado;
    public Inmueble(double metraje, int numHabit, boolean garaje, Estado estado, String direccion) {
        this.metraje = metraje;
        this.numHabit = numHabit;
        this.garaje = garaje;
        this.estado = estado;
        this.direccion = direccion;
    }

    public Inmueble(String nombre, double metraje, int numHabit, boolean garaje, Estado estado, String direccion) {
        this.nombre = nombre;
        this.metraje = metraje;
        this.numHabit = numHabit;
        this.garaje = garaje;
        this.estado = estado;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getMetraje() {
        return metraje;
    }

    public void setMetraje(double metraje) {
        this.metraje = metraje;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public int getNumHabit() {
        return numHabit;
    }

    public void setNumHabit(int numHabit) {
        this.numHabit = numHabit;
    }

    public boolean isGaraje() {
        return garaje;
    }

    public void setGaraje(boolean garaje) {
        this.garaje = garaje;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Inmuebles.Inmueble{" +
                "nombre='" + nombre + '\'' +
                ", metraje=" + metraje +
                ", numHabit=" + numHabit +
                ", garaje=" + garaje +
                ", direccion='" + direccion + '\'' +
                '}';
    }

    public enum Estado {DISPONIBLE, VENDER, ALQUILER}
}
