package boletinRepasoJava1;

import java.util.Scanner;



public class Ejercicio_3 {
    public static void main (String[] args) {

         /*
         * Implementa una variante del programa anterior que, en cada intento que introduce
         * el usuario, el programa indica si ha introducido un dígito correcto en el orden
         * correcto, o, en su defecto, imprime un asterisco. El número secreto sigue siendo 353.
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

        // Logica principal.
        System.out.println("** ADIVINA LA CONTRASEÑA NUMERICA **");

        while (intentos > 0 && !passwordCorrecta) {
            System.out.println("\nIntroduzca la posible contraseña: ");
            passwordIntroducida = sc.nextInt();

            if (passwordIntroducida > VALOR_MAX || passwordIntroducida < VALOR_MIN) {
                System.out.println("Valor fuera del rango: " + VALOR_MIN + " -- " + VALOR_MAX + " inserte un valor dentro de este rango.");
            }

            if (passwordIntroducida == KEY) {
                passwordCorrecta = true;
                System.out.println("Acceso concedido.");
            } else {
                intentos--;

                String passwordIntroducidaParseada = String.format("%03d", passwordIntroducida);
                String keyParseada = String.format("%03d", KEY);

                String passwordDescubierta = "";

                for (int i = 0; i < keyParseada.length(); i++) {
                    if (passwordIntroducidaParseada.charAt(i) == keyParseada.charAt(i)) {
                        passwordDescubierta += keyParseada.charAt(i);
                    } else {
                        passwordDescubierta += '*';
                    }
                }

                if (intentos > 0) {
                    System.out.println("Intentelo otra vez, le quedan " + intentos + " intentos.");
                    System.out.println("-- Pista: " + passwordDescubierta);
                } else {
                    System.out.println("Acceso denegdo. Intentos restantes 0");
                }
            }
        }
        sc.close();
    }
}
