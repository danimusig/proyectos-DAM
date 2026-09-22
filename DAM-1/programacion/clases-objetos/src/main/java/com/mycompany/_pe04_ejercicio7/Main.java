package com.mycompany._pe04_ejercicio7;

/**
 * Clase Principal
 * @author Daniel
 */
public class Main {

    public static void main(String[] args) {
        Gestor gestor1 = new Gestor("Manuel Lopez Aguirre", "123456789");
        CuentaCorriente cuenta1 = new CuentaCorriente("21016765D", "Daniel Munyoz Sigmund", gestor1);
        
        System.out.println(cuenta1.toString());
    }
}
