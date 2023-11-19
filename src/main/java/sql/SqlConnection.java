package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnection {

	private final String user = "SecurePassManager";
	private final String password = "app@2023";
	private final String dataBase = "SecurePassManagerDB";
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
