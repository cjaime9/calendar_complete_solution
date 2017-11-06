package com.anaplan.interview.service;

import java.util.Date;
import java.util.List;

import com.anaplan.interview.dao.CustomerEventDao;
import com.anaplan.interview.dao.EventDao;
import com.anaplan.interview.domain.CustomerEvent;
import com.anaplan.interview.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerEventService {
    @Autowired
    private CustomerEventDao customerEventDao;

    @Autowired
    private EventDao eventDao;

    public int addEventForCustomer(long customerId, long eventId) {
        Event event = eventDao.findByEventId(eventId);
        List<CustomerEvent> conflictingEvents = customerEventDao.getNumberOfEventsUserHasAtCertainTime(customerId, new Date(event.getStartTime()), new Date(event.getEndTime()));
        if (conflictingEvents.size() > 0) {
            return 0;
        }
        return customerEventDao.addCustomerToEvent(customerId, eventId);
    }
}
