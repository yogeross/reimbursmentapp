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




public class RequestDaoImpl implements RequestDao {
	
	public static AwsConnection aws = AwsConnection.getInstance();
	
	public List<CurrentRequest> getRequestList() throws SQLException {
		return null;
		/*
		 * List<CurrentRequest> requestList = new ArrayList<CurrentRequest>();
		 * Connection conn= aws.getConnection(); Statement stmt= conn.createStatement();
		 * ResultSet rs= stmt.executeQuery("SELECT * FROM Request"); CurrentRequest s=
		 * null; while(rs.next()) { s= new CurrentRequest(rs.getInt(1),rs.getInt(2));
		 * requestList.add(s);
		 * 
		 * } return requestList;
		 */
	}

	
	public CurrentRequest getRequest (int employee_id) {
		return null;
		
		/*
		 * Connection conn = aws.getConnection(); String sql =
		 * "SELECT * FROM REQUEST WHERE employee_id = ?"; PreparedStatement ps; try { ps
		 * = conn.prepareStatement(sql); ps.setInt(1, employee_id); ResultSet rs =
		 * ps.executeQuery(); rs.next(); return new CurrentRequest(
		 * rs.getInt(2),rs.getInt(3)); } catch (SQLException e) {
		 * 
		 * e.printStackTrace(); } // TODO Fix error handling return null;
		 */
	}
	
	
	
	
}



