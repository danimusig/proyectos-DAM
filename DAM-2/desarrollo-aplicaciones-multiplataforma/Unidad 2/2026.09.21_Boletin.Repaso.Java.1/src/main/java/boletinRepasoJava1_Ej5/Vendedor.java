package boletinRepasoJava1_Ej5;

import java.util.Date;

/**
 * Clase que contiene los datos y acciones referentes a un vendedor y hereda métodos de la clase Persona.
 * @author danielms
 * @version 1.0
 * @see Date
 */
public class Vendedor extends Persona {

    /**
     * El codigo de indentificacion del vendedor.
     */
    public int codigoVendedor;

    /**
     * El are de venta del vendedor.
     */
    public String areaVenta;

    /**
     * Las ventas totales del vendedor.
     */
    public int totalVentas;

    /**
     * Constructor Principal
     * @param nombre El nombre del vendedor.
     * @param apellido El apellido del vendedor.
     * @param numeroIdentidad El DNI del vendedor.
     * @param direccion La direccion del vendedor.
     * @param telefono El telefono del vendedor.
     * @param anioNacimiento El anio de nacimiento del vendedor.
     * @param codigoVendedor El codigo de identificacion del vendedor.
     * @param areaVenta El are de venta del vendedor.
     * @param totalVentas El total de ventas del vendedor.
     */
    public Vendedor(String nombre, String apellido, int numeroIdentidad, String direccion, int telefono, Date anioNacimiento, int codigoVendedor, String areaVenta, int totalVentas) {
        super(nombre, apellido, numeroIdentidad, direccion, telefono, anioNacimiento);
        this.codigoVendedor = codigoVendedor;
        this.areaVenta = areaVenta;
        this.totalVentas = totalVentas;
    }

    /**
     * Obtiene el codigo del vendedor.
     * @return El codigo del vendedor.
     */
    public int obtenerCodigoVendedor(){
        return this.codigoVendedor;
    }

    /**
     * Obtiene el area de venta del vendedor.
     * @return El area de venta del vendedor.
     */
    public String obtenerAreaVenta() {
        return this.areaVenta;
    }

    /**
     * Obtiene el total de ventas del vendedor.
     * @return El total de ventas del vendedor.
     */
    public int obtenerTotalVentas() {
        return this.totalVentas;
    }

    /**
     * Obtiene el nombre del vendedor.
     * @return El nombre del vendedor.
     */
    @Override
    public String obtenerNombre() {
        return this.nombre;
    }

    /**
     * Obtiene el apellido del vendedor.
     * @return El apellido del vendedor.
     */
    @Override
    public String obtenerApellido() {
        return this.apellido;
    }

    /**
     * Obtiene el nombre completo del vendedor.
     * @return El nombre completo del vendedor.
     */
    @Override
    public String obtenerNombreCompleto() {
        return this.nombre + this.apellido;
    }

    /**
     * Obtiene el DNI del vendedor.
     * @return El DNI del vendedor.
     */
    @Override
    public int obtenerDNI() {
        return 0;
    }

    /**
     * Obtiene la direccion del vendedor.
     * @return La direccion del vendedor.
     */
    @Override
    public String obtenerDireccion() {
        return "";
    }

    /**
     * Obtiene el telefono del vendedor.
     * @return El telefono del vendedor.
     */
    @Override
    public int obtenerTelefono() {
        return 0;
    }

    /**
     * Obtiene el anio de nacimiento.
     * @return El anio de nacimiento.
     */
    @Override
    public Date obtenerAnioNacimiento() {
        return null;
    }
}
