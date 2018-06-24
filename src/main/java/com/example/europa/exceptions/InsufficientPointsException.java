package com.example.europa.exceptions;

public class InsufficientPointsException extends Exception {
    public InsufficientPointsException() {
        super("Insufficient points");
    }
}
