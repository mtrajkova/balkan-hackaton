package com.example.europa.model.blood;

import com.example.europa.model.blood.BloodType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "BLOOD_DONATION_EVENT")
public class BloodDonationEvent {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "DATE_CREATED")
    private String dateCreated;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne
    @JoinColumn(name = "BLOOD_TYPE")
    private BloodType bloodType;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
