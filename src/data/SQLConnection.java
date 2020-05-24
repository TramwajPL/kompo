package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *  Odpowiada za komunikacje
 *  z baza SQL.
 */
public class SQLConnection {
	private Connection connection;
	
	/**
	 *  Zwraca aktualne polaczenie z baza SQL.
	 *  
	 *  @return aktualne polaczanie z baza SQL.
	 */
	public Connection getCon() {
		return connection;
	}
	
	/**
	 * Ustanawia polaczenie z baza SQL
	 */
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
	
	/**
	 * Odpowiada za rozlaczenie z baza SQL
	 */
	public void DisconnectDatabase() {
		try {
			connection.close();

		} catch (SQLException ex) {

		}
	}
}
