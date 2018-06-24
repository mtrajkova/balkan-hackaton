package com.example.europa.model.blood;

import javax.persistence.*;

@Entity
@Table(name = "BLOOD_TYPE_GIVES")
public class BloodTypeGives {
    @Id
    @GeneratedValue
    Long id;

    @Column(name = "GIVES_TYPE")
    private String givesType;

    @Column(name = "RECEIVES_TYPE")
    private String receivesType;

    public BloodTypeGives() {
    }

    public BloodTypeGives(String givesType, String receivesType) {
        this.givesType = givesType;
        this.receivesType = receivesType;
    }

    public String getGivesType() {
        return givesType;
    }

    public void setGivesType(String givesType) {
        this.givesType = givesType;
    }

    public String getReceivesType() {
        return receivesType;
    }

    public void setReceivesType(String receivesType) {
        this.receivesType = receivesType;
    }
}
