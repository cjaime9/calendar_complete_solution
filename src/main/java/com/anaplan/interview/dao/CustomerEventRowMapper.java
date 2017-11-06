package com.anaplan.interview.dao;


import com.anaplan.interview.domain.CustomerEvent;
import com.anaplan.interview.domain.Event;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerEventRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        CustomerEvent customerEvent = new CustomerEvent();
        customerEvent.setEventId(rs.getLong("events.id"));
        customerEvent.setEventName(rs.getString("events.event_name"));
        customerEvent.setEventStartTime(rs.getLong("events.start_time"));
        customerEvent.setEventEndTime(rs.getLong("events.end_time"));
        customerEvent.setCustomerId(rs.getLong("customers.id"));
        customerEvent.setFirstName(rs.getString("customers.first_name"));
        customerEvent.setLastName(rs.getNString("customers.last_name"));
        return customerEvent;
    }
}
