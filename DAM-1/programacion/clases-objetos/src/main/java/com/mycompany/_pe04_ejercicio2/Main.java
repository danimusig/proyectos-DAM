package com.mycompany._pe04_ejercicio2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase principal
 * @author Daniel
 * @version 1.0
 * @see Vehiculo
 * @see Cliente
 * @see LocalDate
 * @see VehiculoAlquilado
 */
public class Main {

    public static void main(String[] args) {
        
        LocalDate fechaAlquiler = LocalDate.parse("24-08-2000", DateTimeFormatter.ofPattern("dd-MM-yyy"));
        
        Vehiculo coche1 = new Vehiculo("12345-d", "Cadillac", "El dorado", 80, true);
        Cliente cliente1 = new Cliente("12345678-D", "Daniel", "Munyoz Sigmund", "123456789");
        VehiculoAlquilado alquiler1 = new VehiculoAlquilado(coche1, cliente1, fechaAlquiler, 7);
        
        System.out.println(cliente1.getDatosCompletos());
        System.out.println("Vehiculo alquilado:");
        System.out.println(coche1.getMatricula() + "\n" + coche1.getMarca() + " " + coche1.getModelo());
        System.out.println("Importe:    ");
        System.out.print(alquiler1.getImporteTotal());
    }

}
