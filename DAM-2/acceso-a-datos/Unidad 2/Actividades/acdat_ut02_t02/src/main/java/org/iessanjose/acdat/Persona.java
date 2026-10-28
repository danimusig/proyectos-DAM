package org.iessanjose.acdat;

public class Persona {
    private String nommbre;
    private String apellido;
    private int edad;
    private String DNI;

    public Persona(String nommbre, String apellido, int edad, String DNI) {
        this.nommbre = nommbre;
        this.apellido = apellido;
        this.edad = edad;
        this.DNI = DNI;
    }

    public String getNommbre() {
        return nommbre;
    }

    public void setNommbre(String nommbre) {
        this.nommbre = nommbre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
}
