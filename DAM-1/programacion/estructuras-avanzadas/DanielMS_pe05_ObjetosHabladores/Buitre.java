package DAM1.DanielMS_pe05_ObjetosHabladores;

/**
 *
 * @author dania
 */
public class Buitre extends Ave {
    
    private int velocidadVuelo;
    
    private double peso;
    
    public Buitre(String sexo, int edad, int velocidadVuelo, double peso) {
        super(sexo, edad);
        
        this.velocidadVuelo = velocidadVuelo;
        
        this.peso = peso;
    }

    public int getVelocidadVuelo() {
        return velocidadVuelo;
    }

    public void setVelocidadVuelo(int nuevaVelocidadVuelo) {
        this.velocidadVuelo = nuevaVelocidadVuelo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double nuevoPeso) {
        this.peso = nuevoPeso;
    }
}
