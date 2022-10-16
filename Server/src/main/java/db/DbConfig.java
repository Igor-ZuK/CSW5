package db;

public class DbConfig {
    private final String dbHost = System.getenv("DB_HOST");
    private final String dbPort = System.getenv().getOrDefault("DB_PORT", "3306");
    private final String dbUser = System.getenv("DB_USER");
    private final String dbPassword = System.getenv("DB_PASSWORD");
    private final String dbName = System.getenv("DB_NAME");

    public String getDbURL() {
        return "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
    }

    public String getDbHost() {
        return dbHost;
    }

    public String getDbPort() {
        return dbPort;
    }

    public String getDbName() {
        return dbName;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public String getDbUser() {
        return dbUser;
    }
}
