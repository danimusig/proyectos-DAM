package com.mycompany._pe04_ejercicio11.maquinaria;

/**
 * Clase Tren: Almacena y modifica la locomotora y los vagones asignados a un tren.
 * @author DanielMS
 * @version 1.0
 * @see Locomotora
 * @see Vagon
 */
public class Tren {
    /**
     * La locomotora del tren.
     */
    private Locomotora locomotora;
    
    /**
     * El primer vagon del tren.
     */
    private Vagon vagon_1;
    
    /**
     * El segundo vagon del tren.
     */
    private Vagon vagon_2;
    
    /**
     * El tercer vagon del tren.
     */
    private Vagon vagon_3;
    
    /**
     * Constructor Principal.
     * @param locomotora1 
     * @param vagon_1
     * @param vagon_2
     * @param vagon_3 
     */
    public Tren(Locomotora locomotora1, Vagon vagon_1, Vagon vagon_2, Vagon vagon_3) {
        this.locomotora = locomotora;
        
        this.vagon_1 = vagon_1;
        
        this.vagon_2 = vagon_2;
        
        this.vagon_3 = vagon_3;
    }
    
    /**
     * Modifica la locomotora del tren.
     * @param nuevaLocomotora La locomotora del tren en un objeto de la clase Locomotora.
     */
    public void setLocomotora(Locomotora nuevaLocomotora) {
        this.locomotora = nuevaLocomotora;
    }
    
    /**
     * Modifica el primer vagon del tren.
     * @param nuevoVagon_1 El primer vagon en un objeto de la clase VAgon.
     */
    public void setVagon_1( Vagon nuevoVagon_1) {
        this.vagon_1 = nuevoVagon_1;
    }
    
    /**
     * Modifica el segundo vagon del tren.
     * @param nuevoVagon_2 El segundo vagon en un objeto de la clase VAgon.
     */
    public void setVagon_2( Vagon nuevoVagon_2) {
        this.vagon_2 = nuevoVagon_2;
    }
    
    /**
     * Modifica el tercer vagon del tren.
     * @param nuevoVagon_3 El tercer vagon en un objeto de la clase Vagon.
     */   
    public void setVagon_3( Vagon nuevoVagon3) {
        this.vagon_3 = nuevoVagon3;
    }        
    
    /**
     * Obtiene la locomotora del tren.
     * @return La locomotora del tren representada en un objeto de la clase Locomotor.
     */
    public Locomotora getlocomotora() {
        return this.locomotora;
    }
    
    /**
     * Obtiene el primer vagon del tren.
     * @return El primer vagon del tren en un objeto de la clase Vagon.
     */
    public Vagon getVagon_1() {
        return this.vagon_1;        
    }
    
    /**
     * Obtiene el segundo vagon del tren.
     * @return El segundo vagon del tren en un objeto de la clase Vagon.
     */
    public Vagon getVagon_2() {
        return this.vagon_2;
    }
    
    /**
     * Obtiene el tercer vagon del tren.
     * @return El tercer vagon del tren en un objeto de la clase Vagon.
     */
    public Vagon getVagon_3() {
        return this.vagon_3;
                
    }
}
