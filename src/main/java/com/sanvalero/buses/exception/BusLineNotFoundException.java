package com.sanvalero.buses.exception;

public class BusLineNotFoundException extends Exception {

    public BusLineNotFoundException() {
        super("BusLine not found");
    }

    public BusLineNotFoundException(String message) {
        super(message);
    }
}
