package com.vikram.traffic.domain;

import com.vikram.traffic.model.TrafficInfo;
import com.vikram.traffic.model.WeatherInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrafficAnalyzerTest {

    private TrafficAnalyzer analyzer;

    @BeforeEach
    void setUp() {
        analyzer = new TrafficAnalyzer();
    }

    @Test
    void lowRisk_lowCongestionClearWeather() {
        WeatherInfo weather = new WeatherInfo(15, "Clear");
        TrafficInfo traffic = new TrafficInfo(3);

        RiskEvaluation result = analyzer.evaluate(weather, traffic);

        assertEquals(RiskLevel.LOW, result.level());
        assertTrue(result.score() < 40, "Score should be below 40 for low risk");
        assertTrue(result.reasons().contains("Congestion <6"));
        assertTrue(result.reasons().contains("Clear/mild weather"));
    }

    @Test
    void mediumRisk_moderateCongestionRain() {
        WeatherInfo weather = new WeatherInfo(10, "Rain");
        TrafficInfo traffic = new TrafficInfo(6);

        RiskEvaluation result = analyzer.evaluate(weather, traffic);

        assertEquals(RiskLevel.MEDIUM, result.level());
        assertTrue(result.score() >= 40 && result.score() < 70,
                "Score should be 40–69 for medium risk, got " + result.score());
        assertTrue(result.reasons().contains("Rain conditions"));
    }

    @Test
    void highRisk_heavyCongestionSnowBelowFreezing() {
        WeatherInfo weather = new WeatherInfo(-5, "Snow");
        TrafficInfo traffic = new TrafficInfo(9);

        RiskEvaluation result = analyzer.evaluate(weather, traffic);

        assertEquals(RiskLevel.HIGH, result.level());
        assertTrue(result.score() >= 70, "Score should be >=70 for high risk, got " + result.score());
        assertTrue(result.reasons().contains("Congestion >=8"));
        assertTrue(result.reasons().contains("Snow conditions"));
        assertTrue(result.reasons().contains("Temperature <= 0°C with snow"));
    }

    @Test
    void highRisk_stormConditions() {
        WeatherInfo weather = new WeatherInfo(20, "Thunderstorm");
        TrafficInfo traffic = new TrafficInfo(9);

        RiskEvaluation result = analyzer.evaluate(weather, traffic);

        assertEquals(RiskLevel.HIGH, result.level());
        assertTrue(result.reasons().contains("Storm conditions"));
    }

    @Test
    void score_cappedAt100() {
        WeatherInfo weather = new WeatherInfo(-5, "Snow");
        TrafficInfo traffic = new TrafficInfo(10);

        RiskEvaluation result = analyzer.evaluate(weather, traffic);

        assertTrue(result.score() <= 100, "Score must never exceed 100");
    }
}
