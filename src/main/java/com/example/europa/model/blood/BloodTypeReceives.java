package com.example.europa.model.blood;


import javax.persistence.*;

@Entity
@Table(name = "BLOOD_TYPE_RECEIVES")
public class BloodTypeReceives {
    @Id
    @GeneratedValue
    Long id;

    @Column(name = "RECEIVES_TYPE")
    private String receivesType;

    @Column(name = "GIVES_TYPE")
    private String givesType;

    public BloodTypeReceives() {
    }

    public BloodTypeReceives(String receivesType, String givesType) {
        this.receivesType = receivesType;
        this.givesType = givesType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReceivesType() {
        return receivesType;
    }

    public void setReceivesType(String receivesType) {
        this.receivesType = receivesType;
    }

    public String getGivesType() {
        return givesType;
    }

    public void setGivesType(String givesType) {
        this.givesType = givesType;
    }
}
