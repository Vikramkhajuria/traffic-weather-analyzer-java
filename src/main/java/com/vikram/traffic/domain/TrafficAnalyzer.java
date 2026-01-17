package com.vikram.traffic.domain;

import com.vikram.traffic.data.DataService;
import com.vikram.traffic.model.TrafficInfo;
import com.vikram.traffic.model.WeatherInfo;
import com.vikram.traffic.domain.RiskLevel;

import java.util.List;
import java.util.ArrayList;


public class TrafficAnalyzer {

    public  RiskLevel getRiskLevel(WeatherInfo Weather1, TrafficInfo trafficInfo1) {
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

    public RiskEvaluation evaluate(WeatherInfo weather,TrafficInfo traffic) {
        int score = 0;
        List<String> reasons = new ArrayList<>();
        int congestion = traffic.getCongestionLevel();
        String condition = weather.getCondition();
        double temperature = weather.getTemperature();

        if (congestion >= 8) {
            score += 55;
            reasons.add("Congestion >=8");
        } else if (congestion >= 6) {
            score += 35;
            reasons.add("Congestion between 5 and 7");
        } else {
            score += 15;
            reasons.add("Congestion <5");
        }
        String c = condition == null ? "" : condition.toLowerCase();

        if (c.contains("snow")) {
            score += 30;
            reasons.add("Snow conditions");
        } else if (c.contains("rain")) {
            score += 20;
            reasons.add("Rain conditions");
        } else if (c.contains("fog")) {
            score += 20;
            reasons.add("Fog conditions");
        } else if (c.contains("storm") || c.contains("thunder")) {
            score += 35;
            reasons.add("Storm conditions");
        } else {
            score += 5;
            reasons.add("Clear/mild weather");
        }

        if (temperature <= 0 && c.contains("snow")) {
            score += 10;
            reasons.add("Temperature <= 0°C with snow");
        }
        if (temperature >= 30) {
            score += 5;
            reasons.add("High temperature >= 30°C");
        }
        if (score > 100) score = 100;
        if (score < 0) score = 0;

        RiskLevel level = (score >= 70) ? RiskLevel.HIGH :
                (score >= 40) ? RiskLevel.MEDIUM :
                        RiskLevel.LOW;
        return new RiskEvaluation(level, score, reasons);

    }
}