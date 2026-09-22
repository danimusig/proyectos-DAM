package com.mycompany._pe04_ejercicio13;

/**
 * Clase Producto: Almacena y modifica informacion sobre los productos.
 * @author DanielMS
 * @version 1.0
 * @see String
 */
public class Producto {
    /**
     * El id del producto.
     */
    private int id;
    
    /**
     * El nomre del producto.
     */
    private String nombre;
    
    /**
     * El precio del producto.
     */
    private double precio;
    
    /**
     * Constructor principal.
     * @param id El id del producto en un entero.
     * @param nombre El nombre del producto en una cadena de caracteres.
     * @param precio El precio del producto en euros.
     */
    public Producto(int id, String nombre, double precio) {
        this.id = id;
        
        this.nombre = nombre;
        
        this.precio = precio;
    }
    
    /**
     * Obtiene el id del producto.
     * @return El id representado en un entero.
     */
    public int getId() {
        return this.id;
    }
    
    /**
     * Otiene el nombre del producto.
     * @return El nombre del producto representado en una cadena de caracteres.
     */
    public String getNombre() {
        return this.nombre;
    }
    
    /**
     * Obtiene el precio del producto.
     * @return El precio del producto en un decimal.
     */
    public double getPrecio() {
        return this.precio;
    }
    
    /**
     * Modifica el precio del producto.
     * @param nuevoPrecio El precio en un decimal.
     */
    public void setPrecio(double nuevoPrecio) {
        this.precio = nuevoPrecio;
    }
    
    /**
     * Aplica al precio un descuento introducido por parametro.
     * @param descuento El descuento aplicado en un entero.
     */
    public void aplicarDescuento(int descuento) {
        double cantidadDescuento = this.precio * ((double)descuento/100);
        this.precio = this.precio - cantidadDescuento;
    }
    
    /**
     * Muestr informacion sobre el producto
     * @return Una cadena de caracteres con informacion sobre el producto.
     */
    @Override
    public String toString() {
        return "\nID Producto: " + this.id + "\nNombre: " + this.nombre + "\nPrecio :" + this.precio;
    }
    
    /**
     * Compara el id y el nombre de dos productos para ver si son iguales.
     * @param otroProducto Otro producto de la clase Producto.
     * @return True si son iguales, false si son diferentes.
     */
    public boolean equals(Producto otroProducto) {
        if ((this.id == otroProducto.id) && (this.nombre.equals(otroProducto.nombre))) {
            System.out.println("Los productos son iguales");
            return true;
        } else {
            System.out.println("Los productos son diferentes");
            return false;
        }
    }
}

 