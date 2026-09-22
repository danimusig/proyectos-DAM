package DAM1.DanielMS_pe05_PenyaBetica;

/**
 * Clase Nombre: Almacena y modifica datos sobre un nombre.
 * @author DanielMS
 * @version 1.0
 * @see String
 */
public class Nombre {
    
    /**
     * El nombre.
     */
    private String nombre;
    
    /**
     * El/los apellidos.
     */
    private String apellido;
    
    /**
     * Constructor principal. 
     * @param nombre El nombre en una cadena de caracteres.
     * @param apellido El/los apellidos en una cadena de caracteres.
     */
    public Nombre(String nombre, String apellido) {
        this.nombre = nombre;
        
        this.apellido = apellido;
    }

    /**
     * Obtiene el nombre.
     * @return El nombre en una cadena de caracteres.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre.
     * @param nombre El nuevo nombre en una cadena de caracteres.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido.
     * @return El apellido en una cadena de caracteres.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Modifica el apellido.
     * @param apellido El apellido en una cadena de caracteres.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    /**
     * Obtiene informacion sobre el nombre.
     * @return Informacion sobre el nombre en una cadena de caracteres.
     */
    public String toString() {
        return this.nombre + " " + this.apellido;
    }
}
