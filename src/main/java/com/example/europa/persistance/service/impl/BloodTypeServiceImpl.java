package com.example.europa.persistance.service.impl;

import com.example.europa.model.blood.BloodType;
import com.example.europa.persistance.repository.BloodTypeRepository;
import com.example.europa.persistance.service.BloodTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BloodTypeServiceImpl implements BloodTypeService {
    @Autowired
    BloodTypeRepository bloodTypeRepository;

    @Override
    public void save(BloodType bloodType) {
        this.bloodTypeRepository.save(bloodType);
    }

    @Override
    public Optional<BloodType> findByType(String type) {
        return this.bloodTypeRepository.findByType(type);
    }
}
