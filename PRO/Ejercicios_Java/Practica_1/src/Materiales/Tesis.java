package Materiales;

public class Tesis extends Material {

    private String universidad;
    private String departamento;

    public Tesis(String titulo, String autor, int anoPublicacion, Estado disponible, String universidad, String departamento) {
        super(titulo, autor, anoPublicacion, Estado.DISPONIBLE);
        this.universidad = universidad;
        this.departamento = departamento;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public double calcularMulta(int diaAtrasado) {
        return diaAtrasado * 0.20;
    }

    @Override
    public String toString() {
        return "Tesis: " +
                "\n -Universidad: " + universidad +
                "\n -Departamento: " + departamento;
    }
}
