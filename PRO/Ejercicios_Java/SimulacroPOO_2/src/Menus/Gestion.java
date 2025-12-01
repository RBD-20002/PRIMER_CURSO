package Menus;

import Inmuebles.Casa;
import Inmuebles.Inmueble;
import Inmuebles.MetodosCreacion;
import Inmuebles.Piso;

import java.util.LinkedList;
import java.util.Scanner;

public class Gestion {

    Scanner sc = new Scanner(System.in);
    LinkedList<Inmueble> inmuebles = new LinkedList<>();

    public boolean Vacio() {
        if (inmuebles.isEmpty()) {
            System.out.println("No hay inmuebles registrados");
            return true;
        } else return false;
    }


    public void RegistrarInmueble() {
        int opcion = -1;
        do {
            InfoMenu.menu2();
            try {
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion) {
                    case 1:
                        Casa nuevoCasa = crearCasa();
                        inmuebles.add(nuevoCasa);
                        break;
                    case 2:
                        Piso nuevoPiso = crearPiso();
                        inmuebles.add(nuevoPiso);
                        break;
                    case 3:
                        Inmueble nuevoInmueble = crearOtro();
                        inmuebles.add(nuevoInmueble);
                        break;
                    case 4:
                        System.out.println("Cancelando");
                        break;
                    default:
                        System.out.println("Opcion invalida");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: LO INTRODUCIDO ES INVALIDO");
            }
        } while (opcion != 4);
    }

    public Casa crearCasa() {
        System.out.println("Introduce los datos de la casa: ");
        double metraje = MetodosCreacion.leerMetraje(sc);
        int numHabit = MetodosCreacion.leerHabitacion(sc);
        boolean garaje = MetodosCreacion.leerGaraje(sc);
        Inmueble.Estado estado = Inmueble.Estado.DISPONIBLE;
        String direccion = MetodosCreacion.leerDireccion(sc);
        int numPlantas = MetodosCreacion.leerPlanta(sc);
        boolean piscina = MetodosCreacion.leerPiscina(sc);

        System.out.println("Creado correctamente");
        return new Casa(metraje, numHabit, garaje, estado, direccion, numPlantas, piscina);
    }

    public Piso crearPiso() {
        System.out.println("Introduce los datos del piso: ");
        double metraje = MetodosCreacion.leerMetraje(sc);
        int numHabit = MetodosCreacion.leerHabitacion(sc);
        boolean garaje = MetodosCreacion.leerGaraje(sc);
        Inmueble.Estado estado = Inmueble.Estado.DISPONIBLE;
        String direccion = MetodosCreacion.leerDireccion(sc);
        int numPlantas = MetodosCreacion.leerPlanta(sc);
        Piso.Letras letra = Piso.Letras.valueOf(MetodosCreacion.leerLetra(sc));

        System.out.println("Creado correctamente");
        return new Piso(metraje, numHabit, garaje, estado, direccion, numPlantas, letra);
    }

    public Inmueble crearOtro() {
        System.out.println("Introduce los datos de otro inmueble: ");
        String nombre = MetodosCreacion.leerNombre(sc);
        double metraje = MetodosCreacion.leerMetraje(sc);
        int numHabit = MetodosCreacion.leerHabitacion(sc);
        boolean garaje = MetodosCreacion.leerGaraje(sc);
        Inmueble.Estado estado = Inmueble.Estado.DISPONIBLE;
        String direccion = MetodosCreacion.leerDireccion(sc);

        System.out.println("Creado correctamente");
        return new Inmueble(nombre, metraje, numHabit, garaje, estado, direccion);
    }

    public void ListarInmuebles() {
        if (Vacio()) return;
        for (int i = 0; i < inmuebles.size(); i++) {
            Inmueble inmueble = inmuebles.get(i);
            Double precio = CalcularPrecio(inmueble);
            System.out.println((i + 1) + " " + inmueble);
            if (precio != null) {
                System.out.println(" Precio: " + precio + (inmueble.getEstado() == Inmueble.Estado.ALQUILER ? "$/mes" : "$"));
            } else {
                System.out.println(" Disponible (sin precio áun)");
            }
        }
    }

    public Double CalcularPrecio(Inmueble inmueble) {
        if (inmueble.getEstado() == Inmueble.Estado.ALQUILER) {
            return inmueble.getMetraje() * 70 + (inmueble.isGaraje() ? 60 : 0);
        } else if (inmueble.getEstado() == Inmueble.Estado.VENDER) {
            if (inmueble instanceof Casa casa) {
                return casa.getMetraje() * 1000 + (casa.isGaraje() ? 30000 : 0) + (casa.isPiscina() ? 50000 : 0) + casa.getNumPlantas() * 20000;
            } else if (inmueble instanceof Piso piso) {
                return piso.getMetraje() * 1000 + (piso.isGaraje() ? 35000 : 0) + piso.getNumPiso() * 15000;
            }
        }
        return null;
    }

    public void ListarInmuebles2() {
        if (Vacio()) return;
        for (int i = 0; i < inmuebles.size(); i++) {
            System.out.println((i + 1) + " " + inmuebles.get(i).toString());
        }
    }

    public void EliminarInmueble() {
        if (Vacio()) return;
        ListarInmuebles2();

        int opcion = -1;
        boolean opcionValido = false;
        while (!opcionValido) {
            try {
                System.out.println("ELige que inmueble eliminar: ");
                opcion = Integer.parseInt(sc.nextLine());
                if (opcion >= 1 && opcion <= inmuebles.size()) opcionValido = true;
                else System.out.println("Opcion invalida");
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Dato introducido invalido");
            }
        }
        inmuebles.remove(opcion - 1);
        System.out.println("Eliminado correctamente");
    }

    public void PonerVenta() {
        if (Vacio()) return;
        int opcion = -1;
        boolean opcionValida = false;
        while (!opcionValida) {
            try {
                ListarInmuebles2();
                System.out.println("Elige el inmueble a poner en venta: ");
                opcion = Integer.parseInt(sc.nextLine());
                if (opcion >= 1 && opcion <= inmuebles.size()) {
                    inmuebles.get(opcion - 1).setEstado(Inmueble.Estado.VENDER);
                    opcionValida = true;
                } else System.out.println("Eleccion invalido");
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Dato introducido invalido");
            }
        }
    }

    public void PonerAlquiler() {
        if (Vacio()) return;
        int opcion = -1;
        boolean opcionValida = false;
        while (!opcionValida) {
            try {
                ListarInmuebles2();
                System.out.println("Elige el inmueble a poner en venta: ");
                opcion = Integer.parseInt(sc.nextLine());
                if (opcion >= 1 && opcion <= inmuebles.size()) {
                    inmuebles.get(opcion - 1).setEstado(Inmueble.Estado.ALQUILER);
                    opcionValida = true;
                } else System.out.println("Eleccion invalido");
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Dato introducido invalido");
            }
        }
    }
}
