package com.ymba.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		System.out.println("In do get of ListReimbursement");
		ObjectMapper mapper=new ObjectMapper();
		RequestDaoImpl rdao = new RequestDaoImpl();
		EmployeeDaoImpl edao = new EmployeeDaoImpl();
		
		HttpSession session = request.getSession();
		String user =  (String) session.getAttribute("employeeUsername");
		System.out.println("List reimbursement user: " + user);
		
		//String user = request.getParameter("username");
		PrintWriter out = response.getWriter();
		String requestJSON;
		//try {
			Employee e = edao.getEmployee(user);
			
			if(e.getPositionId() != 1) {
				requestJSON = mapper.writeValueAsString(rdao.getRequestsForReview(e));
				System.out.println("PositionId is not 1.");
			} else {
				requestJSON = mapper.writeValueAsString(rdao.getRequestsByEmployee(e.getEmployeeID()));
			}
			
			
			
			//requestJSON = mapper.writeValueAsString(rdao.getRequestsByEmployee(e.getEmployeeID()));
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
