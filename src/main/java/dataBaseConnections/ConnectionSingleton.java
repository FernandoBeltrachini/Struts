package dataBaseConnections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingleton {

	private static ConnectionSingleton instance = null;
	Connection con = null;

	String user = new String("root");
	String password = new String("root");
	String jdbcUrlConnection = new String("jdbc:mysql://localhost:3306/struts");

	protected ConnectionSingleton() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(jdbcUrlConnection, user, password);
		} catch (SQLException | ClassNotFoundException e) {
		}
		
	}

	public static ConnectionSingleton getInstance() {
		if (instance == null) {
			instance = new ConnectionSingleton();
		}
		return instance;
	}

}