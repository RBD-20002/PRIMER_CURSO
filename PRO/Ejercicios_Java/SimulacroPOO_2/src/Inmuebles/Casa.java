package Inmuebles;

public class Casa extends Inmueble {

    private int numPlantas;
    private boolean piscina;

    public Casa(double metraje, int numHabit, boolean garaje, Inmueble.Estado estado, String direccion, int numPlantas, boolean piscina) {
        super(metraje, numHabit, garaje, estado, direccion);
        this.numPlantas = numPlantas;
        this.piscina = piscina;
    }

    public int getNumPlantas() {
        return numPlantas;
    }

    public void setNumPlantas(int numPlantas) {
        this.numPlantas = numPlantas;
    }

    public boolean isPiscina() {
        return piscina;
    }

    public void setPiscina(boolean piscina) {
        this.piscina = piscina;
    }

    @Override
    public String toString() {
        return "Inmuebles.Casa{" +
                "numPlantas=" + numPlantas +
                ", piscina=" + piscina +
                '}';
    }
}
