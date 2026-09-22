package Modelo;

import Utils.ConexionDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javafx.collections.ObservableList;
import java.sql.ResultSet;
import java.time.LocalDate;
import javafx.collections.FXCollections;

public class Reserva {
    
    private final String DNI_CLIENTE;
    private String nombreAlojamiento;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private double total;

    // Constructor con todos los parámetros (se mantiene el parámetro 'activa' aunque no se use)
    public Reserva(String dniCliente, String nombreAlojamiento, LocalDate fechaEntrada, 
                   LocalDate fechaSalida, double total, boolean activa) {
        this.DNI_CLIENTE = dniCliente;
        this.nombreAlojamiento = nombreAlojamiento;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.total = total;
    }

    
    public String getDNI_CLIENTE() {
        return DNI_CLIENTE;
    }
    
    public String getNombreAlojamiento() {
        return nombreAlojamiento;
    }

    public void setNombreAlojamiento(String nombreAlojamiento) {
        this.nombreAlojamiento = nombreAlojamiento;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public double getTotal() {
        return total;
    }

    // Getters y setters (se omiten por brevedad, se asume que ya existen)
    public void setTotal(double total) {    
        this.total = total;
    }

    public static ObservableList<Reserva> getReservas() throws SQLException {
        String selectReservas = "SELECT * FROM reservas";
        ObservableList<Reserva> listaReservas = FXCollections.observableArrayList();
        
        try (Connection con = ConexionDB.establecerConexion();
                PreparedStatement stmt = con.prepareStatement(selectReservas);
                ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                listaReservas.add(new Reserva(
                        rs.getString("dni_cliente"),
                        rs.getString("nombre_alojamiento"),
                        rs.getDate("fecha_entrada").toLocalDate(),
                        rs.getDate("fecha_salida").toLocalDate(),
                        rs.getDouble("total_reserva"),
                        true  // el valor no se usa, se podría eliminar del constructor
                ));
            }
        }
        return listaReservas;
    }
    
    public static ObservableList<Reserva> getReservasActivas() throws SQLException {
        // Reservas activas: fecha_entrada <= hoy y fecha_salida >= hoy
        String query = "SELECT * FROM reservas WHERE fecha_entrada <= NOW() AND fecha_salida >= NOW()";
        ObservableList<Reserva> listaReservasActivas = FXCollections.observableArrayList();
        
        try (Connection con = ConexionDB.establecerConexion();
             PreparedStatement stmt = con.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                listaReservasActivas.add(new Reserva(
                    rs.getString("dni_cliente"),
                    rs.getString("nombre_alojamiento"),
                    rs.getDate("fecha_entrada").toLocalDate(),
                    rs.getDate("fecha_salida").toLocalDate(),
                    rs.getDouble("total_reserva"),
                    true
                ));
            }
        }
        return listaReservasActivas;
    }
    
    public static ObservableList<Reserva> getReservasFuturas() throws SQLException {
        // Reservas futuras: fecha_entrada > hoy
        String query = "SELECT * FROM reservas WHERE fecha_entrada > NOW()";
        ObservableList<Reserva> listaReservasFuturas = FXCollections.observableArrayList();
        
        try (Connection con = ConexionDB.establecerConexion();
             PreparedStatement stmt = con.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                listaReservasFuturas.add(new Reserva(
                    rs.getString("dni_cliente"),
                    rs.getString("nombre_alojamiento"),
                    rs.getDate("fecha_entrada").toLocalDate(),
                    rs.getDate("fecha_salida").toLocalDate(),
                    rs.getDouble("total_reserva"),
                    true
                ));
            }
        }
        return listaReservasFuturas;
    }
    
    public static boolean insertarReserva(Reserva r) throws SQLException {
        // Se especifican las columnas porque la tabla tiene un id autoincremental
        String sql = "INSERT INTO reservas (dni_cliente, nombre_alojamiento, fecha_entrada, fecha_salida, total_reserva) VALUES (?,?,?,?,?)";
        
        try (Connection con = ConexionDB.establecerConexion();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, r.getDNI_CLIENTE());
            stmt.setString(2, r.getNombreAlojamiento());
            stmt.setString(3, r.getFechaEntrada().toString());
            stmt.setString(4, r.getFechaSalida().toString());
            stmt.setDouble(5, r.getTotal());
            
            return stmt.executeUpdate() > 0;
        }
    }
    
    public static boolean modificarReserva(Reserva r, String nombreAlojamientoAntiguo) throws SQLException {
        String sql = "UPDATE reservas SET nombre_alojamiento=?, fecha_entrada=?, fecha_salida=?, total_reserva=? WHERE dni_cliente=? AND nombre_alojamiento=?";
        
        try (Connection con = ConexionDB.establecerConexion();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, r.getNombreAlojamiento());
            stmt.setString(2, r.getFechaEntrada().toString());
            stmt.setString(3, r.getFechaSalida().toString());
            stmt.setDouble(4, r.getTotal());
            stmt.setString(5, r.getDNI_CLIENTE());
            stmt.setString(6, nombreAlojamientoAntiguo);
            
            return stmt.executeUpdate() > 0;
        }
    }
    
    public static boolean eliminarReserva(Reserva r) throws SQLException {
        String sql = "DELETE FROM reservas WHERE dni_cliente=? AND nombre_alojamiento=?";
        
        try (Connection con = ConexionDB.establecerConexion();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, r.getDNI_CLIENTE());
            stmt.setString(2, r.getNombreAlojamiento());
            
            return stmt.executeUpdate() > 0;
        }
    }
}