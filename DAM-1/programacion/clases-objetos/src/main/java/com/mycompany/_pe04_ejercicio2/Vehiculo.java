package com.mycompany._pe04_ejercicio2;

/**
 * Clase vehiculo: 
 * @author Daniel
 */
public class Vehiculo {
    /**
     * La matricula del vehiculo.
     */
    private String matricula;
    
    /**
     * La marca del vehiculo
     */
    private String marca;
    
    /**
     * El modelo del vehiculo
     */
    private String modelo;
    
    /**
     * La tarifa diaria
     */
    private double tarifa;
    
    /**
     * La disponibilidad del vehiculo
     */
    private boolean disponible;
    
    /**
     * Constructor Principal.
     * @param matricula La matricula del vehiculo en una cadena de caracteres. 
     * @param marca La marca deL vehiculo en una cadena de caracteres.
     * @param modelo El modelo del vehiculo en una cadena de caracteres.
     * @param tarifa La tarifa por dia de alquiler en euros.
     * @param disponible La disponibilidad del vehiculo en un booleano.
     */
    public Vehiculo (String matricula, String marca, String modelo, double tarifa, Boolean disponible) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.tarifa = tarifa;
        this.disponible = disponible;
    }
    
    /**
     * Modifica la matricula del vehiculo.
     * @param nuevaMatricula La nueva matricula de un vehiculo representada en una cadena de caracteres.
     */
    public void setMatricula(String nuevaMatricula) {
        this.matricula = nuevaMatricula;
    }
    
    /**
     * Modifica la marca del vehiculo.
     * @param nuevaMarca La nueva marca de un vehiculo representada en una cadena de caracteres.
     */
    public void setMarca(String nuevaMarca) {
        this.marca = nuevaMarca;
    }
    
    /**
     * Modifica el modelo del vehiculo.
     * @param nuevoModelo El nuevo modelo de un vehiculo representado en una cadena de caracteres.
     */
    public void setModelo(String nuevoModelo) {
        this.modelo = nuevoModelo;
    }
    
    /**
     * Modifica la tarifa del vehiculo.
     * @param nuevaTarifa La nueva tarifa de un vehiculo representada en euros.
     */
    public void setMatricula(double nuevaTarifa) {
        this.tarifa = nuevaTarifa;
    }
    
    /**
     * Modifica la disponibilidad del vehiculo.
     * @param nuevaDisponibilidad La nueva disponibilidad de un vehiculo representada en un booleano.
     */
    public void setDisponible(Boolean nuevaDisponibilidad) {
        this.disponible = nuevaDisponibilidad;
    }
    
    /**
     * Obtiene la matricula del vehiculo.
     * @return La matricula del vehiculo en una cadena de caracteres.
     */
    public String getMatricula() {
        return this.matricula;
    }
    
    /**
     * Obtiene la marca del vehiculo.
     * @return La marca del vehiculo en una cadena de caracteres.
     */
    public String getMarca() {
        return this.marca;
    }
    
    /**
     * Obtiene el modelo del vehiculo.
     * @return El modelo del vehiculo en una cadena de caracteres.
     */
    public String getModelo() {
        return this.modelo;
    }
    
    /**
     * Obtiene la tarifa del vehiculo.
     * @return La matricula del vehiculo en euros.
     */
    public double getTarifa() {
        return this.tarifa;
    }   
    
    /**
     * Obtiene la disponibilidad del vehiculo.
     * @return La matricula del vehiculo en euros.
     */
    public Boolean getDisponible() {
        return this.disponible;
    }
    
    
}
