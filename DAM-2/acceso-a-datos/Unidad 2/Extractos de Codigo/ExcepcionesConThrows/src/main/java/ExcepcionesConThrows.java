import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExcepcionesConThrows {
    public File crearFucheroTemConCar (String titulo, char car, int numVeces) throws IOException {
        File f = File.createTempFile(titulo, "");
        FileWriter fw = new FileWriter(f);
        for (int i = 1; i < numVeces; i++) fw.write(car);
        fw.close();
        return f;
    }

    public static void main(String[] args) {
        try {
            File ft = new ExcepcionesConThrows().crearFucheroTemConCar("AAAA_", 'A', 20);
            System.out.println("Creado fichero: " + ft.getAbsolutePath());
            ft.delete();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
