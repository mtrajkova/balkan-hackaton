package com.example.europa.web;

import com.example.europa.model.*;
import com.example.europa.model.pojo.BuyItemPojo;
import com.example.europa.model.pojo.BuyMedicinePojo;
import com.example.europa.persistance.service.ItemService;
import com.example.europa.persistance.service.MedicineService;
import com.example.europa.persistance.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/buy")
@CrossOrigin
public class BuyController {
    private MedicineService medicineService;
    private PatientService patientService;
    private ItemService itemService;

    public BuyController(MedicineService medicineService, PatientService patientService, ItemService itemService) {
        this.medicineService = medicineService;
        this.patientService = patientService;
        this.itemService = itemService;
    }

    @PostMapping(value = "/medicine")
    public ResponseEntity buyMedicine(
            @RequestBody BuyMedicinePojo bmp) {
        try {
            Medicine medicine = this.medicineService.findById(Long.parseLong(bmp.getMedicineId())).get();
            Patient patient = this.patientService.findByPersonalId(bmp.getPersonalId()).get();
            patient.setPoints(patient.getPoints() + medicine.getPoints());
            this.patientService.save(patient);
            return ResponseEntity.status(HttpStatus.OK).body(patient);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("buying failed");
        }

    }

    @PostMapping("/item")
    public ResponseEntity buyItem(
            @RequestBody BuyItemPojo bip) {
        try {
            Item item= this.itemService.findById(Long.parseLong(bip.getItemId())).get();
            Patient patient = this.patientService.findByPersonalId(bip.getPersonalId()).get();
            patientService.buyItem(patient, item);
            this.patientService.save(patient);
            return ResponseEntity.status(HttpStatus.OK).body(patient);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }

}
