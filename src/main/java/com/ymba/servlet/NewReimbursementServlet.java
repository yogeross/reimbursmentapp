package com.ymba.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ymba.beans.Employee;
import com.ymba.beans.Event;
import com.ymba.dao.EmployeeDaoImpl;
import com.ymba.dao.EventDaoImpl;
import com.ymba.dao.RequestDaoImpl;

/**
 * Servlet implementation class NewReimbursementServlet
 */
public class NewReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Map<String, String[]> inputs = request.getParameterMap();
		

		
		EventDaoImpl edao = new EventDaoImpl();
		RequestDaoImpl rdao = new RequestDaoImpl();
		
		int eventTypeId = Integer.valueOf(request.getParameter("eventType"));
		
		String dateString = request.getParameter("date");
		String timeString = request.getParameter("time");
		String eventDateTime = dateString +" "+ timeString;
		
		String location = request.getParameter("location");
		String description = request.getParameter("description");
		
		
		String justification = request.getParameter("justify");
		String gradingFormat = request.getParameter("gradeFormat");
		
		
		
		
		
		double cost = Double.valueOf(request.getParameter("cost"));
		
		try {
			edao.registerEvent(eventTypeId, eventDateTime, location, description, gradingFormat, justification, cost);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Event> eventList;
		
		try {
			eventList = edao.getEventList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		int eventId = -1;
		for (Event e : eventList) {
			if (e.getEvent_type_id() == eventTypeId && e.getEvent_datetime() == eventDateTime) {
				// lets assume it's the correct event
				eventId = e.getEventId();
			}
		}
		HttpSession session = request.getSession();
		EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
		Employee currentEmployee = employeeDao.getEmployee( (String) session.getAttribute("username"));
		
		
		rdao.createRequest(currentEmployee.getEmployeeID(), eventId);
		
		
//		for (String paramName : inputs.keySet()) {
//			System.out.println(paramName);
//			response.getWriter().println(paramName);
//			System.out.println(request.getParameter(paramName));
//			response.getWriter().println(request.getParameter(paramName));
//		}
//		
		request.getRequestDispatcher("dashboard.html").forward(request, response);
		
		return;
		
		
		
	}

}
