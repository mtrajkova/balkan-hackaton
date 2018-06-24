package com.example.europa.persistance.service;

import com.example.europa.model.blood.BloodDonationEvent;

import java.io.UnsupportedEncodingException;

public interface EmailService {
    void send(BloodDonationEvent event) throws UnsupportedEncodingException;
}
