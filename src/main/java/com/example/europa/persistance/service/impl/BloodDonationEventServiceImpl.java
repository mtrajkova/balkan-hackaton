package com.example.europa.persistance.service.impl;

import com.example.europa.model.blood.BloodDonationEvent;
import com.example.europa.persistance.repository.BloodDonationEventRepository;
import com.example.europa.persistance.service.BloodDonationEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloodDonationEventServiceImpl implements BloodDonationEventService {
    @Autowired
    private BloodDonationEventRepository bloodDonationEventRepository;

    @Override
    public List<BloodDonationEvent> findAll() {
        return this.bloodDonationEventRepository.findAll();
    }

    @Override
    public void save(BloodDonationEvent bloodDonationEvent) {
        this.bloodDonationEventRepository.save(bloodDonationEvent);
    }
}
