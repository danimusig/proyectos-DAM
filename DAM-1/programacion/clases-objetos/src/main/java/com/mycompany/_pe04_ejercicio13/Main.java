package com.mycompany._pe04_ejercicio13;

/**
 *
 * @author Daniel
 */
public class Main {

    public static void main(String[] args) {
        //Creo los objetos Producto;
        Producto p1 = new Producto(101, "Teclado Mecánico", 50.00);
        Producto p2 = new Producto(102, "Ratón Gaming", 30.00);     
        
        //PRUEBA DE APLICARDESCUENTO
        System.out.println("Precio original p1: " + p1.getPrecio());
        
        p1.aplicarDescuento(20); 
        System.out.println("Precio tras aplicar 20% de descuento: " + p1.getPrecio());
        
        //PRUEBA DE EQUALS
        //Creo un producto p3 con la misma id  y nombre que p1
        Producto p3 = new Producto(101, "Teclado Mecánico", 900.00);
        
        System.out.print("Comparando p1 con p3 (iguales): ");
        p1.equals(p3);         
        
        System.out.print("Comparando p1 con p2 (diferentes): ");
        p1.equals(p2);
    }
}
