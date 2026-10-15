import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Lector implements Callable<String> {

    @Override
    public String call() throws Exception {
        String textoLeido = "Me gustan las películas de acción";
        Thread.sleep(1000);
        return textoLeido;
    }
    public static void main(String[] args) {
        try {
            Lector lector = new Lector();
            ExecutorService servicioEjecucion = Executors.newSingleThreadExecutor();
            Future<String> resultado = servicioEjecucion.submit(lector);
            String texto = resultado.get();
            if (resultado.isDone()) {
                System.out.println("Proceso finalizado.");
            } else if (resultado.isCancelled()) {
                System.out.println("Proceso cancelado");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
