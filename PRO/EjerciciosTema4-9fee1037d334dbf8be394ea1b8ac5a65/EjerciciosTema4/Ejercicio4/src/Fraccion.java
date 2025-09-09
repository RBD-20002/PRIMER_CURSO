public class Fraccion {
    private int num, den;

    public Fraccion() {
        this.den = 1;
    }

    public Fraccion(int num, int den) {
        this.num = num;
        this.den = (den == 0) ? 1 : den;
        simplificar();
    }

    public Fraccion(int num) {
        this.num = num;
        this.den = 1;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getDen() {
        return den;
    }

    public void setDen(int den) {
        this.den = (den == 0) ? 1 : den;
    }

    /*
     Función que calcula el MCD
     */
    private int mcd() {
        int x = Math.abs(num); // Valor absoluto del numerador
        int y = Math.abs(den); // Valor absoluto del denominador
        if(y == 0) return x;
        int aux;
        while(y != 0) {
            aux = x % y;
            x = y; // machaco el valor de x por el de y
            y = aux; // machaco el valor de y por el resultado del resto de la división
        }
        return x; // En la última vuelta tengo el mcd en la X
    }

    private void simplificar() {
        int mcd = mcd();
        num /= mcd;
        den /= mcd;
    }

    private static void simplificar(Fraccion fr) {
        fr.setDen(fr.den/ fr.mcd());
        fr.setNum((fr.num/ fr.mcd()));
    }

    // Al llamar a la fracción, le pasamos otra, y devolvemos una nueva con la suma de ambas
    public Fraccion sumar(Fraccion f) {
        Fraccion aux = new Fraccion();
        aux.num = this.num * f.den + this.den * f.num;
        aux.den = this.den * f.den;
        aux.simplificar();
        return aux;
    }

    // Machaca el valor del objeto que llama, con el resultado de la suma con la que le llega
    public void sumarAEstaFraccion(Fraccion f) {
        this.num = this.num * f.den + this.den * f.num;
        this.den = this.den * f.den;
        this.simplificar();
    }

    // Suma las fracciones que le llegan y devuelve el resultado en un nuevo objeto Fraccion
    // Méthod estático, de forma que es de clase y no podemos usar un objeto para acceder a él
    public static Fraccion sumaDeFracciones(Fraccion a, Fraccion b) {
        Fraccion aux = new Fraccion();
        aux.num = a.num * b.den + a.den * b.num;
        aux.den = a.den * b.den;
        aux.simplificar();
        return aux;
    }

    public Fraccion restar(Fraccion f) {
        Fraccion aux = new Fraccion();
        aux.num = this.num * f.den - this.den * f.num;
        aux.den = this.den * f.den;
        aux.simplificar();
        return aux;
    }

    public Fraccion multiplicar(Fraccion f) {
        Fraccion aux = new Fraccion();
        aux.num = this.num * f.num;
        aux.den = this.den * f.den;
        aux.simplificar();
        return aux;
    }

    public Fraccion dividir(Fraccion f) {
        Fraccion aux = new Fraccion();
        aux.num = this.num * f.den;
        aux.den = this.den * f.num;
        aux.simplificar();
        return aux;
    }

    @Override
    public String toString() {
        simplificar();
        return num + " / " + den;
    }
}
