import java.io.File;
import java.io.IOException;

public class CreadorProcesosProcessBuilder {
    public static void main(String[] args) {
        try {
            ProcessBuilder pBuilder = new ProcessBuilder("/mnt/kingP-1TB/Proyects/proyectos-dam/DAM-2/programacion-servicios-y-procesos/Unidad 1/Extractos de código/Actividad Resuelta 1.2/CreadorProceso/src/main/resources/proceso_c");
            pBuilder.directory(new File("/mnt/kingP-1TB/Proyects/"));

            Process proceso = pBuilder.start();
            int valorRetorno = proceso.waitFor();

            if (valorRetorno == 0) {
                System.out.println("El proceso se ha completado satisfactoriamente");
            } else {
                System.out.println("El proceso ha fallado. Código de error: " + valorRetorno);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
