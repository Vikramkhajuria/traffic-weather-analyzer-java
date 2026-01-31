package com.vikram.traffic.service;

import java.util.List;

public class RiskResult {
    private final String location;
    private final int temperature;
    private final String condition;
    private final int congestion;
    private final String riskLevel;
    private final int score;
    private final List<String> reasons;

    public RiskResult(String location,
                      int temperature,
                      String condition,
                      int congestion,
                      String riskLevel,
                      int score,
                      List<String> reasons
    )
    {
        this.location = location;
        this.temperature = temperature;
        this.condition = condition;
        this.congestion = congestion;
        this.riskLevel = riskLevel;
        this.score = score;
        this.reasons = reasons;
    }

    public String getLocation() { return location; }
    public int getTemperature() { return temperature; }
    public String getCondition() { return condition; }
    public int getCongestion() { return congestion; }
    public String getRiskLevel() { return riskLevel; }
    public int getScore() { return score; }
    public List<String> getReasons() { return reasons; }
}

