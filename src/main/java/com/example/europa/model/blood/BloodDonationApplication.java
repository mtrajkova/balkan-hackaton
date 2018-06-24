package com.example.europa.model.blood;

import javax.persistence.*;

@Entity
@Table(name = "BLOOD_DONATION_APPLICATION")
public class BloodDonationApplication {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "PERSONAL_ID")
    private String personalId;;

    @Column(name = "EVENT_ID")
    private Long eventId;

    public BloodDonationApplication() {
    }

    public BloodDonationApplication(String personalId, Long eventId) {
        this.personalId = personalId;
        this.eventId = eventId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
}
