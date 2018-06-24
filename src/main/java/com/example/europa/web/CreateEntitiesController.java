package com.example.europa.web;

import com.example.europa.model.*;
import com.example.europa.model.blood.BloodDonationEvent;
import com.example.europa.model.blood.BloodType;
import com.example.europa.model.blood.BloodTypeGives;
import com.example.europa.model.blood.BloodTypeReceives;
import com.example.europa.persistance.service.*;
import com.example.europa.utils.LocalDateTimeToStringConverter;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
public class CreateEntitiesController {
    private ItemService itemService;
    private PatientService patientService;
    private MedicineService medicineService;
    private BloodTypeService bloodTypeService;
    private BloodTypeGivesService bloodTypeGivesService;
    private BloodTypeReceivesService bloodTypeReceivesService;
    private BloodDonationEventService bloodDonationEventService;

    public CreateEntitiesController(ItemService itemService, PatientService patientService, MedicineService medicineService, BloodTypeService bloodTypeService, BloodTypeGivesService bloodTypeGivesService, BloodTypeReceivesService bloodTypeReceivesService, BloodDonationEventService bloodDonationEventService) {
        this.itemService = itemService;
        this.patientService = patientService;
        this.medicineService = medicineService;
        this.bloodTypeService = bloodTypeService;
        this.bloodTypeGivesService = bloodTypeGivesService;
        this.bloodTypeReceivesService = bloodTypeReceivesService;
        this.bloodDonationEventService = bloodDonationEventService;
    }

    @GetMapping("/patient")
    public Patient createPatient() {
        Patient patient = new Patient();
        patient.setFirstName("Vladimir");
        patient.setLastName("Zdraveski");
        BloodType bloodType = this.bloodTypeService.findByType("A+").get();
        patient.setBloodType(bloodType);
        patient.setPoints(0L);
        patient.setCity("Skopje");
        patient.setEmail("vladimir_zdraveski@mail.com");
        patient.setCountry("North Macedonia");
        patient.setPersonalId("223305");
        patient.setPostalCode("1000");

        this.patientService.save(patient);

        return patient;
    }

    @GetMapping("/medicine")
    public List<Medicine> createMedicines() throws IOException {
        List<Medicine> medicines = new ArrayList<>();
        Path path = Paths.get("./medicine.jpeg");
        DecimalFormat df = new DecimalFormat(".##");
        byte[] picture = Files.readAllBytes(path);
        Random random = new Random();
        for (int i = 1; i < 6; i++) {
            Medicine medicine = new Medicine();
            medicine.setName("Medicine" + i);
            medicine.setDescription("Description" + i);
            medicine.setPoints(i + 5L);
            Double price = random.nextDouble() * 10 + i;
            medicine.setPrice(Double.parseDouble(df.format(price)));
            medicine.setPicture(picture);

            medicines.add(medicine);

            this.medicineService.save(medicine);
        }
        return medicines;
    }

    @GetMapping("/item")
    public List<Item> createItems() throws IOException {
        List<Item> items = new ArrayList<>();
        Path path = Paths.get("./item.png");
        byte[] picture = Files.readAllBytes(path);
        Random random = new Random();
        for (int i = 1; i < 6; i++) {
            Item item = new Item();
            item.setName("Item" + i);
            item.setPicture(picture);
            item.setPrice(new Long(random.nextInt(300)));

            items.add(item);
            this.itemService.save(item);
        }
        return items;
    }

