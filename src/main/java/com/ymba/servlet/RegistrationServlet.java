package com.ymba.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"\r\n" + 
				"<head>\r\n" + 
				"    <title>Registration</title>\r\n" + 
				"    <link rel=\"stylesheet\" href=\"TRMS.css\">\r\n" + 
				"</head>\r\n" + 
				"\r\n" + 
				"<body>\r\n" + 
				"\r\n" + 
				"    <div class=\"log-form\">\r\n" + 
				"        <h2>Employee Registration Form</h2>\r\n" + 
				"        <form id=\"registerForm\" action=\"register\" method=\"POST\">\r\n" + 
				"            <input type=\"text\" id=\"fname\" name=\"fname\" placeholder=\"First Name\" required>\r\n" + 
				"            <input type=\"text\" id=\"lname\" name=\"lname\" placeholder=\"Last Name\" required>\r\n" + 
				"            <input type=\"text\" id=\"uname\" name=\"uname\" placeholder=\"Username\" required>\r\n" + 
				"            <input type=\"text\" id=\"pword\" name=\"pword\" placeholder=\"Password\" required>\r\n" + 
				"            <input type=\"text\" id=\"vpword\" name=\"vpword\" placeholder=\"Verify Password\" required>\r\n" + 
				"");
		out.println("<select name=\"postion\">");
		
		// TODO for each position type do like <option value="emp">Employee</option>
        //                           <option value="supe">Supervisor</option>
        //                           <option value="head">Head of Department</option>
		
		out.println("</select>");
		
		// Then I need another dropdown for the department list
		
		out.println();
		
		out.println();
		out.println("<input type=\"number\" id=\"supeID\" placeholder=\"Supervisor ID #\" required>\r\n" + 
				"            <button type=\"submit\" class=\"btn\" value=\"Submit Form\">Finish Registration</button>\r\n" + 
				"        </form>\r\n" + 
				"    </div>\r\n" + 
				"    <script type=\"text/javascript\" src=\"TRMSRegister.js\"></script>\r\n" + 
				"</body>\r\n" + 
				"\r\n" + 
				"</html>");
	}

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
		
		
	}



	
	
}
