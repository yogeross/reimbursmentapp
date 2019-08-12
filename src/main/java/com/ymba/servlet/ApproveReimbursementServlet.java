package com.ymba.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class ApproveReimbursementsServlet
 */
public class ApproveReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private int getNextStatus(int currentEmployeeType) {
		if (currentEmployeeType == 2) {
			return 5;
		} else if (currentEmployeeType == 3) {
			return 6;
		} else if (currentEmployeeType == 4) {
			return 1;
		} else if (currentEmployeeType == 5) {
			return 1;
		} else {
			return -1;
		}
	}
	


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ObjectMapper mapper=new ObjectMapper();
		RequestDaoImpl rdao = new RequestDaoImpl();
		EmployeeDaoImpl edao = new EmployeeDaoImpl();
		
		int status =Integer.parseInt(request.getParameter("status"));
		int requestID = Integer.parseInt(request.getParameter("requestID"));
		rdao.updateStatus(status, requestID);
		
		PrintWriter out = response.getWriter();
		String requestJSON;
		//try {
			
			requestJSON = null;
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(requestJSON);
			System.out.println(requestJSON);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int requestId = Integer.valueOf(request.getParameter("requestID"));
		EmployeeDaoImpl edao = new EmployeeDaoImpl();
		RequestDaoImpl rdao = new RequestDaoImpl();
		HttpSession session = request.getSession();
		String user =  (String) session.getAttribute("employeeUsername");
		Employee currentEmployee = edao.getEmployee(user);
		
		int newStatus = getNextStatus(currentEmployee.getPositionId());
		rdao.updateStatus(newStatus, requestId);
		
		
		request.getRequestDispatcher("dashboard").forward(request, response);
	}

}
