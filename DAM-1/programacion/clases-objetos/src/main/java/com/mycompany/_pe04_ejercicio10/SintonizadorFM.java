package com.mycompany._pe04_ejercicio10;

/**
 *
 * @author DanielMS
 */
public class SintonizadorFM {
    
    private double frecuenciaActual;
    
    public SintonizadorFM (double frecuenciaActual) {
        if (this.frecuenciaActual > 108) {
            System.out.print("Frecuencia fuera del rango de señal (80MHz - 108MHz), la frecuencia se sintonizará en 80MHz");
            this.frecuenciaActual = 80;
        } else {
            this.frecuenciaActual = frecuenciaActual;
        }
    }
    
    public SintonizadorFM () {
        this.frecuenciaActual = 80;
    }
    
    public void up() {
        this.frecuenciaActual+=0.5;
        if (this.frecuenciaActual > 108) {
            this.frecuenciaActual = 80;
        } 
    }

    public void down() {
        this.frecuenciaActual-=0.5;
        if (this.frecuenciaActual < 80) {
            this.frecuenciaActual = 108;
        } 
    }
    
    public String mostrarDisplay() {
        return "Frecuencia actual: " + this.frecuenciaActual + "MHz";
    }
    
}
