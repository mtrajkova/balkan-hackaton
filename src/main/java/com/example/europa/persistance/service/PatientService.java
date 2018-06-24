package com.example.europa.persistance.service;

import com.example.europa.exceptions.InsufficientPointsException;
import com.example.europa.model.Item;
import com.example.europa.model.Patient;
import com.example.europa.model.blood.BloodType;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    Optional<Patient> findById(Long id);
    void save(Patient patient);
    List<Patient> findAll();
    Optional<Patient> findByPersonalId(String personalId);
    void buyItem(Patient patient, Item item) throws InsufficientPointsException;
    List<Patient> findByBloodType(BloodType bloodType);
}
