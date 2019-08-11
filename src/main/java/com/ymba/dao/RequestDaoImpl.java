package com.ymba.dao;

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
	
	
	public List<CurrentRequest> getAllRequests() throws SQLException {

		List<CurrentRequest> requestList = new ArrayList<CurrentRequest>();
		Connection conn = aws.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM Request");
		CurrentRequest s = null;
		while (rs.next()) {
			s = new CurrentRequest(rs.getInt("fk_event_id"), rs.getDate("date_submitted").toString(), rs.getString("status"), rs.getString("employee_comments"), rs.getString("denial_reason"), rs.getDouble("amount_approved"), rs.getInt("supervisor_id"), rs.getDate("supervisor_approval_date").toString(), rs.getInt("dept_head_id"), rs.getDate("dept_head_approval_date").toString(), rs.getInt("benco_id"), rs.getDate("benco_approval_date").toString());
			requestList.add(s);
		}
		
		return requestList; 
	}

	
	public List<CurrentRequest> getRequestsByEmployee(int employee_id) {
		
		Connection conn = aws.getConnection();
		String sql = "SELECT * FROM REQUEST WHERE employee_id = ?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, employee_id);
			ResultSet rs = ps.executeQuery();
			
			List<CurrentRequest> requestList = new ArrayList<CurrentRequest>();
			if (rs.next()) {
				
				while (rs.next()) {
					requestList.add(new CurrentRequest(rs.getInt("fk_event_id"), rs.getDate("date_submitted").toString(), rs.getString("status"), rs.getString("employee_comments"), rs.getString("denial_reason"), rs.getDouble("amount_approved"), rs.getInt("supervisor_id"), rs.getDate("supervisor_approval_date").toString(), rs.getInt("dept_head_id"), rs.getDate("dept_head_approval_date").toString(), rs.getInt("benco_id"), rs.getDate("benco_approval_date").toString()));
					
				}
				
				return requestList;
				
			} else {
				// TODO handle this case WAY better
				return null;
			}
			
	
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		} // TODO Fix error handling return null;
		 
	}
	
	
	
	
}



