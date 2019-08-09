package com.ymba.beans;

import java.sql.Date;

public class Employee extends Request  {
	String firstname, lastname ,username, password;
	int departement_id,position_id ,supervisor_id;
	public Employee(int employee_id, int event_id, String firstname, String lastname, String username, String password,
			int departement_id, int position_id, int supervisor_id) {
		super(employee_id, event_id);
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.departement_id = departement_id;
		this.position_id = position_id;
		this.supervisor_id = supervisor_id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getDepartement_id() {
		return departement_id;
	}
	public void setDepartement_id(int departement_id) {
		this.departement_id = departement_id;
	}
	public int getPosition_id() {
		return position_id;
	}
	public void setPosition_id(int position_id) {
		this.position_id = position_id;
	}
	public int getSupervisor_id() {
		return supervisor_id;
	}
	public void setSupervisor_id(int supervisor_id) {
		this.supervisor_id = supervisor_id;
	}
	@Override
	public String toString() {
		return "Employee [" + (firstname != null ? "firstname=" + firstname + ", " : "")
				+ (lastname != null ? "lastname=" + lastname + ", " : "")
				+ (username != null ? "username=" + username + ", " : "")
				+ (password != null ? "password=" + password + ", " : "") + "departement_id=" + departement_id
				+ ", position_id=" + position_id + ", supervisor_id=" + supervisor_id + "]";
	}
}