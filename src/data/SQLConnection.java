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
	private String dbName;
	
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
	 * @throws ClassNotFoundException 
	 */
	public void ConnectToDatabase(){
		
		try {
			String host = "localhost";
			String dbname = "deska_rozdzielcza";
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
	
	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
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
