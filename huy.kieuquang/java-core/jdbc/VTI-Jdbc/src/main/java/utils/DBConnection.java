package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBConnection {
	private static DBConnection instance;
	private final String FILE_PROPERTIES_NAME = "/database.properties";

	private Properties properties;
	private Connection connection;

	public DBConnection() {
		try {
			String currentDir = System.getProperty("user.dir");
			InputStream inputStream = new FileInputStream(currentDir + FILE_PROPERTIES_NAME);
			properties = new Properties();
			properties.load(inputStream);

			// Lay ra thong tin trong file properties
			String driver = properties.getProperty("driver");
			String database = properties.getProperty("database");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");

			Class.forName(driver);
			connection = DriverManager.getConnection(database, username, password);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static DBConnection getInstance() throws SQLException {
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

	public static void closeConnection(Connection con) throws SQLException {
		if (con != null) {
			con.close();
		}
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
	
	public static void closeCallableStatement(CallableStatement callSt) throws SQLException {
		if (callSt != null) {
			callSt.close();
		}
	}

}
