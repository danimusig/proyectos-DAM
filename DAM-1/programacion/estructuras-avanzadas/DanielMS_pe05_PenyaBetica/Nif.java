package DAM1.DanielMS_pe05_PenyaBetica;

/**
 * Clase Nif: Almacena y modifica datos sobre un Nif.
 * @author dania
 * @version 1.0
 * @see String
 * @see Character
 */
public class Nif {
    
    /**
     * Los numeros del Nif.
     */
    private final Integer dni;
    
    /**
     * La letra del Nif.
     */
    private final char letra;
    
    /**
     * Constructor Principal.
     * @param dni Los numeros del nif en un Integer.
     * @param letra La letra del nif en un char.
     */
    public Nif(Integer dni, char letra) {
        //Control de errores de los numeros del dni pasando el dni a una string y contando el numero de caracteres, tiene que ser un numero de 8 digitos.
        if (Integer.toString(dni).length() == 8) {
            System.out.println("ERROR: El dni debe ser un numero de 8 digitos, se asignara 0");
            this.dni = 0;
        } else {
            this.dni = dni;
        }
        
        //Control de rrores de la letra del dni pasando la letra a una cadena y contando el numero de caracteres, tiene que haber solo 1 letra y el caracter introducido deber ser una letra.
        if (Character.isLetter(letra) == false) {
            System.out.println("ERROR: El caracter introducido debe ser una letra, se asignara X");
            this.letra = 'X';
        } else {
            this.letra = letra;
        }
    }

    /**
     * Obtiene los numeros del nif.
     * @return Los numeros del nif en un Integer.
     */
    public Integer getDni() {
        return dni;
    }

    /**
     * Obtiene la letra del nif.
     * @return La letra del nif en un char.
     */
    public char getLetra() {
        return letra;
    }
    
    /**
     * Obtiene informacion sobre el nif.
     * @return El nif en una cadena de caracteres.
     */
    public String toString() {
        return this.dni + "-" + this.letra;
    }
    
}
