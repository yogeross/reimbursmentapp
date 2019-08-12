package com.ymba.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ymba.dao.EmployeeDaoImpl;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Map<String, String[]> inputs = request.getParameterMap();
		String name= request.getParameter("fname");
		response.getWriter().println(name);
		String lastName= request.getParameter("lname");
		response.getWriter().println(lastName);
		for (String paramName : inputs.keySet()) {
			System.out.println(paramName);
			response.getWriter().println(paramName);
			System.out.println(request.getParameter(paramName));
			response.getWriter().println(request.getParameter(paramName));
		}
		
		
		//EmployeeDaoImpl edao = new EmployeeDaoImpl();
		
		
		
		
		//edao.createEmployee(request.getParameter(fname),String lastname, String username, String password, int department_id, int position_id)
		
		
		
	}



	
	
}
