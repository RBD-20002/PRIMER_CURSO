package Transporte;

public class AutoBus extends TransportePublico {

    private boolean wifi;

    public AutoBus(String matricula, int capacidad, double velocidadMax, boolean wifi) {
        super(matricula, capacidad, velocidadMax);
        this.wifi = wifi;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    @Override
    public String toString() {
        return "AutoBus: " +
                "\n -Wifi=" + wifi;
    }
}
