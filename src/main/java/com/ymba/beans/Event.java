package com.ymba.beans;


public class Event {
	private int employee_id;
	private String location;
	private String description;
	private String grading_format;
	private String justification;
	private String work_missed;
	private double event_cost;
	private int event_type_id;
	private String event_datetime;
	
	
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Event(int employee_id, int event_id, int event_type_id, String event_datetime, String location,
			String description, String grading_format, String justification, String work_missed, double event_cost) {
		this.employee_id=employee_id;
		this.event_type_id = event_type_id;
		this.event_datetime = event_datetime;
		this.location = location;
		this.description = description;
		this.grading_format = grading_format;
		this.justification = justification;
		this.work_missed = work_missed;
		this.event_cost = event_cost;
	}


	public int getEmployee_id() {
		return employee_id;
	}


	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getGrading_format() {
		return grading_format;
	}


	public void setGrading_format(String grading_format) {
		this.grading_format = grading_format;
	}


	public String getJustification() {
		return justification;
	}


	public void setJustification(String justification) {
		this.justification = justification;
	}


	public String getWork_missed() {
		return work_missed;
	}


	public void setWork_missed(String work_missed) {
		this.work_missed = work_missed;
	}


	public double getEvent_cost() {
		return event_cost;
	}


	public void setEvent_cost(double event_cost) {
		this.event_cost = event_cost;
	}


	public int getEvent_type_id() {
		return event_type_id;
	}


	public void setEvent_type_id(int event_type_id) {
		this.event_type_id = event_type_id;
	}


	public String getEvent_datetime() {
		return event_datetime;
	}


	public void setEvent_datetime(String event_datetime) {
		this.event_datetime = event_datetime;
	}


	@Override
	public String toString() {
		return "Event [employee_id=" + employee_id + ", location=" + location + ", description=" + description
				+ ", grading_format=" + grading_format + ", justification=" + justification + ", work_missed="
				+ work_missed + ", event_cost=" + event_cost + ", event_type_id=" + event_type_id + ", event_datetime="
				+ event_datetime + "]";
	}
	

	
}