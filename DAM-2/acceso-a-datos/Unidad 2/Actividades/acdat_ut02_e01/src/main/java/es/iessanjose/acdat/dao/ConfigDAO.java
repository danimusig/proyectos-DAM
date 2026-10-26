package es.iessanjose.acdat.dao;

import es.iessanjose.acdat.model.DbConfigDTO;
import java.io.File;
import java.io.IOException;

public interface ConfigDAO {
    DbConfigDTO cargarConfiguracion(File archivo) throws IOException;
    void guardarConfiguracion(DbConfigDTO config, File archivo) throws IOException;
}