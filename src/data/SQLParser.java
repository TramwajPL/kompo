package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import logic.Speed;
import logic.TooLargeIndexException;

/**
 *  Klasa zapisuj�ca i odczytuj�ca dane 
 *  z bazy SQL.
 */
public class SQLParser {
	/**
	 * Funkcja spisuj�ca z bazy danych na podstawie parametru 
	 * szybko�ci znajduj�ce si� w tabeli do listy speeds i 
	 * zwracaj�ca ta list�
	 * @param sql
	 * @return speeds
	 */
	public SpeedContainer convert(SQLConnection sql) {
	     
		Statement statement;
		ResultSet result = null;
		SpeedContainer speeds = new SpeedContainer();
		try {
			statement = sql.getCon().createStatement();
			result = statement.executeQuery("select *from szybkosci");

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			while (result.next()) {
				double a = result.getDouble("szybko��");
				double b = result.getDouble("przyspieszenie");
				double c = result.getDouble("op�rPowietrza");
				Speed speed = new Speed(a,b,c);
				speeds.add(speed);
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} 
		return speeds;
    }
	
	/**
	 * Funkcja zapisuj�ca szybko�ci z listy do tabeli 
	 * znajduj�cej si� w bazie danych sql.
	 * @param speeds
	 * @param sql
	 */
	public void convert(SpeedContainer speeds, SQLConnection sql) {
	     
		String query;
		PreparedStatement st;
		try {
			query = "DELETE FROM szybko�ci";
			st = sql.getCon().prepareStatement(query);
			st.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for(int i=0; i<speeds.size(); i++) {
			
			 query = "INSERT INTO szybko�ci" +
		              " (szybko��, przyspieszenie, op�rPowietrza)" +
		              " VALUES (?, ?, ?)";
			try {
				st = sql.getCon().prepareStatement(query);
				st.setDouble(1, speeds.get(i).getSpeed());
				st.setDouble(1, speeds.get(i).getAcceleration());
				st.setDouble(1, speeds.get(i).getAirResistance());
			    st.executeUpdate();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (TooLargeIndexException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
    }
}
