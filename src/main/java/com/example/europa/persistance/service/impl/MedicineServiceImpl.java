package com.example.europa.persistance.service.impl;

import com.example.europa.model.Medicine;
import com.example.europa.persistance.repository.MedicineRepository;
import com.example.europa.persistance.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicineServiceImpl implements MedicineService {
    @Autowired
    private MedicineRepository medicineRepository;

    @Override
    public List<Medicine> findAll() {
        return this.medicineRepository.findAll();
    }

    @Override
    public Optional<Medicine> findById(Long id) {
        return this.medicineRepository.findById(id);
    }

    @Override
    public void save(Medicine medicine) {
        this.medicineRepository.save(medicine);
    }
}
