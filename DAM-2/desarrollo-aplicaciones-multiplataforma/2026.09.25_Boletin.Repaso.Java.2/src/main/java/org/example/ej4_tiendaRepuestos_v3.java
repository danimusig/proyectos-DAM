package org.example;

import java.io.*;
import java.sql.*;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ej4_tiendaRepuestos_v3 {

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

                case 4: exportarProductos(); break;

                case 5: importarProductos(); break;

                case 6: enviarRespuestosBBDD(); break;

                case 7: obtenerRepuestosBBDD(); break;

                case 8: System.out.println("Saliendo del programa"); break;
            }
        } while(opcionMenu != 8);
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
                                + "* Pulse 4 para exportar los productos a .txt: \n"
                                + "* Pulse 5 para importar los archivos desde .txt: \n"
                                + "* Pulse 6 para enviar los productos a la base de datos: \n"
                                + "* Pulse 7 para recibir los productos de la base datos: \n"
                                + "* Pulse 8 para salir: ");
                opcion = sc.nextInt();

            } while (opcion < 1 || opcion > 8);
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


    private static void exportarProductos()  {
        System.out.println("Seguro que desea exportar? \n(Los repuestos con la misma clave se sobreescribiran) - s/n ");
        String confirmacion = sc.next().trim().toLowerCase();

        if (confirmacion.equals("s") || confirmacion.equals("si")) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/resources/productos.txt"))) {
                // Bucle for each que obtiene el par clave valor de cada repuesto.
                for (Map.Entry<String, Integer> registro : catalogoRepuestos.entrySet()) {
                    System.out.println("Key = " + registro.getKey() + ", Value = " + registro.getValue());
                    bw.write(registro.getKey() + ":" + registro.getValue());
                    bw.newLine();
                }

                System.out.println("Listo");
                bw.flush();
            } catch (IOException e) {
                System.err.println("Error escribiendo el archivo: " + e.getMessage());
            }
        } else {
            System.out.println("Volviendo al menu...");
        }
    }


    private static void importarProductos() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/productos.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {

                // Ignoro las lineas vacias
                if (linea.trim().isEmpty()) {
                    continue;
                }

                // Creo el array que guarda el par clave:valor
                String[] partesProducto = linea.split(":", 2);

                // Si el la linea contiene un formato incorrecto la ignoro y aviso.
                if (partesProducto.length == 2) {


                    try {
                        String codProductoImprt = partesProducto[0].trim();
                        int stockProductoImprt = Integer.parseInt(partesProducto[1].trim());
                        // Compruebo que no exista un registro con la misma clave y si existe lo ignoro y aviso.
                        if (catalogoRepuestos.containsKey(codProductoImprt)) {
                            System.out.println("Clave duplicada ignorada: " + codProductoImprt);
                        } else {
                            catalogoRepuestos.put(codProductoImprt, stockProductoImprt);
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("Stock no valido en la linea " + linea);

                    }
                } else {
                    System.err.println("Saltandose linea malformada: " + linea);
                }
            }
        } catch (IOException e) {
            System.err.println("Error leyendo el archivo: " + e.getMessage());
        }
    }


    public static void enviarRespuestosBBDD()  {
        String insertQuery = "INSERT INTO REPUESTO(codigo, nExistencias) VALUES (?, ?)";
        try (Connection con = DriverManager.getConnection("jdbc:sqlite:src/main/resources/existencias.db");
             PreparedStatement ps = con.prepareStatement(insertQuery)) {
            for(Map.Entry<String, Integer> registro : catalogoRepuestos.entrySet()) {
                ps.setString(1, registro.getKey());
                ps.setInt(2, registro.getValue());
            }

            int cantInserciones = ps.executeUpdate();
            if (cantInserciones > 0) {
                System.out.println("Se han añadido productos a la base de datos.");
            } else {
                System.err.println("Hubo un error en la exportacion.");
            }
        } catch (SQLException e) {
            System.err.println("ERROR: Fallo en la base de datos: " + e.getMessage());
        }
    }


    public static void obtenerRepuestosBBDD()  {
        String selectQuery = "SELECT * FROM REPUESTO";

        try (Connection con = DriverManager.getConnection("jdbc:sqlite:src/main/resources/existencias.db");
            PreparedStatement ps = con.prepareStatement(selectQuery);
            ResultSet rs = ps.executeQuery()) {

            int cantInserciones = 0;
            while (rs.next()) {
                String codigoRecibido = rs.getString("codigo");
                int nExistenciasRecibido = rs.getInt("nExistencias");
                catalogoRepuestos.put(codigoRecibido, nExistenciasRecibido);
                cantInserciones++;
            }

            if (cantInserciones > 0) {
                System.out.println("Se han obtenido los productos de la base de datos.");
            } else {
                System.err.println("Hubo un error en la importacion.");
            }
        } catch (SQLException e) {
            System.err.println("ERROR: Fallo en la base de datos: " + e.getMessage());
        }
    }
}
