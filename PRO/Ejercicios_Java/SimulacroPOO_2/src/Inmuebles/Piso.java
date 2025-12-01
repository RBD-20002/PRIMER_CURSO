package Inmuebles;

public class Piso extends Inmueble {

    private int numPiso;
    private Letras letra;
    public Piso(double metraje, int numHabit, boolean garaje, Estado estado, String direccion, int numPiso, Letras letra) {
        super(metraje, numHabit, garaje, estado, direccion);
        this.numPiso = numPiso;
        this.letra = letra;
    }

    public int getNumPiso() {
        return numPiso;
    }

    public void setNumPiso(int numPiso) {
        this.numPiso = numPiso;
    }

    public Letras getLetra() {
        return letra;
    }

    public void setLetra(Letras letra) {
        this.letra = letra;
    }

    @Override
    public String toString() {
        return "Inmuebles.Piso{" +
                "numPiso=" + numPiso +
                ", letra=" + letra +
                '}';
    }

    public enum Letras {A, B, C, D, E, F}
}
