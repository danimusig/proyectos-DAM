package DAM1.DanielMS_pe05_ObjetosHabladores;

/**
 *
 * @author DanielMS 
 */
public class Bedel extends Persona implements Hablador {
    
    private String turno;
    
    private int antiguedad;
    
    public Bedel(String nombre, int edad, String turno, int antiguedad) {
        super(nombre, edad);
        
        this.turno = turno;
        
        this.antiguedad = antiguedad;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String nuevoTurno) {
        this.turno = turno;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int nuevaAntiguedad) {
        this.antiguedad = nuevaAntiguedad;
    }

    public void hablar() {
        System.out.println("Hola, soy un bedel y se hablar.");
    }
}
