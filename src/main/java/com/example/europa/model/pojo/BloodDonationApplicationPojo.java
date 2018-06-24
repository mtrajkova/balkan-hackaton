package com.example.europa.model.pojo;

public class BloodDonationApplicationPojo {
    private String personalId;
    private String eventId;

    public BloodDonationApplicationPojo(String personalId, String eventId) {
        this.personalId = personalId;
        this.eventId = eventId;
    }

    public BloodDonationApplicationPojo() {
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }
}
