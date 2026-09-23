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
    protected String nombre;

    /**
     * El apellido de la persona.
     */
    protected String apellido;

    /**
     * El DNI de la persona.
     */
    protected int numeroIdentidad;

    /**
     * La direccion de la persona.
     */
    protected String direccion;

    /**
     * El telefono de la persona.
     */
    protected int telefono;

    /**
     * El anio de nacimiento de la persona.
     */
    protected Date anioNacimiento;

    /**
     * Constructor Principal
     * @param nombre
     * @param apellido
     * @param numeroIdentidad
     * @param direccion
     * @param telefono
     * @param anioNacimiento
     */
    protected Persona(String nombre, String apellido, int numeroIdentidad, String direccion, int telefono, Date anioNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroIdentidad = numeroIdentidad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.anioNacimiento = anioNacimiento;
    }

    /**
     *
     * @return
     */
    protected abstract String obtenerNombre();

    /**
     *
     * @return
     */
    protected abstract String obtenerApellido();

    /**
     *
     * @return
     */
    protected abstract String obtenerNombreCompleto();

    /**
     *
     * @return
     */
    protected abstract int obtenerDNI();

    /**
     *
     * @return
     */
    protected abstract String obtenerDireccion();

    /**
     *
     * @return
     */
    protected abstract int obtenerTelefono();

    /**
     *
     * @return
     */
    protected abstract Date obtenerAnioNacimiento();
}