    @GetMapping("/bloodTypes")
    public String createBloodType() throws IOException {
        BloodType aPositive = new BloodType("A+");
        BloodType aNegative = new BloodType("A-");
        BloodType abPositive = new BloodType("AB+");
        BloodType abNegative = new BloodType("AB-");
        BloodType oPositive = new BloodType("O+");
        BloodType oNegative = new BloodType("O-");
        BloodType bPositive = new BloodType("B+");
        BloodType bNegative = new BloodType("B-");

        Path ap = Paths.get("./A+.png");
        Path an = Paths.get("./A-.png");
        Path bp = Paths.get("./B+.png");
        Path bn = Paths.get("./B-.png");
        Path abp = Paths.get("./AB+.png");
        Path abn = Paths.get("./AB-.png");
        Path op = Paths.get("./O+.png");
        Path on = Paths.get("./O-.png");

        aPositive.setPicture(Files.readAllBytes(ap));
        aNegative.setPicture(Files.readAllBytes(an));
        bPositive.setPicture(Files.readAllBytes(bp));
        bNegative.setPicture(Files.readAllBytes(bn));
        abPositive.setPicture(Files.readAllBytes(abp));
        abNegative.setPicture(Files.readAllBytes(abn));
        oPositive.setPicture(Files.readAllBytes(op));
        oNegative.setPicture(Files.readAllBytes(on));

        this.bloodTypeService.save(aPositive);
        this.bloodTypeService.save(aNegative);
        this.bloodTypeService.save(bPositive);
        this.bloodTypeService.save(bNegative);
        this.bloodTypeService.save(abPositive);
        this.bloodTypeService.save(abNegative);
        this.bloodTypeService.save(oPositive);
        this.bloodTypeService.save(oNegative);

        BloodTypeGives btg1 = new BloodTypeGives("O+", "O+");
        BloodTypeGives btg2 = new BloodTypeGives("O+", "A+");
        BloodTypeGives btg3 = new BloodTypeGives("O+", "B+");
        BloodTypeGives btg4 = new BloodTypeGives("O+", "AB+");
        BloodTypeGives btg5 = new BloodTypeGives("A+", "A+");
        BloodTypeGives btg6 = new BloodTypeGives("A+", "AB+");
        BloodTypeGives btg7 = new BloodTypeGives("B+", "B+");
        BloodTypeGives btg8 = new BloodTypeGives("B+", "AB+");
        BloodTypeGives btg9 = new BloodTypeGives("AB+", "AB+");
        BloodTypeGives btg10 = new BloodTypeGives("O-", "O+");
        BloodTypeGives btg11 = new BloodTypeGives("O-", "O-");
        BloodTypeGives btg12 = new BloodTypeGives("O-", "A+");
        BloodTypeGives btg13 = new BloodTypeGives("O-", "A-");
        BloodTypeGives btg14 = new BloodTypeGives("O-", "B+");
        BloodTypeGives btg15 = new BloodTypeGives("O-", "B-");
        BloodTypeGives btg16 = new BloodTypeGives("O-", "AB+");
        BloodTypeGives btg17 = new BloodTypeGives("O-", "AB-");
        BloodTypeGives btg18 = new BloodTypeGives("A-", "A-");
        BloodTypeGives btg19 = new BloodTypeGives("A-", "A+");
        BloodTypeGives btg20 = new BloodTypeGives("A-", "AB+");
        BloodTypeGives btg21 = new BloodTypeGives("A-", "AB-");
        BloodTypeGives btg22 = new BloodTypeGives("B-", "B+");
        BloodTypeGives btg23 = new BloodTypeGives("B-", "B-");
        BloodTypeGives btg24 = new BloodTypeGives("B-", "AB+");
        BloodTypeGives btg25 = new BloodTypeGives("B-", "AB-");
        BloodTypeGives btg26 = new BloodTypeGives("AB-", "AB+");
        BloodTypeGives btg27 = new BloodTypeGives("AB-", "AB-");

        this.bloodTypeGivesService.save(btg1);
        this.bloodTypeGivesService.save(btg2);
        this.bloodTypeGivesService.save(btg3);
        this.bloodTypeGivesService.save(btg4);
        this.bloodTypeGivesService.save(btg5);
        this.bloodTypeGivesService.save(btg6);
        this.bloodTypeGivesService.save(btg7);
        this.bloodTypeGivesService.save(btg8);
        this.bloodTypeGivesService.save(btg9);
        this.bloodTypeGivesService.save(btg10);
        this.bloodTypeGivesService.save(btg11);
        this.bloodTypeGivesService.save(btg12);
        this.bloodTypeGivesService.save(btg13);
        this.bloodTypeGivesService.save(btg14);
        this.bloodTypeGivesService.save(btg15);
        this.bloodTypeGivesService.save(btg16);
        this.bloodTypeGivesService.save(btg17);
        this.bloodTypeGivesService.save(btg18);
        this.bloodTypeGivesService.save(btg19);
        this.bloodTypeGivesService.save(btg20);
        this.bloodTypeGivesService.save(btg21);
        this.bloodTypeGivesService.save(btg22);
        this.bloodTypeGivesService.save(btg23);
        this.bloodTypeGivesService.save(btg24);
        this.bloodTypeGivesService.save(btg25);
        this.bloodTypeGivesService.save(btg26);
        this.bloodTypeGivesService.save(btg27);


        BloodTypeReceives btr1 = new BloodTypeReceives("O+", "O+");
        BloodTypeReceives btr2 = new BloodTypeReceives("O+", "O-");
        BloodTypeReceives btr3 = new BloodTypeReceives("A+", "A+");
        BloodTypeReceives btr4 = new BloodTypeReceives("A+", "A-");
        BloodTypeReceives btr5 = new BloodTypeReceives("A+", "A+");
        BloodTypeReceives btr6 = new BloodTypeReceives("A+", "O+");
        BloodTypeReceives btr7 = new BloodTypeReceives("A+", "O-");
        BloodTypeReceives btr8 = new BloodTypeReceives("B+", "B+");
        BloodTypeReceives btr9 = new BloodTypeReceives("B+", "B-");
        BloodTypeReceives btr10 = new BloodTypeReceives("B+", "O+");
        BloodTypeReceives btr11 = new BloodTypeReceives("B+", "O-");
        BloodTypeReceives btr12 = new BloodTypeReceives("AB+", "O+");
        BloodTypeReceives btr13 = new BloodTypeReceives("AB+", "O-");
        BloodTypeReceives btr14 = new BloodTypeReceives("AB+", "A+");
        BloodTypeReceives btr15 = new BloodTypeReceives("AB+", "A-");
        BloodTypeReceives btr16 = new BloodTypeReceives("AB+", "B+");
        BloodTypeReceives btr17 = new BloodTypeReceives("AB+", "B-");
        BloodTypeReceives btr18 = new BloodTypeReceives("AB+", "AB-");
        BloodTypeReceives btr19 = new BloodTypeReceives("AB+", "AB+");
        BloodTypeReceives btr20 = new BloodTypeReceives("O-", "O-");
        BloodTypeReceives btr21 = new BloodTypeReceives("A-", "A-");
        BloodTypeReceives btr22 = new BloodTypeReceives("A-", "O-");
        BloodTypeReceives btr23 = new BloodTypeReceives("B-", "B-");
        BloodTypeReceives btr24 = new BloodTypeReceives("B-", "O-");
        BloodTypeReceives btr25 = new BloodTypeReceives("B-", "AB-");
        BloodTypeReceives btr26 = new BloodTypeReceives("AB-", "AB-");
        BloodTypeReceives btr27 = new BloodTypeReceives("AB-", "A-");
        BloodTypeReceives btr28 = new BloodTypeReceives("AB-", "B-");
        BloodTypeReceives btr29 = new BloodTypeReceives("AB-", "O-");

        this.bloodTypeReceivesService.save(btr1);
        this.bloodTypeReceivesService.save(btr2);
        this.bloodTypeReceivesService.save(btr3);
        this.bloodTypeReceivesService.save(btr4);
        this.bloodTypeReceivesService.save(btr5);
        this.bloodTypeReceivesService.save(btr6);
        this.bloodTypeReceivesService.save(btr7);
        this.bloodTypeReceivesService.save(btr8);
        this.bloodTypeReceivesService.save(btr9);
        this.bloodTypeReceivesService.save(btr10);
        this.bloodTypeReceivesService.save(btr11);
        this.bloodTypeReceivesService.save(btr12);
        this.bloodTypeReceivesService.save(btr13);
        this.bloodTypeReceivesService.save(btr14);
        this.bloodTypeReceivesService.save(btr15);
        this.bloodTypeReceivesService.save(btr16);
        this.bloodTypeReceivesService.save(btr17);
        this.bloodTypeReceivesService.save(btr18);
        this.bloodTypeReceivesService.save(btr19);
        this.bloodTypeReceivesService.save(btr20);
        this.bloodTypeReceivesService.save(btr21);
        this.bloodTypeReceivesService.save(btr22);
        this.bloodTypeReceivesService.save(btr23);
        this.bloodTypeReceivesService.save(btr24);
        this.bloodTypeReceivesService.save(btr25);
        this.bloodTypeReceivesService.save(btr26);
        this.bloodTypeReceivesService.save(btr27);

        return "blood types created";
    }

