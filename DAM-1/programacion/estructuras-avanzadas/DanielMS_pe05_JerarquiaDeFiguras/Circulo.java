package DAM1.DanielMS_pe05_JerarquiaDeFiguras;

/**
 * Clase Circulo: Almacena y modifica datos sobre un circulo.
 * @author DanielMS
 * @version 1.0
 * @see String
 */
public class Circulo extends Figura {
    
    /**
     * El radio del circulo.
     */
    private double radio;

    /**
     * Constructor Principal.
     * @param radio El radio del circulo en centimetros.
     */
    public Circulo(double radio) {
        this.radio = radio;
    }

    /**
     * Obtiene el radio del circulo.
     * @return El radio del circulo en centimetros.
     */
    public double getRadio() {
        return radio;
    }

    /**
     * Modifica el radio del circulo.
     * @param radio El nuevo radio en centimetros.
     */
    public void setRadio(double nuevoRadio) {
        this.radio = nuevoRadio;
    }
    
    /**
     * Obtiene informacion sobre el circulo.
     * @return
     */
    public String toString() {
        return "Este círculo tiene " + this.radio + "cm de radio.";
    }
    
    /**
     * Dibuja un circulo.
     */
    @Override
    public void dibujar() {
        System.out.println("Dibujando un circulo");
    }
    
    /**
     * Borra el circulo.
     */
    @Override
    public void borrar() {
        System.out.println("Borrando el circulo");
    }
    
}
