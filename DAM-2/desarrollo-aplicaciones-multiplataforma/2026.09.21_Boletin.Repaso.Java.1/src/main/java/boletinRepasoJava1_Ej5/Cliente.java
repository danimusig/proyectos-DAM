package boletinRepasoJava1_Ej5;

import java.util.Collections;
import java.util.Date;
import java.util.Set;

/**
 * Clase que contiene los atriibutos y acciones referentes a las de un cliente.
 * @author danielms
 * @version 1.0
 * @see Collections
 * @see Date
 * @see Set
 */
public class Cliente extends Persona {

    /**
     *
     */
    public int codigoCliente;

    /**
     *
     */
    public Date fecharegistro;

    /**
     *
     */
    public Set<Libro> librosComprados = Collections.emptySet();

    /**
     *
     * @param nombre
     * @param apellido
     * @param numeroIdentidad
     * @param direccion
     * @param telefono
     * @param anioNacimiento
     * @param codigoCliente
     * @param fecharegistro
     * @param librosComprados
     */
    public Cliente(String nombre, String apellido, int numeroIdentidad, String direccion, int telefono, Date anioNacimiento, int codigoCliente, Date fecharegistro, Set<Libro> librosComprados) {
        super(nombre, apellido, numeroIdentidad, direccion, telefono, anioNacimiento);
        this.codigoCliente = codigoCliente;
        this.fecharegistro = fecharegistro;
        this.librosComprados = librosComprados;
    }

    /**
     *
     * @return
     */
    public int obtenerCodigoCliente() {
        return this.codigoCliente;
    }

    /**
     *
     * @return
     */
    public Date obtenerFechaRegistro() {
        return this.fecharegistro;
    }

    /**
     *
     * @return
     */
    public Set<Libro> obtenerLibrosComprados() {
        return this.librosComprados;
    }

    /**
     *
     * @return
     */
    @Override
    protected String obtenerNombre() {
        return this.nombre;
    }

    /**
     *
     * @return
     */
    @Override
    protected String obtenerApellido() {
        return this.apellido;
    }

    /**
     *
     * @return
     */
    @Override
    protected String obtenerNombreCompleto() {
        return this.nombre + " " + this.apellido;
    }

    /**
     *
     * @return
     */
    @Override
    protected int obtenerDNI() {
        return this.numeroIdentidad;
    }

    /**
     *
     * @return
     */
    @Override
    protected String obtenerDireccion() {
        return this.direccion;
    }

    /**
     *
     * @return
     */
    @Override
    protected int obtenerTelefono() {
        return this.telefono;
    }

    /**
     *
     * @return
     */
    @Override
    protected Date obtenerAnioNacimiento() {
        return this.anioNacimiento;
    }
}
