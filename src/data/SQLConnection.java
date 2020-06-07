package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *  Odpowiada za komunikacj� z baz� SQL.
 */
public class SQLConnection {
	private Connection connection;
	private String dbName;
	
	/**
	 *  Zwraca aktualne po��czenie z baz� SQL.
	 *  @return aktualne po��czanie z baz� SQL.
	 */
	public Connection getCon() {
		return connection;
	}
	
	/**
	 * Ustanawia po��czenie z baz� SQL.
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
