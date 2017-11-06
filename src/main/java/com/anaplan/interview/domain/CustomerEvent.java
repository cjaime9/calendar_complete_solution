package com.anaplan.interview.domain;

import java.util.Date;

public class CustomerEvent {
    private long customerId;

    private long eventId;

    private String firstName;

    private String lastName;

    private String eventName;

    private long eventStartTime;

    private long eventEndTime;

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public long getEventStartTime() {
        return eventStartTime;
    }

    public void setEventStartTime(long eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    public long getEventEndTime() {
        return eventEndTime;
    }

    public void setEventEndTime(long eventEndTime) {
        this.eventEndTime = eventEndTime;
    }

    public String getEventStartDate() {
        return new Date(getEventStartTime()).toString();
    }

    public String getEventEndDate() {
        return new Date(getEventEndTime()).toString();
    }

    @Override
    public String toString() {
        return "CustomerEvent{" +
                "customerId=" + customerId +
                ", eventId=" + eventId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", eventName='" + eventName + '\'' +
                ", eventStartTime=" + eventStartTime +
                ", eventEndTime=" + eventEndTime +
                '}';
    }
}
