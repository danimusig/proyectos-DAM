package com.mycompany._pe04_ejercicio9;

import java.util.Scanner;

/**
 * 
 * @author Daniel
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Por favor introduzca el limite de caracteres de la cadena:");
        int longitudCadena = sc.nextInt();
        sc.nextLine();
        System.out.println("Introduzca la cadena: ");
        String fraseUsuario = sc.nextLine();
        
        Texto cadena1 = new Texto(fraseUsuario, longitudCadena);
        
        System.out.println(cadena1.mostrar());
        
        cadena1.addPrincipio("hola ");
        cadena1.addFinal(" tardes");
        cadena1.setCadena(" buenos dias señor");
        
        System.out.println(cadena1.mostrar());
    }
}
