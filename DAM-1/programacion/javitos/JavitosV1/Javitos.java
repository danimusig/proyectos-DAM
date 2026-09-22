package dam1_dmusig_Javitos;

import java.util.Arrays;

/**
 * Clase Javitos: Gestiona los clientes y los alojamientos del complejo.
 *
 * @author dmunsig
 * @version 1.0
 * @see String
 * @see Arrays
 * @see Alojamiento
 * @see Cliente
 */
public class Javitos {

    /**
     * Los alojamientos del complejo.
     */
    private Alojamiento[] alojamientos = new Alojamiento[15];

    /**
     * Los clientes que han usado las instalaciones.
     */
    private Cliente[] clientes = new Cliente[100];

    /**
     * El numero de alojamientos totales.
     */
    private int numAlojamientos;

    /**
     * El numero de clientes totales.
     */
    private int numClientes;

    /**
     * Contructor princiapal.
     * @param alojamientos Los alojamientos del complejo en un array de alojamientos.
     * @param clientes Los clientes del complejo en un array de alojamientos.
     */
    public Javitos(Alojamiento[] alojamientos, Cliente[] clientes) {
        this.alojamientos = alojamientos;
        this.clientes = clientes;
        
        //Recorro los arrays para ver el numero de alojamientos y clientes.
        for (int i = 0;i < this.clientes.length;i++) {
            if (this.clientes[i] != null) {
                this.numClientes++; 
            }    
        }
        
        for (int i = 0;i < this.alojamientos.length;i++) {
            if (this.alojamientos[i] != null) {
                this.numAlojamientos++; 
            }    
        }        
    }

    /**
     * Da de alta a un cliente en el sistema.
     * @param nuevoCliente
     */
    public void altaCliente(Cliente nuevoCliente) {
        if (numClientes >= clientes.length) {
            System.out.println("La lista de clientes esta completo.");
            return;
        }

        this.clientes[this.numClientes] = nuevoCliente;
        System.out.println("El cliente " + nuevoCliente.getDni() + " ha sido registrado, hay un total de " + this.numClientes);

        this.numClientes++;
    }

    /**
     * Da de baja a un cliente en el sistema.
     * @param clienteBaja El cliente a añadir al sistema.
     */
    public void bajaCliente(String dni) {
        if (numClientes == 0) {
            System.out.println("No hay clientes registrados en el sistema.");
            return;
        }

        int posicionClienteBaja = -1; //Inicio la variable en -1 ya que los arrays empiezan desde 0.
        
        //Recorro el array con un bucle comparando los dni de los clientes registrados con el que se busca.
        for (int i = 0; i < this.numClientes; i++) {
            if (this.clientes[i].getDni().equals(dni)) {
                posicionClienteBaja = i;
                break;
            }
        }
        
        //Si la posicion sigue siendo -1 significa que el objeto no existe en el array y el metodo termina.
        if (posicionClienteBaja == -1) {
            System.out.println("El cliente no existe en el sistema.");
            return;
        }
        
        //Comenzando desde la posicion del valor se van moviendo los datos hacia la derecha dejando el hueco libre, luego el ultimo valor se borra.
        if (posicionClienteBaja != -1) {
            for (int i = posicionClienteBaja; i < this.numClientes - 1; i++) {
                this.clientes[i] = this.clientes[i + 1];
            }
        }
        
        //Le doy valor null a la ultima posicion para asi poder borrarla al quitarle tamaño al array.
        this.clientes[numClientes - 1] = null;
        this.numClientes--;
        System.out.println("Se elimino al cliente con DNI " + dni + " de la posicion " + posicionClienteBaja + " en la lista.");
    }

    /**
     * Añade un alojamiento al sistema.
     * @param nuevoAlojamiento El alojamiento a añadir al sistema.
     */
    public void altaAlojamiento(Alojamiento nuevoAlojamiento) {
        if (this.numAlojamientos >= this.alojamientos.length) {
            System.out.println("El array esta completo.");
            return;
        }

        this.alojamientos[this.numAlojamientos] = nuevoAlojamiento;
        System.out.println("El alojamiento " + nuevoAlojamiento.getNombre() + " ha sido registrado.");

        this.numAlojamientos++;
    }

    /**
     * Quita del sistema un alojamiento.
     * @param alojamientoBaja El alojamiento que se quiere quitar del sistema.
     */
    public void bajaAlojamiento(String nombreAlojamiento) {
        //Control de errores
        if (numAlojamientos == 0) {
            System.out.println("No hay alojamientos registrados en el sistema.");
            return;
        }

        int posicionAlojamientoBaja = -1; //Inicio la variable en -1 ya que los arrays empiezan en 0

        //Recorro el array con un bucle comparando los nombres de los alojamientos registrados con el que se busca.
        for (int i = 0; i < this.numClientes; i++) {
            if (this.alojamientos[i].getNombre().equals(nombreAlojamiento)) {
                posicionAlojamientoBaja = i;
                break;
            }
        }

        //Si la posicion sigue siendo -1 significa que no hay una posocion asocioada al dato y se termina de ejecutar el metodo.
        if (posicionAlojamientoBaja == -1) {
            System.out.println("El cliente no existe en el sistema.");
            return;
        }
        
        //Comenzando desde la posicion del valor se van moviendo los datos hacia la derecha dejando el hueco libre, luego el ultimo valor se borra.
        if (posicionAlojamientoBaja != -1) {
            for (int i = posicionAlojamientoBaja; i < this.numAlojamientos - 1; i++) {
                this.alojamientos[i] = this.alojamientos[i + 1];
            }
        }
        
        //Le doy valor null a la ultima posicion para asi poder borrarla al quitarle tamaño al array.
        this.alojamientos[numAlojamientos - 1] = null;
        this.numAlojamientos--;
        System.out.println("Se elimino al alojamiento " + nombreAlojamiento + " de la posicion " + posicionAlojamientoBaja + " en la lista.");
    }
    
