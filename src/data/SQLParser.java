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
 *  Klasa zapisuj¹ca i odczytuj¹ca dane 
 *  z bazy SQL.
 */
public class SQLParser {
	/**
	 * Funkcja spisuj¹ca z bazy danych na podstawie parametru 
	 * szybkoœci znajduj¹ce siê w tabeli do listy speeds i 
	 * zwracaj¹ca ta listê
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
				double a = result.getDouble("szybkoœæ");
				double b = result.getDouble("przyspieszenie");
				double c = result.getDouble("opórPowietrza");
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
	 * Funkcja zapisuj¹ca szybkoœci z listy do tabeli 
	 * znajduj¹cej siê w bazie danych sql.
	 * @param speeds
	 * @param sql
	 */
	public void convert(SpeedContainer speeds, SQLConnection sql) {
	     
		String query;
		PreparedStatement st;
		try {
			query = "DELETE FROM szybkoœci";
			st = sql.getCon().prepareStatement(query);
			st.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for(int i=0; i<speeds.size(); i++) {
			
			 query = "INSERT INTO szybkoœci" +
		              " (szybkoœæ, przyspieszenie, opórPowietrza)" +
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
