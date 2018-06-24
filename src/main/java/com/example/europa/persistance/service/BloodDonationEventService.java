package com.example.europa.persistance.service;

import com.example.europa.model.blood.BloodDonationEvent;

import java.util.List;

public interface BloodDonationEventService {
    List<BloodDonationEvent> findAll();
    void save(BloodDonationEvent bloodDonationEvent);
}
