package dam1_dmunsig_ListaArray;

/**
 * Interface Lista: Esta interface guarda metodos relacionados con el manejo de listas en Java.
 * @author dmunsig
 * @version 1.0
 * @see String;
 */

public interface Lista {

    /**
     * Obtiene el tamaño total de la lista.
     * @return El tamanyo de la lista en un entero. 
     */
    public int getTamanyo();
    
    /**
     * Inserta un objeto/valor al final de la lista.
     * @param valor El objeto/valor a insertar al final de la lista.
     */
    public void insertarAlFinal(int valor);
    
    /**
     * Inserta un objeto/dato la principio de la lista.
     * @param valor El objeto/dato a insertar al principio de la lista.
     */
    public void insertarAlPrincipio(int valor);
    
    /**
     * Inserta un objeto/dato en la posicion X de la lista.
     * @param posicion La posicion en la que el objeto/dato sera insertado.
     * @param valor El objeto/dato que sera insertado.
     */
    public void insertarEnLaPosicion(int posicion, int valor);
    
    /**
     * Elimila el primer objeto/dato de la lista.
     */
    public void eliminarLaPrimera();
    
    /**
     * Elimila el ultimo objeto/dato de la lista.
     */
    public void eliminiarLaUltima();
    
    /**
     * ELimina el objeto/dato en la posicion X de la lista.
     * @param posicion La posicion del objeto/dato que sera eliminado.
     */
    public void eliminar(int posicion);
    
    /**
     * Devuelve la posicion en la lista del objeto/dato X.
     * @param n La posicion del objeto/dato en la lista.
     * @return El objeto/dato de la lista en la posicion n.
     */
    public int buscar(int n); //Devuelve la posicion
    
    /**
     * Concatena dos listas.
     * @param lista2 La lista que va a ser concatenada.
     */
    public void unirDosListas(Lista lista2);
    
    /**
     * Muestra todos los objetos/datos guardados de la lista.
     * @return Todos los objetos/datos guardados de la lista en una cadena.
     */
    public String imprimirLista();

}
