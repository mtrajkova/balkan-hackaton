package com.example.europa.persistance.repository;

import com.example.europa.model.Patient;
import com.example.europa.model.blood.BloodType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByPersonalId(String personalId);
    List<Patient> findByBloodType(BloodType bloodType);
}
