package boletinRepasoJava1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ejercicio_4 {
    public static void main (String[] args) {

        /*
         *  Implementa un programa que convierta un número decimal en su representación
         *  binaria. Hay que tener en cuenta que desconocemos cuántas cifras tiene el número
         *  que introduce el usuario. Recuerda que para pasar el número de decimal a binario se
         *  realizan divisiones sucesivas entre 2 hasta que el cociente sea cero, y posteriormente
         *  se cogen los restos de esas divisiones en orden inverso.
         */

        Scanner sc = new Scanner(System.in);

        int numDecimal;
        ArrayList<Integer> numBinario = new ArrayList<>();

        System.out.println("-- Conversor Decimal/Binario --");
        System.out.println("Introduzca un numero decimal para convertirlo a binario: ");
        int numIntroducido = sc.nextInt();
        numDecimal = numIntroducido;
        // Iba a usar metodos de Java para convertir el numero y procesarlo pero en internet he visto
        // que se podia resolver a pura matemática.

        if (numDecimal == 0) {
            numBinario.add(0);
        } else {
            while (numDecimal > 0) {
                numBinario.add(numDecimal % 2);
                numDecimal /= 2;
            }

            Collections.reverse(numBinario);

            System.out.println("La conversion de " + numIntroducido + " a binario es: ");
            for (Integer num : numBinario) {
                System.out.print(num);
            }
        }


    }
}
