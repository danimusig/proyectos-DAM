package boletinRepasoJava1;

public class Ejercicio_1 {
    public static void main(String[] args) {

        /*
        * Escribe un programa Java que imprima por pantalla los números del 1 al 100 que
        * sean divisibles por 3.
        * */

        for(int i=1;i<100;i++) {
            if(i%3==0) {
                System.out.println(i + " - Es divisor de 3!");
            }
        }

    }
}