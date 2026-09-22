package com.mycompany._pe04_ejercicio11.personal;

/**
 * Clase Mecanico: Almacena y modifica informacion sobre los mecanicos.
 * @author DanielMS
 * @version 1.0
 * @see String
 */
public class Mecanico {
    /**
     * El nombre del mecanico.
     */
    private String nombre;
    
    /**
     * El telefono del mecanico.
     */
    private int telefono;
    
    /**
     * La especialidad del mecanico.
     */
    private String especialidad;
    
    /**
     * Constructor Principal
     * @param nombre El nombre del mecanico en una cadena de caracteres.
     * @param telefono El telefono del mecanico en un numero entero.
     * @param especialidad La especialidad del mecanido en una cadena de caracteres.
     */
    public Mecanico(String nombre, int telefono, String especialidad) {
        this.nombre = nombre;
        
        this.telefono = telefono;
        
        if (especialidad.equals("frenos") || especialidad.equals("hidráulica") || especialidad.equals("electricidad") || especialidad.equals("motor") ) {
            this.especialidad = especialidad;
        } else {
            System.out.print("ERROR: Esa especialidad no existe");
        }
    }
    
    /**
     * Modifica el nombre del mecanico.
     * @param nuevoNombre El nuevo nombre del mecanico en una cadena de caracteres.
     */
    public void setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }
    
    /**
     * Modifica el telefono del mecanico.
     * @param nuevoTelefono El nuevo telefono del mecanico en un entero.
     */
    public void setTelefono(int nuevoTelefono) {
        this.telefono = nuevoTelefono;
    }

    /**
     * Modifica la especialidad del mecanico.
     * @param nuevaEspecialidad La nueva especialidad del mecanico en una cadena de caracteres.
     */
    public void setEspecialidad(String nuevaEspecialidad) {
        if (nuevaEspecialidad.equals("frenos") || nuevaEspecialidad.equals("hidráulica") || nuevaEspecialidad.equals("electricidad") || nuevaEspecialidad.equals("motor") ) {
            this.especialidad = nuevaEspecialidad;
        } else {
            System.out.print("ERROR: Esa especialidad no existe");
        }
    }    
    
    /**
     * Obtiene el nombre del maquinista.
     * @return El nombre del maquinista representado en una cadena de caracteres.
     */
    public String getNombre() {
        return this.nombre;
    }
    
    /**
     * Obtiene el telefono del maquinista.
     * @return El telefono del maquinista representado en un numero entero.
     */
    public int getTelefono() {
        return this.telefono;
    }
    
    /**
     * Obtiene la especialidad del maquinista.
     * @return La especialidad del maquinista representada en una cadena de caracteres.
     */
    public String getEspecialidad() {
        return this.especialidad;
    }
}
