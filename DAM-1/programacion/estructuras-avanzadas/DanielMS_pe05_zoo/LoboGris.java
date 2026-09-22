package DAM1.DanielMS_pe05_zoo;

import java.time.LocalDate;

/**
 * Clase LoboGris: Permi
 * @author DanielMS
 * @version 1.0
 * @see String
 */
public class LoboGris extends Animal {
        
    /**
     * El nombre del alimento del lobo gris.
     */
    private static final String NOMALIMENTO = "Carne"; //Ya que todos los animales de una misma especie tienen la misma dieta creo el atributo como static final.
    
     /**
     * La cantidad de alimento que consume el lobo gris.
     */
    private static final int CANTIDADALIMENTO = 2; //Ya que todos los animales de una misma especie tienen la misma dieta creo el atributo como static final.
    
    /**
     * Constructor Principal.
     * @param nombre El nombre del lobo gris en una cadena de caracteres.
     * @param fechaEntrada La fecha de entrada al zoo del lobo gris en un objeto LocalDate.
     * @param procedencia La procedencia del lobo gris en una cadena de caracteres.
     */
    public LoboGris(String nombre, LocalDate fechaEntrada, String procedencia) {
        super(nombre, fechaEntrada, procedencia);
        
    }  

    /**
     * Obtiene el nombre del alimento del lobo gris.
     * @return El nombre del alimento en una cadena de caracteres.
     */
    public String getNOMALIMENTO() {
        return NOMALIMENTO;
    }

    /**
     * Obtiene la cantidad de alimento del lobo gris.
     * @return La cantidad de alimento en una cadena de caracteres.
     */
    public int getCantidad() {
        return CANTIDADALIMENTO;
    }
    
    /**
     * Obtiene informacion sobre el lobo gris.
     * @return Informacion sobre el lobo gris en una cadena de caracteres.
     */
    @Override
    public String toString() {
        return "\n<-- Informacion sobre el Lobo Gris -->" + super.toString() + "\n Alimentación: " + this.NOMALIMENTO + " - " + this.CANTIDADALIMENTO + " kg.";
    }
            
}
