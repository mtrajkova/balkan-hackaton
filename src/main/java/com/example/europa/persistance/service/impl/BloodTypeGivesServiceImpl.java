package com.example.europa.persistance.service.impl;

import com.example.europa.model.blood.BloodTypeGives;
import com.example.europa.persistance.repository.BloodTypeGivesRepository;
import com.example.europa.persistance.service.BloodTypeGivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloodTypeGivesServiceImpl implements BloodTypeGivesService {
    @Autowired
    private BloodTypeGivesRepository bloodTypeGivesRepository;


    @Override
    public void save(BloodTypeGives bloodTypeGives) {
        this.bloodTypeGivesRepository.save(bloodTypeGives);
    }

    @Override
    public List<BloodTypeGives> findByGivesType(String type) {
        return this.bloodTypeGivesRepository.findByGivesType(type);
    }

    @Override
    public List<BloodTypeGives> findByReceivesType(String type) {
        return this.bloodTypeGivesRepository.findByReceivesType(type);
    }
}
