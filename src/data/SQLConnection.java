package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {
	private Connection connection;
	
	public Connection getCon() {
		return connection;
	}
	
	public void ConnectToDatabase() {
		
		try {
			String host = "localhost";
			String dbname = "kalendarz";
			String url = String.format("jdbc:sqlserver://%s;databaseName=%s", host, dbname);
			String user = "sa";
			String pass = "123456789";
			String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			Class.forName(driver).newInstance();			
			connection = DriverManager.getConnection(url, user, pass);
			
		} catch (Exception ex) {
			System.err.println("Blad polaczenia z SQL");

		}
		
	}
	
	public void DisconnectDatabase() {
		try {
			connection.close();

		} catch (SQLException ex) {

		}
	}
}
