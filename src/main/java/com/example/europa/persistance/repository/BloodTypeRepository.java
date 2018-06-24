package com.example.europa.persistance.repository;

import com.example.europa.model.blood.BloodType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BloodTypeRepository extends JpaRepository<BloodType, String> {
    Optional<BloodType> findByType(String type);
}
