package es.iessanjose.acdat.service;

import es.iessanjose.acdat.model.DbConfigDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnectionService {
    private static final Logger LOGGER = Logger.getLogger(DatabaseConnectionService.class.getName());

    public static boolean probarConexion(DbConfigDTO config) {
        LOGGER.info("Intentando conectar a la BD con la URL: " + config.getJdbcUrl());
        try (Connection conn = DriverManager.getConnection(config.getJdbcUrl(), config.getUser(), config.getPassword())) {
            if (conn != null && !conn.isClosed()) {
                LOGGER.info("Conexión establecida exitosamente con el servidor: " + config.getHost());
                System.out.println("¡Conexión a la base de datos establecida correctamente!");
                return true;
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error de conexión a la base de datos: " + e.getMessage(), e);
            System.err.println("Error al conectar con la Base de Datos: " + e.getMessage());
        }
        return false;
    }
}