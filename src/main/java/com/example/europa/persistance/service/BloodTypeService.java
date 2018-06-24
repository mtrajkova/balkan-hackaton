package com.example.europa.persistance.service;

import com.example.europa.model.blood.BloodType;

import java.util.Optional;

public interface BloodTypeService {
    void save(BloodType bloodType);
    Optional<BloodType> findByType(String type);
}
