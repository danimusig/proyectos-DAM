package com.mycompany._pe04_ejercicio1;

/**
 * Clase principal para poder usar los métodos de la clase Calendario
 * @author Daniel
 * @version 1.0
 * @see Calendario
 * @see String
 */
public class Main {

    public static void main(String[] args) {
        Calendario c1 = new Calendario(24,8,2025);
        
        System.out.println(c1.toString());
        
        c1.incrementarAnyo(30);
        System.out.println(c1.toString());
        
        System.out.println(c1.equalsCalendario("24-8-2055"));
        
        c1.incrementarDia();
        c1.incrementarMes();
        System.out.println(c1.toString());

        System.out.print(c1.equalsCalendario("24-8-2055"));   
    }
}
