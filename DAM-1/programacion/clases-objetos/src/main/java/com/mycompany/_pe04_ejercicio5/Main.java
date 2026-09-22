/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany._pe04_ejercicio5;

/**
 *
 * @author Daniel
 */
public class Main {
    
    public static void main(String[] args) {
        //Creo un objeto de la clase CuentaCorriente
        CuentaCorriente miCuenta = new CuentaCorriente("12345678A", "Daniel", 1000.0);
        
        //PRUEBA DE NOMBRE
        miCuenta.nombreTitular = "Daniel Modificado";
        System.out.println("Nombre (Público): Acceso permitido. Nuevo nombre: " + miCuenta.nombreTitular);

        //PRUEBA DE DNI
        miCuenta.dni = "87654321B";
        System.out.println("DNI (Default): Acceso permitido (mismo paquete). Nuevo DNI: " + miCuenta.dni);

        //PRUEBA DE SALDO
        System.out.println("Saldo (Privado): Acceso DENEGADO directamente.");
        
        // Para acceder al saldo, estamos obligados a usar los métodos públicos
        System.out.println("Saldo (vía getSaldo): " + miCuenta.getSaldo());
    }
}
