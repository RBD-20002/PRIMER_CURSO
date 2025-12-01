package Principales;

public class Cliente {

    private String nombre;
    private String apellido;
    private boolean VIP;

    public Cliente(String nombre, String apellido, boolean VIP) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.VIP = VIP;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public boolean isVIP() {
        return VIP;
    }

    public void setVIP(boolean VIP) {
        this.VIP = VIP;
    }

    @Override
    public String toString() {
        return "Cliente: " + nombre + " " + apellido +
                "\nVIP: " + VIP;
    }
}
