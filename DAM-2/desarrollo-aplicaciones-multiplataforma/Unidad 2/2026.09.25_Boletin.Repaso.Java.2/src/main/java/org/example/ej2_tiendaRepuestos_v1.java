package org.example;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ej2_tiendaRepuestos_v1 {

    private static final Scanner sc = new Scanner(System.in);
    private static final Map<String , Integer> catalogoRepuestos = new TreeMap<>();

    public static void main(String[] args) {
        int opcionMenu;
        do {
            opcionMenu = menu();
            switch (opcionMenu) {
                case 1: registrarProducto(); break;

                case 2: retirarProducto(); break;

                case 3: actualizarExistencias(); break;

                case 4: System.out.println("Saliendo del programa"); break;
            }
        } while(opcionMenu != 6);
        sc.close();
    }


    public static int menu() {
        int opcion = 0;
        try {
            do {
                System.out.println("\n               \uD83D\uDD27 TIENDA REPUESTOS \uD83D\uDE99  \n");
                System.out.println(
                        "* Pulse 1 para añadir un producto:\n"
                                + "* Pulse 2 para retirar un producto: \n"
                                + "* Pulse 3 actualizar el stock de un producto: \n"
                                + "* Pulse 4 para salir: ");
                opcion = sc.nextInt();

            } while (opcion < 1 || opcion > 6);
        } catch (InputMismatchException e) {
            System.err.println("Error debe entrar un numero valido: " + e.getMessage());
            sc.nextLine();
        }
        return opcion;
    }


    public static void registrarProducto() {
        try {
            String codProducto = "";
            do {
                System.out.println("Introduzca un cod de producto valido: (0 para salir)");
                codProducto = sc.next().trim();

                if (catalogoRepuestos.containsKey(codProducto)) {
                    System.err.println("Un producto ya existe con ese codigo: " + codProducto);
                }

            } while (catalogoRepuestos.containsKey(codProducto) && !codProducto.equals("0"));

            if (codProducto.equals("0")) {
                System.out.println("Volviendo al menu...");
            } else {
                System.out.println("Introduzca el número de existencias de dicho producto: ");
                int numExistencias = sc.nextInt();

                catalogoRepuestos.put(codProducto, numExistencias);

                System.out.println("Producto registrado correctamente.");
            }
        } catch (InputMismatchException e) {
            System.err.println("Error: El número de existencias debe ser un valor entero:" + e.getMessage());
            sc.nextLine();
        }
    }


    public static void retirarProducto() {
        String codProducto = " ";
        try {
            do {
                System.out.println("Introduzca un cod de producto valido: (0 para salir)");
                codProducto = sc.next().trim();

                if (!catalogoRepuestos.containsKey(codProducto)) {
                    System.err.println("ALERTA: El producto " + codProducto + " no se encuentra registrado.");
                }

            } while (!catalogoRepuestos.containsKey(codProducto) && !codProducto.equals("0"));

            if (codProducto.equals("0")) {
                System.out.println("Volviendo al menu...");
            } else {
                System.out.println("Está seguro de que desea borrar el producto nº: " + codProducto  + " (s/n)" );
                String confirmacionRetirada = sc.next().trim();

                if (!confirmacionRetirada.equals("s") || !confirmacionRetirada.equals("si")) {
                    catalogoRepuestos.remove(codProducto);
                    System.out.println("Producto borrado correctamente.");

                } else {
                    System.out.println("Operación cancelada. Volviendo al menú...");
                }
            }
        } catch (Exception e) {
            System.err.println("Error borrando el producto: " + e.getMessage());

        }
    }


    public static void actualizarExistencias() {
        String codProducto = " ";
        try {
            do {
                System.out.println("Introduzca un cod de producto valido: (0 para salir)");
                codProducto = sc.next().trim();

                if (!catalogoRepuestos.containsKey(codProducto)) {
                    System.out.println("ALERTA: El producto " + codProducto + "No se encuentra registrado.");
                }
            } while (!catalogoRepuestos.containsKey(codProducto) && !codProducto.equals("0"));

            if (codProducto.equals("0")) {
                System.out.println("Volviendo al menu...");
            } else {
                System.out.println("Nuevo stock del producto: " + codProducto);
                int nuevoStock = sc.nextInt();

                catalogoRepuestos.replace(codProducto, nuevoStock);

                System.out.println("Stock actualizado correctamente.");
            }
        } catch (Exception e) {
            System.err.println(e.getStackTrace());
        }
    }
}
