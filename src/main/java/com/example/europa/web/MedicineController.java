package com.example.europa.web;

import com.example.europa.model.Medicine;
import com.example.europa.persistance.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/medicines")
@CrossOrigin
public class MedicineController {
    @Autowired
    private MedicineService medicineService;

    @GetMapping("/all")
    public List<Medicine> findAll(){
        return this.medicineService.findAll();
    }
}
