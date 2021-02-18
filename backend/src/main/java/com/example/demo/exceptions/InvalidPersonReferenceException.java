package com.example.demo.exceptions;

public class InvalidPersonReferenceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidPersonReferenceException(String errorMessage) {
        super(errorMessage);
    }

}