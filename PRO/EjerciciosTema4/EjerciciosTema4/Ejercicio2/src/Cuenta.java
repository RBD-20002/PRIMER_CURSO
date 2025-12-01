public class Cuenta {
    private String nombre;
    private String numeroCuenta;
    private double saldo, tipoInteres;

    public Cuenta() {
        this.nombre = "";
        this.numeroCuenta = "";
    }

    public Cuenta(String nombre, String numeroCuenta, double tipoInteres, double saldo) {
        this.nombre = nombre;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.tipoInteres = tipoInteres;
    }

    public Cuenta(Cuenta cuenta) {
        this.nombre = cuenta.nombre;
        this.numeroCuenta = cuenta.numeroCuenta;
        this.saldo = cuenta.saldo;
        this.tipoInteres = cuenta.tipoInteres;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getTipoInteres() {
        return tipoInteres;
    }

    public void setTipoInteres(double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

    public boolean ingreso(double cantidad) {
        if (cantidad <= 0) return false;
        else {
            setSaldo(getSaldo() + cantidad);
            return true;
        }
    }

    /*
        Podemos acceder a los atributos usando los getters y los setters o accediendo directamente con this
        siempre que estemos en la propia clase, obviamente fuera de ella tan solo con los getters y los setters,
        pero lo lógico es hacerlo dentro siempre de la misma forma por coherencia, aquí en este ejemplo
        lo hago de ambas para que veáis que no hay problema.
     */

    public boolean reintegro(double cantidad) {
        if (cantidad <= 0 || cantidad > this.saldo) return false;
        else {
            this.saldo -= cantidad;
            return true;
        }
    }

    public boolean transferencia(Cuenta cuentaDestino, double cantidad) {
        if(cantidad <= 0) {
            System.out.println("No se ha podido realizar la transferencia, cantidad errónea, debe ser positiva.");
            return false;
        }
        if (cantidad > this.saldo) {
            System.out.println("No se ha podido realizar la transferencia, no hay suficiente saldo");
            return false;
        }
        if (this.equals(cuentaDestino)) {
            System.out.println("No se ha podido realizar la transferencia, debe ser entre cuentas diferentes");
            return false;
        }
        else {
            System.out.println("Transferencia completada.");
            this.reintegro(cantidad); // Quito la cantidad de la cuenta de origen
            cuentaDestino.ingreso(cantidad); // Transfiero la cantidad quitada a la cuenta destino
            return true;
        }
    }
}
