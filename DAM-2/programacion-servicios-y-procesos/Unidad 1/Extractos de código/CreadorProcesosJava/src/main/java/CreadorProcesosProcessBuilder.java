import java.io.File;
import java.io.IOException;

public class CreadorProcesosProcessBuilder {
    public static void main(String[] args) {
        try {
            ProcessBuilder pBuilder = new ProcessBuilder("C://PSP_Unidad1//proceso_c//proceso_c.exe");
            pBuilder.directory(new File("C://directorio_salida"));

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
