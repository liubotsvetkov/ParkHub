package com.example.parkhub.exceptionHandlerModule;

public class ParkingSlotNotFoundException extends Exception {
    public ParkingSlotNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
