package com.mycompany._pe04_ejercicio2;

/**
 * Clase Cliente: 
 * @author Daniel
 */
public class Cliente {
    /**
     * El dni del cliente.
     */
    private String dni;
    
    /**
     * El nombre del cliente.
     */
    private String nombre;
    
    /**
     * Los apellidos del cliente.
     */
    private String apellidos;
    
    /**
     * El numero de telefono del cliente.
     */
    private String telefono;
    
    /**
     * Constructor principal.
     * @param dni El dni del cliente en una cadena de caracteres.
     * @param nombre El nombre del cliente en una cadena de caracteres.
     * @param apellidos Los apellidos del cliente en una cadena de caracteres.
     * @param telefono El numero de telefono del cliente en una cadena de caracteres.
     */
    public Cliente(String dni, String nombre, String apellidos, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
    }
    
    /**
     * Modifica el dni del cliente.
     * @param nuevoDni El nuevo dni del cliente en una cadena de caracteres.
     */
    public void setDni(String nuevoDni) {
        this.dni = nuevoDni;
    }
    
    /**
     * Modifica el nombre del cliente.
     * @param nuevoNombre El nuevo nombre del cliente en una cadena de caracteres.
     */
    public void setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }
    
    /**
     * Modifica los apellidos del cliente.
     * @param nuevoApellido El nuevo apellido del cliente en una cadena de caracteres.
     */
    public void setApellidos(String nuevoApellido) {
        this.apellidos = nuevoApellido;
    }
    
    /**
     * Modifica el numero de telefono del cliente.
     * @param nuevoTelefono El nuevo numero de telefono del cliente en una cadena de caracteres.
     */
    public void setTelefono(String nuevoTelefono) {
        this.telefono = nuevoTelefono;
    }
    
    /**
     * Obtiene el dni del cliente.
     * @return El dni del cliente en una cadena de caracteres.
     */
    public String getDni() {
        return this.dni;
    }
    
    /**
     * Obtiene el nombre del cliente.
     * @return El nombre del cliente en una cadena de caracteres.
     */
    public String getNombre() {
        return this.nombre;
    }
    
    /**
     * Obtiene los apellidos del cliente.
     * @return EL apellido del cliente en una cadena de caracteres.
     */
    public String getApellidos() {
        return this.apellidos;
    }
    
    /**
     * Obtiene el numero de telefono del cliente.
     * @return El telefono del cliente en una cadena de caracteres.
     */
    public String getTelefono() {
        return this.telefono;
    }   
    
    /**
     * Obtiene el nombre completo del cliente.
     * @return El nombre completo del cliente en una cadena de caracteres compuesto por los atributos nombre y apellidos.
     */
    public String getNombreCompleto() {
        return "" + this.nombre + " " + this.apellidos;
    }
    
    /**
     * Obtiene los todos los datos almacenados del cliente.
     * @return Todos los datos del cliente en una cadena de caracteres compuesto por todos los atributos de la clase cliente.
     */
    public String getDatosCompletos() {
        return "Datos cliente: \nDNI: " + this.dni + "\nNobre: " + this.nombre + "\nApellidos: " + this.apellidos + "\nTelefono: " + this.telefono;
    }
    
    
}
