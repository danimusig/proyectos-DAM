package com.mycompany._pe04_ejercicio14;

/**
 * Clase SensorTemperatura
 * @author Daniel
 * @version 1.0
 * @see String
 */
public class SensorTemperatura {
    /**
     * La ubicacion.
     */
    private String ubicacion;
    
    /**
     * La temperatura actual.
     */
    private double temperaturaActual;
    
    /**
     * La temperatura maxima medible.
     */
    private static double temperaturaMaximaMediable = 98.9;
   
    /**
     * Constructor Principal.
     * @param ubicacion La ubicacion en una cadena de caracteres.
     * @param temperaturaActual La temperatura actual en un decimal.
     */ 
    public SensorTemperatura(String ubicacion, double temperaturaActual) {
        this.ubicacion = ubicacion;
        
        if (temperaturaActual > this.temperaturaMaximaMediable) {
            System.out.print("ALERTA: La temperatura sobrepasa los límites medibles");
        } else {
            this.temperaturaActual = temperaturaActual;
        }
    }
    
    /**
     * Comprueba que la temperatura no sea peligrosa 
     * @return True si es peligrosa false si no lo es
     */
    public boolean esPeligrosa() {
        if (this.temperaturaActual > 50 || this.temperaturaActual < -40) {
            return true;
        } else {
            return false;
        }
    }
}
