package com.example.europa.persistance.service;

import com.example.europa.model.blood.BloodDonationApplication;

import java.util.List;
import java.util.Optional;

public interface BloodDonationApplicationService {
    List<BloodDonationApplication> findAll();
    List<BloodDonationApplication> findByEventId(Long eventId);
    List<BloodDonationApplication> findByPersonalId(String personalId);
    Optional<BloodDonationApplication> findById(Long id);
    void save(BloodDonationApplication bloodDonationApplication);

}
