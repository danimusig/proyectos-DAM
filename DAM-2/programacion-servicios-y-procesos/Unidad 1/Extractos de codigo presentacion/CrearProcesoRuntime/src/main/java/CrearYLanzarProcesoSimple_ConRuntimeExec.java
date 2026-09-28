import java.io.IOException;

public class CrearYLanzarProcesoSimple_ConRuntimeExec {
    public static void main(String[] args) {
        // Encierro toda la lógica con un try-catch y controlo los errores
        try {
            // Creo un proceso nuevo y lo lanzo en un solo paso
            Process obProcesoHijo = Runtime.getRuntime().exec("ls -l");

            // waitFor() espera la finalización del proceso
            int codExit = obProcesoHijo.waitFor();

            System.out.println("La ejecución de 'ls' y '-l' devuelve " + codExit);

        } catch (IOException ex) {
            System.err.println("Excepción de E/S!!");
            ex.printStackTrace();
            System.exit(-1);
        } catch (InterruptedException ex) {
            System.err.println("El proceso hijo finalizó de forma incorrecta");
            ex.printStackTrace();
            System.exit(-2);
        }

        System.exit(0);
    }
}