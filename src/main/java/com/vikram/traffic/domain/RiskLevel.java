package com.vikram.traffic.domain;

// A finite set of allowed Values
// Type safe, Easy to expand, Allows attaching behavior


public enum RiskLevel {
    LOW("Low risk "),
    MEDIUM("Moderate risk "),
    HIGH("High risk ");

    private final String message;

    RiskLevel(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

