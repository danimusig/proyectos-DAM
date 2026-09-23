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
     *
     * @return
     */
    public int obtenerCodigoVendedor(){
        return this.codigoVendedor;
    }

    /**
     *
     * @return
     */
    public String areaVenta() {
        return this.areaVenta;
    }

    /**
     *
     * @return
     */
    public int totalVentas() {
        return this.totalVentas();
    }

    /**
     * @return
     */
    @Override
    protected String obtenerNombre() {
        return "";
    }

    /**
     * @return
     */
    @Override
    protected String obtenerApellido() {
        return "";
    }

    /**
     * @return
     */
    @Override
    protected String obtenerNombreCompleto() {
        return "";
    }

    /**
     * @return
     */
    @Override
    protected int obtenerDNI() {
        return 0;
    }

    /**
     * @return
     */
    @Override
    protected String obtenerDireccion() {
        return "";
    }

    /**
     * @return
     */
    @Override
    protected int obtenerTelefono() {
        return 0;
    }

    /**
     * @return
     */
    @Override
    protected Date obtenerAnioNacimiento() {
        return null;
    }
}
