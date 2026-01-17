package com.vikram.traffic.web;

import com.vikram.traffic.model.Location;
import com.vikram.traffic.service.RiskResult;
import com.vikram.traffic.service.RiskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RiskController {


    private final RiskService riskService;

    public RiskController (RiskService riskService){
        this. riskService = riskService;
    }

    @GetMapping("/analysis")
    public RiskResult analysis(@RequestParam String location) {
        return riskService.calculateRisk(location);
    }

    @GetMapping("/locations")
    public List<Location> locations() {
        return riskService.getLocations();
    }
}

