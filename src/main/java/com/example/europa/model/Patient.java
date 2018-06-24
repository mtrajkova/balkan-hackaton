package com.example.europa.model;

import com.example.europa.model.blood.BloodType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "PATIENT")
public class Patient extends User {
    @JsonIgnore
    @Column(name = "PATIENT_FIELD")
    private String patientField;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PATIENT_FAMILY_DOCTOR")
    private FamilyDoctor familyDoctor;

    @Column(name = "PATIENT_POINTS")
    private Long points;

    @ManyToOne
    @JoinColumn(name = "BLOOD_TYPE")
    private BloodType bloodType;

    public Patient(){}

    public Patient(String patientField, FamilyDoctor familyDoctor, Long points, BloodType bloodType) {
        this.patientField = patientField;
        this.familyDoctor = familyDoctor;
        this.points = points;
        this.bloodType = bloodType;
    }

    public Patient(String firstName, String lastName, String personalId, String email, String city, String country, String postalCode, String patientField, FamilyDoctor familyDoctor, Long points, BloodType bloodType) {
        super(firstName, lastName, personalId, email, city, country, postalCode);
        this.patientField = patientField;
        this.familyDoctor = familyDoctor;
        this.points = points;
        this.bloodType = bloodType;
    }

    public String getPatientField() {
        return patientField;
    }

    public FamilyDoctor getFamilyDoctor() {
        return familyDoctor;
    }

    public Long getPoints() {
        return points;
    }

    public void setPatientField(String patientField) {
        this.patientField = patientField;
    }

    public void setFamilyDoctor(FamilyDoctor familyDoctor) {
        this.familyDoctor = familyDoctor;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }
}
