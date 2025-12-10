package com.vikram.traffic.domain;

import com.vikram.traffic.model.TrafficInfo;
import com.vikram.traffic.model.WeatherInfo;
import com.vikram.traffic.domain.RiskLevel;


public class TrafficAnalyzer {

    public static RiskLevel getRiskLevel(WeatherInfo Weather1, TrafficInfo trafficInfo1) {
        String condition = Weather1.getCondition();
        int congestion = trafficInfo1.getCongestionLevel();

        if (congestion >= 8 && condition.equals("Snow")) {
            return RiskLevel.HIGH;

        } else if (congestion >= 6) {
            return RiskLevel.MEDIUM;

        } else {
            return RiskLevel.LOW;
        }
    }
}