import java.util.ArrayList;

public class RatonSimple implements Runnable {
    private String nombre;
    private int tiempoAlimentacion;
    private int alimentoConsumido;

    public RatonSimple(String nombre, int tiempoAlimentacion) {
        super();
        this.nombre = nombre;
        this.tiempoAlimentacion = tiempoAlimentacion;
    }

    public void comer() {
        try {
            System.out.println("El raton \s ha comenzado a alimentarse\n"  + nombre);
            Thread.sleep(tiempoAlimentacion * 1000);
            alimentoConsumido++;
            System.out.println("El raton \s ha terminado de alimentarse\n" + nombre);
            System.out.println("Alimento consumido :" + alimentoConsumido);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        this.comer();
    }

    public static void main(String[] args) {
        RatonSimple gonzales = new RatonSimple("Gonzales", 3);

        /*new Thread(gonzales).start();
        new Thread(gonzales).start();
        new Thread(gonzales).start();
        new Thread(gonzales).start();*/

        //Error de concurrencia
        /*for (int i=0;i<100;i++) {
            new Thread(gonzales).start();
        }*/

        //Estados de un thread
        ArrayList<Thread.State> estadosHilo = new ArrayList<>();
        Thread h = new Thread(gonzales);
        estadosHilo.add(h.getState());
        h.start();
        while (h.getState()!=Thread.State.TERMINATED) {
            if (!estadosHilo.contains(h.getState())) {
                estadosHilo.add(h.getState());            }
        }

        if (!estadosHilo.contains(h.getState())) {
            estadosHilo.add(h.getState());
        }
        for (Thread.State estado : estadosHilo) {
            System.out.println(estado);
        }
    }
}