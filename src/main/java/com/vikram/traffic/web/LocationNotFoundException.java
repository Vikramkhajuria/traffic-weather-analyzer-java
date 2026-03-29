package com.vikram.traffic.web;

public class LocationNotFoundException extends RuntimeException {
    public LocationNotFoundException(String location) {
        super("Unknown location: " + location);
    }
}
