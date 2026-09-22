package com.mycompany._pe04_ejercicio5;

/**
 * Clase CuentaCorriente: Almacena datos del titular y permite ingresar y sacar dinero segun el saldo del titular.
 * @author DanielMS
 * @version 1.0
 * @see String
 */

public class CuentaCorriente {
    
    /**
     * El dni de la cuenta corriente.
     */
    String dni;
    
    /**
     * El nombre del titular de la cuenta corriente.
     */    
    public String nombreTitular;
        
    /**
     * El saldo en la cuenta del titular.
     */    
    private double saldo;

    /**
     * Constructor principal.
     * @param dni El dni del titular de la cuenta en una cadena de caracteres. 
     * @param nombreTitular El nombre completo del titular de la cuenta en una cadena de caracteres.
     */ 
    public CuentaCorriente(String dni, String nombreTitular){
        this.dni = dni;
        this.nombreTitular = nombreTitular;
        this.saldo = 0;
    }
    
    /**
     * Constructor auxiliar.
     * @param dni El dni del titular de la cuenta en una cadena de caracteres.
     * @param saldo El saldo de la cuenta del titular en euros.
     */
    public CuentaCorriente(String dni, double saldo) {
        this.dni = dni;
        this.nombreTitular = "";
        this.saldo = saldo;
    }
    
    /**
     * Constructor auxiliar.
     * @param dni El dni del titular de la cuenta en una cadena de caracteres.
     * @param nombreTitular El nombre completo del titular de la cuenta en una cadena de caracateres.
     * @param saldo El saldo de la cuenta en euros.
     */
    public CuentaCorriente(String dni, String nombreTitular, double saldo) {
        this.dni = dni;
        this.nombreTitular = nombreTitular;
        this.saldo = saldo;
    }
    
    /**
     * Modifica el dni de la cuenta corriente.
     * @param nuevoDni El nuevo dni de la cuenta en una cadena de caracteres.
     */
    public void setDni(String nuevoDni) {
        this.dni = nuevoDni;
    }
    
    /**
     * Modifica el nombre del titular de la cuenta.
     * @param nuevoTitular El nuevo titular de la cuenta en una cadena de caracteres. 
     */
    public void setnombreTitular(String nuevoTitular) {
        this.nombreTitular = nuevoTitular;
    }
    
    /**
     * Modifica el saldo de la cuenta corriente.
     * @param nuevoSaldo El nuevo saldo de la cuenta en euros.
     */
    public void setSaldo(int nuevoSaldo) {
        this.saldo = nuevoSaldo;
    }
    
    /**
     * Obtiene el dni del titular de la cuenta.
     * @return El dni del titular de la cuenta en una cadena de caracteres.
     */
    public String getDni() {
        return this.dni;
    }
    
    /**
     * Obtiene el nombre completo del titular de la cuenta.
     * @return El nombre completo del titular en una cadena de caracteres.
     */
    public String getNombreTitular() {
        return this.nombreTitular;
    }
    
    /**
     * Obtiene el saldo de la cuenta corriente.
     * @return El saldo de la cuenta corriente en euros.
     */
    public double getSaldo() {
        return this.saldo;
    }
    
    /**
     * Retira dinero de la cuenta si la cantidad a retirar es menor que el saldo.
     * @param retiro La cantidad de dinero que se desea retirar de la cuenta en euros.
     * @return La confimación de si ha sido correcta la retirada de saldo o si no lo ha sido en un booleano.
     */
    public boolean sacarDinero(double retiro) {
        if (retiro>this.saldo) {
            System.out.println("No tiene saldo suficiente");
            return false;
        } else {
            this.saldo-=retiro;
            System.out.println("Retiro exitoso");
            return true;
        } 
    }
    
    /**
     * Ingresa saldo en la cuenta.
     * @param dinero El dinero a ingresar en la cuenta en euros.
     */
    public void ingresarDinero(double dinero) {
        this.saldo+=dinero;
    }

    /**
     * Muestra información guardada sobre la cuenta corriente.
     * @return Información sobre la cuenta corriente en una cadena de caracteres.
     */
    public String toString() {
        return "Cuenta corriente : " + this.dni + "\nNombre del titular: " + this.nombreTitular + "\nSaldo de la cuenta: " + this.saldo;
    }
}
