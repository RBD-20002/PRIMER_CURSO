public class Main {
    public static void main(String[] args) {
        Contador count = new Contador();
        Contador countParam = new Contador(10);
        Contador countNegative = new Contador(-5); // Lo debería inicializar a 0

        System.out.println("Valores iniciales:");
        System.out.println(count.getCont());
        System.out.println(countParam.getCont());
        System.out.println(countNegative.getCont());

        count.incrementar();
        countParam.decrementar();
        countNegative.decrementar();

        System.out.println("Valores tras los cambios");
        System.out.println(count.getCont());
        System.out.println(countParam.getCont());
        System.out.println(countNegative.getCont());

        count.setCont(5);
        countNegative.setCont(-5);
        System.out.println("Valores tras los cambios");
        System.out.println(count.getCont());
        System.out.println(countParam.getCont());
        System.out.println(countNegative.getCont());

    }
}
