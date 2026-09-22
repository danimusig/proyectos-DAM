package com.mycompany._pe04_ejercicio11.personal;

import java.util.Date;

/**
 * Clase JefeEstacion: Almacena y modifica informacion sobre los jefesd de estacion.
 * @author DanielMS
 * @version 1.0
 * @see String
 * @see Date
 */
public class JefeEstacion {
    /**
     * El nombre del jefe de estacion.
     */
    private String nombre;
    
    /**
     * El dni del jefe de estacion.
     */
    private String dni;
    
    /**
     * La fecha de incorporacion del jefe de estacion.
     */
    private Date fechaIncorporacion;
    
    /**
     * Constructor Principal.
     * @param nombre El nombre del jefe de estacion en una cadena de caracteres.
     * @param dni El dni del jefe de estacion en una cadena de caracteres.
     * @param fechaIncorporacion La fecha de incorporacion del jefe de estacion en un objeto Date.
     */
    public JefeEstacion(String nombre, String dni, Date fechaIncorporacion) {
        this.nombre = nombre;
        
        this.dni = dni;
        
        this.fechaIncorporacion = fechaIncorporacion;
    }
    
    /**
     * Modifica el nombre del jefe de estacion.
     * @param nuevoNombre El nuevo nombre en una cadena de caracteres.
     */
    public void setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }
    
    /**
     * Modifica el dni del jefe de estacion.
     * @param nuevoDNI El nuevo dni en una cadena de caracteres.
     */
    public void setDNI(String nuevoDNI) {
        this.dni = nuevoDNI;
    }

    /**
     * Modifica la fecha de incorporacion del jefe de estacion.
     * @param nuevaFechaIncorporacion La nueva fecha de incorporacion en un objeto de la clase Date.
     */
    public void setFechaIncorporacion(Date nuevaFechaIncorporacion) {
            this.fechaIncorporacion = nuevaFechaIncorporacion;
    }    
    
    /**
     * Obtiene el nombre del jefe de estacion.
     * @return El nombre del jefe de estacion representado en una cadena de caracteres.
     */
    public String getNombre() {
        return this.nombre;
    }
    
    /**
     * Obtiene el dni del jefe de estacion.
     * @return El dni del jefe de estacion representado en una cadena de caracteres.
     */
    public String getDNI() {
        return this.dni;
    }
    
    /**
     * Ontiene la fecha de incorporacion del jefe de estacion.
     * @return La fecha de incorporacion del jefe de estacion en un objeto de la clase Date. 
     */
    public Date getFechaIncorporacion() {
        return this.fechaIncorporacion;
    }
}
