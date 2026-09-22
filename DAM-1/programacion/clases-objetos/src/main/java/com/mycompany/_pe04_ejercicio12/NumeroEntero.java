package com.mycompany._pe04_ejercicio12;

/**
 * Clase NumeroEntero: Almacena y modifica informacion sobre un numero entero.
 * @author Daniel
 */
public class NumeroEntero {
    /**
     * El valor del numero entero.
     */
    private int valor;
    
    /**
     * El valor maximo del numero entero.
     */
    public static final int VALOR_MAXIMO = 999999;
    
    /**
     * El valor minimo del numero entero.
     */
    public static final int VALOR_MINIMO = -999999;
    
    /**
     * Constructor Principal
     * @param valor El valor del numero entero en un numero entero.
     */
    public NumeroEntero(int valor) {
        
        if (valor > this.VALOR_MAXIMO) {
            this.valor = this.VALOR_MAXIMO;
        } else if (valor < VALOR_MINIMO) {
            this.valor = this.VALOR_MINIMO;
        } else {
            this.valor = valor;
        }
    }
    
    /**
     * Compara el valor con otro introducido como parametro.
     * @param otroEntero El valor con el que se va a comparar.
     * @return 1 si es menor, 0 si es igual, -1 si es mayor.
     */
    public int compareTo(Integer otroEntero) {
        //El metodo compare de la clase Integer devuelve 1, 0 o -1 por defecto.
        return Integer.compare(this.valor, otroEntero);
    }
    
    /**
     * Obtiene el valor del numero entero.
     * @return El valor del numero entero en un numero entero.
     */
    public int getValor() {
        return this.valor;
    }
    
    /**
     * Obtiene el signo del numero entero (Positivo/Negativo)
     * @return 1 si es positivo, -1 si es negativo, 0 si tiene el valor 0.
     */
    public int signo() {
        if (this.valor > 0) {
            return 1;
        } else if (this.valor < 0) {
            return -1;
        } else {
            return 0;  
        }
    }
    
    /**
     * Obtiene el valor decimal del valor.
     * @return El valor decimal del valor en un numero decimal.
     */
    public double getValorDecimal() {
        return (double) this.valor;
    }
    
    /**
     * Obtiene el valor del numero entero.
     * @return Una cadena de caracteres con el valor de numero entero.
     */
    public String toString() {
        return "El valor es:" + this.valor;
    }
    
}
