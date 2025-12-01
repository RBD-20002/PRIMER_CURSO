package Menus;

public class InfoMenu {

    public static void menu1() {
        System.out.println("""
                |-----INMOBILIARIA-----|
                |1. Registrar inmuebles|
                |2. Poner en venta     |
                |3. Poner en alquiler  |
                |4. Listar Inmuebles   |
                |5. Eliminar Inmueble  |
                |6. Salir del progrmaa |
                |----------------------|
                """);
    }

    public static void menu2() {
        System.out.println("""
                |--CREAR INMUEBLE--|
                |1. Casa           |
                |2. Piso           |
                |3. Otro           |
                |4. Cancelar       |
                |------------------|
                """);
    }

}
