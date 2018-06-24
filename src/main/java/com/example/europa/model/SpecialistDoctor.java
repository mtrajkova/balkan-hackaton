package com.example.europa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "SPECIALIST_DOCTOR")
public class SpecialistDoctor extends User {
    @Column(name = "SPECIALIST_DOCTOR_FIELD")
    private String specialistDoctorField;

    public SpecialistDoctor(){}

    public SpecialistDoctor(String specialistDoctorField) {
        this.specialistDoctorField = specialistDoctorField;
    }

    public SpecialistDoctor(String firstName, String lastName, String personalId, String email, String city, String country, String postalCode, String specialistDoctorField) {
        super(firstName, lastName, personalId, email, city, country, postalCode);
        this.specialistDoctorField = specialistDoctorField;
    }
}
