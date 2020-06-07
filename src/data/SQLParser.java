package data;

import logic.TravelInformation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *  Klasa zapisuj¹ca i odczytuj¹ca dane 
 *  z bazy SQL.
 */
public class SQLParser {
	/**
	 * Funkcja spisuj¹ca z bazy danych na podstawie parametru 
	 * szybkoœci znajduj¹ce siê w tabeli do listy speeds i 
	 * zwracaj¹ca ta listê
	 * @param info
	 * @return speeds
	 */
	public TravelInformation convertFromSQL(TravelInformation info, SQLConnection sql) {
	    sql.ConnectToDatabase();
		Statement statement;
		ResultSet result = null;
		try {
			statement = sql.getCon().createStatement();
			result = statement.executeQuery("select *from deska");

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
	 * Funkcja zapisuj¹ca szybkoœci z listy do tabeli 
	 * znajduj¹cej siê w bazie danych sql.
	 * @param info
	 * @param sql
	 */
	public void convert(TravelInformation info, SQLConnection sql) {
	     
		String query;
		PreparedStatement st;
		try {
			query = "DELETE FROM deska";
			st = sql.getCon().prepareStatement(query);
			st.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		query = "INSERT INTO deska" +
		              " (totalDistance, firstDailyOdometerValue, secondDailyOdometerValue, totalTravelTime, singleTravelDistance, fuelConsumed)" +
		              " VALUES (?, ?, ?, ?, ?, ?)";
		try {
			st = sql.getCon().prepareStatement(query);
			st.setDouble(1, info.getTotalDistance());
			st.setDouble(2, info.getFirstDailyOdometerValue());
			st.setDouble(3, info.getSecondDailyOdometerValue());
			st.setInt(4, info.getTotalTravelTime());
			st.setDouble(5, info.getSingleTravelDistance());
			st.setDouble(6, info.getFuelConsumed());
			st.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
    }
}
