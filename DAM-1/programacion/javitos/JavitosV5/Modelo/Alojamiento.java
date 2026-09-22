package Modelo;

import Utils.ConexionDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

/**
 * Clase Alojamiento: Permite crear y gestionar informacion sobre alojamientos.
 * @author dmunsig
 * @version 3.0
 * @see String
 * @see Alojamiento
 */

public class Alojamiento implements Comparable<Alojamiento> {
    /**
     * El nombre del alojamiento.
     */
    private String nombre;
    
    /**
     * La capacidad del alojamiento en personmas.
     */
    private int capacidad;
    
    /**
     * La tarifa por noche del alojamiento.
     */
    private double tarifa;

    /**
     * Si tiene chimenea o no.
     */
    private boolean tieneChimenea;
    
    /**
     * Si tiene jacuzzi o no.
     */
    private boolean tieneJacuzzi;
    
    /**
     * Si esta alquiladaAhora o no.
     */
    private boolean alquiladaAhora;
    
    /**
     * El numero de veces alquilado.
     */
    private int numVecesAlquilado;
    
    /**
     * Constructor Principal.
     * @param nombre El nombre del alojamiento.
     * @param capacidad La capacidad del alojamiento en personmas.
     * @param tarifa La tarifa por noche del alojamiento.
     * @param tieneChimenea Si tiene chimenea o no.
     * @param tieneJacuzzi Si tiene jacuzzi o no.
     */
    public Alojamiento(String nombre, int capacidad, double tarifa, boolean tieneChimenea, boolean tieneJacuzzi) {
        this.capacidad = capacidad;
        this.tarifa = tarifa;
        this.nombre = nombre;
        this.tieneChimenea = tieneChimenea;
        this.tieneJacuzzi = tieneJacuzzi;
        this.alquiladaAhora = false; // Por defecto al crearse esta libre.
        this.numVecesAlquilado = 0; // Inicio en el constructor el contador.    
    }

