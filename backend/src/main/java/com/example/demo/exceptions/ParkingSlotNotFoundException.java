package com.example.demo.exceptions;

public class ParkingSlotNotFoundException extends Exception {
    public ParkingSlotNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
