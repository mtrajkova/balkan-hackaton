package com.example.europa.persistance.service.impl;

import com.example.europa.model.blood.BloodDonationEvent;
import com.example.europa.model.Patient;
import com.example.europa.model.blood.BloodType;
import com.example.europa.model.blood.BloodTypeGives;
import com.example.europa.persistance.service.*;
import it.ozimov.springboot.mail.model.Email;
import it.ozimov.springboot.mail.model.defaultimpl.DefaultEmail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.internet.InternetAddress;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmailServiceImpl implements EmailService {
    private PatientService patientService;
    private BloodTypeService bloodTypeService;
    private BloodTypeGivesService bloodTypeGivesService;
    private it.ozimov.springboot.mail.service.EmailService emailService;

    @Value("${spring.mail.username}") String fromEmail;

    public EmailServiceImpl(PatientService patientService, BloodTypeService bloodTypeService, BloodTypeGivesService bloodTypeGivesService, it.ozimov.springboot.mail.service.EmailService emailService) {
        this.patientService = patientService;
        this.bloodTypeService = bloodTypeService;
        this.bloodTypeGivesService = bloodTypeGivesService;
        this.emailService = emailService;
    }

    @Override
    public void send(BloodDonationEvent event) throws UnsupportedEncodingException {

        Email email = DefaultEmail.builder()
                .from(new InternetAddress(fromEmail, "Europa Team"))
                .to(this.getDonatorsInternetAdresses(event))
                .subject("Need for blood donation")
                .body("There is a need for your blood type")
                .encoding("UTF-8")
                .build();

        emailService.send(email);
    }

    public List<InternetAddress> getDonatorsInternetAdresses(BloodDonationEvent event){

        String bloodType = event.getBloodType().getType();
        List<BloodTypeGives> donatorGroups = this.bloodTypeGivesService.findByReceivesType(bloodType);
        List<BloodType> qualifiedGroups = donatorGroups
                .stream()
                .map(btg -> this.bloodTypeService.findByType(btg.getGivesType()).get())
                .collect(Collectors.toList());

        List<Patient> donators = qualifiedGroups
                .stream()
                .map(bt -> this.patientService.findByBloodType(bt))
                .flatMap(List::stream)
                .collect(Collectors.toList());

        List<InternetAddress> internetAddresses = donators
                .stream()
                .map(d -> {
                    try {
                        return new InternetAddress(d.getEmail(), d.getFirstName() + " " + d.getLastName());
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        return null;
                    }
                })
                .collect(Collectors.toList());

        return internetAddresses;
    }
}
