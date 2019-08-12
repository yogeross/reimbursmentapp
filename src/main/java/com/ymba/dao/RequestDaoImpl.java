package com.ymba.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ymba.beans.CurrentRequest;
import com.ymba.connection.AwsConnection;




public class RequestDaoImpl {
	
	public static AwsConnection aws = AwsConnection.getInstance();
	
	public void updateStatus(int status,int requestID ) {
		Connection conn = aws.getConnection();
		String sql= "CALL update_status(?,?)";
		try {
			CallableStatement call = conn.prepareCall(sql);
			call.setInt(1,status);
			call.setInt(2, requestID);
			call.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public List<CurrentRequest> getAllRequests() throws SQLException {

		List<CurrentRequest> requestList = new ArrayList<CurrentRequest>();
		Connection conn = aws.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM Request");
		CurrentRequest s = null;
		while (rs.next()) {
			s = new CurrentRequest(rs.getInt("request_id"),rs.getInt("fk_event_id"), rs.getDate("date_submitted").toString(), rs.getInt("status_id"), rs.getString("comments"), rs.getString("denial_reason"), rs.getDouble("amount_approved"), rs.getInt("supervisor_id"), rs.getDate("supervisor_approval_date").toString(), rs.getInt("dept_head_id"), rs.getDate("dept_head_approval_date").toString(), rs.getInt("benco_id"), rs.getDate("benco_approval_date").toString());
			requestList.add(s);
		}
		
		return requestList; 
	}

	
	public List<CurrentRequest> getRequestsByEmployee(int employee_id) {
		
		Connection conn = aws.getConnection();
		String sql = "SELECT * FROM REQUEST WHERE fk_employee_id = ?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, employee_id);
			ResultSet rs = ps.executeQuery();
			
			List<CurrentRequest> requestList = new ArrayList<CurrentRequest>();
			
			while (rs.next()) {
				CurrentRequest cr = new CurrentRequest(rs.getInt("request_id"),rs.getInt("fk_event_id"), rs.getDate("date_submitted").toString(), rs.getInt("status_id"), rs.getString("comments"), rs.getString("denial_reason"), rs.getDouble("amount_approved"), rs.getInt("supervisor_id"), rs.getDate("supervisor_approval_date").toString(), rs.getInt("dept_head_id"), rs.getDate("dept_head_approval_date").toString(), rs.getInt("benco_id"), rs.getDate("benco_approval_date").toString());
				System.out.println("Printing a request");
				System.out.println(cr);
				requestList.add(cr);
				
			}

			return requestList;

		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		} // TODO Fix error handling return null;
		 
	}
	
	
	
	
	public void createRequest(int employee_id, int event_id) {
		try {
			CallableStatement insertCall = aws.getConnection().prepareCall("{call insert_request(?, ?)}");
			insertCall.setInt(1, employee_id);
			insertCall.setInt(2, event_id);
			insertCall.execute();
		} catch (SQLException e) {
			// TODO Actually handle this exception
			e.printStackTrace();
		}
	}
	
	
	
}



