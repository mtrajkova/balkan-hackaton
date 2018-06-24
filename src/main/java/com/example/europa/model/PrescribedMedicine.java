package com.example.europa.model;

import javax.persistence.*;

@Entity
@Table(name = "PRESCRIBED_MEDICINE")
public class PrescribedMedicine {
    @Id
    @GeneratedValue
    @Column(name = "PRESCRIBED_MEDICINE_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEDICINE")
    private Medicine medicine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRESCRIPTION")
    private Prescription prescription;

}
