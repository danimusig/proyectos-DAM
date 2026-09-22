package DAM1.DanielMS_pe05_museo;

/**
 * Clase Administrativo: Clase hijo de Trabajador donde se guardan atributos y metodos especificos para gestionar datos de los administradores.
 * @author DanielMS
 * @version 1.0
 * @see String
 */
public class Administrativo extends Trabajador {
    
    /**
     * Las horas a trabajar del administrarivo.
     */
    private int numHoras;
    
    /**
     * El horario del administrativo.
     */
    private String horario;

    /**
     * Constructor Principal.
     * @param nombre El nombre del administrativo en una cadena de caracteres.
     * @param DNI El DNI del administrativo en una cadena de caracteres.
     * @param cuentaBanco El numero de cuenta del adminitrativo en una cadena de caracteres.
     * @param numHoras Las horas a trabajar del adminitrativo en un entero.
     * @param horario El horario del administratico en una cadena de caracteres.
     */
    public Administrativo(String nombre, String DNI, String cuentaBanco, int numHoras, String horario) {
        super(nombre, DNI, cuentaBanco);
        
        this.numHoras = numHoras;
        
        this.horario = horario;
    }
        
    /**
     * Obtiene el numero de horas a trabajar del administrativo.
     * @return El numero de horas en un entero.
     */
    public int getNumHoras() {
        return this.numHoras;
    }
    
    /**
     * Obtiene el horario del administrativo.
     * @return El horario del administrativo en una cadena de caracteres.
     */
    public String getHorario() {
        return this.horario;
    }        
    
    /**
     * Modifica las horas a atrabajar del administrativo.
     * @param nuevaHoras Las nuevas horas en un entero.
     */
    public void setNumHoras(int nuevaHoras) {
        this.numHoras = nuevaHoras;
    }
    
    /**
     * Modifica el horario del administrativo.
     * @param nuevoHorario El nuevo horario del administrarivo en una cadena de caracteres.
     */
    public void setHorario(String nuevoHorario) {
        this.horario = nuevoHorario;
    }
    
    /**
     * Obtiene informacion sobre el administrativo.
     * @return Informacion sobre el administrativo en una cadena de caracteres.
     */
    public String toString() {
        return "\n>- Datos del administrativo -<" + super.toString() + "\n Horas de este mes: " + this.numHoras + "\n Horario: " + this.horario;
    }
}
