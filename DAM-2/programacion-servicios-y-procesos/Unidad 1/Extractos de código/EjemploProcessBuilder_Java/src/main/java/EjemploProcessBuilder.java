import java.io.File;
import java.io.IOException;
import java.util.Map;

public class EjemploProcessBuilder {
    public static void main(String[] args) {
        try {
            // Instanciación e inicio
            ProcessBuilder pb = new ProcessBuilder("gnome-text-editor", "datos.txt");

            // Establecer directorio de trabajo
            pb.directory(new File("/home/danielms/Documents/"));

            // Obtener variables de entorno
            Map<String, String> env = pb.environment();
            // Para ejecutarlo en UNIX cambio el env.get por el .availableProcessors ya que es multiplataforma
            System.out.println("Número de procesadores: " + Runtime.getRuntime().availableProcessors());

            // Iniciar proceso y esperar
            Process proceso = pb.start();
            int valorRetorno = proceso.waitFor();
            System.out.println("Valor retorno: " + valorRetorno);

            // Ejemplo para lanzar múltiples instancias
            ProcessBuilder pBuilder = new ProcessBuilder("gnome-text-editor");
            for (int i = 0; i < 10; i++) {
                pBuilder.start();
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
