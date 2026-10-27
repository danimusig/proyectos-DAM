package org.iessanjose.acdat;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ActividadesACDAT {

    public static void main(String[] args) {

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


        /* Ejercicio 3: Contar lineas, palabras y caracteres en un fichero. */
        String nomFichero = "f_texto.txt";
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
    }

        /* Ejercicio 4: Buscar una palabra en un fichero de texto. */
        /* Ejercicio 5: Serialización y deserialización de objetos. */
}
