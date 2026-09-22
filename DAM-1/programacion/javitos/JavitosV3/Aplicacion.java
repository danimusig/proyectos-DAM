
package Javitos;

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
 * Clase Aplicacion: Clase con un menu donde se trabaja con los objetos Cliente y Alojamientos sobre una base de datos ObjectDB.
 * @author dmunsig
 * @version 1.0
 * @see String
 * @see List
 * @see Arraylist
 * @see EntityManager
 * @see EntityManagerFactory
 */
public class Aplicacion {
    
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
                            listadoClientes();
                        } else if (submenu == 2) {
                            listadoAlojamientos();
                        }
                        break;

                    case 4: //Lista los objetos ordenados por un parametro determinado.
                        System.out.println("* Pulse 1 para listar los clientes ordenados por veces alojado.");
                        System.out.println("* Pulse 2 para listar los alojamientos ordenados por veces alquilado.");
                        submenu = sc.nextInt();

                        if (submenu == 1) {
                            topClientes();
                        } else if (submenu == 2) {
                            topAlojamientos();
                        }
                        break;

                    case 5: //Modifica un objeto de la bbdd.
                        System.out.println("* Pulse 1 para listar los clientes ordenados por veces alojado.");
                        System.out.println("* Pulse 2 para listar los alojamientos ordenados por veces alquilado.");
                        submenu = sc.nextInt();

                        if (submenu == 1) {
                            setInfoCliente();
                        } else if (submenu == 2) {
                            setInfoAlojamiento();
                        }
                        break;

                    case 6: //elimina un objeto de la bbdd.
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
                        System.out.println("* Pulse 1 para eliminar la base de datos de clientes.");
                        System.out.println("* Pulse 2 para eliminar la base de datos de alojamientos.");
                        submenu = sc.nextInt();

                        if (submenu == 1) {
                            eliminarCliente();
                        } else if (submenu == 2) {
                            eliminarAlojamiento();
                        }
                        break;

                    case 0: //Cierra la bbdd y enseña un mensaje de salida.
                        cerrarBBDD();    
                        break;
                }
            } while (opcion!=0);
        } catch (EmailNoValidaException e) { 
            System.out.println(e.getMessage());
            
        } catch (DniNoValidaException e) { 
            System.out.println(e.getMessage());
            
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            
        }
    }
    
    /**
     * Menu con diferentes funciones.
     * @return La funcion deseada en un entero.
     */
    public static int menu() {
    Scanner sc = new Scanner(System.in);
        int opcion = 0;
        try {
            do {
                System.out.println("\n**************************************************************************************");
                System.out.println("************************ --- SISTEMA DE GESTION JAVITOS --- **************************"); 
                System.out.println("**************************************************************************************");
                System.out.println(
                        "* Pulse 1 para dar de alta.\n" +
                        "* Pulse 2 para consultar informacion.\n" +
                        "* Pulse 3 para listar objetos existentes.\n" +
                        "* Pulse 4 para obtener el listado ordenado de objetos.\n" +
                        "* Pulse 5 para modificar información de un objeto.\n" +
                        "* Pulse 6 para eliminar un determinado objeto.\n" +
                        "* Pulse 7 para eliminar todos los objetos de la base de datos.\n" +
                        "* Pulse 0 para salir de la aplicación"
                );
                System.out.println("************************************************************************************** \n");                

                opcion = sc.nextInt();
            } while (opcion < 0 || opcion > 10);   
            
        } catch(InputMismatchException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
        return opcion;
    }   
    
    /**
     * Da de alta un cliente en la bbdd.
     */
    public static void altaCliente() {
             
        Scanner sc = new Scanner(System.in);
        
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/clientes.odb");
            EntityManager em = emf.createEntityManager();   
            System.out.println("Introduzca el nombre completo:");
            String nombre = sc.nextLine().toUpperCase();
            
            System.out.println("Introduzca el dni:");
            String dni = sc.nextLine();
            
            System.out.println("Introduzca el email:");
            String email = sc.nextLine();
            
            System.out.println("Introduzca el lugar de residencia:");
            String lugarResidencia = sc.nextLine();
            
            Cliente c = new Cliente(nombre, dni, email, lugarResidencia);

            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
            System.out.println("*** Cliente añadido correctamente: ");            
            em.close();
            emf.close();
        
        } catch (EntityExistsException e) {
            System.out.println("ERROR: ya existe un cliente con ese dni.");
        } catch (PersistenceException e) {
            System.out.println("Error de base de datos: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
    
    /**
     * Da de alta un objeto alojamiento en la bbdd.
     */
    public static void altaAlojamiento() {
             
        Scanner sc = new Scanner(System.in);
        
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/alojamientos.odb");
            EntityManager em = emf.createEntityManager();   
            System.out.println("Introduzca el nombre:");
            String nombre = sc.nextLine().toUpperCase();
            
            System.out.println("Introduzca la capacidad de alojamiento:");
            int capacidad = sc.nextInt();            
            
            System.out.println("Introduzca la tarifa por noche:");
            double tarifa = sc.nextDouble();
            
            boolean tieneChimenea;            
            System.out.println("¿Tiene chimenea?: (Si/No)");
            String chimenea = sc.nextLine().toLowerCase();
            if (chimenea.equals("si")) {
                tieneChimenea = true;
            } else {
                tieneChimenea = false;
            }  
            
            boolean tieneJacuzzi;            
            System.out.println("¿Tiene jacuzzi?: (Si/No)");
            String jacuzzi = sc.nextLine().toLowerCase();
            if (jacuzzi.equals("si")) {
                tieneJacuzzi = true;
            } else {
                tieneJacuzzi = false;
            }  
            
            Alojamiento a = new Alojamiento(nombre, capacidad, tarifa, tieneChimenea, tieneJacuzzi);

            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();
            System.out.println("*** Alojamiento añadido correctamente: ");            
            em.close();
            emf.close();
        
        } catch (EntityExistsException e) {
            System.out.println("ERROR: ya existe un alojamiento con ese nombre.");
        } catch (PersistenceException e) {
            System.out.println("Error de base de datos: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }    
    
    /**
     * Muestra informacion sobre un cliente especifico.
     */
    public static void getInfoCliente() { 
        try {
            Scanner sc = new Scanner(System.in);
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/clientes.odb");
            EntityManager em = emf.createEntityManager();
            
            System.out.println("Por favor introduzca el dni del cliente: ");
            String dniUsuario = sc.nextLine();
            
            if(!dniUsuario.matches("[0-9]{8}[A-Z]")) {
                return; 
            } else {
                Query query = em.createQuery("SELECT c FROM Cliente c WHERE dni='" + dniUsuario + "'");
                List<Cliente> infoCliente = new ArrayList<>();
                infoCliente = query.getResultList();

                for(Cliente c : infoCliente) {
                    System.out.println(c.toString());
                }
                em.close();
                emf.close();    
            }
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
            
        } catch (NoSuchElementException e) {
            System.out.println("El cliente no existe: " + e.getMessage());
            
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }      
    }
    
    /**
     * Muestra informacion sobre un alojamiento determinado.
     */
    public static void getInfoAlojamiento() { 
        try {
            Scanner sc = new Scanner(System.in);
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/alojamientos.odb");
            EntityManager em = emf.createEntityManager();
            
            System.out.println("Por favor introduzca el nombre del alojamiento: ");
            String nombreUsuario = sc.nextLine();
            
            Query query = em.createQuery("SELECT a FROM Alojamiento a WHERE nombre='" + nombreUsuario + "'");
            List<Alojamiento> infoAlojamiento = new ArrayList<>();
            infoAlojamiento = query.getResultList();
            for(Alojamiento a : infoAlojamiento) {
                System.out.println(a.toString());
            }
            em.close();
            emf.close();    
           
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
            
        } catch (NoSuchElementException e) {
            System.out.println("El alojamiento no existe: " + e.getMessage());
            
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }      
    }
            
    /**
     * Muestra una lista de clientes.
     */
    public static void listadoClientes() {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/clientes.odb");
            EntityManager em = emf.createEntityManager();
            Query query = em.createNamedQuery("datosCliente");
            List<Cliente> listaClientes = new ArrayList<>();
            listaClientes = query.getResultList();

            for(Cliente c : listaClientes) {
                System.out.println(c.toString());
            }
            em.close();
            emf.close();    
            
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }     
    }
    
    /**
     * Muestra una lista de alojamientos.
     */
    public static void listadoAlojamientos() {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/alojamientos.odb");
            EntityManager em = emf.createEntityManager();
            Query query = em.createNamedQuery("datosAlojamiento");
            List<Alojamiento> listaAlojamientos = new ArrayList<>();
            listaAlojamientos = query.getResultList();

            for(Alojamiento a : listaAlojamientos) {
                System.out.println(a.toString());
            }
            em.close();
            emf.close();    
            
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }     
    }
    
    /**
     * Muestra una lista ordenada de clientes.
     */
    public static void topClientes() {
        try { 
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/clientes.odb");
            EntityManager em = emf.createEntityManager();
            Query query = em.createNamedQuery("datosCliente");
            List<Cliente> listaCliente = new ArrayList<>();
            listaCliente = query.getResultList();
            
            if (listaCliente.isEmpty()) {
                System.out.println("No hay clientes registrados en el sistema");
                return;
            } else {
                ArrayList<Cliente> topCliente = new ArrayList<>(listaCliente);
                //Lo adecuado seria usar un comparator pero no los hemos dado.
                //Uso el metodo de ordenacion BubbleSort.
                for (int i = 0; i < topCliente.size() - 1; i++) {
                    for (int j = 0; j < topCliente.size() - i - 1; j++) {
                        // Si el siguiente tiene mas hospedaciones que el actual, los intercambiamos.
                        if (topCliente.get(j).getVecesAlojado() < topCliente.get(j + 1).getVecesAlojado()) {
                            Cliente temp = topCliente.get(j);
                            topCliente.set(j, topCliente.get(j + 1));
                            topCliente.set(j + 1, temp);
                        }    
                    }
                }

                System.out.println("\n--- LISTADO CLIENTES (POR ESTANCIAS) ---");
                for (Cliente c : topCliente) {
                    System.out.println("Cliente: " + c.getNombre() + " | DNI: " + c.getDni() + " | Estancias: " + c.getVecesAlojado());
                }
            }    
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
    
    /**
     * Muestra una lista irdenada de alojamientos.
     */
    public static void topAlojamientos() {
        try { 
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/alojamientos.odb");
            EntityManager em = emf.createEntityManager();
            Query query = em.createNamedQuery("datosAlojamiento");
            List<Alojamiento> listaAlojamientos = new ArrayList<>();
            listaAlojamientos = query.getResultList();
            
            if (listaAlojamientos.isEmpty()) {
                System.out.println("No hay alojamientos registrados en el sistema");
                return;
            } else {
                ArrayList<Alojamiento> topAlojamiento = new ArrayList<>(listaAlojamientos);
                //Lo adecuado seria usar un comparator pero no los hemos dado.
                //Uso el metodo de ordenacion BubbleSort.
                for (int i = 0; i < topAlojamiento.size() - 1; i++) {
                    for (int j = 0; j < topAlojamiento.size() - i - 1; j++) {
                        // Si el siguiente se ha alquilado mas veces que el actual, los intercambiamos.
                        if (topAlojamiento.get(j).getVecesAlquilado() < topAlojamiento.get(j + 1).getVecesAlquilado()) {
                            Alojamiento temp = topAlojamiento.get(j);
                            topAlojamiento.set(j, topAlojamiento.get(j + 1));
                            topAlojamiento.set(j + 1, temp);
                        }    
                    }
                }

                System.out.println("\n--- LISTADO ALOJAMIENTOS (POR VECES ALQUILADO) ---");
                for (Alojamiento a : topAlojamiento) {
                    System.out.println("Alojamiento: " + a.getNombre() + " Veces alquilado: " + a.getVecesAlquilado());
                }
            }    
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
    
    /**
     * Modifica la informacion de un cliente.
     * @throws EmailNoValidaException
     * @throws DniNoValidaException 
     */
    public static void setInfoCliente() throws EmailNoValidaException, DniNoValidaException {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/clientes.odb");
            EntityManager em = emf.createEntityManager();
            Scanner sc = new Scanner(System.in);

            System.out.println("Introduzca el dni del cliente que desea modificar: ");
            String dniUsuario = sc.nextLine();

            if(!dniUsuario.matches("[0-9]{8}[A-Z]")) {
                throw new DniNoValidaException("El formato del dni es incorrecto.");    
            } else {
                em.getTransaction().begin();
                Query query = em.createQuery("SELECT c FROM Cliente c  WHERE dni='" + dniUsuario + "'");
                Cliente clientebbdd = (Cliente) query.getSingleResult();
                
                //Trabajo directamente sobre el objeto cliente de la base de datos, pudiendo usar los setter y getter en lugar de sentencias JPQL.
                System.out.println("Introduzca el nuevo nombre: \n  Nombre actual: " + clientebbdd.getNombre());
                String nuevoNombre = sc.nextLine();
                clientebbdd.setNombre(nuevoNombre);
                
                System.out.println("Introduzca el nuevo email del cliente: \n  Mail actual: " + clientebbdd.getEmail());
                String nuevoEmail = sc.nextLine();
                if (!nuevoEmail.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                    throw new EmailNoValidaException("El formato del email no es valido.");
                } else {
                    clientebbdd.setEmail(nuevoEmail);
                }
                
                System.out.println("Introduzca el nuevo lugar de residencia: \n  Lugar de residencia actual: " + clientebbdd.getLugarResidencia());
                String nuevoLugarResidencia = sc.nextLine();
                clientebbdd.setLugarResidencia(nuevoLugarResidencia);
              
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

    /**
     * Modifica un alojamiento determinado.
     */
    public static void setInfoAlojamiento() {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/alojamientos.odb");
            EntityManager em = emf.createEntityManager();
            Scanner sc = new Scanner(System.in);

            System.out.println("Introduzca el nombre del alojamiento que desea modificar: ");
            String nombreAlojamientoUsuario = sc.nextLine();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT a FROM Alojamiento a WHERE nombre='" + nombreAlojamientoUsuario + "'");
            Alojamiento alojamientobbdd = (Alojamiento) query.getSingleResult();
           
            //Trabajo directamente sobre el objeto cliente de la base de datos, pudiendo usar los setter y getter en lugar de sentencias JPQL.
            System.out.println("Introduzca el nuevo nombre: \n  Nombre actual: " + alojamientobbdd.getNombre());
            String nuevoNombre = sc.nextLine();
            alojamientobbdd.setNombre(nuevoNombre);
                
            System.out.println("Introduzca la nueva capacidad de alojamiento: \n  Capacidad actual: " + alojamientobbdd.getCapacidad());
            int nuevaCapacidad = sc.nextInt();
            alojamientobbdd.setCapacidad(nuevaCapacidad);
            
            System.out.println("Introduzca la nueva tarifa por noche: \n Tarifa por noche actual: " + alojamientobbdd.getTarifa());
            double nuevaTarifa = sc.nextDouble();
            alojamientobbdd.setTarifa(nuevaTarifa);
                     
            System.out.println("¿Tiene chimenea?: (Si/No)");
            String chimenea = sc.nextLine().toLowerCase();
            if (chimenea.equals("si")) {
                alojamientobbdd.setTieneChimenea(true);
            } else {
                alojamientobbdd.setTieneChimenea(false);     
            }            
            
            System.out.println("¿Tiene jacuzzi?: (Si/No)");
            String jacuzzi = sc.nextLine().toLowerCase();
            if (jacuzzi.equals("si")) {
                alojamientobbdd.setTieneJacuzzi(true);
            } else {
                alojamientobbdd.setTieneJacuzzi(false);     
            }            
            em.getTransaction().commit();
            em.close();
            emf.close();
                
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (PersistenceException e) {
            System.out.println("Error de base de datos: " + e.getMessage());
            
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }   
    }    

    /**
     * Elimina un cliente de la base de datos.
     */    
    public static void eliminarCliente() {
        try {
            Scanner sc = new Scanner(System.in);
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/clientes.odb");
            EntityManager em = emf.createEntityManager();

            System.out.println("Introduzca el dni del cliente: ");
            String dniUsuario = sc.nextLine();

             if(!dniUsuario.matches("[0-9]{8}[A-Z]")) {
                throw new DniNoValidaException("El formato del dni es erroneo.");
            } else {
                em.getTransaction().begin();
                Query deleteCliente  = em.createQuery("DELETE FROM Cliente WHERE dni='" + dniUsuario + "'");
                int numeroObjetosBorrados = deleteCliente.executeUpdate();
                System.out.println("Se han eliminado "+numeroObjetosBorrados+" objetos.");
                em.getTransaction().commit();
            }  
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            
        } catch (PersistenceException e) {
            System.out.println("Error de base de datos: " + e.getMessage());
            
        } catch (NoSuchElementException e) {
            System.out.println("No existe un cliente con ese dni: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }   
    }
    
    /**
     * Elimina un alojamiento de la base de datos.
     */
    public static void eliminarAlojamiento() {
        try {
            Scanner sc = new Scanner(System.in);
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/alojamientos.odb");
            EntityManager em = emf.createEntityManager();

            System.out.println("Introduzca el nombre del alojamiento: ");
            String nombreAlojamientoUsuario = sc.nextLine();
            em.getTransaction().begin();
            Query deleteAlojamiento  = em.createQuery("DELETE FROM Alojamiento WHERE nombre='" + nombreAlojamientoUsuario + "'");
            int numeroObjetosBorrados = deleteAlojamiento.executeUpdate();
            System.out.println("Se han eliminado " + numeroObjetosBorrados + " objetos.");
            em.getTransaction().commit();
  
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            
        } catch (PersistenceException e) {
            System.out.println("Error de base de datos: " + e.getMessage());
            
        } catch (NoSuchElementException e) {
            System.out.println("No existe un alojamiento con ese nombre: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }   
    }   
    
    /**
     * Elimina todos los registros de la base de datos de clientes.
     */
    public static void eliminarClientesBBDD() {
        try {
            Scanner sc = new Scanner(System.in);
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/clientes.odb");
            EntityManager em = emf.createEntityManager();

            System.out.println("Esta seguro de que desea borrar la base de datos: (Y - si, N - no)");
            String opcion = sc.next().toUpperCase();
            if (opcion.equals("Y")) {
                em.getTransaction().begin();
                Query borradoClientes = em.createNamedQuery("borrarTodosLosClientes");
                borradoClientes.executeUpdate();
                em.getTransaction().commit();
                System.out.println("La base de datos ha sido borrada.");
            } 
        } catch (InputMismatchException | EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }       
    }    
    
    /**
     * Elimina todos los registros de la base de datos de alojamientos.
     */
    public static void eliminarAlojamientosBBDD() {
        try {
            Scanner sc = new Scanner(System.in);
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/alojamientos.odb");
            EntityManager em = emf.createEntityManager();

            System.out.println("Esta seguro de que desea borrar la base de datos: (Y - si, N - no)");
            String opcion = sc.next().toUpperCase();
            if (opcion.equals("Y")) {
                em.getTransaction().begin();
                Query borradoAlojamientos = em.createNamedQuery("borrarTodosLosAlojamientos");
                borradoAlojamientos.executeUpdate();
                em.getTransaction().commit();
                System.out.println("La base de datos ha sido borrada.");
            } 
        } catch (InputMismatchException | EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }       
    }    
    
    /**
     * Mensaje de salida y cierra el programa.
     */
    public static void cerrarBBDD() {
            System.out.println("************************************************************************************");
            System.out.println("* Sesion de Javitos cerrada...");
            System.out.println("************************************************************************************");        
            return;
    }
}

