package com.ymba.beans;

import java.sql.Date;

public class Request {
	int employee_id, event_id;

	public Request(int employee_id, int event_id) {
		super();
		this.employee_id = employee_id;
		this.event_id = event_id;
		
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public int getEvent_id() {
		return event_id;
	}

	public void setEvent_id(int event_id) {
		this.event_id = event_id;
		
	}

	@Override
	public String toString() {
		return "Request [employee_id=" + employee_id + ", event_id=" + event_id + "]";
	}
}
