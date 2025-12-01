package Usuarios;

public class Usuario {

    private static String codigo;
    private static int contador = 1;
    private String nombre;
    private String apellido;

    public Usuario(String cdigogo, String nombre, String apellido) {
        codigo = String.format("CD-(%d)", contador++);
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public static String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        Usuario.codigo = codigo;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        Usuario.contador = contador;
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

    @Override
    public String toString() {
        return "Usuario:" +
                "\n -Nombre: " + nombre +
                "\n -Apellido: " + apellido;
    }
}
