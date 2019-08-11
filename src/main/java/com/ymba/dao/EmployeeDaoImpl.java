package com.ymba.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ymba.beans.Employee;
import com.ymba.connection.AwsConnection;





public class EmployeeDaoImpl implements EmployeeDao {
	
	public static AwsConnection aws = AwsConnection.getInstance();
	
	public static boolean doesEmployeeExist(String username) {
		Connection conn = aws.getConnection();
		
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs= stmt.executeQuery("SELECT * FROM Employee WHERE EmployeeID="+username);
			
			if (rs.getMetaData().getColumnCount() == 0) {
				return false;
			} else {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO actually handle this exception
			e.printStackTrace();
		}

		return false;
		
	}
	
	public static boolean checkCredentials(String username, String password) {
		Connection conn = aws.getConnection();
		
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs= stmt.executeQuery("SELECT * FROM Employee WHERE EmployeeID="+username);
			
			if (rs.getString("USERNAME").equals(username) && rs.getString("PASSWORD").equals(password)) {
				return true;
			} else {
				return false;
			}
			
		} catch (SQLException e) {
			// TODO actually handle this exception
			e.printStackTrace();
		}

		return false;
		
		
	}

		
	public void createEmployee(String firstname,String lastname, String username, String password,int departement_id,int position_id) throws SQLException {
		Connection conn = aws.getConnection();
		String sql = "{ call insert_employee (?,?,?,?,?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, firstname);
		call.setString(2, lastname);
		call.setString(3, username);
		call.setString(4, password);
		call.setInt(6, departement_id);
		call.setInt(7,position_id );
		call.execute();	
	}
		     
		     
	public void registerEvent( int event_typeid, String event_datetime, String location, 
								String description , String grading_format, 
								String justification, Double cost) throws SQLException {
		
		Connection conn = aws.getConnection();
		String sql = "{ call insert_event (?,?,?,?,?,?,?)";
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


		
	public void claimMoney (int employee_id, int event_id) {

		Connection conn = aws.getConnection(); 
		String sql = "{ call insert_request (?,?)";
		CallableStatement call;
		try {
			call = conn.prepareCall(sql);
			call.setInt(1, employee_id);
			call.setInt(2, event_id);
		
			call.execute();
		} catch (SQLException e) {
			// TODO Add meaningful error message and actually handle the error
			e.printStackTrace();
		} 
		  
	}
	
	
	public void submitGrade(String grade, int event_id) throws SQLException {
		  Connection conn = aws.getConnection(); 
		  String sql = "{ call insert_request (?,?)";
		  CallableStatement call;
		  try {
			call = conn.prepareCall(sql);
			call.setString(1, grade);
			call.setInt(2, event_id);
		
			call.execute();
		} catch (SQLException e) {
			// TODO Add meaningful error message and actually handle the error
			e.printStackTrace();
		}  
		
	}
	
	
	public void alterAmountRequested(Double amount, int request_id ) throws SQLException {
		
		Connection conn = aws.getConnection(); 
		String sql = "{ call update_amount (?, ?)";
		
		try {
			CallableStatement call = conn.prepareCall(sql); 
			call.setDouble(1,amount);
			call.setInt(2, request_id);
			call.execute(); 
			}   catch (SQLException e) {
			// TODO Add meaningful error message and actually handle the error
			e.printStackTrace();
		}
		
	}
		
	public static Employee getEmployee(String username) {
		Employee employee=null;
		Connection conn = aws.getConnection();
		String sql = "SELECT * FROM employee WHERE username=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				employee=new Employee(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getDouble(8),rs.getInt(9));
				return employee;
			}
			else{
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	public void addInfo(String comments, int request_id) throws SQLException {
		Connection conn = aws.getConnection(); 
		String sql = "{ call update_amount (?, ?)";
		
		try {
			CallableStatement call = conn.prepareCall(sql); 
			call.setString(1,comments);
			call.setInt(2, request_id);
			call.execute();
		} catch (SQLException e) {
			// TODO Add meaningful error message and actually handle the error
			e.printStackTrace();
		}
		
		
	}

	
	public String checkStatus(int request_id) throws SQLException {
		Connection conn = aws.getConnection(); 
		String sql = "SELECT status FROM Request WHERE requestID = ?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, request_id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Add meaningful error message and actually handle the error
			e.printStackTrace();
		} 
		
		return null;
	}


	public ArrayList<Employee> getDepartmentList(){
	
		ArrayList<Employee> departementList = new ArrayList<Employee>(); 
		Connection conn = aws.getConnection();
		try {
			
			Statement stmt = conn.createStatement();

			ResultSet rs= stmt.executeQuery("SELECT Dept_Name FROM Employee a INNER JOIN departement b on a.PK_Dept_id=b.PK_Dept_id");
			Employee u = null;
			while (rs.next()) {
				u = new Employee(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getDouble(8),rs.getInt(9));
				departementList.add(u); 
			}
		} catch (SQLException e) {
			// TODO Fix error handling
			e.printStackTrace();
		}	
		return departementList; 
		
	}
	
	
	public void printAllDepartments() {
		ArrayList<Employee> departementList = this.getDepartmentList();
		for(Employee u:departementList ) {
			System.out.println(u.toString());
		}
	}
	
	



	
}
	
	
	




