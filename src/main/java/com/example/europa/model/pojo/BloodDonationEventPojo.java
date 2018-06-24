package com.example.europa.model.pojo;

public class BloodDonationEventPojo {
    private String description;
    private String name;
    private String bloodType;
    private String phoneNumber;

    public BloodDonationEventPojo() {
    }

    public BloodDonationEventPojo(String description, String name, String bloodType, String phoneNumber) {
        this.description = description;
        this.name = name;
        this.bloodType = bloodType;
        this.phoneNumber = phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
