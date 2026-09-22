package DAM1.DanielMS_pe05_JerarquiaDeFiguras;

/**
 * Clase Pizarra: Modifica y almacena datos sobre una pizarra y sus figuras.
 * @author DanielMS
 * @version 1.0
 * @see String
 * @see Figura
 */
public class Pizarra {
    
    /**
     * La primera figura de la pizarra.
     */
    private Figura figura1;
    
    /**
     * La segundo figura de la pizarra.
     */
    private Figura figura2;
    
    /**
     * La tercera figura de la pizarra.
     */
    private Figura figura3;

    /**
     * Constructor Principal.
     * @param figura1 La primera figura de la pizarra en un objeto Figura.
     * @param figura2 La segunda figura de la pizarra en un objeto Figura.
     * @param figura3 La tercera figura de la pizarra en un objeto Figura.
     */
    public Pizarra(Figura figura1, Figura figura2, Figura figura3) {
        this.figura1 = figura1;
        
        this.figura2 = figura2;
        
        this.figura3 = figura3;
    }

    /**
     * Obtiene la primera figura de la pizarra.
     * @return La figura en un objeto Figura.
     */
    public Figura getFigura1() {
        return figura1;
    }

    /**
     * Modifica la primera figura de la pizarra.
     * @param nuevaFigura1 La nueva figura en un objeto Figura.
     */
    public void setFigura1(Figura nuevaFigura1) {
        this.figura1 = nuevaFigura1;
    }

    /**
     * Obtiene la segunda figura de la pizarra.
     * @return La figura en un objeto Figura.
     */
    public Figura getFigura2() {
        return figura2;
    }

    /**
     * Modifica la segunda figura de la pizarra.
     * @param nuevaFigura2 La nueva figura en un objeto Figura.
     */
    public void setFigura2(Figura nuevaFigura2) {
        this.figura2 = nuevaFigura2;
    }

    /**
     * Obtiene la tercera figura de la pizarra.
     * @return La figura en un objeto Figura.
     */
    public Figura getFigura3() {
        return figura3;
    }

    /**
     * Modifica la tercera figura de la pizarra.
     * @param nuevaFigura3 La nueva figura en un objeto Figura.
     */
    public void setFigura3(Figura nuevaFigura3) {
        this.figura3 = nuevaFigura3;
    }
    
    /**
     * Obtiene informacion sobre la pizarra.
     * @return Informacion sobre la pizarra en una cadena de caracteres.
     */
    public String toString() {
        return "Hay 3 figuras en la pizarra: \n Primera figura: " + this.figura1 + "\n Segunda figura: " + this.figura2 + " \n Tercera figura: " + this.figura3;
    }
    
    /**
     * Borra la primera figura dandole el valor null.
     */
    public void borrarFigura1() {
        this.figura1 = null;
    }
    
    /**
     * Borra la segunda figura dandole el valor null.
     */
    public void borrarFigura2() {
        this.figura2 = null;
    }

    /**
     * Borra la tercera figura dandole el valor null.
     */
    public void borrarFigura3() {
        this.figura3 = null;
    }    
}
