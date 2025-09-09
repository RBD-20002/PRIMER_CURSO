public class Main {
    public static void main(String[] args) {
        Fecha fecha = new Fecha(15,12,2023);
        while (fecha.getMes() < 4 || fecha.getMes() > 11) {
            System.out.println(fecha);
            fecha.diaSiguiente();
        }

        Fecha fechaInvalida = new Fecha(29,2,2013);
        System.out.println(fechaInvalida); // Debería mostrar la fecha por defecto
    }
}
