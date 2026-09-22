package DAM1.DanielMS_pe05_PenyaBetica;

/**
 * Clase Persona: Almacena y modifica datos sobre una persona.
 * @author DanielMS
 * @version 1.0
 * @see String
 * @see Nombre
 * @see Nif
 * @see Fecha
 */
public class Persona {
    
    /**
     * El nombre de la persona.
     */
    private Nombre nombre;
    
    /**
     * El nif de la persona.
     */
    private final Nif nif;
    
    /**
     * La fecha de nacimiento de la persona.
     */
    private final Fecha fechaNacimiento;
    
    /**
     * Constructor Principal.
     * @param nombreSocio El nombre de la persona en un objeto de la clase Nombre.
     * @param nif El nif de la persona en un objeto de la clase Nif.
     * @param fechaNacimiento La fecha de nacimiento de la persona en un objeto de la clase Fecha.
     */
    public Persona(Nombre nombre, Nif nif, Fecha fechaNacimiento) {
        this.nombre = nombre;
        
        this.nif = nif;
        
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene el nombre de la persona.
     * @return El nombre de la persona en un objeto de la clase Nombre.
     */
    public Nombre getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre de la persona.
     * @param nuevoNombre El nuevo nombre de la persona en un objeto de la clase Nombre.
     */
    public void setNombre(Nombre nuevoNombre) {
        this.nombre = nuevoNombre;
    }

    /**
     * Obtiene la fecha de nacimiento de la persona.
     * @return La fecha de nacimiento de la persona en un objeto de la clase Fecha.
     */
    public Fecha getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    /**
     * Obtiene informacion sobre la persona.
     * @return Informacion sobre la persona en una cadena de caracteres.
     */
    public String toString() {
        return "\n Nombre: " + this.nombre + "\n NIF: " + this.nif + "\n Fecha de nacimiento: " + this.fechaNacimiento; 
    }
}
