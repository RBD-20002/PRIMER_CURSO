package Transporte;

import java.util.Scanner;

public class Taxi extends TransportePublico {

    private double tarifaBase;

    public Taxi(String matricula, int capacidad, double velocidadMax, double tarifaBase) {
        super(matricula, capacidad, velocidadMax);
        this.tarifaBase = tarifaBase;
    }

    public double getTarifaBase() {
        return tarifaBase;
    }

    public void setTarifaBase(double tarifaBase) {
        this.tarifaBase = tarifaBase;
    }

    public double calcularTarifa() {
        double tarifa = tarifaBase;
        boolean tarifaValida = false;
        Scanner sc = new Scanner(System.in);

        while (!tarifaValida) {
            System.out.println("Ingresa la distancia: ");
            double distancia = Double.parseDouble(sc.nextLine());

            if (distancia <= 0) {
                System.out.println("La distancia no puede ser negativa");
                continue;
            }
            tarifa = distancia * 1.5;
            tarifaValida = true;
        }
        sc.close();
        return tarifa;
    }

    @Override
    public String toString() {
        return "Taxi: " +
                "\n -Tarifa Base: " + tarifaBase;
    }
}
