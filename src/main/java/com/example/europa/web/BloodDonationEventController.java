package com.example.europa.web;

import com.example.europa.model.blood.BloodDonationApplication;
import com.example.europa.model.blood.BloodDonationEvent;
import com.example.europa.model.pojo.BloodDonationApplicationPojo;
import com.example.europa.model.pojo.BloodDonationEventPojo;
import com.example.europa.persistance.service.BloodDonationApplicationService;
import com.example.europa.persistance.service.BloodDonationEventService;
import com.example.europa.persistance.service.BloodTypeService;
import com.example.europa.persistance.service.EmailService;
import com.example.europa.utils.LocalDateTimeToStringConverter;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/blood/donation/events")
public class BloodDonationEventController {
    private BloodDonationEventService bloodDonationEventService;
    private BloodTypeService bloodTypeService;
    private EmailService emailService;
    private BloodDonationApplicationService bloodDonationApplicationService;

    public BloodDonationEventController(BloodDonationEventService bloodDonationEventService, BloodTypeService bloodTypeService, EmailService emailService, BloodDonationApplicationService bloodDonationApplicationService) {
        this.bloodDonationEventService = bloodDonationEventService;
        this.bloodTypeService = bloodTypeService;
        this.emailService = emailService;
        this.bloodDonationApplicationService = bloodDonationApplicationService;
    }

    @GetMapping("/all")
    public List<BloodDonationEvent> getAllEvents(){
        return this.bloodDonationEventService.findAll();
    }

    @PostMapping(value = "/create")
    public String createEvent(@RequestBody BloodDonationEventPojo event) throws UnsupportedEncodingException {
        BloodDonationEvent bloodDonationEvent = new BloodDonationEvent();
        bloodDonationEvent.setBloodType(this.bloodTypeService.findByType(event.getBloodType()).get());
        bloodDonationEvent.setName(event.getName());
        bloodDonationEvent.setPhoneNumber(event.getPhoneNumber());
        bloodDonationEvent.setDescription(event.getDescription());
        bloodDonationEvent.setDateCreated(LocalDateTimeToStringConverter.convert(LocalDateTime.now()));

        this.bloodDonationEventService.save(bloodDonationEvent);

        this.emailService.send(bloodDonationEvent);

        return "success";
    }

    @PostMapping(value = "/apply")
    public String createEvent(@RequestBody BloodDonationApplicationPojo bdap){
        BloodDonationApplication bda = new BloodDonationApplication();
        bda.setEventId(Long.parseLong(bdap.getEventId()));
        bda.setPersonalId(bdap.getPersonalId());
        this.bloodDonationApplicationService.save(bda);

        return "success";
    }
}
