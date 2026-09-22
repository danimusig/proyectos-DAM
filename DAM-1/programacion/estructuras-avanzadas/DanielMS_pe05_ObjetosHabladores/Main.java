package DAM1.DanielMS_pe05_ObjetosHabladores;

/**
 * Clase Principal para probar los metodos y clases.
 * @author DanielMS
 * @version 1.0
 * @see String
 */
public class Main {
    
    public static void main(String[] args) {
        
        //Creo los objetos habladores.
        Alumno alumno1  = new Alumno("Daniel", 25, "Informatica", 1);
        Profesor profe1 = new Profesor("Paco", 37, "731-D", "arthur@morgan.es");
        Bedel bedel1 = new Bedel("Alejandro", 50, "Tarde", 30);
        TV tv1 = new TV(75, 800, "si", 7);
        Radio radio1 = new Radio(20, 80.75, "no", 4);
        Loro loro1 = new Loro("Macho", 3, "Congo", "Azabache");
        Piolin piolin1 = new Piolin("Macho", 7, "En la lluvia", 12);
        
        //Habla el alumno.
        alumno1.hablar();
        System.out.println("        Nombre: " + alumno1.getNombre() + "         Edad: " + alumno1.getEdad() + "\n        Carrera: " + alumno1.getCarrera() + "   Curso: " + alumno1.getCurso() + "\n");
                
        //Habla el profesor.
        profe1.hablar();
        System.out.println("        Nombre: " + profe1.getNombre() + "           Edad: " + profe1.getEdad() + "\n        Despacho: " + profe1.getDespacho() + "        Email: " + profe1.getEmail() + "\n");
   
        //Habla el bedel.
        bedel1.hablar();
        System.out.println("        Nombre: " + bedel1.getNombre() + "      Edad: " + bedel1.getEdad() + "\n        Turno: " + bedel1.getTurno() + "           Antiguedad: " + bedel1.getAntiguedad() + "\n");
        
        //Habla la TV.
        tv1.hablar();
        System.out.println("        Consumo: " + tv1.getConsumo() + "            Precio: " + tv1.getPrecio() + "\n        Teletexto: " + tv1.getTeletexto() + "          Antiguedad: " + tv1.getAntiguedad() + "\n");
        
        //Habla la radio.
        radio1.hablar();
        System.out.println("        Consumo: " + radio1.getConsumo() + "            Precio: " + radio1.getPrecio() + "\n        Cassete: " + radio1.getCassete() + "            Antiguedad " + radio1.getAntiguedad() + "\n");
        
        //Habla el loro.
        loro1.hablar();
        System.out.println("        Sexo: " + loro1.getSexo() + "            Edad: " + loro1.getEdad() + "\n        Region: " + loro1.getRegion() + "          Color: " + loro1.getColor() + "\n");
        
        //Habla Piolin.
        piolin1.hablar();
        System.out.println("        Sexo: " + piolin1.getSexo() + "            Edad: " + piolin1.getEdad() + "\n        Canta: " + piolin1.getCanta() + "    Peliculas: " + piolin1.getNumPeliculas() + "\n");
    }
}
