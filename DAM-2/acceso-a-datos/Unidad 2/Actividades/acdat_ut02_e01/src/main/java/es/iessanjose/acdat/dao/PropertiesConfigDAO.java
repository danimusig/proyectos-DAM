package es.iessanjose.acdat.dao;

import es.iessanjose.acdat.model.DbConfigDTO;
import java.io.*;
import java.util.Properties;

public class PropertiesConfigDAO implements ConfigDAO {

    @Override
    public DbConfigDTO cargarConfiguracion(File archivo) throws IOException {
        Properties props = new Properties();
        try (InputStream in = new FileInputStream(archivo)) {
            props.load(in);
        }
        DbConfigDTO config = new DbConfigDTO();
        config.setHost(props.getProperty("db.host", "localhost"));
        config.setPort(Integer.parseInt(props.getProperty("db.port", "3306")));
        config.setDbName(props.getProperty("db.name", "test"));
        config.setUser(props.getProperty("db.user", "root"));
        config.setPassword(props.getProperty("db.password", ""));
        return config;
    }

    @Override
    public void guardarConfiguracion(DbConfigDTO config, File archivo) throws IOException {
        Properties props = new Properties();
        props.setProperty("db.host", config.getHost());
        props.setProperty("db.port", String.valueOf(config.getPort()));
        props.setProperty("db.name", config.getDbName());
        props.setProperty("db.user", config.getUser());
        props.setProperty("db.password", config.getPassword());

        try (OutputStream out = new FileOutputStream(archivo)) {
            props.store(out, "Configuracion de Conexion a Base de Datos");
        }
    }
}