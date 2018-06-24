package com.example.europa.persistance.service;

import com.example.europa.model.Medicine;

import java.util.List;
import java.util.Optional;

public interface MedicineService {
    List<Medicine> findAll();
    Optional<Medicine> findById(Long id);
    void save(Medicine medicine);
}
