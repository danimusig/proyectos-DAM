package DAM1.DanielMS_pe05_ObjetosHabladores;

/**
 *
 * @author DanielMS
 */
public class Canario extends Ave {
    
    private String canta;
    
    public Canario(String sexo, int edad, String canta) {
        super(sexo, edad);
        
        this.canta = canta;
    }

    public String getCanta() {
        return this.canta;
    }

    public void setCanta(String nuevoCanto) {
        this.canta = nuevoCanto;
    }
}
