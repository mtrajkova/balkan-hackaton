package com.example.europa.model.blood;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "BLOOD_TYPE")
public class BloodType implements Serializable{

    @Id
    @Column(name = "TYPE")
    private String type;

    @Column(name = "PICTURE")
    private byte[] picture;

    public BloodType(String type, byte[] picture) {
        this.type = type;
        this.picture = picture;
    }

    public BloodType(String type){
        this.type = type;
    }

    public BloodType() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BloodType)) return false;

        BloodType bloodType = (BloodType) o;

        if (getType() != null ? !getType().equals(bloodType.getType()) : bloodType.getType() != null) return false;
        return Arrays.equals(getPicture(), bloodType.getPicture());
    }

    @Override
    public int hashCode() {
        int result = getType() != null ? getType().hashCode() : 0;
        result = 31 * result + Arrays.hashCode(getPicture());
        return result;
    }
}


