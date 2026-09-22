package dms.dam1._pe08_colleciones_json;

/**
 * Clase Alojamiento: Permite crear y gestionar informacion sobre alojamientos.
 * @author dmunsig
 * @version 2.0
 * @see String
 * @see Alojamiento
 */
public class Alojamiento implements Comparable<Alojamiento>{
    /**
     * El nombre del alojamiento.
     */
    private String nombre;
    
    /**
     * La capacidad del alojamiento en personmas.
     */
    private int capacidad;
    
    /**
     * La tarifa por noche del alojamiento.
     */
    private double tarifa;
    
    /**
     * Si tiene chimenea o no.
     */
    private boolean tieneChimenea;
    
    /**
     * Si tiene jacuzzi o no.
     */
    private boolean tieneJacuzzi;
    
    /**
     * Si esta alquiladaAhora o no.
     */
    private boolean alquiladaAhora;
    
    /**
     * El numero de veces alquilado.
     */
    private int numVecesAlquilado;
    
    /**
     * Constructor Principal.
     * @param nombre El nombre del alojamiento.
     * @param capacidad La capacidad del alojamiento en personmas.
     * @param tarifa La tarifa por noche del alojamiento.
     * @param tieneChimenea Si tiene chimenea o no.
     * @param tieneJacuzzi Si tiene jacuzzi o no.
     */
    public Alojamiento(String nombre, int capacidad, double tarifa, boolean tieneChimenea, boolean tieneJacuzzi) {
        if (capacidad <= 0) {
            System.out.println("ALERTA: Valores introducidos incorrectos, el alojamiento no tiene capacidad establecida, aparecera como 0.");
            this.capacidad = 0;
        } else {
            this.capacidad = capacidad;
        }
        
        if (tarifa <= 0) {
            System.out.println("ALERTA: Valores introducidos incorrectos, la tarifa no tiene valor establecido, aparecera como 0.");
            this.tarifa = 0;
        } else {
            this.tarifa = tarifa;
        }
        
        this.nombre = nombre;
        this.tieneChimenea = tieneChimenea;
        this.tieneJacuzzi = tieneJacuzzi;
        this.alquiladaAhora = false; // Por defecto al crearse esta libre.
        this.numVecesAlquilado = 0; //Inicio en el constructor el contador.    
    }
    
    /**
     * Obtiene el nombre del alojamiento.
     * @return El nombre del alojamiento en una cadena de caracteres.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre del alojamiento.
     * @param nombre El nuevo nombre del alojamiento en una cadena de caracteres.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la capacidad del alojamiento.
     * @return La capacidad del alojamiento en personas,
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * Modifica la capacidad del alojamiento.
     * @param capacidad La nueva capacidad del alojamiento en personas.
     */
    public void setCapacidad(int nuevaCapacidad) {
        this.capacidad = nuevaCapacidad;
    }

    /**
     * Obtiene la tarifa del alojamiento por noche.
     * @return La tarifa del alojamiento por noche en euros.
     */
    public double getTarifa() {
        return tarifa;
    }

    /**
     * Modifica la tarifa del alojamiento por noche. 
     * @param nuevaTarifa la nueva tarifa del alojamiento por noche.
     */
    public void setTarifa(double nuevaTarifa) {
        this.tarifa = nuevaTarifa;
    }

    /**
     * Obtiene si el alojamiento tiene chimenea.
     * @return Si el alojamiento tiene chimenea en un boolean.
     */
    public boolean getTieneChimenea() {
        return tieneChimenea;
    }

    /**
     * Modifica si el alojamiento tiene chimenea.
     * @param tieneChimenea Si tiene o no chimenea el alojamiento en un boolean.
     */
    public void setTieneChimenea(boolean tieneChimenea) {
        this.tieneChimenea = tieneChimenea;
    }

    /**
     * Obtiene si el alojamiento tiene jacuzzi.
     * @return Si el alojamiento tiene jacuzzi en un boolean.
     */
    public boolean getTieneJacuzzi() {
        return tieneJacuzzi;
    }

    /**
     * Modifica si el alojamiento tiene jacuzzi.
     * @param tieneJacuzzi si el alojamiento tiene jacuzzi en un boolean.
     */
    public void setTieneJacuzzi(boolean tieneJacuzzi) {
        this.tieneJacuzzi = tieneJacuzzi;
    }

    /**
     * Obtiene si el alojamiento esta alquiladaAhora.
     * @return Si el alojamiento esta alquiladaAhora en un boolean.
     */
    public boolean estaAlquiladaAhora() {
        return alquiladaAhora;
    }

    /**
     * Obtiene las veces que se ha alquilado el alojamiento.
     * @return Las veces que se ha alquilado el alojamiento en un entero.
     */
    public int getVecesAlquilado() {
        return numVecesAlquilado;
    }

    /**
     * Modifica las veces que se ha alquilado el alojamiento.
     * @param numVecesAlquilado Las veces que se ha alquilado el alojamiento en un entero.
     */
    public void setVecesAlquilado(int numVecesAlquilado) {
        this.numVecesAlquilado = numVecesAlquilado;
    }
    
    /**
     * Modifica el estado de alquiladaAhora a true e incrementea numVecesAlquilado
     */
    public void alquilar() {
        this.alquiladaAhora = true;
        this.numVecesAlquilado++;
    }
    
    /**
     * Modifica alquiladaAhora a false.
     */
    public void liberar() {
        this.alquiladaAhora = false;
    }
    
    /**
     * Compara alfabeticamente los nombres de dos alojamientos.
     * @param alojamiento2 El nombre del alojamiento a comparar con el primero.
     * @return -1 si es menor 0 si es igual 1 si es mayor.
     */
    @Override
    public int compareTo(Alojamiento alojamiento2) {
        return this.nombre.compareTo(alojamiento2.nombre);
    }
    
    /**
     * Muestra informacion sobre los alojamientos.
     * @return Informacion sobre los alojamientos en una cadena.
     */
    @Override 
    public String toString() {
        return "<-- ALOJAMIENTO \n Nombre: " + this.nombre + "\n Capacidad: " + this.capacidad + "\n Tarifa por noche: " + this.tarifa + "\n Chimenea: " + this.tieneChimenea + "\n Jacuzzi: " + this.tieneJacuzzi + "\n Disponible: " + this.alquiladaAhora + "\n Veces alquilado: " + this.numVecesAlquilado;
    }
    
}
