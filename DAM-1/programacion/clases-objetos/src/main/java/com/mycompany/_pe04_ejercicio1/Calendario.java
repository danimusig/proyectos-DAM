package com.mycompany._pe04_ejercicio1;

/**
 * Clase Calendario: Representa una fecha y deja cambiarla.
 * @author Daniel
 * @version 1.0
 * @see String
 */
public class Calendario {
    
    /**
     * El dia en el que se encuentra el calendario.
     */
    private int dia;
    
    /**
     * El mes en el que se encuentra el calendario.
     */
    private int mes;
    
    /**
     * El año en el que se encuentra el calendario.
     */
    private int anyo;
    
    /**
     * Contructor principal.
     * @param dia Guarda el dia en el que se encuentra el calendario.
     * @param mes Guarda el mes en el que se encuentra el calendario.
     * @param anyo Guarda el anyo en el que se encuentra el calendario.
     */
    public Calendario (int dia, int mes, int anyo) {
        this.dia = dia;
        this.mes = mes;
        this.anyo = anyo;
    }
    
    /**
     * Obtiene el dia.
     * @return El dia representado en dias.
     */
    public int getDia() {
        return this.dia;
    }
    
    /**
     * Obtiene el mes.
     * @return El mes representado en meses.
     */
    public int getMes() {
        return this.mes;
    }
    
    /**
     * Obtiene el anyo.
     * @return El anyo representado en anyos.
     */
    public int getAnyo() {
        return this.anyo;
    }
    
    /**
     * Incrementa el dia una unidad.
     */
    public void incrementarDia() {
        this.dia++;
    }
    
    /**
     * Incrementa el mes una unidad.
     */
    public void incrementarMes() {
        this.mes++;
    }
    
    /**
     * Incrementa el anyo el numero de veces que indique el parametro.
     * @param incrementoAnyo El numero de anyos que va a incrementar anyo.
     */
    public void incrementarAnyo(int incrementoAnyo) {
        this.anyo+=incrementoAnyo;
    }
    
    /**
     * Obtiene una cadena con informacion sobre la fecha.
     * @return La fecha establecida en Calendario.
     */
    public String toString() {
        return "La fecha actual es: " + this.dia + "-" + this.mes + "-" + this.anyo;
    }
    
    /**
     * Obtiene un booleano que devuelve true si la fecha introducida por parámetro es igual a la establecida en Calendario.
     * @param fechaUsuario La fecha introducida por el parámetro del método.
     * @return Un booleano.
     */
    public boolean equalsCalendario(String fechaUsuario) {
        String fecha = this.dia + "-" + this.mes + "-" + this.anyo;
        
        if (fecha.equals(fechaUsuario)) {
            System.out.println("Las fechas son identicas");
            return true;
        } else {
            System.out.println("Las fechas son diferentes");
            return false;
        }
    }
}
