package DAM1.DanielMS_pe05_museo;

/**
 * Clase Vigilante: Clase hijo de Trabajador donde se guardan atributos y metodos específicos para gestionar datos sobre los vigilantes.
 * @author DanielMS
 * @version 1.0
 * @see String
 */
public class Vigilante extends Trabajador {
    
    /**
     * El numero de licencia de arma del vigilante.
     */
    private final int numLicenciaArma;
    
    /**
     * Contructor Principal.
     * @param nombre El nombre del vigilante en una cadena de caracteres.
     * @param DNI El DNI del vigilante en una cadena de caracteres.
     * @param cuentaBancaria El numero de cuenta del vigilante en una cadena de caracteres.
     * @param numLicenciaArma El numero de licencia de arma del vigilante en un entero.
     */
    public Vigilante(String nombre, String DNI, String cuentaBancaria, int numLicenciaArma) {
        super(nombre, DNI, cuentaBancaria);
        
        this.numLicenciaArma = numLicenciaArma;
    }
    
    /**
     * Obtiene el numero de licencia de arma del vigilante.
     * @return El numero de licencia de arma en un entero.
     */
    public int getNumLicenciaArmas() {
        return this.numLicenciaArma;
    }
    
    /**
     * Obtiene informacion sobre el vigilante.
     * @return Informacion sobre el vigilante en una cadena de caracteres.
     */
    public String toString() {
        return "\n>- Datos del Vigilante -<" + super.toString() + "\n Licencia de armas: " + this.numLicenciaArma;
    }
    
}
