import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Para evitar crear objetos de esta clase, podría hacerla abstracta o 'abstract'
 * pero eso ya lo veremos en el tema siguiente.
 */
public class Empresa {
    private static Empleado[] empleados;
    private static final int MAX_EMPLEADOS = 20;
    private static Scanner sc;

    public static void leerEmpleados() {
        boolean numEmpleadosOk = false;
        sc = new Scanner(System.in);
        while (!numEmpleadosOk) {
            // Declaramos el Scanner para tener su referencia antes del try
            try {
                int numEmpleados = 0;
                System.out.println("Introduce el número de empleados (max 20)");
                numEmpleados = sc.nextInt();
                System.out.println("Introduzca el importe al que se pagan las horas extra: ");
                Empleado.setImporteHoraExtra(sc.nextDouble());
                if (numEmpleados < 1 || numEmpleados > MAX_EMPLEADOS) {
                    System.out.println("El número de empleados debe ser positivo y menor a 20");
                } else if (Empleado.getImporteHoraExtra() <= 0) {
                    System.out.println("El importe de la hora extra debe ser positivo");
                } else {
                    numEmpleadosOk = true;
                    empleados = new Empleado[numEmpleados];
                }
            } catch (InputMismatchException e) {
                System.out.println("Debe introducir un número" + e.getMessage());
            }
        }
        sc.nextLine();
        for (int i = 0; i < empleados.length; i++) {
            empleados[i] = nuevoEmpleado();
        }
        sc.close();
    }

    private static Empleado nuevoEmpleado() {
        System.out.println("Introduce el nombre del Empleado: ");
        String nombre = sc.nextLine();
        System.out.println("Introduce el NIF del Empleado: ");
        String nif = sc.nextLine();
        System.out.println("Introduce el sueldo base del Empleado: ");
        double sueldoBase = sc.nextDouble();
        sc.nextLine();
        System.out.println("Introduce el número de horas extra del Empleado: ");
        int horasExtra = sc.nextInt();  // Habría que capturar la InputMismatch
        sc.nextLine();
        System.out.println("Introduce el tipo de IRPF del Empleado: ");
        double irpf = sc.nextDouble();  // Habría que capturar la InputMismatch
        sc.nextLine();
        boolean casadoOk = false;
        String casado = null;
        while (!casadoOk) {
            System.out.println("Introduce si está o no casado el Empleado (s/n): ");
            casado = sc.nextLine().toLowerCase();
            if (casado.equals("s") || casado.equals("n")) {
                casadoOk = true;
            } else System.out.println("Introduzca solo 's' o 'n'");
        }
        boolean isCasado = (casado.equals("s"));
        System.out.println("Introduce el número de hijos del Empleado: ");
        int numHijos = sc.nextInt(); // Habría que capturar la InputMismatch
        sc.nextLine();
        Empleado empleado = new Empleado(nif);
        empleado.setCasado(isCasado);
        empleado.setHorasExtra(horasExtra);
        empleado.setNombre(nombre);
        empleado.setNumHijos(numHijos);
        empleado.setSueldoBase(sueldoBase);
        empleado.setTipoIrpf(irpf);
        return empleado;
    }

    public static void mostrarEmpleados() {
        for (Empleado empleado: empleados) {
            System.out.println(empleado + "\n");
        }
    }

    /**
     * Muestra el empleado que más cobra
     */
    public static void mostrarEmpleadoMasCobra() {
        int pos = 0;
        for(int i = 1; i < empleados.length; i++) {
            if (empleados[i].sueldoLiquido() > empleados[pos].sueldoLiquido()) {
                pos = i;
            }
        }
        System.out.println(empleados[pos]);
    }

    /**
     * Muestra el empleado que menos cobra
     */
    public static void mostrarEmpleadoMenosCobra() {
        int pos = 0;
        for(int i = 1; i < empleados.length; i++) {
            if (empleados[i].sueldoLiquido() < empleados[pos].sueldoLiquido()) {
                pos = i;
            }
        }
        System.out.println(empleados[pos]);
    }

    /**
     * Muestra el empleado que más cobra por las horas extras
     */
    public static Empleado empleadoMasHorasExtra() {
        int pos = 0;
        for(int i = 1; i < empleados.length; i++) {
            if (empleados[i].getHorasExtra() > empleados[pos].getHorasExtra()) {
                pos = i;
            }
        }
        return empleados[pos];
    }

    /**
     * Muestra el empleado que menos cobra por las horas extras
     */
    public static Empleado empleadoMenosHorasExtra() {
        int pos = 0;
        for(int i = 1; i < empleados.length; i++) {
            if (empleados[i].getHorasExtra() < empleados[pos].getHorasExtra()) {
                pos = i;
            }
        }
        return empleados[pos];
    }

    /**
     * Muestra el array de los empleados ordenados de mayor a menor segun su salario
     * Vamos a usar el método de la ordenadción por burbuja
     */
    public static void mostrarEmpleadosOrdenadosPorSalarioDesc() {
        Empleado[] aux = Arrays.copyOf(empleados, empleados.length); // Hacemos una copia del array para no perder el original
        // Ordenación por burbuja, es decir, usando el algoritmo de bubblesort
        for (int i = 0; i < aux.length - 1; i++) {
            for (int j = 0; j <  aux.length - i - 1; j++) {
                if(aux[j].sueldoLiquido() < aux[j + 1].sueldoLiquido()) {
                    Empleado temp = aux[j];
                    aux[j] = aux[j + 1];
                    aux[j + 1] = temp;
                }
            }
        }
        for (Empleado empleado: aux) System.out.println(empleado); // Los mostramos ya ordandos
    }

    /**
     * Devuelve un array con los empleados ordenados de menor a mayor con respecto a
     * lo que cobran, pero esta vez vamos a usar un objeto Comparator
     */
    public static Empleado[] empleadosOrdenadosPorSalarioAsc() {
        Empleado[] aux = Arrays.copyOf(empleados, empleados.length);
        Arrays.sort(aux, Comparator.comparingDouble(Empleado::sueldoLiquido));
        return aux;
    }
}
