package com.mycompany._pe04_ejercicio11.maquinaria;

/**
 * Clase Vagon: Almacena y modifica información sobre los vagones.
 * @author DanielMS
 * @version 1.0
 * @see String
 */
class Vagon {
    /**
     * La id del vagon.
     */
    private int numID;
    
    /**
     * La carga maxima del vagon.
     */
    private int cargaMaxima;
    
    /**
     * La carga actual del vagon.
     */
    private int cargaActual;
    
    /**
     * El tipo de mercancia del vagon.
     */
    private String tipoMercancia;
    
    /**
     * Constructor Principal.
     * @param numID El id del cagon en un numero entero. 
     * @param cargaMaxima La carga maxima del vagon en kilos.
     * @param cargaActual La carga actual del vagon en kilos.
     * @param tipoMercancia El tipo de mercancia del vagon en una cadena de caracteres.
     */
    public Vagon(int numID, int cargaMaxima, int cargaActual, String tipoMercancia) {
        this.numID = numID;
        
        this.cargaMaxima = cargaMaxima;
        
        if (cargaActual > cargaMaxima) {
            System.out.println("ALERTA: La carga actual (" + this.cargaActual + ") supera a la carga máxima (" + this.cargaMaxima + ")");
        } else {
            this.cargaActual = cargaActual;
        }
        
        this.tipoMercancia = tipoMercancia;
    }
    
    /**
     * Modifica la id del vagon.
     * @param nuevaID La id del cagon en un numero entero.
     */
    public void setNumID(int nuevaID) {
        this.numID = nuevaID;
    }
    
    /**
     * Modifica la carga maxima del vagon.
     * @param nuevaCargaMax La nueva carga maxima del vagon en kilos.
     */
    public void setCargaMaxima(int nuevaCargaMax) {
        this.cargaMaxima = nuevaCargaMax;
    }
    
    /**
     * Modifica la carga actual del vagon.
     * @param nuevaCargaActual  La nueva carga del vagon en kilos.
     */
    public void setCargaActual(int nuevaCargaActual) {
        if (nuevaCargaActual > this.cargaMaxima) {
            System.out.println("ALERTA: La nueva carga (" + nuevaCargaActual + ") supera a la carga máxima (" + this.cargaMaxima + ")");
        } else {
            this.cargaActual = cargaActual;
        }    
    }
    
    /**
     * Modifica el tipo de mercancia del vagon.
     * @param nuevaMercancia EL tipo de mercancia en una cadena de caracteres.
     */
    public void setTipoMercancia (String nuevaMercancia) {
        this.tipoMercancia = nuevaMercancia;
    }
    
    /**
     * Obtiene el id del vagon.
     * @return El id del vagon representado en un numero entero.
     */
    public int getNumID() {
        return this.numID;
    }
    
    /**
     * Ontiene la carga maxima del vagon.
     * @return La carga maxima del vagon representada en kilos.
     */
    public int getCargaMaxima() {
        return this.cargaMaxima;
    }
    
    /**
     * Obtiene la carga actual del vagon.
     * @return La carga actual del vagon representada en kilos.
     */
    public int getCargaActual() {
        return this.cargaActual;
    }
    
    /**
     * Obtiene el tipo de mercancia.
     * @return El tipo de mercancia representada en una cadena de caracteres.
     */
    public String getTipoMercancia() {
        return this.tipoMercancia;
    }
}
