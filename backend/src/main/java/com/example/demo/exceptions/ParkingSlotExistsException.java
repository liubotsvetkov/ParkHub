package com.example.demo.exceptions;

public class ParkingSlotExistsException extends Exception {
    public ParkingSlotExistsException(String errorMessage) {
        super(errorMessage);
    }
}
