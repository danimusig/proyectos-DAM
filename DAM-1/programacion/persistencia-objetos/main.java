package pkg2026.pkg3.pkg5.pe10_bbddoo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.RollbackException;

/**
 * 
 * @author dmunsig
 * @version 1.0
 * @see String
 * @see List
 * @see ArrayList
 * @see EntityManager
 * @see EntityManagerFactory
 */
public class main {
    
    public static void main(String[] args) {
        int opcion = 0;
        do {
            opcion = menu();
            switch(opcion) {
                case 1:
                    altaVehiculo();
                    break;
                case 2:
                    listadoVehiculo();
                    break;
                case 3:
                    getInfoVehiculo();
                    break;
                case 4:
                    setInfoVehiculo();
                    break;
                case 5:
                    eliminarVehiculo();
                    break;
                case 6:
                    contarNumVehiculo();
                    break;
                case 7:
                    listarVehiculosMarca();
                    break;
                case 8:
                    listarVehiculosNumPlazas();
                    break;
                case 9:
                    listarVehiculosExtras();
                    break;
                case 10:
                    eliminarRegistrosBBDD();
                    break;
                case 0:
                    cerrarBBDD();    
                    break;
            }
        }while (opcion!=0);
    }
    
    public static int menu() {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        try {
            do {
                System.out.println("\n************************************************************************************");
                System.out.println("************************ --- Gestion de Vehiculos --- ******************************"); 
                System.out.println("************************************************************************************");
                System.out.println(
                        "* Pulse 1 para dar de alta un Vehículo.\n" +
                        "* Pulse 2 para listar todos los vehículos existentes en la base de datos.\n" +
                        "* Pulse 3 para obtener la información sobre un vehículo.\n" +
                        "* Pulse 4 para actualizar la información de un vehículo.\n" +
                        "* Pulse 5 para eliminar un vehículo (a partir de su matrícula).\n" +
                        "* Pulse 6 para conocer el nº total de vehículos en la base de datos.\n" +
                        "* Pulse 7 para listar todos los vehículos de una determinada marca.\n" +
                        "* Pulse 8 para listar todos los vehículos de un determinado número de plazas.\n" +
                        "* Pulse 9 para listar todos los vehículos que tengan un extra en especifico.\n" +
                        "* Pulse 10 para eliminar todos los vehículos de la base de datos.\n" +
                        "* Pulse 0 para salir de la aplicación"
                );
                System.out.println("************************************************************************************ \n");                

                opcion = sc.nextInt();
            } while (opcion < 0 || opcion > 10);   
            
        } catch(InputMismatchException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
        return opcion;
    }
    
    public static void altaVehiculo() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/flotaVehiculos.odb");
        EntityManager em = emf.createEntityManager();
        Scanner sc = new Scanner(System.in);
        List<String> listaExtras =  new ArrayList<>();
        try {
            System.out.println("Introduzca la matricula del vehiculo:");
            String matricula = sc.nextLine().toUpperCase();
            
            System.out.println("Introduzca la marca del vehiculo:");
            String marca = sc.nextLine();
            
            System.out.println("Introduzca el modelo del vehiculo:");
            String modelo = sc.nextLine();
            
            System.out.println("Introduzca las plazas del vehiculo:");
            int numPlazas = sc.nextInt();

            System.out.println("Introduzca los extras del vehiculo: (0 para salir) ");
                while (true) {
                    String nuevoExtra = sc.nextLine();
                    if (nuevoExtra.equals("0")) {
                        break;
                    }
                    if (!nuevoExtra.isEmpty()){
                        listaExtras.add(nuevoExtra);
                    }
                }
        Vehiculo v = new Vehiculo(matricula, marca, modelo, numPlazas, listaExtras);
        System.out.println("*** Vehiculo añadido correctamente: ");
        System.out.println(v.toString());
        
        em.getTransaction().begin();
        em.persist(v);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
        } catch (EntityExistsException e) {
            System.out.println("ERROR: ya existe un vehiculo con esa matricula.");
        } catch (PersistenceException e) {
            System.out.println("Error de base de datos: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
    
    public static void listadoVehiculo() {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/flotaVehiculos.odb");
            EntityManager em = emf.createEntityManager();
            Query query = em.createNamedQuery("listadoVehiculo");
            List<Vehiculo> listaVehiculos = new ArrayList<>();
            listaVehiculos = query.getResultList();

            for(Vehiculo v : listaVehiculos) {
                System.out.println(v.toString());
            }
            em.close();
            emf.close();    
            
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }     
    }
    
    public static void getInfoVehiculo() {
        try {
            Scanner sc = new Scanner(System.in);
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/flotaVehiculos.odb");
            EntityManager em = emf.createEntityManager();
            
            System.out.println("Por favor introduzca la matricula del vehiculo: ");
            String matriculaUsuario = sc.nextLine();
            
            if(!matriculaUsuario.matches("[0-9]{4}-[A-Z]{3}")) {
                return; 
            } else {
                Query query = em.createQuery("SELECT v FROM Vehiculo v WHERE matricula='" + matriculaUsuario + "'");
                List<Vehiculo> infoVehiculo = new ArrayList<>();
                infoVehiculo = query.getResultList();

                for(Vehiculo v : infoVehiculo) {
                    System.out.println(v.toString());
                }
                em.close();
                emf.close();    
            }
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }      
    }
    
    public static void setInfoVehiculo() {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/flotaVehiculos.odb");
            EntityManager em = emf.createEntityManager();
            Scanner sc = new Scanner(System.in);
            List<String> listaNuevoExtra = new ArrayList<>();

            System.out.println("Introduzca la matricula del vehiculo que desea modificar: ");
            String matriculaUsuario = sc.nextLine().toUpperCase();

            if(!matriculaUsuario.matches("[0-9]{4}-[A-Z]{3}")) {
                throw new IllegalArgumentException("El formato de la matricula es erroneo (DDDD-LLL)");    
            } else {
                em.getTransaction().begin();
                Query query  = em.createQuery("SELECT v FROM Vehiculo v  WHERE matricula='" + matriculaUsuario + "'");
                Vehiculo vehiculobbdd = (Vehiculo) query.getSingleResult();
                
                //Trabajo directamente sobre el objeto vehiculo de la base de datos, pudiendo usar los setter y getter en lugar de sentencias JPQL.
                System.out.println("Introduzca la nueva marca del vehiculo: \n  Marca actual: " + vehiculobbdd.getMarca());
                String nuevaMarca = sc.nextLine();
                vehiculobbdd.setMarca(nuevaMarca);
                
                System.out.println("Introduzca el nuevo modelo del vehiculo: \n  Modelo actual: " + vehiculobbdd.getModelo());
                String nuevoModelo = sc.nextLine();
                vehiculobbdd.setModelo(nuevoModelo);
                
                System.out.println("Introduzca la cantidad de plazas del vehiculo: \n  Nº plazas actual: " + vehiculobbdd.getNumPlazas());
                int nuevoNumPlaza = sc.nextInt();
                vehiculobbdd.setNumPlazas(nuevoNumPlaza);
                
                System.out.println("Introduzca los extras del vehiculo: (0 para salir)  \n  Paquete Extras actual: " + vehiculobbdd.getExtras());
                while (true) {
                    String nuevoExtra = sc.nextLine();
                    if (nuevoExtra.equals("0")) {
                        break;
                    }
                    if (!nuevoExtra.isEmpty()){
                        listaNuevoExtra.add(nuevoExtra);
                    }
                }
                vehiculobbdd.setExtras(listaNuevoExtra); //No se pueden actualizar las listas con sentencias JPQL asi que trabajamos con el objeto de la base de datos directamente.
                
                em.getTransaction().commit();
                em.close();
                emf.close();
            }    
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (PersistenceException e) {
            System.out.println("Error de base de datos: " + e.getMessage());
            
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
            
        }   
    }
    
    public static void eliminarVehiculo() {
        try {
            Scanner sc = new Scanner(System.in);
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/flotaVehiculos.odb");
            EntityManager em = emf.createEntityManager();

            System.out.println("Introduzca la matricula del vehiculo que desea eliminar: ");
            String matriculaUsuario = sc.nextLine().toUpperCase();

            if(!matriculaUsuario.matches("[0-9]{4}-[A-Z]{3}")) {
                throw new IllegalArgumentException("El formato de la matricula es erroneo (DDDD-LLL)");    
            } else {
                em.getTransaction().begin();
                Query deleteVehiculo  = em.createQuery("DELETE FROM Vehiculo WHERE matricula='" + matriculaUsuario + "'");
                int numeroObjetosBorrados = deleteVehiculo.executeUpdate();
                System.out.println("Se han eliminado "+numeroObjetosBorrados+" objetos.");
                em.getTransaction().commit();
            }  
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            
        } catch (PersistenceException e) {
            System.out.println("Error de base de datos: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }   
    }
    
    public static void contarNumVehiculo() {
        try {
            Scanner sc = new Scanner(System.in);
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/flotaVehiculos.odb");
            EntityManager em = emf.createEntityManager();

            Query query = em.createNamedQuery("listadoVehiculo");
            List<Vehiculo> listadoVehiculos = new ArrayList<>();
            listadoVehiculos = query.getResultList();

            System.out.println("Hay un total de " + listadoVehiculos.size() + " vehiculos en la base de datos.");
        
        } catch(Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());

        }
            
    }
    
    public static void listarVehiculosMarca() {
        try {
            Scanner sc = new Scanner(System.in);
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/flotaVehiculos.odb");
            EntityManager em = emf.createEntityManager();
            

            System.out.println("Introduzca la marca que desea consultar: ");
            String marca = sc.nextLine();
            Query query = em.createQuery("SELECT v FROM Vehiculo v WHERE v.marca='" + marca + "'");
            List<Vehiculo> listaVehiculosMarca = new ArrayList<Vehiculo>();
            listaVehiculosMarca = query.getResultList();
            
            if (listaVehiculosMarca.isEmpty()) {
                System.out.println("No hay vehículos de la marca '" + marca + "'.");
            } else {
                for(Vehiculo v : listaVehiculosMarca) {
                    System.out.println(v.toString());    
                }
            }
                
            em.close();
            emf.close();
        } catch (InputMismatchException | EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }    
    }
    
    public static void listarVehiculosNumPlazas() {
        try {
            Scanner sc = new Scanner(System.in);
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/flotaVehiculos.odb");
            EntityManager em = emf.createEntityManager();
            
            System.out.println("Introduzca el numero de plazas de os vehiculos que desea consultar: ");
            int numPlazas = sc.nextInt();
            Query query = em.createQuery("SELECT v FROM Vehiculo v WHERE v.numPlazas=" + numPlazas);
            List<Vehiculo> listaVehiculosNumPlazas = new ArrayList<Vehiculo>();
            listaVehiculosNumPlazas = query.getResultList();
            
            if (listaVehiculosNumPlazas.isEmpty()) {
                System.out.println("No hay vehículos con '" + numPlazas + " plazas.");
            } else {
                for(Vehiculo v : listaVehiculosNumPlazas) {
                    System.out.println(v.toString());    
                }
            }
            em.close();
            emf.close();
        } catch (InputMismatchException | EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }    
    }
    
    public static void listarVehiculosExtras() {
        try {
            Scanner sc = new Scanner(System.in);
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/flotaVehiculos.odb");
            EntityManager em = emf.createEntityManager();
            
            Query query = em.createNamedQuery("listadoVehiculo");
            
            List<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
            listaVehiculos = query.getResultList();
            
            List<String> listaExtras = new ArrayList<>();

            System.out.println("Introduzca los extras que desea consultar: (0 para terminar de introducir) ");
            while (true) {
                String extra = sc.nextLine().trim();
                if (extra.equals("0")) {
                    break;
                }
                if (!extra.isEmpty()) {
                    listaExtras.add(extra);
                }
            }            

            for (Vehiculo v: listaVehiculos) {
                if(v.getExtras().containsAll(listaExtras)) {
                    System.out.println(v.toString());
                }
            }
            System.out.println();
            em.close();
            emf.close();
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        } catch (EntityNotFoundException | NoSuchElementException e) {
            System.out.println("Error de base de datos:" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado:" + e.getMessage());
        }
    }
   
    public static void eliminarRegistrosBBDD() {
        try {
            Scanner sc = new Scanner(System.in);
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/flotaVehiculos.odb");
            EntityManager em = emf.createEntityManager();

            System.out.println("Esta seguro de que desea borrar la base de datos: (Y - si, N - no)");
            String opcion = sc.next().toUpperCase();
            if (opcion.equals("Y")) {
                em.getTransaction().begin();
                Query borradoVehiculos = em.createNamedQuery("borrarTodosLosVehiculos");
                borradoVehiculos.executeUpdate();
                em.getTransaction().commit();
                System.out.println("La base de datos ha sido borrada.");
            } 
        } catch (InputMismatchException | EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }       
    }
    
    public static void cerrarBBDD()throws EntityNotFoundException {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/flotaVehiculos.odb");
            EntityManager em = emf.createEntityManager();
            System.out.println("************************************************************************************");
            System.out.println("* Sesion cerrada...");
            System.out.println("************************************************************************************");        
            em.close();
            emf.close();
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
