package pe11_bbdd_relacionales_jdbc;

import java.sql.*;
import java.util.Scanner;
import javax.management.Query;

/**
 * 
 * @author dmunsig
 */
public class Cerveceria {
    
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int opcion = 0;
            do {
                opcion = menu();
                switch(opcion) {
                    case 1:
                        altaBar();
                        break;
                    
                    case 2:
                        altaPersona();
                        break;
                    
                    case 3:
                        asociarPersonaBar();
                        break;
                    
                    case 4:
                        altaCerveza();
                        break;
                        
                    case 5:
                        asociarCervezaBar();
                        break;
                        
                    case 6:
                        asociarCervezaPersona();
                        break;
                    
                    case 7:
                        cambioSexo();
                        break;
                        
                    case 8:
                        noGustaCerveza();
                        break;
                        
                    case 9:
                        listaSirvenCerveza();
                        break;       
                        
                    case 10:
                        salirPrograma();
                        break;
                }
            } while(opcion != 10);  
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
            
        }           
    }
    
    public static int menu() {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        try {
            do {
                System.out.println("************************************************************************");
                System.out.println("*********************** - GESTION CERVECERIA - *************************");       
                System.out.println("************************************************************************");        
                System.out.println(
                      "* Pulse 1 para dar de alta un bar.\n"
                    + "* Pulse 2 para dar de alta una pesona.\n"
                    + "* Pulse 3 para asociar un bar a una persona que lo frecuenta.\n"
                    + "* Pulse 4 para dar de alta una cerveza.\n"
                    + "* Pulse 5 para asociar una cerveza a un bar.\n"
                    + "* Pulse 6 para asociar una persona a una cerveza.\n"
                    + "* Pulse 7 para modificar el sexo de una persona.\n"
                    + "* Pulse 8 para que a una persona deje de gustarle una cerveza.\n"
                    + "* Pulse 9 para obtener un listado de bares.\n"
                    + "* Pulse 10 para salir.\n");
                System.out.println("************************************************************************");
                opcion = sc.nextInt();
            } while(opcion <= 0 | opcion >= 10);            
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
            
        }  
        return opcion;
    }
    
    public static void altaBar() {
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/bares";
//            Class.forName("org.mariadb.jdbc.Driver");
//            String url = "jdbc:mariadb://localhost:3306/bares";
            Connection con = DriverManager.getConnection(url, "root", "232431");
            Statement stmt = con.createStatement();
            
            System.out.println("Introduzca el nombre del bar: ");
            String nombreBar = sc.nextLine();
            
            System.out.println("Introduzca la localidad donde se encuentra: ");
            String localidad = sc.nextLine();
            
            //Uso insert ignore para ignorar los duplicados desde la base de datos.
            String insertBar = "INSERT IGNORE INTO bar VALUES ('" + nombreBar + "', '" + localidad + "');";
            stmt.executeUpdate(insertBar);
            
            stmt.close();
            con.close();
            
        } catch(Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
            
        }
    }
    
    public static void altaPersona() {
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/bares";
//            Class.forName("org.mariadb.jdbc.Driver");
//            String url = "jdbc:mariadb://localhost:3306/bares";
            Connection con = DriverManager.getConnection(url, "root", "232431");
            Statement stmt = con.createStatement();
            
            System.out.println("Introduzca el nombre de la persona: ");
            String nombrePersona = sc.nextLine();
            
            System.out.println("Introduzca el sexo de la persona: ");
            String sexo = sc.nextLine();
            
            String insertPersona = "INSERT IGNORE INTO persona VALUES ('" + nombrePersona + "', '" + sexo + "')";
            stmt.executeUpdate(insertPersona);
            
            stmt.close();
            con.close();           
            
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());

        }
    }
    
    public static void asociarPersonaBar() {
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/bares";
//            Class.forName("org.mariadb.jdbc.Driver");
//            String url = "jdbc:mariadb://localhost:3306/bares";
            Connection con = DriverManager.getConnection(url, "root", "232431");
            Statement stmt = con.createStatement();
            
            System.out.println("Introduzca el nombre de la persona: ");
            String nombrePersona = sc.nextLine();
            
            System.out.println("Introduzca el nombre del bar que frecuenta:");
            String barFrecuentado = sc.nextLine();
            
            String insertFrecuenta = "INSERT IGNORE INTO frecuenta VALUES ('" + nombrePersona + "', '" + barFrecuentado + "')";
            stmt.executeUpdate(insertFrecuenta);
            
            stmt.close();
            con.close();
            
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }    
    }
    
    public static void altaCerveza() {
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/bares";
//            Class.forName("org.mariadb.jdbc.Driver");
//            String url = "jdbc:mariadb://localhost:3306/bares";
            Connection con = DriverManager.getConnection(url, "root", "232431");
            Statement stmt = con.createStatement();
            
            System.out.println("Introduzca el nombre de la cerveza: ");
            String nombreCerveza = sc.nextLine();
            
            System.out.println("Introduzca el tipo de cerveza:");
            String tipoCerveza = sc.nextLine();
            
            String insertCerveza = "INSERT IGNORE INTO cerveza VALUES ('" + nombreCerveza + "', '" + tipoCerveza + "')";           
            stmt.executeUpdate(insertCerveza);
            
                        stmt.close();
            con.close();
        } catch(Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
            
        }     
    }
    
    public static void asociarCervezaBar() {
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/bares";
//            Class.forName("org.mariadb.jdbc.Driver");
//            String url = "jdbc:mariadb://localhost:3306/bares";
            Connection con = DriverManager.getConnection(url, "root", "232431");
            Statement stmt = con.createStatement();
            
            System.out.println("Introduzca el nombre del bar: ");
            String nombreBar = sc.nextLine();
            
            System.out.println("Introduzca el nombre de la cerveza que se sirve: ");
            String nombreCerveza = sc.nextLine();
            
            String insertSirve = "INSERT IGNORE INTO sirve VALUES ('" + nombreBar + "', '" + nombreCerveza + "')";           
            stmt.executeUpdate(insertSirve);  
            
        } catch(Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
            
        }      
    }
    
    public static void asociarCervezaPersona() {
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/bares";
//            Class.forName("org.mariadb.jdbc.Driver");
//            String url = "jdbc:mariadb://localhost:3306/bares";
            Connection con = DriverManager.getConnection(url, "root", "232431");
            Statement stmt = con.createStatement();
            
            System.out.println("Introduzca el nombre de la persona: ");
            String nombrePersona = sc.nextLine();
            
            System.out.println("Introduzca el nombre de la cerveza que le gusta: ");
            String nombreCerveza = sc.nextLine();
            
            String insertGusta = "INSERT IGNORE INTO gusta VALUES ('" + nombrePersona + "', '" + nombreCerveza + "')";
            stmt.executeUpdate(insertGusta);
        
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }    
    }
    
    public static void cambioSexo() {
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/bares";
//            Class.forName("org.mariadb.jdbc.Driver");
//            String url = "jdbc:mariadb://localhost:3306/bares";
            Connection con = DriverManager.getConnection(url, "root", "232431");
            Statement stmt = con.createStatement();
            
            System.out.println("Introduzca el nombre de la persona: ");
            String nombrePersona = sc.nextLine();
            
            String selectPersona = "SELECT nombre, sexo FROM persona;";
            ResultSet datosPersona = stmt.executeQuery(selectPersona);
            
            if (datosPersona.getString("sexo").equals("Masculino")) {
                String updatePersona = "UPDATE persona SET sexo='Femenino' WHERE nombre='"+ nombrePersona + "';";
                stmt.executeUpdate(updatePersona);
            } else {
                String updatePersona = "UPDATE persona SET sexo='Masculino' WHERE nombre='"+ nombrePersona + "';";
                stmt.executeUpdate(updatePersona);
            }
            
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
    
    public static void noGustaCerveza() {
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/bares";
//            Class.forName("org.mariadb.jdbc.Driver");
//            String url = "jdbc:mariadb://localhost:3306/bares";
            Connection con = DriverManager.getConnection(url, "root", "232431");
            Statement stmt = con.createStatement();
            
            System.out.println("Introduzca el nombre de la persona: ");
            String nombrePersona = sc.nextLine();
            
            System.out.println("intrpduzca el nombre de la ceveza que no le gusta: ");
            String nombreCerveza = sc.nextLine();
            
            String deleteGusta = "DELETE FROM gusta WHERE persona='" + nombrePersona + "');";
            stmt.executeUpdate(deleteGusta);
            
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
    
    public static void listaSirvenCerveza() {
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/bares";
//            Class.forName("org.mariadb.jdbc.Driver");
//            String url = "jdbc:mariadb://localhost:3306/bares";
            Connection con = DriverManager.getConnection(url, "root", "232431");
            Statement stmt = con.createStatement();
            
            System.out.println("Introduzca el tipo de cerveza: ");
            String tipoCerveza = sc.nextLine();
            
            String selectBarCerveza = "SELECT bar, ciudad "
                    + "FROM bar b JOIN sirve s ON b.bar = s.bar JOIN cerveza c ON c.cerveza = s.cerveza "
                    + "WHERE c.tipo ='" + tipoCerveza + "';";
            ResultSet datosBarCerveza = stmt.executeQuery(selectBarCerveza);
            
            while(datosBarCerveza.next()) {
                System.out.println("Bar: " + datosBarCerveza.getString("bar") + "\t Ciudad: " + datosBarCerveza.getString("ciudad"));
            }
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
            
        }    
    }
    
    public static void salirPrograma() {
        System.out.println("Cerrando el programa...");
    }
}

