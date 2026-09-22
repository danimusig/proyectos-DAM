package DAM1.DanielMS_pe05_JerarquiaDeFiguras;

/**
 * Clase Triangulo: Almacena y modifica datos sobre un triangulo.
 * @author DanielMS
 * @version 1.0
 * @see String
 */
public class Triangulo extends Figura {
    
    /**
     * El primer lado del triangulo.
     */
    private double lado1;
    
    /**
     * El segundo lado del triaugulo.
     */
    private double lado2;
    
    /**
     * El tercer lado del triangulo.
     */
    private double lado3;

    /**
     * Constructor Principal.
     * @param lado1 El primer lado del triangulo en centimetros.
     * @param lado2 El segundo lado del triangulo en centimetros.
     * @param lado3 El tercer lado del triangulo en centimetros.
     */
    public Triangulo(double lado1, double lado2, double lado3) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    /**
     * Obtiene el primer lado del triangulo.
     * @return El lado en centimetros.
     */
    public double getLado1() {
        return lado1;
    }

    /**
     * Modifica el primer lado del triangulo.
     * @param nuevoLado1 El nuevo lado en centimetros.
     */
    public void setLado1(double nuevoLado1) {
        this.lado1 = nuevoLado1;
    }

    /**
     * Obtiene el segunudo lado del triangulo.
     * @return El lado en centimetros.
     */
    public double getLado2() {
        return lado2;
    }

    /**
     * Modifica el segundo lado del triangulo.
     * @param nuevoLado2 El nuevo lado en centimetros.
     */
    public void setLado2(double nuevoLado2) {
        this.lado2 = nuevoLado2;
    }

    /**
     * Obtiene el tercer lado del triangulo.
     * @return El lado del triangulo en centimetros.
     */
    public double getLado3() {
        return lado3;
    }

    /**
     * Modifica el tercer lado del triangulo.
     * @param nuevoLado3 El nuevo lado en centimetros.
     */
    public void setLado3(double nuevoLado3) {
        this.lado3 = nuevoLado3;
    }
    
    /**
     * Obtiene informacion sobre el triangulo.
     * @return Informacion sobre el triangulo en una cadena de caracteres.
     */
    public String toString() {
        return "Triangulo: \n Lado 1: " + this.lado1 + "\n Lado 2: " + this.lado2 + "\n Lado 3: " + this.lado3;
    }
    
    /**
     * Dibuja un triangulo.
     */
    @Override
    public void dibujar() {
        System.out.println("Dibujando un triangulo");
    }
    
    /**
     * Borra un triangulo.
     */
    @Override
    public void borrar() {
        System.out.println("Borrando el triangulo");
    }
    
    
    
}
