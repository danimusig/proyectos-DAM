package DAM1.DanielMS_pe05_PenyaBetica;

/**
 * Clase Socio: Almacena y modifica datos sobre una Persona Socio.
 * @author DanielMS
 * @version 1.0
 * @see String
 * @see Nif
 * @see Nombre
 * @see Fecha
 */
public class Socio extends Persona {
    
    /**
     * El codigo del socio.
     */
    private final int CodigoSoc;
    
    /**
     * La fecha de alta del socio.
     */
    private final Fecha FechaAlta;
    
    /**
     * Constructor Principal.
     * @param nombreSocio El nombre del socio en un objeto de la clase Nombre.
     * @param nifSocio El nif del socio en un objeto de la clase Nif.
     * @param fechaNacimiento La fecha de nacimiento del socio en un objeto de la clase Fecha.
     * @param CodigoSoc El codigo del socio en un entero.
     * @param FechaAlta La fecha de alta del socio en un objeto de la clase Fecha.
     */
    public Socio(Nombre nombreSocio, Nif nifSocio, Fecha fechaNacimiento, int CodigoSoc, Fecha FechaAlta) {
        super(nombreSocio, nifSocio, fechaNacimiento);
 
        this.CodigoSoc = CodigoSoc;
        
        this.FechaAlta = FechaAlta;
    }

    /**
     * Obtiene el codigo del socio.
     * @return El codigo del socio en un entero.
     */
    public int getCodigoSoc() {
        return CodigoSoc;
    }

    /**
     * Obtiene la fecha de alta del socio.
     * @return La fecha de alta del socio en un entero.
     */
    public Fecha getFechaAlta() {
        return FechaAlta;
    }
    
    /**
     * Obtiene informacion sobre el socio.
     * @return Informacion sobre el socio en una cadena de caracteres.
     */
    public String toString() {
        return "\n<--- Datos del Socio ---> \n Codigo de Socio: " + this.CodigoSoc + super.toString() + "\n Fecha Alta: " + this.FechaAlta;
    }
}
