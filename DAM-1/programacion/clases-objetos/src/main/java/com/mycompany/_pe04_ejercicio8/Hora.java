package com.mycompany._pe04_ejercicio8;


/**
 * Clase hora
 * @author DanielMS
 * @version 1.0
 * @see String
 */
public class Hora {
    
    /**
     * La hora en la que se encuentra el reloj.
     */
    private int hora;
    
    /**
     * Los minutos en los que se ecuentra el reloj.
     */
    private int minutos;
    
    /**
     * Los segundos en los que se encuentra el reloj.
     */
    private int segundos;
    
    /**
     * Contructor principal.
     * @param hora La hora del reloj en horas.
     * @param minutos Los minutos del reloj en minutos.
     * @param segundos Los segundos del reloj en segundos.
     */
    public Hora(int hora, int minutos, int segundos) {
        this.hora = hora;
        this.minutos = minutos;
        this.segundos = segundos;
    }
    
    /**
     * Modifica la hora del reloj.
     * @param nuevaHora La nueva hora del reloj en horas.
     */
    public void setHora(int nuevaHora) {
        this.hora = nuevaHora;
    }
    
    /**
     * Modifica los minutos del reloj.
     * @param nuevoMinutos Los nuevos minutos del reloj en minutos.
     */
    public void setMinutos(int nuevoMinutos) {
        this.minutos = nuevoMinutos;
    }
    
    /**
     * Modifica los segundos del reloj.
     * @param nuevoSegundos Los segundos del reloj en segundos.
     */
    public void setSegundos (int nuevoSegundos) {
        this.segundos = nuevoSegundos;
    }
    
    /**
     * Obtiene la hora.
     * @return La hora representada en horas.
     */
    public int getHora() {
        return this.hora;
    }
    
    /**
     * Obtiene los minutos.
     * @return Los minutos representados en minutos.
     */
    public int getMinutos() {
        return this.minutos;
    }
    
    /**
     * Obtiene los segundos.
     * @return Los segundos representados en segundos.
     */
    public int getSegundos() {
        return this.segundos;
    }
    
    /**
     * Obtiene una cadena con la hora y le da un formato a los números para que aparezca con un 0 a la izquierda cuando tiene menos de 2 cifras.
     * @return 
     */
    public String toString() {
        
        String DosCerosHora = String.valueOf(String.format("%02d", this.hora));
        String DosCerosMinutos = String.valueOf(String.format("%02d", this.minutos));
        String DosCerosSegundos = String.valueOf(String.format("%02d", this.segundos));
        return "\n" + DosCerosHora + ":" + DosCerosMinutos + ":" + DosCerosSegundos;
    }
    
    /**
     * Incrementa los segundos en uno, si los minutos o segundos llegan a 60 se reiniciaran a 0, si la hora llega a las 24:00:00 se mostrará las 00:00:00
     */
    public void incrementarSegundos() {
        this.segundos++;
        
        if (this.segundos >= 59) {
            this.minutos++;
            this.segundos = 00;
        }
        
        if (this.minutos >= 59) {
            this.hora++;
            this.minutos = 00;
        }
        
        if (this.hora >= 24) {
            this.hora = 00;
            this.minutos = 00;
            this.segundos = 00;
        }    
    }
}
