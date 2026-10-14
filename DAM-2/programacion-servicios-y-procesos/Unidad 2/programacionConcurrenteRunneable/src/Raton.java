//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Raton implements Runnable {
    private String nombre;
    private int tiempoAlimentacion;

    public Raton(String nombre, int tiempoAlimentacion) {
        super();
        this.nombre = nombre;
        this.tiempoAlimentacion = tiempoAlimentacion;
    }

    public void comer() {
        try {
            System.out.println("El raton \s ha comenzado a alimentarse\n"  + nombre);
            Thread.sleep(tiempoAlimentacion * 1000);
            System.out.println("El raton \s ha terminado de alimentarse\n" + nombre);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        this.comer();
    }

    public static void main(String[] args) {
        Raton pica = new Raton("Pica", 4);
        Raton pepito = new Raton("Pepito", 5);
        Raton gonzales = new Raton("Gonzales", 3);
        Raton mickey = new Raton("Mickey", 6);

        new Thread(pica).start();
        new Thread(pepito).start();
        new Thread(gonzales).start();
        new Thread(mickey).start();
    }
}