    /**
     * "Constructor" usado para recoger los datos de la base de datos.
     * @param nombre El nombre del alojamiento.
     * @param capacidad La capacidad del alojamiento en personas.
     * @param tarifa La tarifa por noche del alojamiento.
     * @param tieneChimenea Si tiene chimenea o no.
     * @param tieneJacuzzi Si tiene jacuzzi o no.
     * @param alquiladaAhora Si la vivienda se encuentra alquilada ahora.
     * @param numVecesAlquilado La cantidad de veces que se ha alquilado la vivienda.
     */
    public Alojamiento(String nombre, int capacidad, double tarifa, boolean tieneChimenea, boolean tieneJacuzzi, boolean alquiladaAhora, int numVecesAlquilado) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.tarifa = tarifa;
        this.tieneChimenea = tieneChimenea;
        this.tieneJacuzzi = tieneJacuzzi;
        this.alquiladaAhora = alquiladaAhora;
        this.numVecesAlquilado = numVecesAlquilado;
    }
    
    /**
     * Obtiene el nombre del alojamiento.
     * @return El nombre del alojamiento en una cadena de caracteres.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre del alojamiento.
     * @param nombre El nuevo nombre del alojamiento en una cadena de caracteres.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la capacidad del alojamiento.
     * @return La capacidad del alojamiento en personas,
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * Modifica la capacidad del alojamiento.
     * @param nuevaCapacidad La nueva capacidad del alojamiento en personas.
     */
    public void setCapacidad(int nuevaCapacidad) {
        this.capacidad = nuevaCapacidad;
    }

    /**
     * Obtiene la tarifa del alojamiento por noche.
     * @return La tarifa del alojamiento por noche en euros.
     */
    public double getTarifa() {
        return tarifa;
    }

    /**
     * Modifica la tarifa del alojamiento por noche. 
     * @param nuevaTarifa la nueva tarifa del alojamiento por noche.
     */
    public void setTarifa(double nuevaTarifa) {
        this.tarifa = nuevaTarifa;
    }

    /**
     * Obtiene si el alojamiento tiene chimenea.
     * @return Si el alojamiento tiene chimenea en un boolean.
     */
    public boolean getTieneChimenea() {
        return tieneChimenea;
    }

    /**
     * Modifica si el alojamiento tiene chimenea.
     * @param tieneChimenea Si tiene o no chimenea el alojamiento en un boolean.
     */
    public void setTieneChimenea(boolean tieneChimenea) {
        this.tieneChimenea = tieneChimenea;
    }

    /**
     * Obtiene si el alojamiento tiene jacuzzi.
     * @return Si el alojamiento tiene jacuzzi en un boolean.
     */
    public boolean getTieneJacuzzi() {
        return tieneJacuzzi;
    }

    /**
     * Modifica si el alojamiento tiene jacuzzi.
     * @param tieneJacuzzi si el alojamiento tiene jacuzzi en un boolean.
     */
    public void setTieneJacuzzi(boolean tieneJacuzzi) {
        this.tieneJacuzzi = tieneJacuzzi;
    }
    
    public void setAlquiladaAhora(boolean alquiladaAhora) {
        this.alquiladaAhora = alquiladaAhora;
    }

    /**
     * Obtiene si el alojamiento esta alquiladaAhora.
     * @return Si el alojamiento esta alquiladaAhora en un boolean.
     */
    public boolean getAlquiladaAhora() {
        return alquiladaAhora;
    }

    /**
     * Obtiene las veces que se ha alquilado el alojamiento.
     * @return Las veces que se ha alquilado el alojamiento en un entero.
     */
    public int getNumVecesAlquilado() {
        return numVecesAlquilado;
    }

    /**
     * Modifica las veces que se ha alquilado el alojamiento.
     * @param numVecesAlquilado Las veces que se ha alquilado el alojamiento en un entero.
     */
    public void setNumVecesAlquilado(int numVecesAlquilado) {
        this.numVecesAlquilado = numVecesAlquilado;
    }

    /**
     * Modifica el estado de alquiladaAhora a true e incrementea
     * numVecesAlquilado
     */
    public void alquilar() {
        this.alquiladaAhora = true;
        this.numVecesAlquilado++;
    }

    /**
     * Modifica alquiladaAhora a false.
     */
    public void liberar() {
        this.alquiladaAhora = false;
    }

    /**
     * Compara alfabeticamente los nombres de dos alojamientos.
     *
     * @param alojamiento2 El nombre del alojamiento a comparar con el primero.
     * @return -1 si es menor 0 si es igual 1 si es mayor.
     */
    @Override
    public int compareTo(Alojamiento alojamiento2) {
        return this.nombre.compareTo(alojamiento2.nombre);
    }

    /**
     * Muestra informacion sobre los alojamientos.
     *
     * @return Informacion sobre los alojamientos en una cadena.
     */
    @Override
    public String toString() {
        return this.nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alojamiento other = (Alojamiento) obj;
        return Objects.equals(this.nombre, other.nombre);
    }
    
    public static ObservableList<Alojamiento> getAlojamientos() throws SQLException {        
        
        String selectAlojamiento = "SELECT DISTINCT * FROM alojamientos";
        
        ObservableList<Alojamiento> listaAlojamientos = FXCollections.observableArrayList();

        try (Connection con = ConexionDB.establecerConexion(); 
                PreparedStatement stmtAlojamiento = con.prepareStatement(selectAlojamiento)) {
            try (ResultSet rsAlojamiento = stmtAlojamiento.executeQuery()) {
                while (rsAlojamiento.next()) { 
                    listaAlojamientos.add(new Alojamiento(
                            rsAlojamiento.getString("nombre"),
                            rsAlojamiento.getInt("capacidad"),
                            rsAlojamiento.getDouble("tarifa"),
                            rsAlojamiento.getBoolean("tieneChimenea"),
                            rsAlojamiento.getBoolean("tieneJacuzzi"),
                            rsAlojamiento.getBoolean("alquiladaAhora"),
                            rsAlojamiento.getInt("numVecesAlquilada")
                    ));
                }      
            }
        } 
        
        return listaAlojamientos;
    }
    
    public static ObservableList<Alojamiento> getAlojamientosFiltrados(int capacidadAlojamiento) throws SQLException {

        String selectAlojamientoFiltrado = "SELECT DISTINCT * FROM alojamientos WHERE capacidad=?";

        ObservableList<Alojamiento> listaAlojamientosFiltrados = FXCollections.observableArrayList();

        try (Connection con = ConexionDB.establecerConexion(); 
                PreparedStatement stmtAlojamiento = con.prepareStatement(selectAlojamientoFiltrado)) {
                stmtAlojamiento.setInt(1, capacidadAlojamiento);
            
            try (ResultSet rsAlojamiento = stmtAlojamiento.executeQuery()) {
                while (rsAlojamiento.next()) {
                    listaAlojamientosFiltrados.add(new Alojamiento(
                            rsAlojamiento.getString("nombre"),
                            rsAlojamiento.getInt("capacidad"),
                            rsAlojamiento.getDouble("tarifa"),
                            rsAlojamiento.getBoolean("tieneChimenea"),
                            rsAlojamiento.getBoolean("tieneJacuzzi"),
                            rsAlojamiento.getBoolean("alquiladaAhora"),
                            rsAlojamiento.getInt("numVecesAlquilada")
                    ));
                }
            }
        }
        
        return listaAlojamientosFiltrados;
    }
    
    public static ObservableList<Alojamiento> getAlojamientosAltaCapacidad() throws SQLException {

        String selectAlojamientoFiltrado = "SELECT DISTINCT * FROM alojamientos WHERE capacidad>10";

        ObservableList<Alojamiento> listaAlojamientosFiltrados = FXCollections.observableArrayList();

        try (Connection con = ConexionDB.establecerConexion(); 
                PreparedStatement stmtAlojamiento = con.prepareStatement(selectAlojamientoFiltrado)) {
            try (ResultSet rsAlojamiento = stmtAlojamiento.executeQuery()) {
                while (rsAlojamiento.next()) {
                    listaAlojamientosFiltrados.add(new Alojamiento(
                            rsAlojamiento.getString("nombre"),
                            rsAlojamiento.getInt("capacidad"),
                            rsAlojamiento.getDouble("tarifa"),
                            rsAlojamiento.getBoolean("tieneChimenea"),
                            rsAlojamiento.getBoolean("tieneJacuzzi"),
                            rsAlojamiento.getBoolean("alquiladaAhora"),
                            rsAlojamiento.getInt("numVecesAlquilada")
                    ));
                }
            }
        }
        
        return listaAlojamientosFiltrados;
    }
    
    public static boolean insertarAlojamiento(Alojamiento a) throws SQLException {
       
        String insertAlojamiento = "INSERT INTO alojamientos VALUES (?,?,?,?,?,?,?)";
        
        try (Connection con = ConexionDB.establecerConexion();
                PreparedStatement stmtAlojamiento = con.prepareStatement(insertAlojamiento)) {
            
            stmtAlojamiento.setString(1, a.getNombre());
            stmtAlojamiento.setInt(2, a.getCapacidad());
            stmtAlojamiento.setDouble(3, a.getTarifa());
            stmtAlojamiento.setInt(4, (a.getTieneChimenea() ? 1 : 0));
            stmtAlojamiento.setInt(5, (a.getTieneJacuzzi() ? 1 : 0));
            stmtAlojamiento.setInt(6, (a.getAlquiladaAhora() ? 1 : 0));
            stmtAlojamiento.setInt(7, (a.getNumVecesAlquilado()));
            
            int numFilas = stmtAlojamiento.executeUpdate();
            return numFilas > 0;
        }
    }
    
    // En la clase Alojamiento, añadir este método (no eliminar el existente)
    public static boolean modificarAlojamiento(Alojamiento a, String nombreOriginal) throws SQLException {
        
        String updateAlojamiento = "UPDATE alojamientos SET nombre=?, capacidad=?, tarifa=?, tieneChimenea=?, tieneJacuzzi=?, alquiladaAhora=?, numVecesAlquilada=? WHERE nombre=?";
        
        try (Connection con = ConexionDB.establecerConexion(); 
                PreparedStatement stmtAlojamiento = con.prepareStatement(updateAlojamiento)) {
            stmtAlojamiento.setString(1, a.getNombre());
            stmtAlojamiento.setInt(2, a.getCapacidad());
            stmtAlojamiento.setDouble(3, a.getTarifa());
            stmtAlojamiento.setInt(4, a.getTieneChimenea() ? 1 : 0);
            stmtAlojamiento.setInt(5, a.getTieneJacuzzi() ? 1 : 0);
            stmtAlojamiento.setInt(6, a.getAlquiladaAhora() ? 1 : 0);
            stmtAlojamiento.setInt(7, a.getNumVecesAlquilado());
            stmtAlojamiento.setString(8, nombreOriginal);
            
            int numFilas = stmtAlojamiento.executeUpdate();
            return numFilas > 0;
        }
    }
    
    public static boolean eliminarAlojamiento(Alojamiento a) throws SQLException {
        
        String deleteAlojamiento = "DELETE FROM alojamientos WHERE nombre=?";
        try (Connection con = ConexionDB.establecerConexion();
                PreparedStatement stmtAlojamiento = con.prepareStatement(deleteAlojamiento)) {
            stmtAlojamiento.setString(1, a.getNombre());
            
            int numFilas = stmtAlojamiento.executeUpdate();
            return numFilas > 0;
        }
    }
}
