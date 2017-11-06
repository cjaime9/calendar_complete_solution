package com.anaplan.interview.controller;

import com.anaplan.interview.dao.CustomerEventDao;
import com.anaplan.interview.domain.CustomerEvent;
import com.anaplan.interview.domain.CustomerEventInput;
import com.anaplan.interview.domain.EventInput;
import com.anaplan.interview.service.CustomerEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerEventController {
    @Autowired
    private CustomerEventDao customerEventDao;

    @Autowired
    private CustomerEventService customerEventService;

    @RequestMapping(value = "customerevents", method = RequestMethod.POST)
    public String addCustomerToEvent(@RequestBody CustomerEventInput customerEventInput) {
        int count = customerEventService.addEventForCustomer(customerEventInput.getCustomerId(), customerEventInput.getEventId());
        if (count > 0) {
            return "SUCCESS";
        }
        return "FAILURE";
    }

    @RequestMapping(value = "customerevents", method = RequestMethod.DELETE)
    public String removeCustomerFromEvent(int customerId, int eventId) {
        int count = customerEventDao.removeCustomerFromEvent(customerId, eventId);
        if (count > 0) {
            return "SUCCESS";
        }
        return "FAILURE";
    }

    @RequestMapping(value = "customerevents", method = RequestMethod.GET)
    public List<CustomerEvent> getAllCustomerEvents() {
        List<CustomerEvent> customerEvents = customerEventDao.getCustomerEvents();
        return customerEvents;
    }

    @RequestMapping(value = "customerevents/customers/{customerId}", method = RequestMethod.GET)
    public List<CustomerEvent> getAllCustomerEventsForCustomer(@PathVariable int customerId) {
        List<CustomerEvent> customerEvents = customerEventDao.getCustomerEventsForCustomer(customerId);
        return customerEvents;
    }

    @RequestMapping(value = "customerevents/events/{eventId}", method = RequestMethod.GET)
    public List<CustomerEvent> getAllCustomersForEvent(@PathVariable int eventId) {
        List<CustomerEvent> customers = customerEventDao.getAllCustomersForEvent(eventId);
        return customers;
    }

}
