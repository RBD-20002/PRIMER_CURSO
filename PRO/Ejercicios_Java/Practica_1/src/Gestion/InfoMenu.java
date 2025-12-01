package Gestion;

public class InfoMenu {

    public void menu1() {
        System.out.println("""
                |------BIBLIOTECA------|
                |1. Registrar          |
                |2. Registrar Préstamo |
                |3. Calcular Multas    |
                |4. Filtrar Materiales |
                |5. Listar             |
                |6. Salir              |
                |----------------------|
                """);
    }

    public void menu2() {
        System.out.println("""
                |---MATERIALES---|
                |1. Libro        |
                |2. Revista      |
                |3. Tesis        |
                |4. Regresar     |
                |----------------|
                """);
    }

    public void menu3() {
        System.out.println("""
                |---FILTRAR---|
                |1. Titulo    |
                |2. Autor     |
                |3. Regresar  |
                |-------------|
                """);
    }

    public void menu4() {
        System.out.println("""
                |---OPCIONES---|
                |1. Materiales |
                |2. SQL.Usuario    |
                |3. Regresar   |
                |--------------|
                """);
    }

    public void menu5() {
        System.out.println("""
                |----LISTAR----|
                |1. Materiales |
                |2. Usuarios   |
                |3. Regresar   |
                |--------------|
                """);
    }
}
