package DAM1.DanielMS_pe05_ObjetosHabladores;

/**
 * 
 * @author DanielMS
 */
public class Radio extends Aparato implements Hablador {
    
    public String cassete;
    
    public int antiguedad;
    
    public Radio(int consumo, double precio, String cassete, int antiguedad) {
        super(consumo, precio);
        
        this.cassete = cassete;
        
        this.antiguedad = antiguedad;
    }

    public String getCassete() {
        return cassete;
    }

    public void setCassete(String nuevoCassete) {
        this.cassete = nuevoCassete;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int nuevaAntiguedad) {
        this.antiguedad = nuevaAntiguedad;
    }

    public void hablar() {
        System.out.println("Hola, soy una radio y se hablar.");
    }
    
    
}
