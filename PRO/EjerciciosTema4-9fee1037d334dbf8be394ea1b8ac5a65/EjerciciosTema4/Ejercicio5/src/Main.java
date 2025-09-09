public class Main {
    public static void main(String[] args) {
        Empresa.leerEmpleados();
        System.out.println("Lista de empleados: ");
        Empresa.mostrarEmpleados();
        System.out.println("Empleado que más cobra");
        Empresa.mostrarEmpleadoMasCobra();
        System.out.println("Empleado que menos cobra");
        Empresa.mostrarEmpleadoMenosCobra();
        System.out.println("Empleado que cobra más por las horas extra");
        System.out.println(Empresa.empleadoMasHorasExtra());
        System.out.println("Empleado que menos cobra por las horas extra");
        System.out.println(Empresa.empleadoMenosHorasExtra());
        System.out.println("Empleados ordenados según lo que cobran: ");
        Empresa.mostrarEmpleadosOrdenadosPorSalarioDesc();
        System.out.println("Empleados ordenados según lo que cobran (asc)");
        Empleado[] ordenados = Empresa.empleadosOrdenadosPorSalarioAsc();
        for(Empleado empleado: ordenados) System.out.println(empleado);

    }
}
