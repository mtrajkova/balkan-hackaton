package com.example.europa.persistance.repository;

import com.example.europa.model.blood.BloodDonationApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BloodDonationApplicationRepository extends JpaRepository<BloodDonationApplication, Long> {
    List<BloodDonationApplication> findByEventId(Long eventId);
    List<BloodDonationApplication> findByPersonalId(String personalId);
    Optional<BloodDonationApplication> findById(Long id);
}
