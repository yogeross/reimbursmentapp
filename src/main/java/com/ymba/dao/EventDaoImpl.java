package com.ymba.dao;

import java.sql.Blob;
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
			s= new Event(rs.getInt("event_id"),rs.getInt("fk_event_type_id"),rs.getString("event_datetime"),rs.getString("event_location"),rs.getString("event_description"),rs.getString("grading_format"),rs.getString("justification"),rs.getString("work_missed"), rs.getDouble("event_cost"));
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
			return new Event(rs.getInt("event_id"),rs.getInt("fk_event_type_id"),rs.getString("event_datetime"),rs.getString("event_location"),rs.getString("event_description"),rs.getString("grading_format"),rs.getString("justification"),rs.getString("work_ missed"), rs.getDouble("event_cost"));
		} catch (SQLException e) { 
			// TODO Fix error handling
			e.printStackTrace();
		}
		
		return null;
	}
	
	 
	 
 
	public void registerEvent( int event_typeid, String event_datetime, String location, 
								String description , String grading_format, 
								String justification, Double cost, String workMissed, Blob eventAttachment, Blob approvalAttachment, String approvalType, int employeeId) throws SQLException {

		Connection conn = aws.getConnection();
		String sql = "{ call insert_event_and_request(?,?,?,?,?,?,?, ?, ?, ?, ?, ?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, event_typeid);
		call.setString(2, event_datetime);
		call.setString(3, location);
		call.setString(4, description);
		call.setDouble(5, cost);
		call.setString(6, justification);
		call.setString(7, grading_format);
		call.setString(8, workMissed);
		call.setBlob(9, eventAttachment);
		call.setBlob(10, approvalAttachment);
		call.setString(11, approvalType);
		call.setInt(12, employeeId);
		
		call.execute();	
}

	 
	 
	 
	 
	
}
	
