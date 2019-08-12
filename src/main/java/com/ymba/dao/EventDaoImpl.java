package com.ymba.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ymba.beans.Event;
import com.ymba.connection.AwsConnection;




public class EventDaoImpl implements EventDao {

	public static AwsConnection aws = AwsConnection.getInstance();
	
	public List<Event> getEventList() throws SQLException {
		List<Event> eventList = new ArrayList<Event>(); 
		Connection conn= aws.getConnection();
		Statement stmt= conn.createStatement();
		ResultSet rs= stmt.executeQuery("SELECT * FROM Event");
		Event s= null;
		while(rs.next()) {
			s= new Event(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getDouble(10));
			eventList.add(s);
			
		}
		return eventList;

	}

	 public Event getEvent (int event_id) {
		Connection conn = aws.getConnection();
		String sql = "SELECT * FROM EVENT WHERE event_id = ?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, event_id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			//return new Event(employee_id, event_id,     event_type_id, event_datetime, location,       description,   grading_format, justification, work_missed, event_cost)
			return new Event(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getDouble(10));
		} catch (SQLException e) { 
			// TODO Fix error handling
			e.printStackTrace();
		}
		
		return null;
	}
	
	 
	 
 
	public void registerEvent( int event_typeid, String event_datetime, String location, 
								String description , String grading_format, 
								String justification, Double cost) throws SQLException {

		Connection conn = aws.getConnection();
		String sql = "{ call insert_event(?,?,?,?,?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, event_typeid);
		call.setString(2, event_datetime);
		call.setString(3,location );
		call.setString(4, description);
		call.setString(5, grading_format);
		call.setString(6, justification);
		call.setDouble(7, cost);
		
		call.execute();	
}

	 
	 
	 
	 
	
}
	
