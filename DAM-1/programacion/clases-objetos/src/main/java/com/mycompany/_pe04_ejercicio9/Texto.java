package com.mycompany._pe04_ejercicio9;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class Texto {
    
    /**
     * La cadena introducida por el usuario.
     */
    private String cadena = "";
    
    /**
     * La fecha de creacion de la cadena.
     */
    private LocalDate creacion;
    
    /**
     * La longitud máxima de la cadena establecida por el usuario.
     */
    private int longitudMaxima;
    
    public Texto(String cadena, int longitudMaxima) {
        
        if (this.cadena.length() > longitudMaxima) {
            System.out.print("ERROR: cadena demasiado larga, se truncara a " + this.longitudMaxima + " caracteres.");
            this.cadena = cadena.substring(0, longitudMaxima);
        } else {
            this.cadena = cadena;
        }
        
        this.longitudMaxima=longitudMaxima;

        creacion = LocalDate.now();
        this.creacion = creacion;        
    }
    
    public void setCadena(String nuevaCadena) {
        if (this.cadena.length() + nuevaCadena.length() > this.longitudMaxima) {
            System.out.print("ERROR: cadena demasiado larga, se truncara a " + this.longitudMaxima + " caracteres.");
            this.cadena = nuevaCadena.substring(0, this.longitudMaxima);
        } else {
            this.cadena = nuevaCadena;
        }
    }    
        
    public void setLongitudMaxima(int nuevaLongitudMaxima) {
        this.longitudMaxima = nuevaLongitudMaxima;
    }        
    
    public String getCadena() {
        return this.cadena;
    }
    
    public LocalDate getCreacion() {
        return this.creacion;
    }
    
    public int LongitudMaxima() {
        return this.longitudMaxima;
    }
    
    public void addFinal(char charFinal) {
        if (this.cadena.length() + 1 > this.longitudMaxima) {
            System.out.print("ERROR: No se pudo anyadir '" + charFinal + "' porque excede el limite de caracteres establecido de la cadena ");
        } else {
            this.cadena+=charFinal;
        }
    }
    
    public void addFinal(String cadenaFinal) {
        if (this.cadena.length() + cadenaFinal.length() > this.longitudMaxima) {
            System.out.println("ERROR: No se pudo anyadir '" + cadenaFinal + "' porque excede el limite de caracteres establecido de la cadena.");
        } else {
        this.cadena+=cadenaFinal;
        }     
    }    
    
    public void addPrincipio(char charPrincipio) {
        if (this.cadena.length() + 1 > this.longitudMaxima) {
            System.out.println("ERROR: No se pudo anyadir '" + charPrincipio + "' porque excede el limite de caracteres establecido de la cadena.");
        } else {        
            this.cadena = charPrincipio + this.cadena;
        }
    }
    
    public void addPrincipio(String cadenaPrincipio) {
        if (this.cadena.length() + cadenaPrincipio.length() > this.longitudMaxima) {
            System.out.println("ERROR: No se pudo anyadir '" + cadenaPrincipio + "' a la cadena porque excede el limite de caracteres establecido de la cadena.");
        } else {        
           this.cadena = cadenaPrincipio + this.cadena;
        }
    }
    
    public String mostrar() {
        return "\nInformacion sobre la cadena:" + "\nTexto: " + this.cadena + "\nFecha de cracion: " + this.creacion + "\nLongitud maxima: " + this.longitudMaxima;
    }
}
