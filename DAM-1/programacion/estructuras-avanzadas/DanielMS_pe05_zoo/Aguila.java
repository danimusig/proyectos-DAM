package DAM1.DanielMS_pe05_zoo;

import java.time.LocalDate;

/**
 * Clase Aguila: 
 * @author DanielMS
 * @version 1.0
 * @see String
 */
public class Aguila extends Animal {
    
    /**
     * El nombre del alimento del aguila.
     */
    private static final String NOMALIMENTO = "Pienso"; //Ya que todos los animales de una misma especie tienen la misma dieta creo el atributo como static final.
    
    /**
     * La cantidad de alimento que consume el aguila.
     */
    private static final double CANTIDADALIMENTO = 0.3; //Ya que todos los animales de una misma especie tienen la misma dieta creo el atributo como static final.
    
    /**
     * Constructor Principal.
     * @param nombre El nombre del aguila en una cadena de caracteres.
     * @param fechaEntrada La fecha de entrada al zoo del aguila en un objeto LocalDate.
     * @param procedencia La procedencia del aguila en una cadena de caracteres.
     */
    public Aguila(String nombre, LocalDate fechaEntrada, String procedencia) {
        super(nombre, fechaEntrada, procedencia);
    }  

    /**
     * Obtiene el nombre del alimento del aguila.
     * @return El nombre del alimento en una cadena de caracteres.
     */
    public String getNOMALIMENTO() {
        return NOMALIMENTO;
    }

    /**
     * Obtiene la cantidad de comida del aguila.
     * @return La cantidad de comida en un double.
     */
    public double getCantidad() {
        return CANTIDADALIMENTO;
    }
    
    /**
     * Obtiene informacion sobre el aguila.
     * @return Informacion sobre el aguila en una cadena de caracteres.
     */
    @Override
    public String toString() {
        return "\n<-- Informacion sobre el Aguila -->" + super.toString() + "\n Alimentación: " + this.NOMALIMENTO + " - " + this.CANTIDADALIMENTO + "kg.";
    }
            
}