    @GetMapping("/event")
    public BloodDonationEvent createEvent(){
        BloodDonationEvent event = new BloodDonationEvent();
        event.setName("Blood donation event");

        event.setDateCreated(LocalDateTimeToStringConverter.convert(LocalDateTime.now()));
        event.setDescription("Event Description");
        event.setPhoneNumber("223 305");

        BloodType bloodType = this.bloodTypeService.findByType("O-").get();
        event.setBloodType(bloodType);
        this.bloodDonationEventService.save(event);

        event = new BloodDonationEvent();
        event.setName("Blood donation event");
        event.setDateCreated(LocalDateTimeToStringConverter.convert(LocalDateTime.now()));
        event.setDescription("Event Description");
        event.setPhoneNumber("223 305");

        bloodType = this.bloodTypeService.findByType("A+").get();
        event.setBloodType(bloodType);
        this.bloodDonationEventService.save(event);

        event = new BloodDonationEvent();
        event.setName("Blood donation event");
        event.setDateCreated(LocalDateTimeToStringConverter.convert(LocalDateTime.now()));
        event.setDescription("Event Description");
        event.setPhoneNumber("223 305");

        bloodType = this.bloodTypeService.findByType("AB-").get();
        event.setBloodType(bloodType);
        this.bloodDonationEventService.save(event);

        return event;
    }

}
