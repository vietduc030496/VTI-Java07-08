package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBConnection {
    private static DBConnection instance;
    private final String fileProperties = "/application.properties";

    private Properties properties;
    private Connection connection;

    private DBConnection() throws IOException, ClassNotFoundException, SQLException {
        String currentDir = System.getProperty("user.dir");
        InputStream inputStream = new FileInputStream(currentDir + fileProperties);
        properties = new Properties();
        properties.load(inputStream);

        String driver = properties.getProperty("driver");
        String database = properties.getProperty("database");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        Class.forName(driver);
        connection = DriverManager.getConnection(database, username, password);
    }

    public static DBConnection getInstance() throws SQLException, IOException, ClassNotFoundException {
        if (instance == null) {
            instance = new DBConnection();
        } else if (instance.getConnection().isClosed()) {
            // Mo lai connection
            instance = new DBConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public static void closeResultSet(ResultSet rs) throws SQLException {
        if (rs != null) {
            rs.close();
        }
    }

    public static void closeStatement(Statement sta) throws SQLException {
        if (sta != null) {
            sta.close();
        }
    }

    public static void closePreparedStatement(PreparedStatement ps) throws SQLException {
        if (ps != null) {
            ps.close();
        }
    }

    public static void closeConnection(Connection con) throws SQLException {
        if (con != null) {
            con.close();
        }
    }
}
