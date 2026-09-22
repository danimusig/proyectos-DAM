package DAM1.DanielMS_pe05_zoo;

import java.time.LocalDate;

/**
 * Clase Animal: Contiene los atributos y metodos comunes entre los animales del zoo. 
 * @author DanielMS
 * @version 1.0
 * @see String
 * @see LocalDate
 */
public class Animal {
    
    /**
     * El nombre del animal.
     */
    private String nombre;
    
    /**
     * La fecha de ingreso al zoo del animal.
     */
    private LocalDate fechaEntrada;
    
    /**
     * La procedencia del animal.
     */
    private String procedencia;
    
    /**
     * Constructor Principal.
     * @param nombre El nombre del animal en una cadena de caracteres.
     * @param fechaEntrada La fecha de entrada del animal en un objeto LocalDate.
     * @param procedencia La precedencia del animal en una cadena de caracteres.
     */
    public Animal(String nombre, LocalDate fechaEntrada, String procedencia) {
        
        this.nombre = nombre;
        
        this.fechaEntrada = fechaEntrada;
        
        this.procedencia = procedencia;
    }
    
    /**
     * Obtiene el nombre del animal.
     * @return El nombre del animal en una cadena de caracteres.
     */
    public String getNombre() {
        return this.nombre;
    }
    
    /**
     * Obtiene la fecha de entrada al zoo del animal.
     * @return La fecha de entrada en un objeto LocalDate.
     */
    public LocalDate getFechaEntrada() {
        return this.fechaEntrada;
    }
    
    /**
     * Obtiene la procedencia del animal.
     * @return La procedencia del animal en una cadena de caracteres.
     */
    public String getProcedencia() {
        return this.procedencia;
    }
    
    /**
     * Modifica el nombre del animal.
     * @param nuevoNombre El nuevo nombre en una cadena de caracteres.
     */
    public void setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }
    
    /**
     * Moficica la fecha de entrada al zoo del animal.
     * @param nuevaFechaEntrada La nueva fecha de entrada en un objeto LocalDate.
     */
    public void setFechaEntrada(LocalDate nuevaFechaEntrada) {
        this.fechaEntrada = nuevaFechaEntrada;
    }
    
    /**
     * Modifica la procedencia del animal.
     * @param nuevaProcedencia La nueva procedencia en una cadena de caracteres.
     */
    public void setProcedencia(String nuevaProcedencia) {
        this.procedencia = nuevaProcedencia;
    }
    
    /**
     * Obtiene informacion sobre el animal.
     * @return Informacion sobre el animal en una cadena de caracteres.
     */
    @Override
    public String toString() {
        return "\n Nombre: " + this.nombre + " \n Fecha Entrada: " + this.fechaEntrada + "\n Procedencia: " + this.procedencia;
    } 
}
