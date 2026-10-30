package org.iessanjose.acdat;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ActividadesACDAT {
    public static void main(String[] args) {
        // Descomentar el método según el ejercicio a probar:
        // ejercicio1();
        // ejercicio2();
        // ejercicio3();
        // ejercicio4();
        // ejercicio5();
        // ejercicio6();
        // ejercicio7();
        // ejercicio8();
        ejercicio9();
        // ejercicio10();
        // ejercicio11("input.txt", "output_reemplazado.txt", "Java", "Kotlin");
        // ejercicio12("fichero1.txt", "fichero2.txt");
        // ejercicio13();
        // ejercicio14();
        // ejercicio15();
        // ejercicio16();
        // ejercicio17("datos.txt", "datos.enc", "datos_descifrados.txt");
    }

    public static void ejercicio1() {
        File textInput = new File("input.txt");
        File textOutput = new File("output.txt");

        // Crear archivo de entrada por defecto si no existe para pruebas
        if (!textInput.exists()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(textInput))) {
                bw.write("Hola, este es el fichero de entrada de prueba.");
                bw.newLine();
                bw.write("Segunda línea del fichero input.txt.");
            } catch (IOException e) {
                System.out.println("Error al crear el input.txt de prueba.");
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader(textInput));
             BufferedWriter bw = new BufferedWriter(new FileWriter(textOutput))) {

            String linea = br.readLine();
            while (linea != null) {
                bw.write(linea);
                bw.newLine();
                linea = br.readLine();
            }

            System.out.println("[Ej 1] Se leyó y escribió el archivo correctamente.");

        } catch (IOException e) {
            System.out.println("ERROR: No se pudo trabajar sobre el archivo: " + e.getMessage());
        }
    }


    /* -------------------------------------------------------------
     * Ejercicio 2: Copiar un fichero de texto línea por línea
     * Commit 2: acdat.ut02.t01.02
     * ------------------------------------------------------------- */
    public static void ejercicio2() {
        File textInput = new File("source.txt");
        File textOutput = new File("dest.txt");

        if (!textInput.exists()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(textInput))) {
                bw.write("Línea uno de source.txt");
                bw.newLine();
                bw.write("Línea dos de source.txt");
            } catch (IOException e) {
                System.out.println("Error al crear source.txt de prueba.");
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader(textInput));
             BufferedWriter bw = new BufferedWriter(new FileWriter(textOutput))) {

            String linea = br.readLine();
            while (linea != null) {
                bw.write(linea);
                bw.newLine();
                linea = br.readLine();
            }

            System.out.println("[Ej 2] Fichero copiado línea por línea correctamente en dest.txt.");

        } catch (IOException e) {
            System.out.println("ERROR: No se pudo copiar el archivo: " + e.getMessage());
        }
    }

    /* -------------------------------------------------------------
     * Ejercicio 3: Contar líneas, palabras y caracteres en un fichero
     * Commit 3: acdat.ut02.t01.03
     * ------------------------------------------------------------- */
    public static void ejercicio3() {
        String nomFichero = "f_texto.txt";
        File f = new File(nomFichero);

        if (!f.exists()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
                bw.write("Hola mundo Java");
                bw.newLine();
                bw.write("Acceso a datos curso 2026");
            } catch (IOException e) {
                System.out.println("Error al crear f_texto.txt de prueba.");
            }
        }

        int cantLineas = 0;
        int cantPalabras = 0;
        int cantCaracteres = 0;

        try (BufferedReader bfr = new BufferedReader(new FileReader(f))) {
            String linea = bfr.readLine();
            while (linea != null) {
                cantLineas++;
                cantCaracteres += linea.length();

                if (!linea.trim().isEmpty()) {
                    String[] palabras = linea.trim().split("\\s+");
                    cantPalabras += palabras.length;
                }

                linea = bfr.readLine();
            }

            System.out.println("[Ej 3] Resultados para " + nomFichero + ":");
            System.out.println("  - Cantidad de Líneas: " + cantLineas);
            System.out.println("  - Cantidad de Palabras: " + cantPalabras);
            System.out.println("  - Cantidad de Caracteres: " + cantCaracteres);

        } catch (IOException e) {
            System.out.println("ERROR al leer el fichero: " + e.getMessage());
        }
    }

    /* -------------------------------------------------------------
     * Ejercicio 4: Buscar una palabra en un fichero de texto
     * Commit 4: acdat.ut02.t01.04
     * ------------------------------------------------------------- */
    public static void ejercicio4(String palabraBusqueda, String nomFichero) {
        File fichero = new File(nomFichero);

        if (!fichero.exists()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichero))) {
                bw.write("patata y mas patata en la misma linea.");
                bw.newLine();
                bw.write("otra linea sin la palabra.");
                bw.newLine();
                bw.write("patata.");
            } catch (IOException e) {
                System.out.println("Error al crear archivo de prueba.");
            }
        }

        int contPalabra = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String linea = br.readLine();
            while (linea != null) {
                String[] palabras = linea.split("\\s+");
                for (String p : palabras) {
                    // Limpiar signos de puntuación básicos si los hubiera
                    p = p.replaceAll("[^a-zA-ZáéíóúÁÉÍÓÚñÑ]", "");
                    if (p.equalsIgnoreCase(palabraBusqueda)) {
                        contPalabra++;
                    }
                }
                linea = br.readLine();
            }

            System.out.println("[Ej 4] La palabra '" + palabraBusqueda + "' aparece " + contPalabra + " veces.");
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    /* -------------------------------------------------------------
     * Ejercicio 5: Serialización y deserialización de objetos
     * Commit 5: acdat.ut02.t01.05
     * ------------------------------------------------------------- */
    public static void ejercicio5() {
        // Nota: Asegúrate de que tu clase Persona implemente 'java.io.Serializable'
        Persona p1 = new Persona("Daniel", "Muñoz", 25, "123456789D");
        String ficheroSerial = "persona.dat";

        // Serializar objeto
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ficheroSerial))) {
            oos.writeObject(p1);
            System.out.println("[Ej 5] Objeto Persona serializado correctamente en " + ficheroSerial);
        } catch (IOException e) {
            System.err.println("Error al serializar: " + e.getMessage());
        }

        // Deserializar objeto
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ficheroSerial))) {
            Persona copiaP1 = (Persona) ois.readObject();
            System.out.println("[Ej 5] Objeto deserializado con éxito:");
            System.out.println("  -> Nombre: " + copiaP1.getNommbre() + " " + copiaP1.getApellido() +
                    ", Edad: " + copiaP1.getEdad() + ", DNI: " + copiaP1.getDNI());
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al deserializar: " + e.getMessage());
        }
    }

    /* -------------------------------------------------------------
     * Ejercicio 6: Gestión de un directorio de archivos
     * Commit 6: acdat.ut02.t01.06
     * ------------------------------------------------------------- */
    public static void ejercicio6() {
        File directory = new File("dir_prueba");
        if (!directory.exists()) {
            directory.mkdir();
            System.out.println("Directorio creado: " + directory.getName());
        }

        // Crear archivos dentro del directorio
        String[] files = {"file1.csv", "file2.txt"};
        for (String nombreFile : files) {
            File f = new File(directory, nombreFile);
            try {
                if (f.createNewFile()) {
                    System.out.println("Archivo creado: " + nombreFile);
                }
            } catch (IOException e) {
                System.err.println("No se pudo crear el archivo: " + nombreFile);
            }
        }

        // Listar contenidos
        System.out.println("[Ej 6] Listando contenido del directorio:");
        File[] listado = directory.listFiles();
        if (listado != null) {
            for (File file : listado) {
                System.out.println(" - " + (file.isDirectory() ? "[Carpeta] " : "[Archivo] ") + file.getName());
            }
        }
    }

    /* -------------------------------------------------------------
     * Ejercicio 7: Leer y escribir en ficheros binarios
     * ------------------------------------------------------------- */
    public static void ejercicio7() {
        File origenBin = new File("origen.bin");
        File destinoBin = new File("destino.bin");

        // Crear un fichero binario de prueba escribiendo bytes aleatorios
        try (FileOutputStream fos = new FileOutputStream(origenBin)) {
            fos.write(new byte[]{0x41, 0x42, 0x43, 0x44}); // Bytes de ejemplo (ABCD)
        } catch (IOException e) {
            System.err.println("Error al crear binario de prueba.");
        }

        // Copiar fichero binario usando FileInputStream y FileOutputStream
        try (FileInputStream fis = new FileInputStream(origenBin);
             FileOutputStream fos = new FileOutputStream(destinoBin)) {

            int b;
            while ((b = fis.read()) != -1) {
                fos.write(b);
            }

            System.out.println("[Ej 7] Fichero binario copiado correctamente de 'origen.bin' a 'destino.bin'.");

        } catch (IOException e) {
            System.err.println("Error en la gestión de flujos binarios: " + e.getMessage());
        }
    }

    /* -------------------------------------------------------------
    * Ejercicio 8: Lectura de un fichero CSV
    * -------------------------------------------------------------*/

    public static void ejercicio8() {
        String rutaCSV = "datos.csv";
        File file = new File(rutaCSV);

        if (!file.exists()) {
            System.out.println("El fichero " + rutaCSV + " no existe.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            System.out.println("--- Contenido del archivo CSV ---");
            while ((linea = br.readLine()) != null) {
                String[] columnas = linea.split(",");
                for (String col : columnas) {
                    System.out.printf("[%s]\t", col.trim());
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.err.println("Error al leer el fichero CSV: " + e.getMessage());
        }
    }

    /* Ejercicio 9: Escribir un fichero CSV */
    public static void ejercicio9() {
        String rutaCSV = "salida.csv";
        try (Scanner sc = new Scanner(System.in);
             BufferedWriter bw = new BufferedWriter(new FileWriter(rutaCSV, true))) {

            System.out.println("Introduce los datos para el registro CSV:");
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Apellido: ");
            String apellido = sc.nextLine();
            System.out.print("Edad: ");
            String edad = sc.nextLine();
            System.out.print("DNI: ");
            String dni = sc.nextLine();

            String lineaCsv = String.format("%s,%s,%s,%s", nombre, apellido, edad, dni);
            bw.write(lineaCsv);
            bw.newLine();

            System.out.println("Registro guardado con éxito en " + rutaCSV);
        } catch (IOException e) {
            System.err.println("Error al escribir en el fichero CSV: " + e.getMessage());
        }
    }

    /* Ejercicio 10: Gestión de archivos de configuración (Properties) */
    public static void ejercicio10() {
        String rutaConfig = "config.properties";

        // 1. Escritura de propiedades
        Properties props = new Properties();
        props.setProperty("app.nombre", "GestionACDAT");
        props.setProperty("app.version", "1.0.0");
        props.setProperty("db.url", "jdbc:mysql://localhost:3306/db_acdat");
        props.setProperty("db.user", "admin");

        try (FileOutputStream fos = new FileOutputStream(rutaConfig)) {
            props.store(fos, "Configuracion de la Aplicacion");
            System.out.println("Fichero de propiedades guardado correctamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar el fichero .properties: " + e.getMessage());
        }

        // 2. Lectura de propiedades
        Properties propsLeidas = new Properties();
        try (FileInputStream fis = new FileInputStream(rutaConfig)) {
            propsLeidas.load(fis);
            System.out.println("--- Contenido de " + rutaConfig + " ---");
            propsLeidas.forEach((key, val) -> System.out.println(key + " = " + val));
        } catch (IOException e) {
            System.err.println("Error al cargar el fichero .properties: " + e.getMessage());
        }
    }

    /* Ejercicio 11: Buscar y reemplazar texto en un fichero */
    public static void ejercicio11(String rutaOrigen, String rutaDestino, String buscar, String reemplazar) {
        File origen = new File(rutaOrigen);

        if (!origen.exists()) {
            System.out.println("El archivo de origen " + rutaOrigen + " no existe.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(origen));
             BufferedWriter bw = new BufferedWriter(new FileWriter(rutaDestino))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String lineaModificada = linea.replaceAll(buscar, reemplazar);
                bw.write(lineaModificada);
                bw.newLine();
            }
            System.out.println("Reemplazo finalizado. Resultado escrito en " + rutaDestino);
        } catch (IOException e) {
            System.err.println("Error al procesar la sustitución de texto: " + e.getMessage());
        }
    }

    /* Ejercicio 12: Comparar dos ficheros de texto */
    public static void ejercicio12(String rutaF1, String rutaF2) {
        File f1 = new File(rutaF1);
        File f2 = new File(rutaF2);

        if (!f1.exists() || !f2.exists()) {
            System.out.println("Uno o ambos ficheros a comparar no existen.");
            return;
        }

        try (BufferedReader br1 = new BufferedReader(new FileReader(f1));
             BufferedReader br2 = new BufferedReader(new FileReader(f2))) {

            String l1 = br1.readLine();
            String l2 = br2.readLine();
            int numLinea = 1;
            boolean sonIguales = true;

            while (l1 != null || l2 != null) {
                if (l1 == null || l2 == null || !l1.equals(l2)) {
                    sonIguales = false;
                    System.out.println("Diferencia encontrada en la línea " + numLinea + ":");
                    System.out.println("  [Fichero 1]: " + (l1 != null ? l1 : "<Fin de fichero>"));
                    System.out.println("  [Fichero 2]: " + (l2 != null ? l2 : "<Fin de fichero>"));
                }
                numLinea++;
                if (l1 != null) l1 = br1.readLine();
                if (l2 != null) l2 = br2.readLine();
            }

            if (sonIguales) {
                System.out.println("Los dos ficheros son exactamente iguales.");
            }
        } catch (IOException e) {
            System.err.println("Error al comparar los ficheros: " + e.getMessage());
        }
    }

    /* Ejercicio 13: Leer un fichero JSON (usando Gson) */
    public static void ejercicio13() {
        String rutaJson = "personas.json";
        File file = new File(rutaJson);

        if (!file.exists()) {
            System.out.println("El fichero " + rutaJson + " no existe.");
            return;
        }

        Gson gson = new Gson();
        try (FileReader reader = new FileReader(file)) {
            Type tipoLista = new TypeToken<List<Persona>>() {
            }.getType();
            List<Persona> personas = gson.fromJson(reader, tipoLista);

            System.out.println("--- Lista de Personas leídas del JSON ---");
            for (Persona p : personas) {
                System.out.println("Nombre: " + p.getNommbre() + " " + p.getApellido() +
                        ", Edad: " + p.getEdad() + ", DNI: " + p.getDNI());
            }
        } catch (IOException e) {
            System.err.println("Error al leer el fichero JSON: " + e.getMessage());
        }
    }

    /* Ejercicio 14: Escribir un fichero JSON (usando Gson) */
    public static void ejercicio14() {
        String rutaJson = "personas.json";
        List<Persona> lista = new ArrayList<>();
        lista.add(new Persona("Daniel", "Muñoz", 25, "123456789D"));
        lista.add(new Persona("María", "García", 22, "987654321M"));

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(rutaJson)) {
            gson.toJson(lista, writer);
            System.out.println("Fichero JSON escrito correctamente en " + rutaJson);
        } catch (IOException e) {
            System.err.println("Error al generar el fichero JSON: " + e.getMessage());
        }
    }


    /* Ejercicio 15: Leer y escribir ficheros XML (API DOM estándar) */
    public static void ejercicio15() {
        String rutaXml = "personas.xml";
        List<Persona> personas = List.of(
                new Persona("Daniel", "Muñoz", 25, "123456789D"),
                new Persona("Carlos", "López", 30, "876543210X")
        );

        // 1. Escritura XML con DOM
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element root = doc.createElement("personas");
            doc.appendChild(root);

            for (Persona p : personas) {
                Element elemPersona = doc.createElement("persona");

                Element nombre = doc.createElement("nombre");
                nombre.appendChild(doc.createTextNode(p.getNommbre()));
                elemPersona.appendChild(nombre);

                Element apellido = doc.createElement("apellido");
                apellido.appendChild(doc.createTextNode(p.getApellido()));
                elemPersona.appendChild(apellido);

                Element edad = doc.createElement("edad");
                edad.appendChild(doc.createTextNode(String.valueOf(p.getEdad())));
                elemPersona.appendChild(edad);

                Element dni = doc.createElement("dni");
                dni.appendChild(doc.createTextNode(p.getDNI()));
                elemPersona.appendChild(dni);

                root.appendChild(elemPersona);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(rutaXml));
            transformer.transform(source, result);

            System.out.println("Fichero XML escrito correctamente en " + rutaXml);
        } catch (Exception e) {
            System.err.println("Error al crear el XML: " + e.getMessage());
        }

        // 2. Lectura XML con DOM
        try {
            File xmlFile = new File(rutaXml);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            System.out.println("--- Lectura del archivo XML ---");
            NodeList nList = doc.getElementsByTagName("persona");

            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String nombre = element.getElementsByTagName("nombre").item(0).getTextContent();
                    String apellido = element.getElementsByTagName("apellido").item(0).getTextContent();
                    String edad = element.getElementsByTagName("edad").item(0).getTextContent();
                    String dni = element.getElementsByTagName("dni").item(0).getTextContent();
                    System.out.println("Persona: " + nombre + " " + apellido + " | Edad: " + edad + " | DNI: " + dni);
                }
            }
        } catch (Exception e) {
            System.err.println("Error al leer el XML: " + e.getMessage());
        }
    }


    /* Ejercicio 16: Crear un log de eventos en un fichero de texto */
    public static void ejercicio16() {
        Logger logger = Logger.getLogger("AppLogger");
        try {
            FileHandler fh = new FileHandler("eventos.log", true);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);

            logger.info("Aplicación iniciada.");
            logger.warning("Uso elevado de memoria detectado.");
            logger.severe("Fallo de conexión en la base de datos.");

            System.out.println("Eventos registrados en eventos.log");
        } catch (IOException e) {
            System.err.println("Error al configurar el logger: " + e.getMessage());
        }
    }


    /* Ejercicio 17: Cifrado y descifrado de archivos con AES */
    public static void ejercicio17(String rutaOrigen, String rutaCifrado, String rutaDescifrado) {
        try {
            // Generar clave simétrica AES
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            SecretKey secretKey = keyGen.generateKey();

            Cipher cipher = Cipher.getInstance("AES");

            // 1. Cifrar archivo
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] inputBytes = Files.readAllBytes(Paths.get(rutaOrigen));
            byte[] bytesCifrados = cipher.doFinal(inputBytes);
            Files.write(Paths.get(rutaCifrado), bytesCifrados);
            System.out.println("Fichero cifrado guardado en " + rutaCifrado);

            // 2. Descifrar archivo
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] bytesParaDescifrar = Files.readAllBytes(Paths.get(rutaCifrado));
            byte[] bytesDescifrados = cipher.doFinal(bytesParaDescifrar);
            Files.write(Paths.get(rutaDescifrado), bytesDescifrados);
            System.out.println("Fichero descifrado guardado en " + rutaDescifrado);

        } catch (Exception e) {
            System.err.println("Error durante el cifrado/descifrado: " + e.getMessage());
        }
    }
}

