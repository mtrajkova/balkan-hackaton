package com.example.europa.persistance.repository;

import com.example.europa.model.blood.BloodTypeGives;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BloodTypeGivesRepository extends JpaRepository<BloodTypeGives, Long> {
    List<BloodTypeGives> findByGivesType(String type);
    List<BloodTypeGives> findByReceivesType(String type);
}
