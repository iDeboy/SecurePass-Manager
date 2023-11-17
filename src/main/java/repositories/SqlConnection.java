package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnection {

	private final String user = "root";
	private final String password = "hono2002";
	private final String dataBase = "SecurePassManager";
	private final String host = "localhost";
	private final String port = "3306";

	private final String connectionString = "jdbc:mysql://" + host + ":" + port + "/" + dataBase;

	public SqlConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			System.out.println("No se cargo correctamente el driver.");
		}
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(connectionString, user, password);
	}

}
