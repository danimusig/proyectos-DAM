package com.mycompany._pe04_ejercicio11.personal;

/**
 * Clase Maquinista: Almacena y modifica informacion sobre los maquinistas.
 * @author Daniel
 * @version 1.0
 * @see String
 */
public class Maquinista {
    /**
     * El nombre del maquinista.
     */
    private String nombre;
    
    /**
     * El dni del maquinista.
     */
    private String dni;
    
    /**
     * El sueldo del maquinista.
     */
    private double sueldo;
    
    /**
     * El rango del maqinista.
     */
    private String rango;
    
    /**
     * Constrctor Principal.
     * @param nombre El nombre del maquinista en una cadena de caracteres.
     * @param dni El dni del maquinista en una cadena de caracteres.
     * @param sueldo El sueldo del maquinista en euros.
     * @param rango El rango del maquinista en una cadena de caracteres.
     */
    public Maquinista(String nombre, String dni, double sueldo, String rango){
        this.nombre = nombre;
        this.dni = dni;
        this.sueldo = sueldo;
        this.rango = rango;
    }
    
    /**
     * Modifica el nombre del maquinista.
     * @param nuevoNombre El nuevo nombre en una cadena de caracteres.
     */
    public void setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }
    
    /**
     * Modifica el dni del maquinista.
     * @param nuevoDNI El nuevo dni del maquinista en una cadena de caracteres.
     */
    public void setDNI(String nuevoDNI) {
        this.dni = nuevoDNI;
    }

    /**
     * Modifica el sueldo del maquinista.
     * @param nuevoSueldo El nuevo sueldo del maquinista en euros.
     */
    public void setSueldo(double nuevoSueldo) {
        this.sueldo = nuevoSueldo;
    }

    /**
     * Modifica el rango del maquinista.
     * @param nuevoRango El nuevo rango del maquinista en una cadena de caracteres.
     */
    public void setRango(String nuevoRango) {
        this.rango = nuevoRango;
    }    
    
    /**
     * Obtiene el nombre del maquinista.
     * @return El nombre del maquinista representado en una cadena de caracteres.
     */
    public String getNombre() {
        return this.nombre;
    }
    
    /**
     * Obtiene el dni del maquinista.
     * @return El dni del maquinista representado en una cadena de caracteres.
     */
    public String getDNI() {
        return this.dni;
    }
    
    /**
     * Obtiene el sueldo del maquinista.
     * @return El sueldo del maquinista representado en euros.
     */
    public double getSueldo() {
        return this.sueldo;
    }
    
    /**
     * Obtiene el rango del maquinista.
     * @return El rango del maquinista representado en una cadena de caracteres.
     */
    public String getRango() {
        return this.rango;
    }
}
