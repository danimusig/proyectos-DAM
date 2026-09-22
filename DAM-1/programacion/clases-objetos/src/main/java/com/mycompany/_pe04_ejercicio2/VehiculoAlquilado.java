package com.mycompany._pe04_ejercicio2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 
 * Clase VehiculoAlquilado
 * @author DanielMS
 * @see String
 * @see Vehiculo
 * @see Cliente
 */
public class VehiculoAlquilado {
    /**
     * Un vehiculo.
     */
    private Vehiculo vehiculo;
    
    /**
     * Un cliente.
     */
    private Cliente cliente;
    
    /**
     * Fecha en la que se alquila el coche.
     */
    private LocalDate fechaAlquiler ;
    
    /**
     * Los dias que el coche está alquilado.
     */
    private int diasAlquiler;
        
    /**
     * Construstor principal.
     * @param vehiculo Un vehiculo creado con la clase Vehiculo.
     * @param cliente Un cliente creado con la clase Cliente.
     * @param fechaAlquiler Fecha en la cual el coche ha sido alquilado.
     * @param diasAlquiler Días que lleva el coche alquilado.
     */
    public VehiculoAlquilado (Vehiculo vehiculo, Cliente cliente, LocalDate fechaAlquiler, int diasAlquiler) {
        this.vehiculo = vehiculo;
        this.cliente = cliente;
        this.fechaAlquiler = fechaAlquiler;
        this.diasAlquiler = diasAlquiler;
    }
    
    /**
     * Modifica el vehículo alquilado.
     * @param nuevoVehiculoAlquiler El nuevo vehículo alquilado.
     */
    public void setVehiculo(Vehiculo nuevoVehiculoAlquiler) {
        this.vehiculo = nuevoVehiculoAlquiler;
    }
    
    /**
     * Modifica el cliente.
     * @param nuevoClienteAlquiler El nuevo cliente. 
     */
    public void setCliente(Cliente nuevoClienteAlquiler) {
        this.cliente = nuevoClienteAlquiler;
    }
    
    /**
     * Modifica la fecha en la que el coche se aquilo.
     * @param nuevaFechaAlquiler La nueva fecha de alquiler del coche.
     */
    public void setFechaAlquiler(String nuevaFechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler.parse(nuevaFechaAlquiler, DateTimeFormatter.ofPattern("dd-MM-yyy"));
    }
    
    /**
     * Modifica los días que lleva el coche alquilado.
     * @param nuevoDiasAlquiler 
     */
    public void setDiasAlquiler(int nuevoDiasAlquiler) {
        this.diasAlquiler = nuevoDiasAlquiler;
    }
    
    /**
     * Obtiene los datos del cliente.
     * @return Los datos del cliente en un objeto Cliente.
     */
    public Cliente getCliente() {
        return cliente;
    } 
    
    /**
     * Obtiene los datos de un vehiculo.
     * @return Los datos de un vehiculo en un objeto Vehiculo.
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    
    /**
     * Obtiene la fecha de alquiler del vehiculo.
     * @return La fecha de alquiler en un objeto LocalDate.
     */
    public LocalDate getFechaAlquiler() {
        return fechaAlquiler;
    }
    
    /**
     * Obtiene los dias de alquiler del vehiculo.
     * @return Los dias de alquiler del vehiculo representado en dias.
     */
    public int getDiasAlquiler() {
        return diasAlquiler;
    }
    
    /**
     * Obtiene el coste del alquiler del vehiculo multiplicando los días de alquiler por la tarifa diaria.
     * @return El coste del alquiler del vehiculo representado en euros.
     */
    public double getImporteTotal() {
        double coste;
        coste = ((double)this.diasAlquiler * this.vehiculo.getTarifa());
        
        return coste;
    }
    
}
