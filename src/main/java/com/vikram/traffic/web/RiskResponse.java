package com.vikram.traffic.web;

public class RiskResponse {
    private final String location;
    private final int temperature;
    private final String condition;
    private final int congestion;
    private final String riskLevel;

    public RiskResponse(String location, int temperature, String condition, int congestion, String riskLevel) {
        this.location = location;
        this.temperature = temperature;
        this.condition = condition;
        this.congestion = congestion;
        this.riskLevel = riskLevel;
    }

    public String getLocation() { return location; }
    public int getTemperature() { return temperature; }
    public String getCondition() { return condition; }
    public int getCongestion() { return congestion; }
    public String getRiskLevel() { return riskLevel; }
}

