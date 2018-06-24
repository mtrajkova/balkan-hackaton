package com.example.europa.model.pojo;

public class BuyMedicinePojo {
    private String personalId;
    private String medicineId;

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }

    public BuyMedicinePojo() {
    }

    public BuyMedicinePojo(String personalId, String medicineId) {
        this.personalId = personalId;
        this.medicineId = medicineId;
    }
}
