public class Fecha {
    private int dia, mes, anio;

    public Fecha() {}

    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public Fecha(Fecha fecha) {
        this.dia = fecha.dia;
        this.mes = fecha.mes;
        this.anio = fecha.anio;
    }

    public boolean esMayorQue(Fecha fecha) {
        if (anio > fecha.anio) return true;
        else if (anio == fecha.anio && mes > fecha.mes) return true;
        else return anio == fecha.anio && mes == fecha.mes && dia > fecha.dia;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }


    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    /**
     * Método que comprueba que el año sea válido
     * @param anio
     * @return true or false
     */
    private static boolean anioCorrecto(int anio) {
        return anio >= 0 && anio <= 9999;
    }

    private static boolean mesCorrecto(int mes) {
        return mes >= 1 && mes <= 12;
    }

    private static boolean diaCorrecto(int dia, int mes, int anio) {
        if (dia < 1 || dia > 31) return false;
        if (mes == 2 ) {
            if (esBisiesto(anio)) return dia <= 29;
            else return dia <= 28;
        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            return dia <= 30;
        } else {
            return true; // Llegados a este punto ya se que el día es válido y el mes tiene 31 días
        }
    }

    private static boolean esBisiesto(int anio) {
        return (anio % 4) == 0 && ((anio % 100) != 0 || (anio % 400) == 0);
    }

    public static boolean fechaCorrecta(Fecha fecha) {
        return diaCorrecto(fecha.dia, fecha.mes, fecha.anio) && mesCorrecto(fecha.mes) && anioCorrecto(fecha.anio);
    }

    /**
     * Método que aumenta nuestro objeto Fecha al día siguiente, comprobando en cada cambio de día que la nueva
     * fecha es correcta, para ello utilizamos el método estático fechaCorrecta(Fecha fecha) pasándole
     * la referencia 'this' del propio objeto que hace la llamada
     */
    public void diaSiguiente() {
        dia++;
        if (!fechaCorrecta(this)) { // this hace referencia al objeto que hace la llamada, en este caso this es una 'Fecha'
            dia = 1;
            mes++; // Esto nos sirve para todos los casos, excepto haber llegado al 31 de diciembre
            if(!fechaCorrecta(this)) {
                mes = 1;
                anio++; // Para reiniciar con el nuevo año
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (dia < 10) sb.append(0);
        sb.append(dia);
        sb.append("-");
        if (mes < 10) sb.append(0);
        sb.append(mes);
        sb.append("-");
        if (anio < 10) sb.append("000");
        else if (anio < 100) sb.append("00");
        else if (anio < 1000) sb.append(0);
        sb.append(anio);
        return sb.toString();
    }

}
