package com.mycompany._pe04_ejercicio4;

/**
 *
 * @author Daniel
 */
public class Main {

    public static void main(String[] args) {
        CuentaCorriente cuenta1 = new CuentaCorriente("12345678-D", "Daniel Munyoz Sigmund");
        CuentaCorriente cuenta2 = new CuentaCorriente("87651234-F", 6000);
        CuentaCorriente cuenta3 = new CuentaCorriente("87654321-Z", "Laura Torres", 8000);
        
        System.out.println(cuenta1.toString() + "\n\n" + cuenta2.toString() + "\n\n" + cuenta3.toString() + "\n\n");
        
        cuenta1.ingresarDinero(4000);
        cuenta2.setnombreTitular("Jose Munyoz Palomino");
        
        System.out.println(cuenta1.toString() + "\n\n" + cuenta2.toString());
    }
}
