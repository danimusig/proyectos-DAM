import java.util.concurrent.Exchanger;

public class Intercambiador {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<String>();
        new Thread(new TareaA(exchanger)).start();
        new Thread(new TareaB(exchanger)).start();
    }
}
