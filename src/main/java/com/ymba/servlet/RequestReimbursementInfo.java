package com.ymba.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ymba.dao.RequestDaoImpl;

/**
 * Servlet implementation class RequestReimbursementInfo
 */
public class RequestReimbursementInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int requestId = Integer.valueOf(request.getParameter("requestID"));
		RequestDaoImpl rdao = new RequestDaoImpl();

		rdao.updateStatus(3, requestId);
		request.getRequestDispatcher("dashboard").forward(request, response);
		
	}

}
