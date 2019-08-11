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
	private EmployeeDaoImpl edi= new EmployeeDaoImpl();
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
		
		
		if(checkCredentials(request.getParameter("username"), request.getParameter("password"))) {
			int employeePosition = edi.getEmployee(request.getParameter("username")).getPosition_id();
			if(employeePosition==1) {//normal dashboard
				System.out.println("Login success!");
				
				response.sendRedirect("dashboard.html");
				return;
				}
			else if(employeePosition==2) {//supervisor dashboard
				// TODO Display the dashboard
				System.out.println("Login success!");
				//re.forward("supeDashboard.html");
				request.getRequestDispatcher("supeDashboard.html").forward(request, response);
				return;
				}
			else if (employeePosition==3) {// head of department dashboard
				// TODO Display the dashboard
				System.out.println("Login success!");
				//response.sendRedirect("deptHeadDashboard.html");
				request.getRequestDispatcher("deptHeadDashboard.html").forward(request, response);
				return;
			}
			else {//benco dashboard
				// TODO Display the dashboard
				System.out.println("Login success!");
				request.getRequestDispatcher("bencoDashboard.html").forward(request, response);
				return;
			}
			
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
