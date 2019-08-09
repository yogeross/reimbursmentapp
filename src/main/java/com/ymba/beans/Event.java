package com.ymba.beans;
import java.sql.Date;
import java.sql.Time;

public class Event extends Request {
	int event_type_id ;
	String event_datetime, location, description, grading_format, justification;
	String work_missed;
	Double event_cost;
	public Event(int employee_id, int event_id, int event_type_id, String event_datetime, String location,
			String description, String grading_format, String justification, String work_missed, Double event_cost) {
		super(employee_id, event_id);
		this.event_type_id = event_type_id;
		this.event_datetime = event_datetime;
		this.location = location;
		this.description = description;
		this.grading_format = grading_format;
		this.justification = justification;
		this.work_missed = work_missed;
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
	public Double getEvent_cost() {
		return event_cost;
	}
	public void setEvent_cost(Double event_cost) {
		this.event_cost = event_cost;
	}
	@Override
	public String toString() {
		return "Event [event_type_id=" + event_type_id + ", "
				+ (event_datetime != null ? "event_datetime=" + event_datetime + ", " : "")
				+ (location != null ? "location=" + location + ", " : "")
				+ (description != null ? "description=" + description + ", " : "")
				+ (grading_format != null ? "grading_format=" + grading_format + ", " : "")
				+ (justification != null ? "justification=" + justification + ", " : "")
				+ (work_missed != null ? "work_missed=" + work_missed + ", " : "")
				+ (event_cost != null ? "event_cost=" + event_cost : "") + "]";
	}
}