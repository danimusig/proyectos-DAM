package dam1_dmusig_Javitos;

/**
 * Clase Cliente: Permite crear y gestionar informacion relacionada con clientes.
 * @author dmunsig
 * @version 1.0
 * @see String
 * @see Cliente
 */
public class Cliente implements Comparable<Cliente>{
    /**
     * El nombre del cliente.
     */
    private String nombre;
    
    /**
     * El dni del cliente.
     */
    private String dni;
    
    /**
     * El email del cliente.
     */
    private String email;
    
    /**
     * El lugar de residencia del cliente.
     */
    private String lugarResidencia;
    
    /**
     * La cantidad de veces que se ha alojado el cliente.
     */
    private int vecesAlojado;
        
    /**
     * Constructor Principal.
     * @param nombre El nombre del cliente en una cadena.
     * @param DNI El dni del clinete en una cadena.
     * @param email El email del cliente en una cadena.
     * @param lugarResidencia El logar de residencia del cliente ne una cadena.
     * @param vecesAlojado La cantidad de veces que se ha alojado el cliente.
     */
    public Cliente(String nombre, String dni, String email, String lugarResidencia) {
        if (!dni.matches("[0-9]{8}[A-Z]")) {
            System.out.println("ALERTA: Valores introducidos incorrectos, el DNI introducido no tiene el formato correcto (12345678A), se le dara un valor por defecto..");
            this.dni = "00000000A";
        } else {
            this.dni = dni;
        }
        
        if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            System.out.println("ALERTA: Valores introducidos incorrectos, el Email introducido no tiene el formato correcto, se le dara un valor por defecto.");
            this.email = "sin@email.error";
        } else {
            this.email = email;
        }
        
        this.nombre = nombre;
        this.lugarResidencia = lugarResidencia;
        this.vecesAlojado = 0;
    }

    /**
     * Obtiene el nombre del cliente.
     * @return El nombre del cliente en una cadena.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre del cliente.
     * @param nombre El nuevo nombre del cliente en una cadena.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Obtiene el dni del cliente.
     * @return El dni del cliente en una cadena de caracteres.
     */
    public String getDni() {
        return this.dni;
    }
    
    /**
     * Modifica el dni del cliente.
     * @param nuevoDNI EL nuevo dni del cliente en una cadena.
     */
    public void setDni(String nuevoDNI) {
        if (!nuevoDNI.matches("[0-9]{8}[A-Z]")) {
            throw new IllegalArgumentException("Formato de DNI incorrecto.");
        } else {
            this.dni = nuevoDNI;
        }
    }
    
    /**
     * Obtiene el email del cliente.
     * @return El email del cliente en una cadena.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Modifica el email del cliente.
     * @param email El nuevo email del cliente en una cadena.
     */
    public void setEmail(String nuevoEmail) {
        if (!nuevoEmail.matches("^[\\w.-]+@[\\w.-]+\\.[a-z]{2,3}$")) {
            System.out.println("ERROR: El formato del email es incorrecto");
        } else {
            this.email = nuevoEmail;
        }
    }

    /**
     * Obtiene el lugar de residencia del cliente.
     * @return El lugar de residencia del cliente en una cadena de caracteres.
     */
    public String getLugarResidencia() {
        return lugarResidencia;
    }

    /**
     * Modifica el lugar de residencia del cliente.
     * @param lugarResidencia El lugar de residencia del cliente en una cadena de caracteres.
     */
    public void setLugarResidencia(String lugarResidencia) {
        this.lugarResidencia = lugarResidencia;
    }

    /**
     * Obtiene las veces que se ha alojado el cliente.
     * @return Las veces que se ha alojado el cliente en un entero.
     */
    public int getVecesAlojado() {
        return vecesAlojado;
    }

    /**
     * Modifica la cantidad de veces que se ha alojado un cliente.
     * @param vecesAlojado
     */
    public void setVecesAlojado(int vecesAlojado) {
        this.vecesAlojado = vecesAlojado;
    }    
    
    /**
     * Compara dos clientes alfabeticamente usando su nombre como parametro de comparacion.
     * @param cliente2 El cliente con el que se comparara.
     * @return -1 si es menor 0 si es igual 1 si es mayor.
     */
    public int compareTo(Cliente cliente2) {
        return this.nombre.compareTo(cliente2.nombre);
    }
    
    /**
     * Muestra informacion sobre los clientes.
     * @return Informacion sobre los clientes en una cadena.
     */
    @Override 
    public String toString() {
        return "\n<-- CLIENTE \n Nombre: " + this.nombre + "\n DNI: " + this.dni + "\n Email: " + this.email + "\n Lugar Residencia:" + this.lugarResidencia + "\n Veces Alojado: " + this.vecesAlojado ;
    }
    
}
