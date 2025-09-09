public class Asiento {
    private char letra;
    private int fila;
    private Espectador espectador;

    public Asiento(char letra, int fila, Espectador espectador) {
        this.letra = letra;
        this.fila = fila;
        this.espectador = espectador;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public Espectador getEspectador() {
        return espectador;
    }

    public void setEspectador(Espectador espectador) {
        this.espectador = espectador;
    }

    public boolean ocupado() {
        return espectador != null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(letra).append(" ").append(fila);
        sb.append(": ");
        if (ocupado()) sb.append(espectador.getNombre());
        else sb.append("VACÍO");
        return sb.toString();
    }
}
