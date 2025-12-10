package com.vikram.traffic.domain;

import com.vikram.traffic.model.TrafficInfo;
import com.vikram.traffic.model.WeatherInfo;

public class TrafficAnalyzer {

    public static String getRiskLevel(WeatherInfo Weather1, TrafficInfo trafficInfo1) {
        String condition = Weather1.getCondition();
        int congestion = trafficInfo1.getCongestionLevel();

        if (congestion >= 8 && condition.equals("Snow")) {
            return "High";
        } else if (congestion >= 6) {
            return "medium";

        } else {
            return "Low";
        }
    }
}