package Transporte;

public class TranVia extends TransportePublico {

    private int numVagones;

    public TranVia(String matricula, int capacidad, double velocidadMax, int numVagones) {
        super(matricula, capacidad, velocidadMax);
        this.numVagones = numVagones;
    }

    public int getNumVagones() {
        return numVagones;
    }

    public void setNumVagones(int numVagones) {
        this.numVagones = numVagones;
    }

    @Override
    public String toString() {
        return "TranVia: " +
                "\n Numero de Vagones=" + numVagones;
    }
}
