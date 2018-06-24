package com.example.europa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "FAMILY_DOCTOR")
public class FamilyDoctor extends User {
    @Column(name = "FAMILY_DOCTOR_FIELD")
    private String familyDoctorField;

    @OneToMany(mappedBy = "familyDoctor")
    private List<Patient> patients;

    public FamilyDoctor(){}

    public FamilyDoctor(String familyDoctorField) {
        this.familyDoctorField = familyDoctorField;
        this.patients = new ArrayList<>();
    }

    public FamilyDoctor(String firstName, String lastName, String personalId, String email, String city, String country, String postalCode, String familyDoctorField, List<Patient> patients) {
        super(firstName, lastName, personalId, email, city, country, postalCode);
        this.familyDoctorField = familyDoctorField;
        this.patients = patients;
    }

    public String getFamilyDoctorField() {
        return familyDoctorField;
    }

    public void setFamilyDoctorField(String familyDoctorField) {
        this.familyDoctorField = familyDoctorField;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
