package com.ymba.dao;

import java.sql.SQLException;
import java.util.List;

import com.ymba.beans.Request;



public interface RequestDao {
	public List<Request> getrequestList() throws SQLException;

}
