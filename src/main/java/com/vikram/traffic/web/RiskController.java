package com.vikram.traffic.web;

import com.vikram.traffic.service.RiskResult;
import com.vikram.traffic.service.RiskService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class RiskController {

    private final RiskService riskService;

    public RiskController(RiskService riskService) {
        this.riskService = riskService;
    }

    @GetMapping("/risk/{location}")
    public RiskResult risk(@PathVariable String location) {
        return riskService.calculateRisk(location);
    }
}

