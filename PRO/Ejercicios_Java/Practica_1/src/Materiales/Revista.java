package Materiales;

public class Revista extends Material {

    private int numero;
    private String imprenta;

    public Revista(String titulo, String autor, int anoPublicacion, Estado disponible, int numero, String imprenta) {
        super(titulo, autor, anoPublicacion, Estado.DISPONIBLE);
        this.numero = numero;
        this.imprenta = imprenta;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getImprenta() {
        return imprenta;
    }

    public void setImprenta(String titulo) {
        this.imprenta = imprenta;
    }

    @Override
    public double calcularMulta(int diaAtrasado) {
        return diaAtrasado * 0.30;
    }

    @Override
    public String toString() {
        return "Revista:" +
                "\n -Numero: " + numero +
                "\n -Imprenta: " + imprenta;
    }
}
