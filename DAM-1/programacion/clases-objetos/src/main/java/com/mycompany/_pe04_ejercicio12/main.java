package com.mycompany._pe04_ejercicio12;

/**
 *
 * @author Daniel
 */
public class main {

    public static void main(String[] args) {
        //Prueba normal
        NumeroEntero n1 = new NumeroEntero(240);
        System.out.println("Signo: " + n1.signo());
        System.out.println("Decimal: " + n1.getValorDecimal());
        System.out.println("Comparamos el numero: " + n1.compareTo(250));
        
        //Prueba de limites
        NumeroEntero n2 = new NumeroEntero(1000000);
        System.out.print(n1.toString());
    }
}
