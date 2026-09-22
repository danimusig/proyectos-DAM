package Modelo;

import Utils.ConexionDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javafx.collections.ObservableList;
import java.sql.ResultSet;
import javafx.collections.FXCollections;

/**
 * Clase Cliente: Permite crear y gestionar informacion relacionada con
 * clientes.
 *
 * @author dmunsig
 * @version 3.0
 * @see String
 * @see Cliente
 */
public class Cliente implements Comparable<Cliente> {

    /**
     * El dni del cliente.
     */
    private final String DNI_CLIENTE;
    
    /**
     * El nombre del cliente.
     */
    private String nombre;

    /**
     * El email del cliente.
     */
    private String email;

    /**
     * El lugar de residencia del cliente.
     */
    private String lugarResidencia;

    /**
     * La cantidad de veces que se ha alojado el cliente.
     */
    private int numVecesAlojado;
    
    /**
     * Constructor Principal.
     *
     * @param nombre El nombre del cliente en una cadena.
     * @param dni El dni del clinete en una cadena.
     * @param email El email del cliente en una cadena.
     * @param lugarResidencia El logar de residencia del cliente ne una cadena.
     * @throws DniNoValidaException, EmailNoValidaException.
     */
    public Cliente(String DNI_CLIENTE, String nombre, String email, String lugarResidencia) {
        this.DNI_CLIENTE = DNI_CLIENTE;
        this.nombre = nombre;
        this.email = email;
        this.lugarResidencia = lugarResidencia;
        this.numVecesAlojado = 0;
    }

    /**
     * Constructor para recibir los datos que guarda la base de datos.
     * @param nombre
     * @param DNI_CLIENTE
     * @param email
     * @param lugarResidencia
     * @param numVecesAlojado 
     */
    public Cliente(String DNI_CLIENTE, String nombre, String email, String lugarResidencia, int numVecesAlojado) {
        this.DNI_CLIENTE = DNI_CLIENTE;
        this.nombre = nombre;
        this.email = email;
        this.lugarResidencia = lugarResidencia;
        this.numVecesAlojado = numVecesAlojado;
    }

    public String getDNI_CLIENTE() {
        return DNI_CLIENTE;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLugarResidencia() {
        return lugarResidencia;
    }

    public void setLugarResidencia(String lugarResidencia) {
        this.lugarResidencia = lugarResidencia;
    }

    public int getNumVecesAlojado() {
        return numVecesAlojado;
    }

    public void setNumVecesAlojado(int numVecesAlojado) {
        this.numVecesAlojado = numVecesAlojado;
    }
    
    /**
     * Aumenta 1 numVecesAlojado.
     */
    public void alojar() {
        numVecesAlojado++;
    }

    /**
     * Compara dos clientes alfabeticamente usando su nombre como parametro de
     * comparacion.
     *
     * @param cliente2 El cliente con el que se comparara.
     * @return -1 si es menor 0 si es igual 1 si es mayor.
     */
    @Override
    public int compareTo(Cliente cliente2) {
        return this.nombre.compareTo(cliente2.nombre);
    }

    /**
     * Muestra informacion sobre los clientes.
     *
     * @return Informacion sobre los clientes en una cadena.
     */
    @Override
    public String toString() {
        return this.DNI_CLIENTE + " - " + this.nombre;
    }

    public static ObservableList<Cliente> getClientes() throws SQLException {
        String selectClientes = "SELECT DISTINCT * FROM clientes";

        ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();

        try (Connection con = ConexionDB.establecerConexion();
                PreparedStatement stmtClientes = con.prepareStatement(selectClientes)) {
            try (ResultSet rsClientes = stmtClientes.executeQuery()) {
                while(rsClientes.next()) {
                    listaClientes.add(new Cliente(
                            rsClientes.getString("dni"),
                            rsClientes.getString("nombre"),
                            rsClientes.getString("email"),
                            rsClientes.getString("lugarResidencia"),
                            rsClientes.getInt("numVecesAlojado")
                    ));           
                }
            }
        }
        return listaClientes;
    }
    
    public static boolean insertarCliente(Cliente c) throws SQLException {
        String insertClientes = "INSERT INTO clientes VALUES (?, ?, ?, ?, ?)";

        try (Connection con = ConexionDB.establecerConexion(); 
                PreparedStatement stmtClientes = con.prepareStatement(insertClientes)) {
            stmtClientes.setString(1, c.getDNI_CLIENTE());
            stmtClientes.setString(2, c.getNombre());
            stmtClientes.setString(3, c.getEmail());
            stmtClientes.setString(4, c.getLugarResidencia());
            stmtClientes.setInt(5, c.getNumVecesAlojado());
            
            int numFilas = stmtClientes.executeUpdate();
            return numFilas > 0;
        }
    }

    public static boolean modificarCliente(Cliente c, String Dni) throws SQLException {
        String modificarClientes = "UPDATE clientes SET dni=?, nombre=?, email=?, lugarResidencia=?, numVecesAlojado=? WHERE dni=?";

        try (Connection con = ConexionDB.establecerConexion(); 
                PreparedStatement stmtClientes = con.prepareStatement(modificarClientes)) {
            stmtClientes.setString(1, c.getDNI_CLIENTE());
            stmtClientes.setString(2, c.getNombre());
            stmtClientes.setString(3, c.getEmail());
            stmtClientes.setString(4, c.getLugarResidencia());
            stmtClientes.setInt(5, c.getNumVecesAlojado());
            stmtClientes.setString(6, Dni);

            int numFilas = stmtClientes.executeUpdate();
            return numFilas > 0;
        }
    }
    
    public static boolean eliminarCliente(Cliente c) throws SQLException {
        String deleteCliente = "DELETE FROM clientes where dni=?";
        
        try (Connection con = ConexionDB.establecerConexion();
                PreparedStatement stmtClientes = con.prepareStatement(deleteCliente)) {
            stmtClientes.setString(1, c.getDNI_CLIENTE());
            int numFilas = stmtClientes.executeUpdate();
            return numFilas > 0;
        }
    }
}
