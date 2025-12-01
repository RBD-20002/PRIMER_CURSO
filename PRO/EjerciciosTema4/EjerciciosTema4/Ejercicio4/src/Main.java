public class Main {
    public static void main (String[] args) {
        Fraccion fr1 = new Fraccion(1,4);
        Fraccion fr2 = new Fraccion(2,4);

        System.out.println(fr1);
        System.out.println(fr2);

        System.out.println("Suma: " + fr1.sumar(fr2));

        System.out.println("Resta: " + fr1.restar(fr2));

        System.out.println("Multiplicación: " + fr1.multiplicar(fr2));

        System.out.println("División: " + fr1.dividir(fr2));

        System.out.println("Tras las operaciones: " + fr1);

        fr1.sumarAEstaFraccion(fr2);

        System.out.println("Suma que afecta a fr1: " + fr1);

        System.out.println("Suma estática: " + Fraccion.sumaDeFracciones(fr1, fr2));

        Fraccion fr3 = Fraccion.sumaDeFracciones(fr1, fr2);
        System.out.println("Fr3: " + fr3);

    }
}
