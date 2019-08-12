package com.ymba.beans;

public class Employee   {
	private int employee_id;
	private String firstname;
	private String lastname; 
	private String username;
	private String password;
	private int department_id;
	private int position_id ;
	private int supervisor_id;
	private double balance;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int employee_id, int department_id,int position_id,String firstname, String lastname, String username,
			String password,double balance, int supervisor_id) {
		this.employee_id=employee_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.department_id = department_id;
		this.position_id = position_id;
		this.supervisor_id = supervisor_id;
	}
	public int getEmployeeID() {
		return employee_id;
	}
	public void setEmployeeID(int employee_id) {
		this.employee_id = employee_id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
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
	public int getDepartementId() {
		return department_id;
	}
	public void setDepartementId(int departement_id) {
		this.department_id = departement_id;
	}
	public int getPositionId() {
		return position_id;
	}
	public void setPositionId(int position_id) {
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
		return "Employee [firstname=" + firstname + ", lastname=" + lastname + ", username=" + username + ", password="
				+ password + ", departement_id=" + department_id + ", position_id=" + position_id + ", supervisor_id="
				+ supervisor_id + "]";
	}
	
}