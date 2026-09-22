package javitos_bbdd_relacionales;

import java.sql.*;
import java.util.Scanner;
import javax.management.Query;
import java.sql.SQLException;
import javitos_bbdd_relacionales.DniNoValidaException;
import javitos_bbdd_relacionales.EmailNoValidaException;

/**
 * Clase en la que se manejan cleintes y alojamientos en una base de datos. 
 * @author dmunsig
 * @version 1.0
 * @see String
 * @see Scanner
 * @see Connection
 * @see Class
 * @see Statement
 * @throws IllegalArgumentException
 * @throws ClassNotFoundException
 * @throws SQLException
 * @throws DniNoValidaException
 * @throws EmailNoValidaException
 */
public class Javitos_BBDD {
    
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int opcion = 0;
            int submenu = 0;
            do {
                opcion = menu();
                switch(opcion) {
                    case 1: //Alta de un objeto eb la bbdd
                        System.out.println("* Pulse 1 para dar de alta a un cliente.");
                        System.out.println("* Pulse 2 para dar de alta a un alojamiento.");
                        submenu = sc.nextInt();

                        if (submenu == 1) {
                            altaCliente();
                        } else if (submenu == 2) {
                            altaAlojamiento();
                        }
                        break;

                    case 2: //Consulta la informacion de un objeto.
                        System.out.println("* Pulse 1 para ver informacion sobre un cliente.");
                        System.out.println("* Pulse 2 para ver informacion sobre un alojamiento..");
                        submenu = sc.nextInt();

                        if (submenu == 1) {
                            getInfoCliente();
                        } else if (submenu == 2) {
                            getInfoAlojamiento();
                        }
                        break;

                    case 3: //Lista todos los objetos de la bbdd.
                        System.out.println("* Pulse 1 para listar los clientes.");
                        System.out.println("* Pulse 2 para listar los alojamientos.");
                        submenu = sc.nextInt();

                        if (submenu == 1) {
                            listaClientes();
                        } else if (submenu == 2) {
                            listaAlojamientos();
                        }
                        break;

                    case 4: //Lista los objetos ordenados por un parametro determinado.
                        System.out.println("* Pulse 1 para listar los clientes ordenados por veces alojado.");
                        System.out.println("* Pulse 2 para listar los alojamientos ordenados por veces alquilado.");
                        submenu = sc.nextInt();

                        if (submenu == 1) {
                            listaOrdenadaClientes();
                        } else if (submenu == 2) {
                            listaOrdenadaAlojamientos();
                        }
                        break;

                    case 5: //Modifica un objeto de la bbdd.
                        System.out.println("* Pulse 1 para listar los clientes ordenados por veces alojado.");
                        System.out.println("* Pulse 2 para listar los alojamientos ordenados por veces alquilado.");
                        submenu = sc.nextInt();

                        if (submenu == 1) {
                            modificarCliente();
                        } else if (submenu == 2) {
                            modificarAlojamiento();
                        }
                        break;

                    case 6: //Elimina un objeto de la bbdd.
                        System.out.println("* Pulse 1 para eliminar un cliente.");
                        System.out.println("* Pulse 2 para eliminar un alojamiento.");
                        submenu = sc.nextInt();

                        if (submenu == 1) {
                            eliminarCliente();
                        } else if (submenu == 2) {
                            eliminarAlojamiento();
                        }
                        break;
                        
                    case 7: //Elimina todos los objetos de la bbdd.
                        System.out.println("* Pulse 1 para eliminar los registros de la base de datos de clientes.");
                        System.out.println("* Pulse 2 para eliminar los registros de la base de datos de alojamientos.");
                        submenu = sc.nextInt();

                        if (submenu == 1) {
                            eliminarTodosClientes();
                        } else if (submenu == 2) {
                            eliminarTodosAlojamientos();
                        }
                        break;

                    case 0: //Cierra la bbdd y enseña un mensaje de salida.
                        cerrarBBDD();    
                        break;
                }
            } while (opcion!=0);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            
        }        
    }
    
    /**
     * Menu con opciones para manejar una base de datos relacional,
     * @return La opcion del usuario en un entero.
     */
    public static int menu() {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        try {
            do {
                System.out.println("****************************************************************************");
                System.out.println("**************************** - GESTION JAVITOS - ***************************");       
                System.out.println("****************************************************************************");        
                System.out.println(
                      "* Pulse 1 para añadir un registro a la base de datos.\n"
                    + "* Pulse 2 para obtener informacion de un registro a la base de datos.\n"
                    + "* Pulse 3 para listar los registros de una tabla.\n"
                    + "* Pulse 4 para listar los registros ordenados de una tabla.\n"
                    + "* Pulse 5 para modificar un registro.\n"
                    + "* Pulse 6 para eliminar un registro.\n"
                    + "* Pulse 7 para eliminar todos los registros.\n"
                    + "* Pulse 0 para salir del programa.\n");
                System.out.println("****************************************************************************");
                opcion = sc.nextInt();
            } while(opcion <= 0 | opcion >= 7); 
        } catch (IllegalArgumentException e) {
            System.out.println("Error de argumentacion: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
        
        return opcion;
    }
    
    /**
     * Da de alta un cliente en la base de datos.
     */
    public static void altaCliente() {
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/Javitos";
//            Class.forName("org.mariadb.jdbc.Driver");
//            String url = "jdbc:mariadb://localhost:3306/Javitos";
            Connection con = DriverManager.getConnection(url, "root", "232431");
            Statement stmt = con.createStatement();
            
            System.out.println("Introduzca el nombre del cliente: ");
            String nombreCliente = sc.nextLine();
            
            System.out.println("Introduzca el dni del cliente: ");
            String dniCliente = sc.nextLine();
            if (!dniCliente.matches("[0-9]{8}[A-Z]")) {
                throw new DniNoValidaException("EL formato del dni no es valido.");
            } 
            
            System.out.println("Introduzca el email del cliente: ");
            String emailCliente = sc.nextLine();            
            if (!emailCliente.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                throw new EmailNoValidaException("El formato del email no es valido.");
            }
            
            System.out.println("Introduzca el lugar de residencia: ");
            String lugarResidencia = sc.nextLine();
            
            String insertNuevoCliente = "INSERT INTO clientes(nombre, dni, email, lugar_residencia) VALUES ("
                    + "'" + nombreCliente + "', "
                    + "'" + dniCliente + "', "
                    + "'" + emailCliente + "', "
                    + "'" + lugarResidencia + "'"
                    + ");";
            stmt.executeUpdate(insertNuevoCliente);
            
            System.out.println("Se ha añadido al cliente con dni " + dniCliente + "en la base de datos.");
            
            stmt.close();
            con.close();
        
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error en la base de datos: " + e.getMessage());
        } catch (DniNoValidaException e) {
            System.out.println("Dni con formate erroneo: " + e.getMessage());
        } catch (EmailNoValidaException e) {
            System.out.println("Email con fomato erroeno: " + e.getMessage());
        }  
    }
    
    /**
     * Da de alta un alojamiento en la base de datos.
     */
    public static void altaAlojamiento() {
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/Javitos";
//            Class.forName("org.mariadb.jdbc.Driver");
//            String url = "jdbc:mariadb://localhost:3306/Javitos";
            Connection con = DriverManager.getConnection(url, "root", "232431");
            Statement stmt = con.createStatement();
            
            System.out.println("Introduzca el nombre del alojamiento: ");
            String nombreAlojamiento = sc.nextLine();
            
            System.out.println("Introduzca la capacidad del alojamiento:  ");
            int capacidadAlojamiento = sc.nextInt();
            sc.nextLine();
            
            System.out.println("Introduzca la tarifa por noche del alojamiento: ");
            double tarifaAlojamiento = sc.nextDouble();
            sc.nextLine();
            
            System.out.println("¿Tiene chimenea?");
            String chimenea = sc.nextLine();
            boolean tieneChimenea = false;
            if (chimenea.equals("si")) {
                tieneChimenea = true;
            } else if (chimenea.equals("no")){
                tieneChimenea = false;
            }
            int valorTieneChimenea = (tieneChimenea) ? 1:0;
            
            System.out.println("¿Tiene jacuzzi?");
            String jacuzzi = sc.nextLine().toLowerCase();
            boolean tieneJacuzzi = false;
            if (jacuzzi.equals("si")) {
                tieneJacuzzi = true;
            } else if (jacuzzi.equals("no")){
                tieneJacuzzi = false;
            }
            int valorTieneJacuzzi = (tieneJacuzzi) ? 1:0;
           
            String insertNuevoAlojamiento = "INSERT INTO alojamientos(nombre, capacidad, tarifa, tiene_chimenea, tiene_jacuzzi) VALUES("
                    + "'" + nombreAlojamiento + "', "
                    + capacidadAlojamiento + ", "
                    + tarifaAlojamiento + ", "
                    + valorTieneChimenea + ","
                    + valorTieneJacuzzi 
                    + ")";
            stmt.executeUpdate(insertNuevoAlojamiento);
            
            System.out.println("Se ha añadido al alojamiento " + nombreAlojamiento + "en la base de datos.");
            
            stmt.close();
            con.close();
            
        } catch (ClassNotFoundException e) {
            System.err.println("Clase no encontrada: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error en la base de datos: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
    
    /**
     * Obtiene informacion de un cliente determinado.
     */
    public static void getInfoCliente() {
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/Javitos";
//            Class.forName("org.mariadb.jdbc.Driver");
//            String url = "jdbc:mariadb://localhost:3306/Javitos";
            Connection con = DriverManager.getConnection(url, "root", "232431");
            Statement stmt = con.createStatement();
            
            System.out.println("Introduzca el dni del cliente a consultar: ");
            String dniCliente = sc.nextLine();
            if (!dniCliente.matches("[0-9]{8}[A-Z]")) {
                throw new DniNoValidaException("EL formato del dni no es valido.");
            } 
            
            String selectClientes = "SELECT * FROM clientes WHERE dni='" + dniCliente + "';";
            ResultSet datosClientes = stmt.executeQuery(selectClientes);
            
            if(!datosClientes.isBeforeFirst()) { //isBeforeFisrt() de ResultSet es un metodo que si detecta que el "cursor" que está leyendo los datos se encuentra sobre una linea(true) u otro objeto o si esta vacio(false).
                System.out.println("El cliente con DNI " + dniCliente + " no existe.");
            } else {
                while(datosClientes.next())  {
                    System.out.println("*-- Cliente : " + datosClientes.getString("dni") + "\n"
                                + "* Nombre: " + datosClientes.getString("nombre") + "\n"
                                + "* Email: " + datosClientes.getString("email") + "\n"
                                + "* Lugar de Residencia: " + datosClientes.getString("lugar_residencia") + "\n"
                                + "* Num Veces Alojado: " + datosClientes.getInt("num_veces_alojado") + "\n"
                                );
                    System.out.println("*------------------------------------------------------------------------------*");              
                } 
            }
            
            stmt.close();
            con.close();
            
        } catch (ClassNotFoundException e) {
            System.err.println("Clase no encontrada: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error en la base de datos: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        } 
    }
    
    /**
     * Obtiene informacion de un alojamiento determinado.
     */
    public static void getInfoAlojamiento() {
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/Javitos";
//            Class.forName("org.mariadb.jdbc.Driver");
//            String url = "jdbc:mariadb://localhost:3306/Javitos";
            Connection con = DriverManager.getConnection(url, "root", "232431");
            Statement stmt = con.createStatement();
            
            System.out.println("Introduzca el nombre del alojamiento a consultar: ");
            String nombreAlojamiento = sc.nextLine();
            
            String selectAlojamientos = "SELECT * FROM alojamientos WHERE nombre='" + nombreAlojamiento + "';";
            ResultSet datosAlojamientos = stmt.executeQuery(selectAlojamientos);
            
            if(!datosAlojamientos.isBeforeFirst()) {
                System.out.println("El alojamiento de nombre " + nombreAlojamiento + " no existe.");
            } else {
                while(datosAlojamientos.next()) {
                    System.out.println("*-- Alojamiento : " + datosAlojamientos.getString("nombre") + "\n"
                                    + "* Capacidad: " + datosAlojamientos.getInt("capacidad") + "\n"
                                    + "* Tarifa: " + datosAlojamientos.getDouble("tarifa") + "\n"
                                    + "* Chimenea: " + datosAlojamientos.getInt("tiene_chimenea") + "\n"
                                    + "* Jacuzzi: " + datosAlojamientos.getInt("tiene_jacuzzi") + "\n"
                                    + "* Disponibilidad: " + datosAlojamientos.getInt("alquilada_ahora") + "\n"
                                    + "* Num Veces Alquilado: " + datosAlojamientos.getInt("num_veces_alquilado")
                                    );
                    System.out.println("*-----------------------------------------------------------------------------------*"); 
                }    
            }
            
            stmt.close();
            con.close();
            
        } catch (ClassNotFoundException e) {
            System.err.println("Clase no encontrada: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error en la base de datos: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }
    
    /**
     * Lista todos los clientes registrados.
     */
    public static void listaClientes() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/Javitos";
//            Class.forName("org.mariadb.jdbc.Driver");
//            String url = "jdbc:mariadb://localhost:3306/Javitos";
            Connection con = DriverManager.getConnection(url, "root", "232431");
            Statement stmt = con.createStatement();
            
            String selectClientes = "SELECT * FROM clientes;"; 
            ResultSet datosClientes = stmt.executeQuery(selectClientes); 
            
            if(!datosClientes.isBeforeFirst()) {
                System.out.println("No hay clientes registrados en el sistema.");
            } else {
              while(datosClientes.next()) {
                    System.out.println("            <--- LISTADO CLIENTES --->");
                    System.out.println("*-- Cliente : " + datosClientes.getString("dni") + "\n"
                                    + "* Nombre: " + datosClientes.getString("nombre") + "\n"
                                    + "* Email: " + datosClientes.getString("email") + "\n"
                                    + "* Lugar de Residencia: " + datosClientes.getString("lugar_residencia") + "\n"
                                    + "* Num Veces Alojado: " + datosClientes.getInt("num_veces_alojado") + "\n"
                                    );
                    System.out.println("*---------------------------------------------------------------------------------*"); 
                }
            }
            
            stmt.close();
            con.close();
            
        } catch (ClassNotFoundException e) {
            System.err.println("Clase no encontrada: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error en la base de datos: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }
    
    /**
     * lista todos los alojamientos registrados.
     */
    public static void listaAlojamientos() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/Javitos";
//            Class.forName("org.mariadb.jdbc.Driver");
//            String url = "jdbc:mariadb://localhost:3306/Javitos";
            Connection con = DriverManager.getConnection(url, "root", "232431");
            Statement stmt = con.createStatement();
            
            String selectAlojamientos = "SELECT * FROM alojamientos;"; 
            ResultSet datosAlojamientos = stmt.executeQuery(selectAlojamientos);
            
            if(!datosAlojamientos.isBeforeFirst()) {
                System.out.println("No hay alojamientos registrados en el sistema.");
            } else {
                while(datosAlojamientos.next()) {
                    System.out.println("                <--- Listado Alojamientos --->");
                    System.out.println("*-- Alojamiento : " + datosAlojamientos.getString("nombre") + "\n"
                                    + "* Capacidad: " + datosAlojamientos.getInt("capacidad") + "\n"
                                    + "* Tarifa: " + datosAlojamientos.getDouble("tarifa") + "\n"
                                    + "* Chimenea: " + datosAlojamientos.getBoolean("tiene_chimenea") + "\n"
                                    + "* Jacuzzi: " + datosAlojamientos.getBoolean("tiene_jacuzzi") + "\n"
                                    + "* Disponibilidad: " + datosAlojamientos.getBoolean("alquilada_ahora") + "\n"
                                    + "* Num Veces Alquilado: " + datosAlojamientos.getBoolean("num_veces_alquilado")
                                    );
                    System.out.println("*--------------------------------------------------------------------------------------*");    
                }
            }
            
            stmt.close();
            con.close();            
        
        } catch (ClassNotFoundException e) {
            System.err.println("Clase no encontrada: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error en la base de datos: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }
    
    /**
     * Lista todos los clientes ordenados por num de veces alojado.
     */
    public static void listaOrdenadaClientes() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/Javitos";
//            Class.forName("org.mariadb.jdbc.Driver");
//            String url = "jdbc:mariadb://localhost:3306/Javitos";
            Connection con = DriverManager.getConnection(url, "root", "232431");
            Statement stmt = con.createStatement();
            
            String selectClientes = "SELECT * FROM clientes ORDER BY num_veces_alojado DESC;"; 
            ResultSet datosClientes = stmt.executeQuery(selectClientes);
            
            if(!datosClientes.isBeforeFirst()) {
                System.out.println("No hay clientes registrados en el sistema.");
            } else {
                while(datosClientes.next()) {
                    System.out.println("           <--- LISTADO CLIENTES ORDENADO --->");
                    System.out.println("*-- Cliente : " + datosClientes.getString("dni") + "\n"
                                    + "* Nombre: " + datosClientes.getString("nombre") + "\n"
                                    + "* Email: " + datosClientes.getString("email") + "\n"
                                    + "* Lugar de Residencia: " + datosClientes.getString("lugar_residencia") + "\n"
                                    + "* Num Veces Alojado: " + datosClientes.getInt("num_veces_alojado") + "\n"
                                    );
                    System.out.println("*-------------------------------------------------------------------------------------*");                
                }
            }
            
            stmt.close();
            con.close();    
            
        } catch (ClassNotFoundException e) {
            System.err.println("Clase no encontrada: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error en la base de datos: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }
 
    /**
     * Lista todos los alojamientos ordenados por num de veces alquilado.
     */
    public static void listaOrdenadaAlojamientos() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            String url = "jdbc:mariadb://localhost:3306/Javitos";
            Connection con = DriverManager.getConnection(url, "root", "232431");
            Statement stmt = con.createStatement();
            
            String selectAlojamientos = "SELECT * FROM alojamientos ORDER BY num_veces_alquilado DESC;"; 
            ResultSet datosAlojamientos = stmt.executeQuery(selectAlojamientos);
            
            if(!datosAlojamientos.isBeforeFirst()) {
                System.out.println("No hay alojamientos registrados en el sistema.");
            } else {
                while(datosAlojamientos.next()) {
                    System.out.println("           <--- LISTADO ALOJAMIENTOS ORDENADO --->");
                    System.out.println("*-- Alojamiento : " + datosAlojamientos.getString("nombre") + "\n"
                                    + "* Capacidad: " + datosAlojamientos.getInt("capacidad") + "\n"
                                    + "* Tarifa: " + datosAlojamientos.getDouble("tarifa") + "\n"
                                    + "* Chimenea: " + datosAlojamientos.getBoolean("tiene_chimenea") + "\n"
                                    + "* Jacuzzi: " + datosAlojamientos.getBoolean("tiene_jacuzzi") + "\n"
                                    + "* Disponibilidad: " + datosAlojamientos.getBoolean("alquilada_ahora") + "\n"
                                    + "* Num Veces Alquilado: " + datosAlojamientos.getBoolean("num_veces_alquilado")
                                    );
                    System.out.println("*------------------------------------------------------------------------------------------*");      
                }
            }
            
            stmt.close();
            con.close();
            
        } catch (ClassNotFoundException e) {
            System.err.println("Clase no encontrada: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error en la base de datos: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }    
    
    /**
     * Modifica informacion de un cliente determinado.
     */
    public static void modificarCliente() {
        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Javitos";
            //            Class.forName("org.mariadb.jdbc.Driver");
            //            String url = "jdbc:mariadb://localhost:3306/Javitos";
            Connection con = DriverManager.getConnection(url, "root", "232431");
            Statement stmt = con.createStatement();

            System.out.println("Introduzca el dni del cliente que desea modificar: ");
            String dniCliente = sc.nextLine();
            System.out.println(
                    "* Pulse 1 para actualizar el nombre.\n"
                    + "* Pulse 2 para actualizar el elmail.\n"
                    + "* Pulse 3 para actualizar el lugar de residencia.\n"
                    + "* Pulse 4 para actualizar la cantidad de veces alojado.\n"
            );

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Introduzca el nuevo nombre del cliente:");
                    String nombreCliente = sc.nextLine();
                    String updateNombre = "UPDATE clientes SET nombre='" + nombreCliente + "' WHERE dni='" + dniCliente + "';";
                    stmt.executeUpdate(updateNombre);
                    System.out.println("El nombre del cliente " + dniCliente + " ha sido modificado.");
                    break;

                case 2:
                    System.out.println("Introduzca el nuevo email del cliente:");
                    String emailCliente = sc.nextLine();
                    if (!emailCliente.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                        throw new EmailNoValidaException("El formato del email no es valido.");
                    }
                    String updateEmail = "UPDATE clientes SET email='" + emailCliente + "' WHERE dni='" + dniCliente + "';";
                    stmt.executeUpdate(updateEmail);
                    System.out.println("El email del cliente " + dniCliente + " ha sido modificado.");
                    break;

                case 3:
                    System.out.println("Introduzca el nuevo lugar de residencia del cliente:");
                    String lugarResidencia = sc.nextLine();
                    String updateLugarResidencia = "UPDATE clientes SET lugar_residencia='" + lugarResidencia + "' WHERE dni='" + dniCliente + "';";
                    stmt.executeUpdate(updateLugarResidencia);
                    System.out.println("El lugar de residencia del cliente " + dniCliente + " ha sido modificado.");
                    break;

                case 4:
                    System.out.println("Introduzca la nueva cantidad de veces alojado del cliente:");
                    String vecesAlojado = sc.nextLine();
                    String updateVecesAlojado = "UPDATE clientes SET num_veces_alojado=" + vecesAlojado + " WHERE dni='" + dniCliente + "';";
                    stmt.executeUpdate(updateVecesAlojado);
                    System.out.println("La cantidad de veces alojado del cliente " + dniCliente + " ha sido modificada.");
                    break;
            }

            stmt.close();
            con.close();

        } catch (ClassNotFoundException e) {
            System.err.println("Clase no encontrada: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error en la base de datos: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }

    /**
     * Modifica informacion sobre un alojamiento especifico.
     */
    public static void modificarAlojamiento() {
        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Javitos";
            //            Class.forName("org.mariadb.jdbc.Driver");
            //            String url = "jdbc:mariadb://localhost:3306/Javitos";
            Connection con = DriverManager.getConnection(url, "root", "232431");
            Statement stmt = con.createStatement();

            System.out.println("Introduzca el nombre del alojamiento que desea modificar: ");
            String nombreAlojamiento = sc.nextLine();

            System.out.println(
                    "* Pulse 1 para actualizar la capacidad.\n"
                    + "* Pulse 2 para actualizar la tarifa por noche.\n"
                    + "* Pulse 3 para actualizar si tiene chimenea o no.\n"
                    + "* Pulse 4 para actualizar si tiene jacuzzi o no.\n"
                    + "* Pulse 5 para actualizar si esta alquilada o no.\n"
                    + "* Pulse 6 para actualizar la cantidad de veces alojado.\n"
            );
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Introduzca la nueva capacidad del alojamiento:");
                    int capacidadAlojamiento = sc.nextInt();
                    sc.nextLine();
                    String updateCapacidad = "UPDATE alojamientos SET capacidad=" + capacidadAlojamiento + " WHERE nombre='" + nombreAlojamiento + "';";
                    stmt.executeUpdate(updateCapacidad);
                    System.out.println("La capacidad del alojamiento " + nombreAlojamiento + " ha sido modificada.");
                    break;

                case 2:
                    System.out.println("Introduzca la nueva tarifa del alojamiento:");
                    double tarifaAlojamiento = sc.nextDouble();
                    sc.nextLine();
                    String updateTarifa = "UPDATE alojamientos SET tarifa=" + tarifaAlojamiento + " WHERE nombre='" + nombreAlojamiento + "';";
                    stmt.executeUpdate(updateTarifa);
                    System.out.println("La tarifa del alojamiento " + nombreAlojamiento + " ha sido modificada.");
                    break;

                case 3:
                    System.out.println("¿Tiene chimenea?");
                    String chimenea = sc.nextLine();
                    boolean tieneChimenea = false;
                    if (chimenea.equals("si")) {
                        tieneChimenea = true;
                    } else if (chimenea.equals("no")) {
                        tieneChimenea = false;
                    }
                    int valorTieneChimenea = (tieneChimenea) ? 1 : 0;

                    String updateTieneChimenea = "UPDATE alojamientos SET tiene_chimenea=" + valorTieneChimenea + " WHERE nombre='" + nombreAlojamiento + "';";
                    stmt.executeUpdate(updateTieneChimenea);
                    System.out.println("Las capabilidades del alojamiento " + nombreAlojamiento + " han sido modificadas.");
                    break;

                case 4:
                    System.out.println("¿Tiene jacuzzi?");
                    String jacuzzi = sc.nextLine().toLowerCase();
                    boolean tieneJacuzzi = false;
                    if (jacuzzi.equals("si")) {
                        tieneJacuzzi = true;
                    } else if (jacuzzi.equals("no")) {
                        tieneJacuzzi = false;
                    }
                    int valorTieneJacuzzi = (tieneJacuzzi) ? 1 : 0;

                    String updateTieneJacuzzi = "UPDATE alojamientos SET tiene_jacuzzi=" + valorTieneJacuzzi + " WHERE nombre='" + nombreAlojamiento + "';";
                    stmt.executeUpdate(updateTieneJacuzzi);
                    System.out.println("Las capabilidades del alojamiento " + nombreAlojamiento + " han sido modificadas.");
                    break;

                case 5:
                    System.out.println("¿Esta alquilada ahora?");
                    String alquiladaAhora = sc.nextLine().toLowerCase();
                    boolean estaAlquiladaAhora = false;
                    if (alquiladaAhora.equals("si")) {
                        estaAlquiladaAhora = true;
                    } else if (alquiladaAhora.equals("no")) {
                        estaAlquiladaAhora = false;
                    }
                    int valorAlquiladaAhora = (estaAlquiladaAhora) ? 1 : 0;

                    String updateAlquiladaAhora = "UPDATE alojamientos SET alquilada_ahora=" + valorAlquiladaAhora + " WHERE nombre='" + nombreAlojamiento + "';";
                    stmt.executeUpdate(updateAlquiladaAhora);
                    System.out.println("La disponibilidad del alojamiento " + nombreAlojamiento + " ha sido modificada.");
                    break;

                case 6:
                    System.out.println("Introduzca la nueva cantidad de veces alquilado:");
                    int vecesAlquilado = sc.nextInt();
                    String updateVecesAlquilado = "UPDATE alojamientos SET num_veces_alquilado=" + vecesAlquilado + " WHERE nombre='" + nombreAlojamiento + "';";
                    stmt.executeUpdate(updateVecesAlquilado);
                    System.out.println("La cantidad de veces alquilado del alojamiento " + nombreAlojamiento + " ha sido modificada.");
                    break;
            }

            stmt.close();
            con.close();

        } catch (ClassNotFoundException e) {
            System.err.println("Clase no encontrada: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error en la base de datos: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }        
    
    /**
     * Elimina de la base de datos a un cliente determinado.
     */
    public static void eliminarCliente() {
        Scanner sc = new Scanner(System.in);
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/Javitos";
//            Class.forName("org.mariadb.jdbc.Driver");
//            String url = "jdbc:mariadb://localhost:3306/Javitos";
            Connection con = DriverManager.getConnection(url, "root", "232431");
            Statement stmt = con.createStatement();
            
            System.out.println("Por favor introduzca el dni del cliente a borrar:");
            String dniCliente = sc.nextLine();
            
            String borrarClientes = "DELETE FROM clientes WHERE dni='" + dniCliente + "';";
            stmt.executeUpdate(borrarClientes);
            
            stmt.close();
            con.close();  
            
        } catch (ClassNotFoundException e) {
            System.err.println("Clase no encontrada: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error en la base de datos: " + e.getMessage());
        } catch (Exception e) {
             System.err.println("Error inesperado: " + e.getMessage());
        }
    }
    
    /**
     * Elimina de la base de datos un alojamiento determinado.
     */
    public static void eliminarAlojamiento() {
        Scanner sc = new Scanner(System.in);
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/Javitos";
//            Class.forName("org.mariadb.jdbc.Driver");
//            String url = "jdbc:mariadb://localhost:3306/Javitos";
            Connection con = DriverManager.getConnection(url, "root", "232431");
            Statement stmt = con.createStatement();
            
            System.out.println("Por favor introduzca el nombre del alojamiento a borrar:");
            String nombreAlojamiento = sc.nextLine();
            
            String borrarAlojamiento = "DELETE FROM alojamientos WHERE nombre='" + nombreAlojamiento + "';";
            stmt.executeUpdate(borrarAlojamiento);
            
            stmt.close();
            con.close();  
            
        } catch (ClassNotFoundException e) {
            System.err.println("Clase no encontrada: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error en la base de datos: " + e.getMessage());
        } catch (Exception e) {
             System.err.println("Error inesperado: " + e.getMessage());
        }
    }
    
    /**
     * Elimina todos los clientes de la base de datos.
     */
    public static void eliminarTodosClientes() {
        Scanner sc = new Scanner(System.in);
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/Javitos";
//            Class.forName("org.mariadb.jdbc.Driver");
//            String url = "jdbc:mariadb://localhost:3306/Javitos";
            Connection con = DriverManager.getConnection(url, "root", "232431");
            Statement stmt = con.createStatement();
            
            System.out.println("¿Esta seguro que desea borrar todas las entradas de la tabla clientes?");
            String opcion = sc.nextLine().toLowerCase();
            
            if (opcion.equals("no")) {
                System.out.println("Operacion cancelada");
                return;
            } else {
                String borrarClientes = "DELETE FROM clientes;";
                stmt.executeUpdate(borrarClientes);
                System.out.println("Se han eliminado todos los clientes de la base de datos.");
            }
            
            stmt.close();
            con.close();  
            
        } catch (ClassNotFoundException e) {
            System.err.println("Clase no encontrada: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error en la base de datos: " + e.getMessage());
        } catch (Exception e) {
             System.err.println("Error inesperado: " + e.getMessage());
        }
    }
    
    /**
     * Elimina todos los alojamientos de la base de datos.
     */
    public static void eliminarTodosAlojamientos() {
        Scanner sc = new Scanner(System.in);
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/Javitos";
//            Class.forName("org.mariadb.jdbc.Driver");
//            String url = "jdbc:mariadb://localhost:3306/Javitos";
            Connection con = DriverManager.getConnection(url, "root", "232431");
            Statement stmt = con.createStatement();
            
            System.out.println("¿Esta seguro que desea borrar todas las entradas de la tabla alojamientos?");
            String opcion = sc.nextLine().toLowerCase();
            
            if (opcion.equals("no")) {
                System.out.println("Operacion cancelada");
                return;
            } else {
                String borrarAlojamientos = "DELETE FROM alojamientos;";
                stmt.executeUpdate(borrarAlojamientos);
                System.out.println("Se han eliminado todos los alojamientos de la base de datos.");
            }
            
            stmt.close();
            con.close();  
            
        } catch (ClassNotFoundException e) {
            System.err.println("Clase no encontrada: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error en la base de datos: " + e.getMessage());
        } catch (Exception e) {
             System.err.println("Error inesperado: " + e.getMessage());
        }
    }
    
    /**
     * Mensaje de cierre de sesion.
     */
    public static void cerrarBBDD() {
        
            System.out.println("************************************************************************************");
            System.out.println("* Cerrando sesion...");
            System.out.println("************************************************************************************");  
            
    }
}
