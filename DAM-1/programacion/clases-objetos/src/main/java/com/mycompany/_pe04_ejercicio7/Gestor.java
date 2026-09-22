package com.mycompany._pe04_ejercicio7;

/**
 * Clase Gestor: 
 * @author Daniel
 * @version 1.0
 * @see String
 */
public class Gestor {
    
    /**
     * El nombre del gestor.
     */
    public String nombre;
    
    /**
     * El telefono del gestor.
     */
    public String telefono;
    
    /**
     * El dinero máximo con el que opera el gestor.
     */
    public double dineroDispo;
    
    /**
     * Constructor principal.
     * @param nombre El nombre del gestor en una cadena de caracteres.
     * @param telefono El telefono del gestor en una cadena de caracteres.
     * @param dineroDispo El dinero maximo con el que opera el gestor en euros.
     */
    public Gestor(String nombre, String telefono, double dineroDispo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.dineroDispo = dineroDispo;
    }
    
    /**
     * Constrctor auxiliar.
     * @param nombre El nombre del gestor en una cadena de caracteres.
     * @param telefono El telefono del gestor en una cadena de caracteres.
     */
    public Gestor(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.dineroDispo = 10000;
    }    
    
    /**
     * Modifca el nombre del gestor.
     * @param nuevoNombre El nuevo nombre del gestor en una cadena de caracteres.
     */
    public void setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }
    
    /**
     * Modifica el telefono del gestor.
     * @param nuevoTelefono El nuevo numero de telefono del gestor.
     */
    public void setTelefono(String nuevoTelefono) {
        this.telefono = nuevoTelefono;
    }
    
    /**
     * Modifica el dinero operable del gestor.
     * @param nuevoDineroDispo El dinero operable del gestor en euros.
     */
    public void setDineroDispo(double nuevoDineroDispo) {
        this.dineroDispo = nuevoDineroDispo;
    }
    
    /**
     * Obtiene el nombre del gestor.
     * @return El nombre del gestor en una cadena de caracteres.
     */
    public String getNombre() {
        return this.nombre;
    }
    
    /**
     * Obtiene el telefono del gestor.
     * @return El telefono del gestor en unac cadena de caracteres.
     */
    public String getTelefono() {
        return this.telefono;
    }
    
    /**
     * Obtiene el saldo operable del gestor.
     * @return El saldo operable en euros.
     */
    public double getDineroDispo() {
        return this.dineroDispo;
    }
    
    /**
     * 
     */
    public String toString() {
        return "\nNombre: " + this.nombre + "\nTelefono: " + this.telefono + "\nDinero disponible: " + this.dineroDispo;
    }
}

