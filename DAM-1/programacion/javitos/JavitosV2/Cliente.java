package javitos;

import java.io.Serializable;

/**
 * Clase Cliente: Permite crear y gestionar informacion relacionada con clientes.
 * @author dmunsig
 * @version 2.0
 * @see String
 * @see Cliente
 */
public class Cliente implements Comparable<Cliente>, Serializable{
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
    private int numVecesAlojado;
        
    /**
     * Constructor Principal.
     * @param nombre El nombre del cliente en una cadena.
     * @param dni El dni del clinete en una cadena.
     * @param email El email del cliente en una cadena.
     * @param lugarResidencia El logar de residencia del cliente ne una cadena.
     */
    public Cliente(String nombre, String dni, String email, String lugarResidencia) throws DniNoValidaException, EmailNoValidaException {
        if (!dni.matches("[0-9]{8}[A-Z]")) {
            throw new DniNoValidaException("EL formato del dni no es valido.");
        } else {
            this.dni = dni;
        }
        
        if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            throw new EmailNoValidaException("El formato del email no es valido.");
        } else {
            this.email = email;
        }
        
        this.nombre = nombre;
        this.lugarResidencia = lugarResidencia;
        this.numVecesAlojado = 0;
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
    public void setDni(String nuevoDNI) throws DniNoValidaException {
        if (!nuevoDNI.matches("[0-9]{8}[A-Z]")) {
            throw new DniNoValidaException("El DNI no tiene un formato valido.");
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
     * @param nuevoEmail El nuevo email del cliente en una cadena.
     */
    public void setEmail(String nuevoEmail) throws EmailNoValidaException {
        if (!nuevoEmail.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            throw new EmailNoValidaException("El email no tiene un formato valido.");
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
        return numVecesAlojado;
    }

    /**
     * Modifica la cantidad de veces que se ha alojado un cliente.
     * @param numVecesAlojado
     */
    public void setVecesAlojado(int numVecesAlojado) {
        this.numVecesAlojado = numVecesAlojado;
    }    
    
    /**
     * Aumenta 1 numVecesAlojado.
     */
    public void alojar() {
        numVecesAlojado++;
    }
    
    /**
     * Compara dos clientes alfabeticamente usando su nombre como parametro de comparacion.
     * @param cliente2 El cliente con el que se comparara.
     * @return -1 si es menor 0 si es igual 1 si es mayor.
     */
    @Override
    public int compareTo(Cliente cliente2) {
        return this.nombre.compareTo(cliente2.nombre);
    }
    
    /**
     * Muestra informacion sobre los clientes.
     * @return Informacion sobre los clientes en una cadena.
     */
    @Override 
    public String toString() {
        return "\n<-- CLIENTE \n Nombre: " + this.nombre + "\n DNI: " + this.dni + "\n Email: " + this.email + "\n Lugar Residencia:" + this.lugarResidencia + "\n Veces Alojado: " + this.numVecesAlojado;
    }
    
}
