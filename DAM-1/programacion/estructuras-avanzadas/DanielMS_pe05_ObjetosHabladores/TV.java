package DAM1.DanielMS_pe05_ObjetosHabladores;

/**
 *
 * @author DanielMS
 */
public class TV extends Aparato implements Hablador {
    
    private String teletexto;
    
    private int antiguedad;

    public TV(int consumo, double precio, String teletexto, int antiguedad) {
        super(consumo, precio);
        
        this.teletexto = teletexto;
        
        this.antiguedad = antiguedad;   
    }

    public String getTeletexto() {
        return teletexto;
    }

    public void setTeletexto(String nuevoTeletexto) {
        this.teletexto = nuevoTeletexto;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int nuevaAntiguedad) {
        this.antiguedad = nuevaAntiguedad;
    }
    
    public void hablar() {
        System.out.println("Hola, soy una TV y se hablar.");
    }
}
