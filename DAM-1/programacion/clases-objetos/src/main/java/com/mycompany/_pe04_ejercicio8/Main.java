package com.mycompany._pe04_ejercicio8;

/**
 *
 * @author Daniel
 */
public class Main {

    public static void main(String[] args) {
        //Creo los objetos Hora
        Hora hora1 = new Hora(10,20,59);
        Hora hora2 = new Hora(18,59,59);
        Hora hora3 = new Hora(23,59,59);
        
        //Pueba de limites.
        //Si los segundos superan 59 se muestra 00.
        hora1.incrementarSegundos();
        System.out.print(hora1.toString());
        
        //Si los minutos superan 59 aumenta 1 la hora.
        hora2.incrementarSegundos();
        System.out.print(hora2.toString());
        
        //Si la hora pasa a 24, todos los valores vuelven a 00.
        hora3.incrementarSegundos();
        System.out.print(hora3.toString());
    }
}
