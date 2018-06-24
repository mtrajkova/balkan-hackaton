package com.example.europa.model;

import javax.persistence.*;

@Entity
@Table(name = "MEDICINE")
public class Medicine {
    @Id
    @GeneratedValue
    @Column(name = "MEDICINE_ID")
    private Long id;

    @Column(name = "MEDICINE_NAME")
    private String name;

    @Column(name = "MEDICINE_PRICE")
    private Double price;

    @Column(name = "MEDICINE_POINTS")
    private Long points;

    @Column(name = "MEDICINE_PICTURE")
    private byte[] picture;

    @Column(name = "MEDICINE_DESCRIPTION")
    private String description;

    public Medicine(){}

    public Medicine(String name, Double price, Long points, byte[] picture, String description) {
        this.name = name;
        this.price = price;
        this.points = points;
        this.picture = picture;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
