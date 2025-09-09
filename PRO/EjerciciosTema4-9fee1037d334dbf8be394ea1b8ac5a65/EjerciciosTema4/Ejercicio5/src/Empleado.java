public class Empleado {
    private String nif, nombre;
    private int horasExtra, numHijos;
    private double sueldoBase, tipoIrpf;
    private boolean casado;

    private static double importeHoraExtra;

    public Empleado(String nif) {
        this.nif = nif;
    }

    public Empleado() {
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(int horasExtra) {
        this.horasExtra = horasExtra;
    }

    public int getNumHijos() {
        return numHijos;
    }

    public void setNumHijos(int numHijos) {
        this.numHijos = numHijos;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public double getTipoIrpf() {
        return tipoIrpf;
    }

    public void setTipoIrpf(double tipoIrpf) {
        this.tipoIrpf = tipoIrpf;
    }

    public boolean isCasado() {
        return casado;
    }

    public void setCasado(boolean casado) {
        this.casado = casado;
    }

    public static double getImporteHoraExtra() {
        return importeHoraExtra;
    }

    public static void setImporteHoraExtra(double importeHoraExtra) {
        Empleado.importeHoraExtra = importeHoraExtra;
    }

    @Override
    public String toString() {
        return nif + " " + nombre +
                "\nSueldo Base: " + sueldoBase +
                "\nHoras Extras: " + horasExtra +
                "\ntipo IRPF: " + tipoIrpf +
                "\nCasado: " + casado +
                "\nNúmero de Hijos: " + numHijos +
                "\nSalario líquido: " + sueldoLiquido();
    }

    public double complemento() {
        return horasExtra * importeHoraExtra;
    }

    public double sueldoBruto() {
        return sueldoBase + complemento();
    }

    public double retenciones() {
        double retencion = tipoIrpf;
        retencion -= numHijos;
        if (casado) retencion -= 2;
        if (retencion < 0) retencion = 0;
        return sueldoBruto() * retencion/100;
    }

    public double sueldoLiquido() {
        return sueldoBruto() - retenciones();
    }
}
