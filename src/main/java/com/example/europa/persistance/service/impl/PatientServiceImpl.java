package com.example.europa.persistance.service.impl;

import com.example.europa.exceptions.InsufficientPointsException;
import com.example.europa.model.Item;
import com.example.europa.model.Patient;
import com.example.europa.model.blood.BloodType;
import com.example.europa.persistance.repository.PatientRepository;
import com.example.europa.persistance.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Optional<Patient> findById(Long id) {
        return this.patientRepository.findById(id);
    }

    @Override
    public void save(Patient patient) {
        this.patientRepository.save(patient);
    }

    @Override
    public List<Patient> findAll() {
        return this.patientRepository.findAll();
    }

    @Override
    public Optional<Patient> findByPersonalId(String personalId) {
        return this.patientRepository.findByPersonalId(personalId);
    }

    @Override
    public void buyItem(Patient patient, Item item) throws InsufficientPointsException {
        if(patient.getPoints() < item.getPrice()){
            throw new InsufficientPointsException();
        }
        patient.setPoints(patient.getPoints() - item.getPrice());
    }

    @Override
    public List<Patient> findByBloodType(BloodType bloodType) {
        return this.patientRepository.findByBloodType(bloodType);
    }
}
