package boletinRepasoJava1_Ej5;

import java.util.Date;

/**
 * Clase abstracta que almacena los atributos y acciones referentes a una persona.
 * @author danielms
 * @version 1.0
 * @see Date
 */
public abstract class Persona {

    /**
     * El nombre de la persona.
     */
    public String nombre;

    /**
     * El apellido de la persona.
     */
    public String apellido;

    /**
     * El DNI de la persona.
     */
    public int numeroIdentidad;

    /**
     * La direccion de la persona.
     */
    public String direccion;

    /**
     * El telefono de la persona.
     */
    public int telefono;

    /**
     * El anio de nacimiento de la persona.
     */
    public Date anioNacimiento;

    /**
     * Constructor Principal.
     * @param nombre El nombre de la persona.
     * @param apellido El apellido de la persona.
     * @param numeroIdentidad El DNi de la persona.
     * @param direccion La direccion de la persona.
     * @param telefono El telefono de la persona.
     * @param anioNacimiento El anio de nacimiento.
     */
    public Persona(String nombre, String apellido, int numeroIdentidad, String direccion, int telefono, Date anioNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroIdentidad = numeroIdentidad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.anioNacimiento = anioNacimiento;
    }

    /**
     * Obtiene el nombre de la persona.
     * @return El nombre de la persona.
     */
    public abstract String obtenerNombre();

    /**
     * Obtiene el apellido de la persona.
     * @return El apellido de la persona.
     */
    public abstract String obtenerApellido();

    /**
     * Obtiene el nombre completo de la persona.
     * @return El apellido de la persona.
     */
    public abstract String obtenerNombreCompleto();

    /**
     * Obtiene el DNI de la persona.
     * @return El DNI de la persona.
     */
    public abstract int obtenerDNI();

    /**
     * Obtiene la direccion de la persona.
     * @return La direccion de la persona.
     */
    public abstract String obtenerDireccion();

    /**
     * Obtiene el telefono de la persona.
     * @return El telefono de la persona.
     */
    public abstract int obtenerTelefono();

    /**
     * Obtiene el anio de nacimiento.
     * @return El anio de nacimiento.
     */
    public abstract Date obtenerAnioNacimiento();
}
