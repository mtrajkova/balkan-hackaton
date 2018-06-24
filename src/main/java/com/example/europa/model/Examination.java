package com.example.europa.model;

import javax.persistence.*;

@Entity
@Table(name = "EXAMINATION")
public class Examination {
    @Id
    @GeneratedValue
    @Column(name = "EXAMINATION_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EXAMINATION_PATIENT")
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EXAMINATION_FAMILY_DOCTOR")
    private FamilyDoctor familyDoctor;

    public Examination(){}

    public Examination(Patient patient, FamilyDoctor familyDoctor) {
        this.patient = patient;
        this.familyDoctor = familyDoctor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public FamilyDoctor getFamilyDoctor() {
        return familyDoctor;
    }

    public void setFamilyDoctor(FamilyDoctor familyDoctor) {
        this.familyDoctor = familyDoctor;
    }
}
