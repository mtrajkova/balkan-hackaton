package com.example.europa.persistance.service;

import com.example.europa.model.blood.BloodTypeGives;

import java.util.List;

public interface BloodTypeGivesService {
    void save(BloodTypeGives bloodTypeGives);
    List<BloodTypeGives> findByGivesType(String type);
    List<BloodTypeGives> findByReceivesType(String type);
}
