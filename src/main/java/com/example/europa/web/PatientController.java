package com.example.europa.web;

import com.example.europa.model.Patient;
import com.example.europa.persistance.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/patients", produces = MediaType.APPLICATION_JSON_VALUE)
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping("/all")
    public List<Patient> findAll(){
        return this.patientService.findAll();
    }

    @GetMapping("/{id}")
    public Patient findAll(@PathVariable String id){
        return this.patientService.findByPersonalId(id).get();
    }
}
