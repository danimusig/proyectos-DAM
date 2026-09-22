package dam1_dmunsig_ListaArray;

import java.util.Arrays;

/**
 * Clase ListaNumerica: 
 * @author dmunsig
 * @version 1.0
 * @see String
 */
public class ListaNumerica implements Lista {

    /**
     * El tamanyo maximo del array.
     */
    public final int TAM_MAX = 100;
    
    /**
     * Guarda una lista de numeros.
     */
    public int[] lista; //Utilizo int para que el array pueda tener valores null y que cuente al 0 como valor.
    
    /**
     * Cantidad de objetos que guarda el array lista[]. 
     */
    public int tamanyo;
    
    /**
     * Constructor Principal.
     * @param lista Lista de enteros.
     */
    public ListaNumerica() {
        this.lista = new int[TAM_MAX];
        this.tamanyo = 0;
    }

    /**
     * Obtiene los espacios ocupados en el array.
     * @return Los espacios ocupados del array en un entero.
     */
    @Override
    public int getTamanyo() { 
        return this.tamanyo;
    }

    /**
     * Inserta un valor al final del array.
     * @param valor El valor a insertar al final del array.
     */
    @Override
    public void insertarAlFinal(int valor) {
        if (this.tamanyo < TAM_MAX) { 
           this.lista[this.tamanyo] = valor;
           this.tamanyo++;
           System.out.println("SE pudo insertar " + valor + " al final de la this.lista.");
        } else {
            System.out.println("NO se pudo insertar, el array está completo.");
        }       
    }   

    /**
     * Inserta un valor al principio del array.
     * @param valor El valor a insertar al princpio del array.
     */
    @Override
    public void insertarAlPrincipio(int valor) {          
        if (this.tamanyo < TAM_MAX) { 
           System.arraycopy(this.lista, 0, this.lista, 1, (this.tamanyo));
           this.lista[0] = valor;
           this.tamanyo++;
           System.out.println("SE pudo insertar el valor " + valor + " en la posicion 0 del array");
        } else {
           System.out.println("NO se pudo insertar el, array está completo");
        }
    }    

    /**
     * Inserta en la posicion X un valor en el array.
     * @param posicion La posicion del array donde se insertara el valor.
     * @param valor El valor a insertar en la posicion X del array.
     */
    @Override
    public void insertarEnLaPosicion(int posicion, int valor) {   
        if (this.tamanyo>=TAM_MAX) {
            System.out.println("NO se pudo insertar, el array esta completo");
            return;
        }
        
        if (posicion < 0 || posicion > this.tamanyo) {
            System.out.println("Posicion fuera de rango");
            return;
        }
       
        for (int i = this.tamanyo; i >= posicion;i-- ) {
            this.lista[i] = this.lista[i - 1];
        }
        
        this.lista[posicion] = valor;
        this.tamanyo++;
    }
    
    /**
     * Elimina la primera entrada del array.
     */
    @Override
    public void eliminarLaPrimera() {
        if (this.tamanyo == 0) {
            System.out.println("La lista ya esta vacia");
            return;
        }
        
        int primerElemento = this.lista[0]; 
        
        for (int i = 0; i < this.tamanyo -1;i++) {
            this.lista[i] = this.lista[i + 1];
        }
        
        System.out.println("SE elimino el valor " + primerElemento +" de la primera posicion.");
        this.tamanyo--;
    }

    /**
     * Elimina la ultima entrada del array.
     */
    @Override
    public void eliminiarLaUltima() {
        if (this.tamanyo == 0) {
            System.out.println("La lista ya esta vacia.");
            return;
        }
        
        int elementoFinal = this.lista[this.tamanyo - 1];
        
        this.lista[this.tamanyo - 1] = 0;
        this.tamanyo--;
        
        System.out.println("SE elimino el valor " + elementoFinal + " de la ultima posicion en la lista.");
    }
    
    /**
     * Elimina la entrada en la posicion X del array.
     * @param posicion La posicion a la cual se le eliminara el valor.
     */
    @Override
    public void eliminar(int posicion) {
        if (tamanyo == 0) {
            System.out.println("La lista ya esta vacia.");
            return;
        }
        
        if (posicion < 0 || posicion >= this.tamanyo) {
            System.out.println("Error: La posición " + posicion + " no es válida.");
            return;
        }
        
        int elementoPosicion = lista[posicion];
        for (int i = posicion; i < tamanyo - 1; i++) {
            this.lista[i] = lista[i + 1];
        }
        
        tamanyo--;
        System.out.println("SE borro " + elementoPosicion + " de la posicion " + posicion + " en la lista.");
    }  

    /**
     * Busca X valor dentro del array. 
     * @param n El valor a buscar dentro del array.
     * @return El valor si está en el array, -1 si no existe.
     */
    @Override
    public int buscar(int n) {        
        if (n < this.tamanyo || n < 0) {
            return this.lista[n];
        } else {
            System.out.println("La posicion no existe en el array, la posicion mas alta es: " + (this.tamanyo - 1));
            return -1;
        }
    }
    
    /**
     * Concatena dos arrays.
     * @param lista2 EL array a concatenar.
     */
    @Override
    public void unirDosListas(Lista lista2) {
        if (this.tamanyo + lista2.getTamanyo() > TAM_MAX) {
            System.out.println("El tamaño de los dos arrays juntos es mayor que la capacidad maxima");
        } else {
            ListaNumerica listaAux = (ListaNumerica) lista2;
            for (int i=0; i < lista2.getTamanyo(); i++) {
                this.lista[this.tamanyo] = listaAux.lista[i];
                this.tamanyo++;
            }
        }
        
        System.out.println(imprimirLista());
    }

    /**
     * Imprime los valores del array.
     * @return Los valores del array en una string.
     */
    @Override
    public String imprimirLista() {
       return Arrays.toString(Arrays.copyOfRange(this.lista, 0, this.tamanyo));//Uso el metodo copyOfRange('Array', 'comienzo de rango', 'final de rango') dentro del metodo .toString para imprimir solo lo necesario.
    }
    
    /**
     * Muestra informacion sobre el array y su contenido.
     * @return Informacion sobre el array en una cadena de caracteres.
     */
    @Override
    public String toString() {
        return "Lista completa: \n" + imprimirLista();
    }
}
