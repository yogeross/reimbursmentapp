package com.ymba.dao;

import java.sql.SQLException;
import java.util.List;

import com.ymba.beans.CurrentRequest;



public interface RequestDao {
	public List<CurrentRequest> getRequestList() throws SQLException;

}
