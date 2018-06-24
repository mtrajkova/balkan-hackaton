package com.example.europa.persistance.repository;

import com.example.europa.model.blood.BloodDonationEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloodDonationEventRepository extends JpaRepository<BloodDonationEvent, Long> {
}
