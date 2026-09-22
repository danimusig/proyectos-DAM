/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany._pe04_ejercicio10;

/**
 * Clase Main para probar los metodos de la clase SintonizadorFM.
 * @author Daniel
 * @version 1.0
 * @see SintonizadorFM.
 */
public class Main {

    public static void main(String[] args) {
        //Creo los objetos SintonizadorFM
        SintonizadorFM radio1 = new SintonizadorFM(108);
        SintonizadorFM radio2 = new SintonizadorFM();
        
        //Prueba de limites.
        System.out.println("Radio1:");
        System.out.println(radio1.mostrarDisplay());
        //Subo la frecuencia, sobrepasando el limite y muestro la frecuencia por pantalla.
        radio1.up();
        System.out.println(radio1.mostrarDisplay());
        //Bajo la frecuencia una vez sobrepasando el limite establecido y volviendo al valor maximo..
        radio1.down();
        System.out.println(radio1.mostrarDisplay());
        System.out.println("");
        System.out.println("***********************");

        System.out.println("Radio2:");
        System.out.println(radio2.mostrarDisplay());
        //Subo la frecuencia dos veces y muestro la frecuencia por pantalla.
        radio2.down();
        System.out.println(radio2.mostrarDisplay());
        //Subo la frecuencia una vez sobrepasando el limite establecido.
        radio2.up();
        System.out.println(radio2.mostrarDisplay());

        

    }
}
