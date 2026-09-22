package pkg2026.pkg3.pkg5.pe10_bbddoo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 *
 * @author dmunsig
 */
@NamedQuery (name="listadoVehiculo", query="SELECT v FROM Vehiculo v")
@NamedQuery (name="borrarTodosLosVehiculos", query="DELETE FROM Vehiculo v")

@Entity public class Vehiculo implements Serializable {
    @Id protected String matricula;
    private String marca;
    private String modelo;
    private int numPlazas;
    private List<String> extras;

    public Vehiculo(String matricula, String marca, String modelo, int numPlazas, List<String> extras) throws IllegalArgumentException{
        if (!matricula.matches("[0-9]{4}-[A-Z]{3}")) {
            throw new IllegalArgumentException("El formato de la matricula es erroneo (DDDD-LLL)");    
        } else {
            this.matricula = matricula;
        }
        this.marca = marca;
        this.modelo = modelo;
        if (numPlazas <= 0) {
            throw new IllegalArgumentException("Las plazas no pueden ser 0 o negativas.");
        } else {
            this.numPlazas = numPlazas;
        }
        this.extras = extras;
    }
    
    public Vehiculo() {
        
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        if (!matricula.matches("[0-9]{4}-[A-Z]{3}")) {
            throw new IllegalArgumentException("El formato de la matricula es erroneo (DDDD-LLL)");    
        } else {
            this.matricula = matricula;
        }    
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getNumPlazas() {
        return numPlazas;
    }

    public void setNumPlazas(int numPlazas) {
        if (this.numPlazas <= 0) {
            throw new IllegalArgumentException("Las plazas no pueden ser 0 o negativas.");
        } else {
            this.numPlazas = numPlazas;
        }   
    }

    public List<String> getExtras() {
        return extras;
    }

    public void setExtras(List<String> extras) {
        this.extras = extras;
    }
    
    public String toString() {
        return "\n************************************************************************************"
                + "\n*** Datos del Vehiculo: " + this.matricula 
                + "\n* Marca: " + this.marca + " \n* Modelo: " + this.modelo 
                + "\n* Plazas: " + this.numPlazas + "\n* Extras : " + this.extras
                + "\n************************************************************************************";
    }        
}
