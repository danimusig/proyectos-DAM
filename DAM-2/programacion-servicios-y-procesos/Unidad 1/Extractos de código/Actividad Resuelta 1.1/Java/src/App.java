import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) {
        try {
            Process proceso = new ProcessBuilder("python", "/home/danielms/Proyects/DAM-2/programacion-servicios-y-procesos/Unidad 1/actividad-resuelta-1.1/Python/proceso_python.py").start();
            BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()));

            proceso.waitFor();
            int exitStatus = proceso.exitValue();
            System.out.println("Retorno: " +  br.readLine());
            System.out.println("Valor a la salida: " + exitStatus);
        } catch ( IOException | InterruptedException e ) {
            e.printStackTrace();
        }
    }
}
