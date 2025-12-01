package Gestiones;

public class InfoMenu {

    public void menu1() {
        System.out.println("""
                |-----SUPERMERCADO-----|
                |1. Registrar          |
                |2. Eliminar Producto  |
                |3. Listar Producto    |
                |4. Filrar Producto    |
                |5. Atender Clientes   |
                |6. Salir              |
                |----------------------|
                """);
    }

    public void menu2() {
        System.out.println("""
                |----REGISTRAR----|
                |1. Cliente       |
                |2. Producto      |
                |3. Volver        |
                |-----------------|
                """);
    }

    public void menu3() {
        System.out.println("""
                |----FILTRAR----|
                |1. Precio      |
                |2. Nombre      |
                |3. Volver      |
                |---------------|
                """);
    }

    public void menu4() {
        System.out.println("""
                |--TIPO PRODUCTO--|
                |1. Carnes        |
                |2. Verduras      |
                |3. Enlatados     |
                |4. Volver        |
                |-----------------|
                """);
    }

    public void menu5() {
        System.out.println("""
                |--TIPO VERDURA--|
                |1. Legumbras    |
                |2. Verdes       |
                |3. Tuberculos   |
                |4. Hongos       |
                |5. Frutos       |
                |----------------|
                """);
    }
}
