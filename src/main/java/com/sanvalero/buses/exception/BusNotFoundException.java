package com.sanvalero.buses.exception;

public class BusNotFoundException extends Exception {

    public BusNotFoundException() {
        super("Bus not found");
    }

    public BusNotFoundException(String message) {
        super(message);
    }
}
