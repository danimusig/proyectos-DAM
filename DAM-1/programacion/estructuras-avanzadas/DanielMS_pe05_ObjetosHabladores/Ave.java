package DAM1.DanielMS_pe05_ObjetosHabladores;

/**
 * 
 * @author DanielMS
 */
public class Ave {
    
    private String sexo;
    
    private int edad;
    
    public Ave(String sexo, int edad) {
        this.sexo = sexo;
        
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String nuevoSexo) {
        this.sexo = nuevoSexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int nuevaEdad) {
        this.edad = nuevaEdad;
    }
}
