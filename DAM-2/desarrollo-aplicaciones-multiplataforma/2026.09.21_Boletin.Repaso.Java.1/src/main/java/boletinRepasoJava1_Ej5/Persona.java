package boletinRepasoJava1_Ej5;

import java.util.Date;

public abstract class Persona {

    String nombre;
    String apellido;
    int numeroIdentidad;
    String direccion;
    int telefono;
    Date anioNacimiento;

    public Persona(String nombre, String apellido, int numeroIdentidad, String direccion, int telefono, Date anioNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroIdentidad = numeroIdentidad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.anioNacimiento = anioNacimiento;
    }

    public abstract String obtenerNombre();
    public abstract String obtenerApellido();
    public abstract String obtenerNombreCompleto();
    public abstract int obtenerDNI();
    public abstract String obtenerDireccion();
    public abstract int obtenerTelefono();
    public abstract Date anioNacimiento();


}
