package com.ymba.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ymba.connection.AwsConnection;
import com.ymba.dao.EmployeeDaoImpl;



/**
 * Servlet implementation class DashboardServlet
 */
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Im IN THE GET METHOD");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out = response.getWriter();
		out.println(request.getParameter("username"));
		out.println(request.getParameter("password"));
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FUCK!");
		
		if(checkCredentials(request.getParameter("username"), request.getParameter("password"))) {
			// TODO Display the dashboard
			System.out.println("Login success!");
			response.sendRedirect("dashboard.html");
			return;
		} else {
			
			System.out.println("Login Failed");
			response.sendRedirect("home");
			return;
		}
		
	}
	
	public static boolean checkCredentials(String username, String password) {
		Connection conn = AwsConnection.getInstance().getConnection();
		System.out.println(username);
		System.out.println(password);
		
		
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs= stmt.executeQuery("SELECT * FROM Employee WHERE username='"+username+"'");
			if (rs.next()) {
				if (rs.getString("USERNAME").equals(username) && rs.getString("USER_PASSWORD").equals(password)) {
					return true;
				} else {
					return false;
				}
			}
		} catch (SQLException e) {
			// TODO actually handle this exception
			System.out.println("LOGIN EXCEPTION");
			e.printStackTrace();
		}

		return false;
		
		
	}

}
