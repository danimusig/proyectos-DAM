package DAM1.DanielMS_pe05_ObjetosHabladores;

/**
 *
 * @author dania
 */
public class Loro extends Ave implements Hablador {
    
    public String region;
    
    public String color;
    
    public Loro(String sexo, int edad, String region, String color) {
        super(sexo, edad);
        
        this.region = region;
        
        this.color = color;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String nuevaRegion) {
        this.region = nuevaRegion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String nuevoColor) {
        this.color = nuevoColor;
    }
    
    public void hablar() {
        System.out.println("Hola, soy un loro y se hablar.");
    }
}
