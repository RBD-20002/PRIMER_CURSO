import java.time.LocalDate;

public class Persona {
    private String nombre, direccion, ciudad, codPostal;
    private Fecha fechaNacimiento;

    public Persona(String nombre, String direccion, String ciudad, String codPostal, Fecha fechaNacimiento) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.codPostal = codPostal;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public Fecha getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Fecha fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n" +
                "Fecha Nacimiento: " + fechaNacimiento + "\n" +
                "Dirección: " + direccion + "\n" +
                codPostal + " " + ciudad + "\n";
    }

    /*
    Para conseguir la fecha actual del sistema tenemos varias opciones:
    - La clase Date (java.util.Date) (deprecated) pero aún funciona
    - LocalDate --> Nos da la fecha actual sin hora
    - LocalDateTime --> Fecha actual con la hora
    - ZonedDateTime --> Fecha y hora con zona horaria
    - LocalDateTime + FateTimeFormatter --> Darle un formato concreto a LocalDateTime
    - Calendar --> Nos da en general información del calendario
    En este ejemplo vamos a usar LocalDate, ya que la hora nos da igual
     */
    public boolean esMayorDeEdad() {
        LocalDate fechaActual = LocalDate.now(); // Usa el formato: YYYY-MM-DD
        Fecha fechaDeHoy = new Fecha(fechaActual.getDayOfMonth(), fechaActual.getMonthValue(), fechaActual.getYear());
        if ((fechaDeHoy.getAnio() - fechaNacimiento.getAnio()) < 18) return false;
        else if ((fechaDeHoy.getAnio() - fechaNacimiento.getAnio()) == 18) {
            if (fechaDeHoy.getMes() > fechaNacimiento.getMes()) return false;
            else if (fechaDeHoy.getMes() == fechaNacimiento.getMes()) {
                return fechaDeHoy.getDia() >= fechaNacimiento.getDia();
            } else return true;
        } else return true;
    }
}
