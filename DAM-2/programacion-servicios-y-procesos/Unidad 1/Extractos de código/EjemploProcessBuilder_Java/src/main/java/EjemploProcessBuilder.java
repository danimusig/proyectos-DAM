import java.io.File;
import java.io.IOException;
import java.util.Map;

public class EjemploProcessBuilder {
    public static void main(String[] args) {
        try {
            // Instanciación e inicio
            ProcessBuilder pb = new ProcessBuilder("Notepad.exe", "datos.txt");

            // Establecer directorio de trabajo
            pb.directory(new File("C:/directorio_salida/"));

            // Obtener variables de entorno
            Map<String, String> env = pb.environment();
            System.out.println("Número de procesadores: " + env.get("NUMBER_OF_PROCESSORS"));

            // Iniciar proceso y esperar
            Process proceso = pb.start();
            int valorRetorno = proceso.waitFor();
            System.out.println("Valor retorno: " + valorRetorno);

            // Ejemplo para lanzar múltiples instancias
            ProcessBuilder pBuilder = new ProcessBuilder("Notepad.exe");
            for (int i = 0; i < 10; i++) {
                pBuilder.start();
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