    /**
     * Lista los clientes ordenados alfabeticamente.
     */
    public void listadoClientes() {
        //Control de errores.
        if (numClientes == 0) {
            System.out.println("No hay clientes registrados en el sistema.");            
        } else {
            //Copio el array para no modifical el orden en el original.
            Cliente[] copiaClientes = new Cliente[numClientes];
            for (int i = 0; i < numClientes; i++) {
            copiaClientes[i] = this.clientes[i];
            }
            //Ordeno por el nombre por defecto ya que es el parametro que usa el compareTo() de la clase Cliente.
            Arrays.sort(copiaClientes);
            for (int i = 0; i < numClientes; i++) {
                System.out.println(copiaClientes[i].toString());
            }
        }
    }

    /**
     * Lista los alojamientos ordenados alfabeticamente.
     */
    public void listadoAlojamientos() {
        //Control de errores.
        if (numAlojamientos == 0) {
            System.out.println("No hay alojamientos registrados en el sistema.");
        } else {
            //Copio el array para no alteral el orden del array original.
            Alojamiento[] copiaAlojamientos = new Alojamiento[numClientes];
            for (int i = 0; i < numClientes; i++) {
            copiaAlojamientos[i] = this.alojamientos[i];
            }
            //Ordeno por el nombre por defecto ya que es el parametro que usa el compareTo() de la clase Alojamiento.
            Arrays.sort(copiaAlojamientos);
            for (int i = 0; i < numAlojamientos; i++) {
                System.out.println(copiaAlojamientos[i].toString());
            }
        }
    }
    
    /**
     * LIsta los clientes ordenados por mayor cantidad de veces alojado.
     */
    public void topClientes() {    
        //Control de errores.
        if (numClientes == 0) {
            System.out.println("No hay clientes registrados en el sistema");
        } else {
            //Copio el array con el tamaño actual para no modificar el orden del original.
            Cliente[] copiaClientes = new Cliente[numClientes];
            for (int i = 0; i < numClientes; i++) {
                copiaClientes[i] = this.clientes[i];
            }

            //Ordeno usando bubble sort de mayor a menor.
            for (int i = 0; i < copiaClientes.length - 1; i++) {
                for (int j = 0; j < copiaClientes.length - i - 1; j++) {
                    if (copiaClientes[j].getVecesAlojado() < copiaClientes[j + 1].getVecesAlojado()) {
                        Cliente temp = copiaClientes[j];
                        copiaClientes[j] = copiaClientes[j + 1];
                        copiaClientes[j + 1] = temp;
                    }
                }       
            }
        
            //Imprimo por pantalla el array ordenado.
            System.out.println("<-- CLIENTES ORDENADOS POR CANTIDAD DE VECES HOSPEDADO -->");
            for (int i = 0; i < copiaClientes.length; i++ ) {
                System.out.println("Nº" + i + " : " + copiaClientes[i].getNombre() + ", veces alojado: " + copiaClientes[i].getVecesAlojado());
            }
        }   
    }     

    /**
     * Lista los alojamientos ordenados por cantidad de veces alquilado.
     */
    public void topAlojamientos() {
        //Control de errores.
        if (numAlojamientos == 0) {
            System.out.println("No hay alojamientos registrados en el sistema");
            return;
        } else {
            //Copio el array con el tamaño actual para no modificar el orden del original.
            Alojamiento[] copiaAlojamientos = new Alojamiento[this.numAlojamientos];
            for (int i = 0; i < this.numAlojamientos; i++) {
                copiaAlojamientos[i] = this.alojamientos[i];
            }

            //Ordeno usando bubble sort de mayor a menor segun las veces alquilado usando el metodo getVecesAlquilado para acceder a su valor.
            for (int i = 0; i < copiaAlojamientos.length - 1; i++) {
                for (int j = 0; j < copiaAlojamientos.length - i - 1; j++) {
                    if (copiaAlojamientos[j].getVecesAlquilado() < copiaAlojamientos[j + 1].getVecesAlquilado()) {
                        Alojamiento temp = copiaAlojamientos[j];
                        copiaAlojamientos[j] = copiaAlojamientos[j + 1];
                        copiaAlojamientos[j + 1] = temp;
                    }
                }       
            }
            
            //Imprimo por pantalla el array ordenado.
            System.out.println("<-- ALOJAMIENTOS ORDENADOS POR SU POPULARIDAD -->");
            for (int i = 0; i < copiaAlojamientos.length; i++ ) {
                System.out.println("Nº" + i + " : " + copiaAlojamientos[i].getNombre() + " veces alquilado: " + copiaAlojamientos[i].getVecesAlquilado());
            }
        }        
    }        
}
