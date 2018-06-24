package com.example.europa.model;

import javax.persistence.*;

@Entity
@Table(name = "PRESCRIPTION")
public class Prescription {
    @Id
    @GeneratedValue
    @Column(name = "PRESCRIPTION_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRESCRIPTION_PATIENT")
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRESCRIPTION_FAMILY_DOCTOR")
    private FamilyDoctor familyDoctor;


}
