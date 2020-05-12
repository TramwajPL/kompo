package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import logic.Speed;
import logic.TooLargeIndexException;

public class SQLParser {
	public SpeedContainer convert(SQLConnection sql) {
	     
		Statement statement;
		ResultSet result = null;
		SpeedContainer speeds = new SpeedContainer();
		try {
			statement = sql.getCon().createStatement();
			result = statement.executeQuery("select *from wydarzenia");

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
