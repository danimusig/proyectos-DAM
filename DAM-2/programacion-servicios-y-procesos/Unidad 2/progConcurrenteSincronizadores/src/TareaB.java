import java.util.concurrent.Exchanger;

public class TareaB implements Runnable{
    private Exchanger<String> exchanger;

    public TareaB(Exchanger<String> exchanger) {
        super();
        this.exchanger = exchanger;
    }

    public void run() {
        try {
            String mensajeRecibido = exchanger.exchange("Mensaje enviado por TareaB");
            System.out.println("Mensaje recibido en tareaB: " + mensajeRecibido);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
