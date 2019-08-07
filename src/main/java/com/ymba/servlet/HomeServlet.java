package com.ymba.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeServlet
 */
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("login.html").forward(request, response);
//		PrintWriter out = response.getWriter();
//		out.println("<!DOCTYPE html>\r\n" + 
//				"<html>\r\n" + 
//				"    <head>\r\n" + 
//				"      <title>TRMS Login</title>\r\n" + 
//				"      <style></style>  ");
//		out.println("<link rel=\"stylesheet\" href=\"resources/TRMS.css\">");
//		out.println("</head>\r\n" + 
//				"    <body>\r\n" + 
//				"      <div class=\"log-form\">\r\n" + 
//				"        <h2>Login to your account</h2>\r\n" + 
//				"        <form id=\"login\">\r\n" + 
//				"          <input type=\"text\" title=\"username\" placeholder=\"username\" />\r\n" + 
//				"          <input type=\"password\" title=\"username\" placeholder=\"password\" />\r\n" + 
//				"          <button type=\"submit\" value=\"login\" class=\"btn\">Login</button>\r\n" + 
//				"        </form>\r\n" + 
//				"        <form action=\"TRMSRegister.html\">\r\n" + 
//				"            <button type=\"submit\" value=\"register\" class=\"btn\">Register</button>\r\n" + 
//				"          </form>\r\n" + 
//				"      </div> \r\n" + 
//				"    </body>\r\n" + 
//				"</html>");
//		
		
		
		
		
		
		
		//AwsConnection aws = AwsConnection.getInstance();
		//Connection c = aws.getConnection();
		//System.out.println("Connection made");
		
	}

}
