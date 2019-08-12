package com.ymba.dao;

import java.sql.SQLException;
import java.util.List;

import com.ymba.beans.Event;



public interface EventDao {
	public List<Event> getEventList() throws SQLException;
	public Event getEvent (int event_id)throws SQLException;

}
