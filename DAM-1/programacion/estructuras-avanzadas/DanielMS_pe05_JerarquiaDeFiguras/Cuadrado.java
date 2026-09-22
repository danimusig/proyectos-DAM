package DAM1.DanielMS_pe05_JerarquiaDeFiguras;

/**
 * Clase Cuadradro: Almacena y modifica datos sobre un cuadrado.
 * @author DanielMS
 * @version 1.0
 * @see String
 */
public class Cuadrado extends Figura {
    
    /**
     * El lado del cuadrado.
     */
    private double lado;
    
    /**
     * Constructor Principal.
     * @param lado El lado del cuadrado en cm.
     */
    public Cuadrado(double lado) {
        this.lado = lado;
    }

    /**
     * Obtiene el lado del cuadrado.
     * @return El lado del cuadrado en centimetros.
     */
    public double getLado() {
        return lado;
    }

    /**
     * Modifica el lado del cuadrado.
     * @param lado Las nuevas dimensiones del lado en centimetros.
     */
    public void setLado(double nuevoLado) {
        this.lado = nuevoLado;
    }
    
    /**
     * Obtiene informacion sobre el cuadrado.
     * @return Informacion sobre el cuadrado en una cadena de caracteres.
     */
    public String toString() {
        return "Este cuadrado tiene " + this.lado + " cm por lado.";
    }

    /**
     * Dibuja un cuadrado.
     */
    @Override
    public void dibujar() {
        System.out.println("Dibujando un cuadrado");
    }
    
    /**
     * Borra un cuadrado.
     */
    @Override
    public void borrar() {
        System.out.println("Borrando el cuadrado");
    }
        
    
}
