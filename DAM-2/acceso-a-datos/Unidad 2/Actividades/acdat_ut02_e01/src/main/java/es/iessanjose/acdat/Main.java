package es.iessanjose.acdat;

import es.iessanjose.acdat.dao.ConfigDAO;
import es.iessanjose.acdat.dao.JsonConfigDAO;
import es.iessanjose.acdat.dao.PropertiesConfigDAO;
import es.iessanjose.acdat.dao.XmlConfigDAO;
import es.iessanjose.acdat.model.DbConfigDTO;
import es.iessanjose.acdat.service.DatabaseConnectionService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    private static final Logger LOGGER = Logger.getLogger("acdat_ut01_e01.log");

    static {
        try {
            FileHandler fileHandler = new FileHandler("app_configuracion.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fileHandler);
            LOGGER.setLevel(Level.ALL);
        } catch (IOException e) {
            System.err.println("No se pudo inicializar el log: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File dirActual = new File(".");

        // Nombres de archivos soportados
        File fileProps = new File("config.properties");
        File fileXml = new File("config.xml");
        File fileJson = new File("config.json");

        List<File> disponibles = new ArrayList<>();
        if (fileProps.exists()) disponibles.add(fileProps);
        if (fileXml.exists()) disponibles.add(fileXml);
        if (fileJson.exists()) disponibles.add(fileJson);

        System.out.println("=================================");
        System.out.println("  SISTEMA DE CONFIGURACIÓN");
        System.out.println("=================================");
        System.out.println();

        DbConfigDTO configuracionCargada = null;

        if (!disponibles.isEmpty()) {
            System.out.println("Configuraciones disponibles:\n");
            for (int i = 0; i < disponibles.size(); i++) {
                System.out.printf("%d. %s\n", (i + 1), disponibles.get(i).getName());
            }
            System.out.println();
            System.out.print("Seleccione una configuración: ");
            int opcion = Integer.parseInt(scanner.nextLine().trim());

            if (opcion >= 1 && opcion <= disponibles.size()) {
                File archivoSeleccionado = disponibles.get(opcion - 1);
                configuracionCargada = cargarArchivo(archivoSeleccionado);
            } else {
                System.out.println("Opción no válida.");
                return;
            }
        } else {
            System.out.println("No se han encontrado configuraciones almacenadas.\n");
            System.out.println("Introduzca los datos de configuración:\n");

            System.out.print("Servidor: ");
            String host = scanner.nextLine().trim();

            System.out.print("Puerto: ");
            int puerto = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Base de datos: ");
            String dbName = scanner.nextLine().trim();

            System.out.print("Usuario: ");
            String usuario = scanner.nextLine().trim();

            System.out.print("Contraseña: ");
            String password = scanner.nextLine().trim();

            DbConfigDTO nuevaConfig = new DbConfigDTO(host, puerto, dbName, usuario, password);

            System.out.println("\nSeleccione el formato de almacenamiento:\n");
            System.out.println("1. Properties");
            System.out.println("2. XML");
            System.out.println("3. JSON\n");
            System.out.print("Opción: ");
            int opcionFormato = Integer.parseInt(scanner.nextLine().trim());

            File archivoDestino;
            ConfigDAO dao;

            switch (opcionFormato) {
                case 1:
                    archivoDestino = fileProps;
                    dao = new PropertiesConfigDAO();
                    break;
                case 2:
                    archivoDestino = fileXml;
                    dao = new XmlConfigDAO();
                    break;
                case 3:
                default:
                    archivoDestino = fileJson;
                    dao = new JsonConfigDAO();
                    break;
            }

            try {
                dao.guardarConfiguracion(nuevaConfig, archivoDestino);
                System.out.printf("\nConfiguración guardada correctamente como %s\n", archivoDestino.getName());
                LOGGER.info("Nueva configuración guardada en: " + archivoDestino.getName());
                configuracionCargada = nuevaConfig;
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "Error al guardar el archivo de configuración", e);
                System.err.println("Error al guardar la configuración: " + e.getMessage());
                return;
            }
        }

        if (configuracionCargada != null) {
            System.out.println("\nProbando conexión con los parámetros cargados...");
            DatabaseConnectionService.probarConexion(configuracionCargada);
        }
    }

    private static DbConfigDTO cargarArchivo(File archivo) {
        ConfigDAO dao;
        String nombre = archivo.getName().toLowerCase();

        if (nombre.endsWith(".properties")) {
            dao = new PropertiesConfigDAO();
        } else if (nombre.endsWith(".xml")) {
            dao = new XmlConfigDAO();
        } else if (nombre.endsWith(".json")) {
            dao = new JsonConfigDAO();
        } else {
            throw new IllegalArgumentException("Formato no soportado: " + nombre);
        }

        try {
            DbConfigDTO config = dao.cargarConfiguracion(archivo);
            LOGGER.info("Configuración cargada con éxito desde " + archivo.getName());
            return config;
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error al leer el fichero: " + archivo.getName(), e);
            System.err.println("No se pudo cargar la configuración: " + e.getMessage());
            return null;
        }
    }
}