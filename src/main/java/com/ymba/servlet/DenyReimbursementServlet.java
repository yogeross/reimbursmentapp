package com.ymba.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ymba.beans.Employee;
import com.ymba.dao.EmployeeDaoImpl;
import com.ymba.dao.RequestDaoImpl;

/**
 * Servlet implementation class DenyReimbursementServlet
 */
public class DenyReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int requestId = Integer.valueOf(request.getParameter("requestID"));
		RequestDaoImpl rdao = new RequestDaoImpl();


		rdao.updateStatus(2, requestId);
		request.getRequestDispatcher("dashboard.html").forward(request, response);
		return;
		
	}

}
