package com.example.europa.persistance.service.impl;

import com.example.europa.model.blood.BloodDonationApplication;
import com.example.europa.persistance.repository.BloodDonationApplicationRepository;
import com.example.europa.persistance.service.BloodDonationApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BloodDonationApplicationServiceImpl implements BloodDonationApplicationService {
    @Autowired
    private BloodDonationApplicationRepository bloodDonationApplicationRepository;

    @Override
    public List<BloodDonationApplication> findAll() {
        return this.bloodDonationApplicationRepository.findAll();
    }

    @Override
    public List<BloodDonationApplication> findByEventId(Long eventId) {
        return this.bloodDonationApplicationRepository.findByEventId(eventId);
    }

    @Override
    public List<BloodDonationApplication> findByPersonalId(String personalId) {
        return this.bloodDonationApplicationRepository.findByPersonalId(personalId);
    }

    @Override
    public Optional<BloodDonationApplication> findById(Long id) {
        return this.bloodDonationApplicationRepository.findById(id);
    }

    @Override
    public void save(BloodDonationApplication bloodDonationApplication) {
        this.bloodDonationApplicationRepository.save(bloodDonationApplication);
    }
}
