package com.ymba.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ymba.beans.Employee;
import com.ymba.dao.EmployeeDaoImpl;
import com.ymba.dao.RequestDaoImpl;

/**
 * Servlet implementation class ListReimbursementsServlet
 */
public class ListReimbursementsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		ObjectMapper mapper=new ObjectMapper();
		RequestDaoImpl rdao = new RequestDaoImpl();
		EmployeeDaoImpl edao = new EmployeeDaoImpl();
		
		String user =request.getParameter("username");
		PrintWriter out = response.getWriter();
		String requestJSON;
		//try {
			Employee e = edao.getEmployee(user);
			requestJSON = mapper.writeValueAsString(rdao.getRequestsByEmployee(e.getEmployeeID()));
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(requestJSON);
			System.out.println(requestJSON);
		//} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
		out.flush();
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
