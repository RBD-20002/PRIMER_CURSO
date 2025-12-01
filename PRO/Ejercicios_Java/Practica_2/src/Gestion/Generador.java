package Gestion;

import Transporte.AutoBus;
import Transporte.Taxi;
import Transporte.TranVia;
import Transporte.TransportePublico;

import java.util.HashMap;
import java.util.Random;

public class Generador {

    static Random random = new Random();

    static String[] Matricula = {
            "AB123CD", "EF456GH", "IJ789KL", "MN012OP", "QR345ST",
            "UV678WX", "YZ901AB", "CD234EF", "GH567IJ", "KL890MN",
            "LP112QR", "MN223ST", "PQ334UV", "RS445WX", "TU556YZ",
            "VW667AB", "XY778CD", "ZA889EF", "BC990GH", "DE101IJ"
    };

    public static void generarTransporte(HashMap<TransportePublico, String> vehiculos) {
        for (int i = 0; i < 2; i++) {
            String matricula = Matricula[random.nextInt(Matricula.length)];
            int velocidadMax = random.nextInt(120) + 50;

            //AUTOBUS
            boolean wifi = random.nextBoolean();
            TransportePublico autobus = new AutoBus(matricula, 102, velocidadMax, wifi);
            vehiculos.put(autobus, matricula);

            //TAXI
            int pasajeros = (random.nextBoolean() ? 3 : 6);
            double tarifaBase = random.nextDouble() * 50 + 10;
            TransportePublico taxi = new Taxi(matricula, pasajeros, velocidadMax, tarifaBase);
            vehiculos.put(taxi, matricula);

            //TRANVIA
            int vagones = random.nextInt(5) + 1;
            TransportePublico tranVia = new TranVia(matricula, 200, velocidadMax, vagones);
            vehiculos.put(tranVia, matricula);
        }
    }

    public static int validarPasajeros(int choise) {
        int pasajeros = 0;

        switch (choise) {
            case 1 -> pasajeros = 102;
            case 2 -> pasajeros = random.nextBoolean() ? 3 : 6;
            case 3 -> pasajeros = 510;
        }
        return pasajeros;
    }
}
