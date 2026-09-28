package boletinRepasoJava1_Ej5;

import java.util.Collections;
import java.util.Date;
import java.util.Set;

/**
 * Clase que contiene los atributos y acciones referentes a las de un cliente.
 * @author danielms
 * @version 1.0
 * @see Collections
 * @see Date
 * @see Set
 */
public class Cliente extends Persona {

    /**
     * El código del cliente.
     */
    public int codigoCliente;

    /**
     * La fecha de registro del cliente.
     */
    public Date fecharegistro;

    /**
     * Los libros comprados del cliente.
     */
    public Set<Libro> librosComprados = Collections.emptySet();

    /**
     * Constructor Principal
     * @param nombre El nombre del cliente.
     * @param apellido El apellido del cliente.
     * @param numeroIdentidad El DNI del cliente.
     * @param direccion La direccion del cliente.
     * @param telefono El telefono del cliente.
     * @param anioNacimiento El anio de nacimiento.
     * @param codigoCliente El codigo de cliente.
     * @param fecharegistro La fecha de registro del cliente.
     * @param librosComprados El libro comprado del cliente.
     */
    public Cliente(String nombre, String apellido, int numeroIdentidad, String direccion, int telefono, Date anioNacimiento, int codigoCliente, Date fecharegistro, Set<Libro> librosComprados) {
        super(nombre, apellido, numeroIdentidad, direccion, telefono, anioNacimiento);
        this.codigoCliente = codigoCliente;
        this.fecharegistro = fecharegistro;
        this.librosComprados = librosComprados;
    }

    /**
     * Obtener el codigo del cliente.
     * @return El codigo del cliente.
     */
    public int obtenerCodigoCliente() {
        return this.codigoCliente;
    }

    /**
     * Obtiene la fecha de registro del cliente.
     * @return La fecha de registro del cliente.
     */
    public Date obtenerFechaRegistro() {
        return this.fecharegistro;
    }

    /**
     * Obtiene la fecha de registro del cliente.
     * @return La fecha de registro del cliente.
     */
    public Set<Libro> obtenerLibrosComprados() {
        return this.librosComprados;
    }

    /**
     * Obtiene el nombre del cliente.
     * @return El nombre del cliente.
     */
    @Override
    public String obtenerNombre() {
        return this.nombre;
    }

    /**
     * Obtiene el apellido del cliente.
     * @return El apellido del cliente.
     */
    @Override
    public String obtenerApellido() {
        return this.apellido;
    }

    /**
     * Obtiene el nombre completo del cliente.
     * @return El nombre completo del cliente.
     */
    @Override
    public String obtenerNombreCompleto() {
        return this.nombre + " " + this.apellido;
    }

    /**
     * Obtiene el DNI del cliente.
     * @return El DNI del cliente.
     */
    @Override
    public int obtenerDNI() {
        return this.numeroIdentidad;
    }

    /**
     * Obtiene la direccion del cliente.
     * @return La direccion del cliente.
     */
    @Override
    public String obtenerDireccion() {
        return this.direccion;
    }

    /**
     * Obtiene el telefono del cliente.
     * @return El telefono del cliente.
     */
    @Override
    public int obtenerTelefono() {
        return this.telefono;
    }

    /**
     * Obtiene el telefono del cliente.
     * @return El telefono del cliente.
     */
    @Override
    public Date obtenerAnioNacimiento() {
        return this.anioNacimiento;
    }
}
