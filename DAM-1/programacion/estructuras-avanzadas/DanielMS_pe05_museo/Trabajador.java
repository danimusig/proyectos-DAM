package DAM1.DanielMS_pe05_museo;

/**
 * Clase Trabajador: Contiene los atributos y metodos comunes entre los trabajadores del museo.
 * @author DanielMS
 * @version 1.0
 * @see String
 */
public class Trabajador {
    
    /**
     * El nombre del trabajador.
     */
    private String nombre;
    
    /**
     * El DNI del trabajador.
     */
    private final String DNI;
    
    /**
     * El numero de cuenta de banco del trabajador. 
     */
    private String cuentaBanco;    
    
    /**
     * Constructor principal.
     * @param nombre El nombre del trabajador en una cadena de caracteres.
     * @param DNI El DNI del trabajador en una cadena de caracteres.
     * @param cuentaBanco El numero de cueneta del banco en una candena de caracteres.
     */
    public Trabajador (String nombre, String DNI, String cuentaBanco) {
        this.nombre = nombre;
        
        this.DNI = DNI;
        
        this.cuentaBanco = cuentaBanco;
    }
    
    /**
     * Obtiene el nombre del trabajador.
     * @return El nombre en una cadena de caracteres.
     */
    public String getNombre() {
        return this.nombre;
    }
    
    /**
     * Obtiene el DNI del trabajador.
     * @return EL DNI en una cadena de caracteres.
     */
    public String getDNI() { 
        return this.DNI;
    }
    
    /**
     * Obtiene el numero de cuenta del trabajador.
     * @return El numero de cuenta en una cadena de caracteres.
     */
    public String getCuentaBanco() {
        return this.cuentaBanco;
    }
    
    /**
     * Modifica el nombre del trabajador.
     * @param nuevoNombre El nuevo nombre en una cadena de caracteres.
     */
    public void setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }
    
    /**
     * Modifica el numero de cuenta del trabajador.
     * @param nuevaCuenta El nuevo numero de cuenta en una cadena de caracteres.
     */
    public void setCuentaBanco(String nuevaCuenta) {
        this.cuentaBanco = nuevaCuenta;
    }
    
    /**
     * Obtiene informacion sobre el trabajador.
     * @return Informacion sobre el trabajador en una cadena de caracteres.
     */
    @Override
    public String toString() {
        return "\n Nombre: " + this.nombre + "\n DNI: " + this.DNI + "\n Num Cuenta: " + this.cuentaBanco;
    }
}
