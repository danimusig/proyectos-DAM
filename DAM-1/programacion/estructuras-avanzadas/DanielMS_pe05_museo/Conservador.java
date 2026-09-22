package DAM1.DanielMS_pe05_museo;

/**
 * Clase Conservador: Clase hijo de Trabajador donde se guardan atributos y metodos específicos para gestionar datos sobre los conservadores.
 * @author DanielMS
 * @version 1.0
 * @see String
 */
public class Conservador extends Trabajador {
    
    /**
     * Constructor Principal.
     * @param nombre El nombre del conservador en una cadena de caracteres.
     * @param DNI El DNI del conservador en una cadena de caracteres.
     * @param cuentaBanco El numero de cuenta del banco del conservador en una cadena de caracteres.
     */
    public Conservador(String nombre, String DNI, String cuentaBanco) {
        super(nombre, DNI, cuentaBanco);
    }
    
    /**
     * Obtiene informacion sobre el conservador.
     * @return Informacion sobre el conservador en una cadena de caracteres.
     */
    public String toString() {
        return "\n>- Datos del Conservador -< " + super.toString();
    }
}
