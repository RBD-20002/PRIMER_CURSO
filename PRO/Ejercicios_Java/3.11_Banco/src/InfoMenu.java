public class InfoMenu {

    public static void menu1(){
        System.out.println("""
                |BANCO:                 |
                |1. AGREGAR CLIENTE     |
                |2. ELIMINAR CLIENTE    |
                |3. MODIFICAR CLIENTE   |
                |4. LISTAR CLIENTES     |
                |5. LISTAR MOVIMIENTOS  |
                |6. BUSCAR POR NOMBRE   |
                |7. HACER TRANSFERENCIA |
                |8. SALIR               |
                |ELIGE UNA OPCION:      |
                """);
    }

    public static void menu2(){
        System.out.println("""
                |MODIFICAR DATOS     |
                |1. APELLIDOS        |
                |2. DIRECCION        |
                |3. VOLVER AL INICIO |
                """);
    }
}
