package es.iessanjose.acdat.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import es.iessanjose.acdat.model.DbConfigDTO;

import java.io.*;

public class JsonConfigDAO implements ConfigDAO {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public DbConfigDTO cargarConfiguracion(File archivo) throws IOException {
        try (Reader reader = new FileReader(archivo)) {
            return gson.fromJson(reader, DbConfigDTO.class);
        }
    }

    @Override
    public void guardarConfiguracion(DbConfigDTO config, File archivo) throws IOException {
        try (Writer writer = new FileWriter(archivo)) {
            gson.toJson(config, writer);
        }
    }
}