public class Contador {
    private int cont;

    public Contador() {}

    public Contador(int cont) {
        this.cont = (cont < 0) ? 0 : cont; // Es lo mismo que un if-else
    }

    public int getCont() { return this.cont; }

    public void setCont(int cont) {
        this.cont = (cont < 0) ? 0 : cont;
    }

    public void incrementar() {
        this.cont++;
    }

    public void decrementar() {
        if(cont > 0) this.cont--;
    }
}
