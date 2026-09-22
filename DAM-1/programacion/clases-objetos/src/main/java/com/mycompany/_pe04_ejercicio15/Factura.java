package com.mycompany._pe04_ejercicio15;

/**
 * Clase Factura: Esta clase muestra informacion sobre la factura y calcula su precio con IVA.
 * @author DanielMS
 * @version 1.0
 * @see String
 */
public class Factura {
    /**
     * El numero de factura.
     */
    private int numero;
    
    /**
     * El concepto de la factura.
     */
    private String concepto;
    
    /**
     * El importe sin iva aplicado.
     */
    private double importeSinIva;
    
    /**
     * El porcentaje de iva aplicado a todos los precios.
     */
    private static int IVA = 21;
    
    /**
     * Contructor Princìpal.
     * @param numero El numero de factura en un entero.
     * @param concepto El concepto de la factura en una cadena de caracteres.
     * @param importeSinIva El importe sin iva en euros.
     */
    public Factura(int numero, String concepto, double importeSinIva){
        this.numero = numero;
        
        this.concepto = concepto;
        
        this.importeSinIva = importeSinIva;
    }
    
    /**
     * Obtiene el numero de factura.
     * @return 
     */
    public int getNumero() {
        return this.numero;
    }
    
    /**
     * Obtiene el concepto de la factura.
     * @return El concepto de la factura en una cadena de caracteres.
     */
    public String getConcepto() {
        return this.concepto;
    }
    
    /**
     * Obtiene el importe total sumando el iva al importe.
     * @return El importe total en euros.
     */
    public double getImporteTotal() {
        double sumaIVA = (this.importeSinIva * this.IVA) / 100;
        return this.importeSinIva + sumaIVA;
    }
    
    /**
     * Modifica el importeSinIva.
     * @param nuevoImporte El nuevo importe sin el iva incluido representado en euros.
     */
    public void setImporte(double nuevoImporte) {
        this.importeSinIva = nuevoImporte;
    }
    
    /**
     * Modifica el concepto de la factura.
     * @param nuevoConcepto El nuevo concepto de la captura representada en una cadena de caracteres.
     */
    public void setConcepto(String nuevoConcepto) {
        this.concepto = nuevoConcepto;
    }
    
    /**
     * Obtiene informacion sobre la factura.
     * @return Una cadena de caracteres con informacion sobre la factura
     */
    public String toString() {
        return "\nFactura Nº " + this.numero + ":" + "\nConcepto: " + this.concepto + "\nImporte sin IVA: " + this.importeSinIva;
    }
}
