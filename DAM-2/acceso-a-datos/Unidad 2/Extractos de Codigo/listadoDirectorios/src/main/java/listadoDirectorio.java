import java.io.File;

public class listadoDirectorio {
    public static void main(String[] args) {
        String ruta = ".";
        if (args.length >= 1) ruta = args[0];
        File fich = new File(ruta);
        if (fich.isFile()) {
            System.out.println(ruta + " es un fichero.");
        } else {
            System.out.println(ruta + " es un directorio. Contenidos: ");
            File[] ficheros = fich.listFiles();
            for (File f : ficheros) {
                String textoDescr = f.isDirectory() ? "/" : f.isFile() ? "_" : "?";
                System.out.println("(" + textoDescr + ")" + f.getName());
            }
        }
    }
}

