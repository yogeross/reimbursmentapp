package com.ymba.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ymba.beans.Employee;


public interface EmployeeDao {
	public abstract void createEmployee(String firstname,String lastname, String username, String password,int departement_id,int position_id) throws SQLException;
	
	public abstract void claimMoney (int employee_id, int event_id)throws SQLException;
	public abstract void submitGrade(String grade, int event_id)throws SQLException;
	public abstract void alterAmountRequested(Double amount, int request_id)throws SQLException;
	public abstract void addInfo(String comments, int request_id) throws SQLException;
	public abstract String checkStatus (int request_id) throws SQLException;
	public abstract ArrayList <Employee> getDepartmentList() throws SQLException;
	public abstract void printAllDepartments() throws SQLException;
	

}
