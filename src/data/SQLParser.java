package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import logic.Speed;
import logic.TooLargeIndexException;
import logic.TravelInformation;

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
	public TravelInformation convertFromSQL(TravelInformation info, SQLConnection sql) {
	     
		Statement statement;
		ResultSet result = null;
		try {
			statement = sql.getCon().createStatement();
			result = statement.executeQuery("select *from szybkosci");

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			while (result.next()) {
				double a = result.getDouble("totalDistance");
				double b = result.getDouble("firstDailyOdometerValue");
				double c = result.getDouble("secondDailyOdometerValue");
				int d = result.getInt("totalTravelTime");
				double e = result.getDouble("singleTravelDistance");
				double f = result.getDouble("fuelConsumed");
				info.setFirstDailyOdometerValue(b);
				info.setSecondDailyOdometerValue(c);
				info.setTotalDistance(a);
				info.setTotalTravelTime(d);
				info.setSingleTravelDistance(e);
				info.setFuelConsumed(f);
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} 
		return info;
    }
	
	/**
	 * Funkcja zapisuj�ca szybko�ci z listy do tabeli 
	 * znajduj�cej si� w bazie danych sql.
	 * @param speeds
	 * @param sql
	 */
	public void convert(TravelInformation info, SQLConnection sql) {
	     
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
		
		for(int i=0; i<6; i++) {
			
			 query = "INSERT INTO szybko�ci" +
		              " (szybko��, przyspieszenie, op�rPowietrza)" +
		              " VALUES (?, ?, ?)";
			try {
				st = sql.getCon().prepareStatement(query);
				st.setDouble(1, info.getTotalDistance());
				st.setDouble(1, info.getFirstDailyOdometerValue());
				st.setDouble(1, info.getSecondDailyOdometerValue());
				st.setInt(1, info.getTotalTravelTime());
				st.setDouble(1, info.getSingleTravelDistance());
				st.setDouble(1, info.getFuelConsumed());
			    st.executeUpdate();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
    }
}
