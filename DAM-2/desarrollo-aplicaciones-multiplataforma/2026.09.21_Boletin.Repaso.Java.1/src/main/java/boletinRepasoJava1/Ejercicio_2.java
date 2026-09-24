package boletinRepasoJava1;

import java.util.Scanner;

public class Ejercicio_2 {
    public static void main(String[] args) {

        /*
        * Escribe un programa Java que pida al usuario que introduzca una password
        * numérica, de valor comprendido entre 0 y 999 (comprueba que el valor introducido
        * por el usuario está en dicho rango). El programa tiene almacenado el valor de la
        * password correcta en una variable llamada key (que vale 353, que es la contraseña
        * correcta). El objetivo del usuario es introducir la password correcta, en cuyo caso el
        * programa debe imprimir el mensaje: “acceso autorizado”. El usuario tiene un
        * máximo de 3 intentos para introducir la password correcta. Si el usuario falla en sus
        * tres intentos, el programa presentará el mensaje de: “Ha excedido el número de
        * intentos permitidos” y acaba el programa.
        * */


        Scanner sc = new Scanner(System.in);

        // Declaracion de variables inmutables.
        final int KEY = 353;
        final int VALOR_MAX = 999;
        final int VALOR_MIN = 0;

        // Declaracion de variables mutables.
        int intentos = 3;
        int passwordIntroducida;
        boolean passwordCorrecta = false;


        // Lógica principal
        System.out.println("** ADIVINA LA CONTRASEÑA NUMERICA **");

        while (intentos > 0 && !passwordCorrecta) {
            System.out.println("Introduzca la posible contraseña: ");
            passwordIntroducida = sc.nextInt();
            intentos--;

            if (passwordIntroducida > VALOR_MAX || passwordIntroducida < VALOR_MIN) {
                System.out.println("Valor fuera del rango: " + VALOR_MIN + " -- " + VALOR_MAX + " inserte un valor dentro de este rango.");
            }

            if (passwordIntroducida == KEY) {
                passwordCorrecta = true;
                System.out.println("Acceso autorizado.");
            }
        }

        sc.close();
    }
}
