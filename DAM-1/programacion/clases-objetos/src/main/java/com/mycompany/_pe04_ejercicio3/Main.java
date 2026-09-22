
package com.mycompany._pe04_ejercicio3;

/**
 *
 * @author DanielMS
 * @version 1.0
 * @see CuentaCorriente
 */
public class Main {

    public static void main(String[] args) {
        
        CuentaCorriente cuenta1 = new CuentaCorriente("123455678-D", "Daniel Munyoz Sigmund");
        
        System.out.println(cuenta1.toString());
        
        cuenta1.ingresarDinero(5000);
        System.out.println("Saldo despues de ingreso: " + cuenta1.getSaldo());
        
        System.out.println(cuenta1.sacarDinero(5050));
        
        cuenta1.sacarDinero(4500);
        System.out.print(cuenta1.getSaldo());
        
    }
}
