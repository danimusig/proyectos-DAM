package com.mycompany._pe04_ejercicio11.maquinaria;

import com.mycompany._pe04_ejercicio11.personal.Mecanico;

/**
 * Clase Locomotora: Almacena y modifica datos sobre una locomotora.
 * @author DanielMS
 * @version 1.0
 * @see String
 * @see Mecanico
 */
public class Locomotora {
    /**
     * La matricula de la locomotora.
     */
    private int matricula;
    
    /**
     * La potencia del motor de la locomotora.
     */
    private int potenciaMotor;
    
    /**
     * El anyo de fabricacion de la locomotora.
     */
    private int anyoFabricacion;
    
    /**
     * El mecanico asignado al mantenimiento de la locomotora.
     */
    private Mecanico mecanicoLocomotor;
    
    /**
     * Constructor Principal
     * @param matricula La matricula de la locomotora en una cadena de caracteres.
     * @param potenciaMotor La potencia del motor en caballos.
     * @param anyoFabricacion El anyo de fabricacion en anyos.
     * @param mecanicoLocomotor El mecanico de la locomotora en un objeto de la clase Mecanico.
     */
    public Locomotora(int matricula, int potenciaMotor, int anyoFabricacion, Mecanico mecanicoLocomotor) {
        this.matricula = matricula;
        
        this.potenciaMotor = potenciaMotor;
        
        this.anyoFabricacion = anyoFabricacion;
        
        this.mecanicoLocomotor = mecanicoLocomotor;
    }
    
    /**
     * Modifica la matricula de la locomotora.
     * @param nuevaMatricula La nueva matricula en una cadena de caracteres.
     */
    public void setMatricula(int nuevaMatricula) {
        this.matricula = nuevaMatricula;
    }
    
    /**
     * Modifica la potencia del motor de la locomotora.
     * @param nuevaPotenciaMotor La nueva potencia del motor en caballos.
     */
    public void setPotenciaMotor(int nuevaPotenciaMotor) {
        this.potenciaMotor = nuevaPotenciaMotor;
    }
    
    /**
     * Modifica el anyo de fabricacion de la locomotora.
     * @param nuevoAnyoFabricacion El nuevo anyo de fabricacion en anyos.
     */
    public void setAnyofabricacion(int nuevoAnyoFabricacion) {
        this.anyoFabricacion = nuevoAnyoFabricacion;
    }
    
    /**
     * Modifica el mecanico de la locomotora.
     * @param nuevoMecanico El nuevo mecanico en un objeto de la clase Mecanico.
     */
    public void setMecanico (Mecanico nuevoMecanico) {
        this.mecanicoLocomotor = nuevoMecanico;
    }
    
    /**
     * Obtiene la matricula de la locomotora.
     * @return La matricula representada en una cadena de caracteres.
     */
    public int getMatricula() {
        return this.matricula;
    }
    
    /**
     * Obtiene la potencia del motor de la locomotora.
     * @return La potencia del motor representada en caballos.
     */
    public int getPotenciaMotor() {
        return this.potenciaMotor;
    }
    
    /**
     * Obtiene el anyo de fabricacion de la locomotora.
     * @return El anyo de fabricacion representado en anyos.
     */
    public int getAnyoFabricacion() {
        return this.anyoFabricacion;
    }
    
    /**
     * Obtiene el mecanido de la locomotora.
     * @return El mecanido representado en un objeto de la clase Mecanico.
     */
    public Mecanico getMecanicoLocomotor() {
        return this.mecanicoLocomotor;
    }    
    
}
