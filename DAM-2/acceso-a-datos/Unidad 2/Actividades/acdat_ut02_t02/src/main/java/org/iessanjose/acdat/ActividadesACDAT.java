package org.iessanjose.acdat;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ActividadesACDAT {

    public static void main(String[] args)  {

        /* Ejercicio 1: Leer y escribir en ficheros de texto */
        /*String rutaInput = "input.txt";
        String rutaOutput = "output.txt";
        File textInput;
        File textOutput;

        if (!new File(rutaInput).exists()) {
            System.out.println("ERROR: El archivo de entrada no existe..." +
                    " Creando uno vacio (input.txt)");
            textInput = new File(rutaInput);

        }

        if (!new File(rutaOutput).exists()) {
            System.out.println("ERROR: El archivo de salida no existe..." +
                    " Creando uno vacio (input.txt)");
            textOutput = new File(rutaOutput);
        }

        textInput = new File("input.txt");
        textOutput = new File("output.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(textInput));
             BufferedWriter bw = new BufferedWriter(new FileWriter(textOutput))) {

            String linea = br.readLine();

            while (linea != null) {
                bw.write(linea);
                bw.newLine();

                linea = br.readLine();
            }

            System.out.println("Se leyó el archivo correctamente.");

        } catch (IOException e) {
            System.out.println("ERROR: No se pudo trabajar sobre e archivo");
        }
    }*/


        /* Ejercicio 2: Copiar un fichero de texto línea por línea */
        /*String rutaInput = "source.txt";
        String rutaOutput = "dest.txt";
        File textInput;
        File textOutput;

        if (!new File(rutaInput).exists()) {
            System.out.println("ERROR: El archivo de entrada no existe..." +
                    " Creando uno vacio (input.txt)");
            textInput = new File(rutaInput);

        }

        if (!new File(rutaOutput).exists()) {
            System.out.println("ERROR: El archivo de salida no existe..." +
                    " Creando uno vacio (input.txt)");
            textOutput = new File(rutaOutput);
        }

        textInput = new File(rutaInput);
        textOutput = new File(rutaOutput);

        try (BufferedReader br = new BufferedReader(new FileReader(textInput));
             BufferedWriter bw = new BufferedWriter(new FileWriter(textOutput))) {

            String linea = br.readLine();

            while (linea != null) {
                bw.write(linea);
                bw.newLine();

                linea = br.readLine();
            }

            System.out.println("Se leyó el archivo correctamente.");

        } catch (IOException e) {
            System.out.println("ERROR: No se pudo trabajar sobre e archivo");
        }
    }*/


        /* Ejercicio 3: Contar lineas, palabras y caracteres en un fichero. */
        /*String nomFichero = "f_texto.txt";
        File f = new File(nomFichero);
        int cantLineas = 0;
        int cantPalabras = 0;
        int cantLetras = 0;

        if (!f.exists()) {
            System.out.println("Fichero " + nomFichero + " no existe.");
            return;
        }

        try (BufferedReader bfr = new BufferedReader(new FileReader(f))) {
            File fTemp = File.createTempFile(nomFichero, "");
            System.out.println("Creado fichero temporal: " + fTemp.
                    getAbsolutePath());
            BufferedWriter bfw = new BufferedWriter(new FileWriter(fTemp));
            String linea = bfr.readLine();
            while (linea != null) { // En resumen, lee de bfr y escribe en bfw

                for (int i = 0; i < linea.length(); i++) {
                    cantLetras++;
                }

                String[] palabras = linea.split(" ");
                cantPalabras = palabras.length;

                cantLineas++;

                bfw.newLine();
                linea = bfr.readLine();
            }

            System.out.println("Cantidad de Lineas: " + cantLineas);
            System.out.println("Cantidad de Palabras: " + cantPalabras);
            System.out.println("Cantidad de Letras: " + cantLetras);


        } catch (Exception e) {

        }
    }*/


        /* Ejercicio 4: Buscar una palabra en un fichero de texto. */
        /*String palabra = "patata";
        int contPalabra = 0;
        String nomFichero = " ";
        File fichero = new File("f_texto_4.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String linea = br.readLine();
            while (linea != null) {
                if (linea.equals(palabra)) {
                    contPalabra++;
                }
                br.readLine();
            }

            System.out.println("La palabra " + palabra + " sale " + contPalabra + "veces en el texto.");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/


        /* Ejercicio 5: Serialización y deserialización de objetos. */
        /*Persona p1 = new Persona(
                "Daniel",
                "Muñoz",
                25,
                "123456789D");

        try {
            if (!new File("f_persona_1.txt").exists()) {
                File ficheroEntrada = new File("f_persona_1.txt");
                ficheroEntrada.createNewFile();
            }

            if (!new File("f_persona_2.txt").exists()) {
                File ficheroSalida = new File("f_persona_2.txt");
                ficheroSalida.createNewFile();
            }
        } catch (IOException e) {

        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("f_persona_2.txt"));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream("f_persona_1.txt"))) {
                oos.writeObject(p1);
                oos.flush();

                Persona copiap1 = (Persona) ois.readObject();

                System.out.println(copiap1.toString());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);

            Persona p1 = new Persona(
                "Daniel",
                "Muñoz",
                25,
                "123456789D");

        try {
            if (!new File("f_persona_1.txt").exists()) {
                File ficheroEntrada = new File("f_persona_1.txt");
                ficheroEntrada.createNewFile();
            }

            if (!new File("f_persona_2.txt").exists()) {
                File ficheroSalida = new File("f_persona_2.txt");
                ficheroSalida.createNewFile();
            }
        } catch (IOException e) {

        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("f_persona_2.txt"));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream("f_persona_1.txt"))) {
                oos.writeObject(p1);
                oos.flush();

                Persona copia1 = (Persona) ois.readObject();

                System.out.println(copia1.toString());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }*/


        /*Ejercicio 6: Crea un programa que liste todos los archivos y carpetas de un directorio
        dado y permita crear, renombrar y eliminar archivos dentro del mismo.*/
        File directory = new File("dir");
        directory.mkdir();

        String[] files = {"file1.csv", "file2.txt"};
        for (String file: files) {
            try {
                new File(directory, file).createNewFile();
            } catch (IOException e) {
                System.err.println("No se pudo crear el archivo: " + file);
            }
        }

        for (File file : directory.listFiles()) {
            System.out.println(file);
        }

        File renamedDirectory = new File("renamedDir.txt");
        directory.renameTo(renamedDirectory);

        directory.delete();


        /*Ejercicio 7: Implementa un programa que lea un fichero binario y lo copie en otro fichero.*/
        /*try {
            if (!new File("ejercicio7.bin").exists()) {
                File ficheroEntrada = new File("ejercicio7.bin");
                ficheroEntrada.createNewFile();
            }
        } catch (IOException e) {
            System.err.println("Error: El archivo no existe.");
        }

        try (ObjectInputStream fis = new ObjectInputStream(new FileInputStream("ejercicio7.bin"));
             ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ejercicio7.bin"))) {

            Persona p1 = new Persona(
                    "Daniel",
                    "Muñoz",
                    25,
                    "123456789D");

            oos.writeObject(p1);

            Persona copiap1 = (Persona) fis.readObject();
            System.out.println(copiap1.toString());

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }*/


    }
}
