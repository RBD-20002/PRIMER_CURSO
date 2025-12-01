package Transporte;

public class TransportePublico {

    private String matricula;
    private int capacidad;
    private double velocidadMax;

    public TransportePublico(String matricula, int capacidad, double velocidadMax) {
        this.matricula = matricula;
        this.capacidad = capacidad;
        this.velocidadMax = velocidadMax;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public double getVelocidadMax() {
        return velocidadMax;
    }

    public void setVelocidadMax(double velocidadMax) {
        this.velocidadMax = velocidadMax;
    }

    @Override
    public String toString() {
        return "Transporte: " +
                "\n -Matricula='" + matricula +
                "\n -Capacidad=" + capacidad +
                "\n -Velocidad Maxima=" + velocidadMax;
    }
}
