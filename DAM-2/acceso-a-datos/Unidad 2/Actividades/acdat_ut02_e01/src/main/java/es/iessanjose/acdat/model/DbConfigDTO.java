package es.iessanjose.acdat.model;

public class DbConfigDTO {
    private String host;
    private int port;
    private String dbName;
    private String user;
    private String password;

    public DbConfigDTO() {}

    public DbConfigDTO(String host, int port, String dbName, String user, String password) {
        this.host = host;
        this.port = port;
        this.dbName = dbName;
        this.user = user;
        this.password = password;
    }

    public String getHost() { return host; }
    public void setHost(String host) { this.host = host; }

    public int getPort() { return port; }
    public void setPort(int port) { this.port = port; }

    public String getDbName() { return dbName; }
    public void setDbName(String dbName) { this.dbName = dbName; }

    public String getUser() { return user; }
    public void setUser(String user) { this.user = user; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getJdbcUrl() {
        return String.format("jdbc:mysql://%s:%d/%s", host, port, dbName);
    }

    @Override
    public String toString() {
        return String.format("Servidor: %s | Puerto: %d | BD: %s | Usuario: %s", host, port, dbName, user);
    }
}

