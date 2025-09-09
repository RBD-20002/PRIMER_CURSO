import java.util.Arrays;

public class SalaCine {
    private double precio;
    private Pelicula pelicula;
    private Asiento[][] asientos;

    public SalaCine(int filas, int columnas, double precio, Pelicula pelicula) {
        asientos = new Asiento[filas][columnas];
        this.precio = precio;
        this.pelicula = pelicula;
        crearAsientos();
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Asiento[][] getAsientos() {
        return asientos;
    }

    public void setAsientos(Asiento[][] asientos) {
        this.asientos = asientos;
    }

    public int getFilas() {
        return asientos.length;
    }

    public int getColumnas() {
        return asientos[0].length;
    }

    private void crearAsientos() {
        int fila = asientos.length;
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                char letra = (char) ('A' + j); // Estoy usando el valor ASCII para ir recorriendo las letras mayusc
                asientos[i][j] = new Asiento(letra, fila, null);
            }
            fila--;
        }
    }

    public Asiento getAsiento(int fila, char letra) {
        return asientos[asientos.length - fila - 1][letra - 'A'];
    }

    public boolean hayButacaDisponible() {
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                if (!asientos[i][j].ocupado()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean butacaDisponible(int fila, char columna) {
        return !getAsiento(fila, columna).ocupado();
    }

    public boolean puedeSentarse(Espectador espectador) {
        return espectador.dineroSuficiente(precio) && espectador.edadSuficiente(getPelicula().getEdadMinima());
    }

    public void ocuparButaca(Espectador espectador, int fila, char columna) {
        getAsiento(fila, columna).setEspectador(espectador);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Información de la sesión:");
        sb.append("\nPelicula: ").append(pelicula);
        sb.append("\nPrecio de la entrada:").append(precio).append("\n");
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                sb.append(asientos[i][j]).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
