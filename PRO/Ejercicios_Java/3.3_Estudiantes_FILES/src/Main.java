import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcion = -1;
        do{
            try{
                InfoMenu.menu();
                System.out.println("ELIGE UNA OPCION: ");
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion){
                    case 1 -> GestionEstudiantes.agregarAlumno();
                    case 2 -> GestionEstudiantes.agregarNotaAlumno();
                    case 3 -> GestionEstudiantes.mostrarNotaEstudiante();
                    case 4 -> GestionEstudiantes.mostrarTodosEstudiantes();
                    case 5 -> System.out.println("HASTA LUEGO......");
                    default -> System.out.println("OPCION INVALIDA");
                }
            }catch (NumberFormatException e){
                System.out.println("ERROR:DATO INTRODUCIDO INVALIDO");
            }
        }while (opcion != 5);
    }
}
