package DAM1.DanielMS_pe05_zoo;

import java.time.LocalDate;

/**
 * Clase OsoIberico: Permi
 * @author DanielMS
 * @version 1.0
 * @see String
 */
public class OsoIberico extends Animal {
    
    /**
     * El nombre del alimento del oso iberico.
     */
    private static final String NOMALIMENTO = "Fruta"; //Ya que todos los animales de una misma especie tienen la misma dieta creo el atributo como static final.
    
    /**
     * La cantidad de alimento que consume un oso iberico.
     */
    private static final int CANTIDADALIMENTO = 2; //Ya que todos los animales de una misma especie tienen la misma dieta creo el atributo como static final.
    
    /**
     * Constructor Principal.
     * @param nombre El nombre del oso iberico en una cadena de caracteres.
     * @param fechaEntrada La fecha de ingreso al zoo del oso iberico en un objeto LocalDate.
     * @param procedencia La procedencia del oso iberico en una cadena de caracteres.
     */
    public OsoIberico(String nombre, LocalDate fechaEntrada, String procedencia) {
        super(nombre, fechaEntrada, procedencia);
    }  

    /**
     * Obtiene el nombre del alimento del oso iberico.
     * @return El nombre del alimento en un una cadena de caracteres.
     */
    public String getNOMALIMENTO() {
        return NOMALIMENTO;
    }

    /**
     * Obtiene la cantidad de alimento consumida por el oso iberico.
     * @return La cantidad de alimento en un entero.
     */
    public int getCantidad() {
        return CANTIDADALIMENTO;
    }
    
    /**
     * Obtiene informacion sobre el oso iberico.
     * @return Informacion sobre el oso iberico en una cadena de caracteres.
     */
    @Override
    public String toString() {
        return "\n<-- Informacion sobre el Oso Iberico -->" + super.toString() + "\n Alimentacion: " + this.NOMALIMENTO + " - " + this.CANTIDADALIMENTO + " kg.";
    }
            
}
