import java.util.LinkedList;
import java.util.Queue;

public class ColaNoConcurrente implements Runnable {
    private static Queue<Integer> cola = new LinkedList<Integer>();

    @Override
    public void run() {
        cola.add(10);
        for (Integer i : cola) {
            System.out.print(i+":");
        }
        System.out.println("Tamaño cola " + cola.size());
    }

    public static void main(String[] args) {
        for (int i=0;i<10;i++) {
            new Thread(new ColaNoConcurrente()).start();
        }
    }
}
