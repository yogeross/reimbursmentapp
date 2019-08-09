package com.ymba.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ymba.beans.Employee;


public interface EmployeeDao {
	public abstract void create_employee(String firstname,String lastname, String username, String password,int departement_id,int position_id) throws SQLException;
	public abstract void register_event(int event_typeid,String event_datetime, String location, String description , String grading_format, String justification, Double cost) throws SQLException;
	public abstract void Claim_money (int employee_id, int event_id)throws SQLException;
	public abstract void submit_grade(String grade, int event_id)throws SQLException;
	public abstract void  alter_amount_requested(Double amount, int request_id)throws SQLException;
	public abstract void add_additional_info(String comments, int request_id) throws SQLException;
	public abstract String check_status (int request_id) throws SQLException;
	public abstract ArrayList <Employee> getAlldepartement()throws SQLException;
	public abstract void printAlldepartement()throws SQLException;
	

}
