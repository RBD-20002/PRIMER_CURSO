package Gestiones;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MetodosCreacion {

    public String leerDato(Scanner sc) {
        while (true) {
            String dato = sc.nextLine();
            if (!dato.isBlank()) return dato;
            System.out.println("EL dato no puede estar en blanco");
        }
    }

    public double leerNumero(Scanner sc) {
        while (true) {
            try {
                double dato = Double.parseDouble(sc.nextLine());
                if (dato >= 1) return dato;
                else System.out.println("El precio no puede ser negativo");
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Dato introducido invalido");
            }
        }
    }

    public boolean leerVIP(Scanner sc) {
        while (true) {
            String dato = sc.nextLine();
            if (!dato.isBlank()) {
                if (dato.equalsIgnoreCase("S".toLowerCase())) return true;
                else if (dato.equalsIgnoreCase("N".toLowerCase())) return false;
            } else System.out.println("El dato es invalido");
        }
    }

    public void leerFechaCaducidad(Scanner sc) {
        try {
            String dato = sc.nextLine();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fechaLimite = LocalDate.of(2025, 4, 30);
            LocalDate fechaIngreso = LocalDate.parse(dato, formato);
            if (fechaIngreso.isAfter(fechaLimite))
                System.out.println("La fecha es mayor que la limite" + fechaLimite.format(formato));
            else if (fechaIngreso.isBefore(LocalDate.now())) System.out.println("La fecha ya coduco");
            else System.out.println("Fecha valida: " + fechaIngreso.format(formato));
        } catch (NumberFormatException e) {
            System.out.println("La fecha introducida es invalida");
        }
    }
}