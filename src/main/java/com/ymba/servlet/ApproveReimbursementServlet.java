package com.ymba.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ymba.beans.Employee;
import com.ymba.dao.EmployeeDaoImpl;
import com.ymba.dao.RequestDaoImpl;

/**
 * Servlet implementation class ApproveReimbursementsServlet
 */
public class ApproveReimbursementServlet extends HttpServlet {
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
