package com.vikram.traffic.web;

import com.vikram.traffic.domain.TrafficAnalyzer;
import com.vikram.traffic.service.RiskService;

public class LocationNotFoundException extends RuntimeException {
    public LocationNotFoundException(String location) {
        super("Unknown location: " + location);
    }
}
