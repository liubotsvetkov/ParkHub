package com.example.parkhub.exceptionHandlerModule;

public class ParkingSlotExistsException extends Exception {
    public ParkingSlotExistsException(String errorMessage) {
        super(errorMessage);
    }
}
