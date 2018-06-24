package com.example.europa.persistance.service.impl;

import com.example.europa.model.blood.BloodTypeReceives;
import com.example.europa.persistance.repository.BloodTypeReceivesRepository;
import com.example.europa.persistance.service.BloodTypeReceivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BloodTypeReceivesServiceImpl implements BloodTypeReceivesService {
    @Autowired
    BloodTypeReceivesRepository bloodTypeReceivesRepository;

    @Override
    public void save(BloodTypeReceives bloodTypeReceives) {
        this.bloodTypeReceivesRepository.save(bloodTypeReceives);
    }
}
