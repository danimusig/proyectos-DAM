package DAM1.DanielMS_pe05_ObjetosHabladores;

/**
 * 
 * @author DanielMS
 * @verison 1.0
 */
public class Alumno extends Persona implements Hablador {
    
    private String carrera;
    
    private int curso;

    public Alumno(String nombre, int edad, String carrera, int curso) {
        super(nombre, edad);
        this.carrera = carrera;
        this.curso = curso;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int nuevoCurso) {
        this.curso = nuevoCurso;
    }    
    
    public void hablar() {
        System.out.println("Hola, soy un alumno y se hablar.");
    }
}
