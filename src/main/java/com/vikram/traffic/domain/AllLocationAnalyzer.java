package com.vikram.traffic.domain;

import com.vikram.traffic.data.FakeDataService;
import com.vikram.traffic.model.Location;
import com.vikram.traffic.model.TrafficInfo;
import com.vikram.traffic.model.WeatherInfo;
import com.vikram.traffic.data.DataService;

import java.util.List;

public class AllLocationAnalyzer {
    private final DataService service;
    private final TrafficAnalyzer analyzer;

    public AllLocationAnalyzer(DataService service, TrafficAnalyzer analyzer) {
        this.service = service;
        this.analyzer = analyzer;
    }

    public void analyzeAll(List<Location> locations) {

        System.out.println("\n=== All Locations ===");

        for (Location location : locations) {
            WeatherInfo weather = service.getWeatherInfo(location);
            TrafficInfo traffic = service.getTrafficInfo(location);
            RiskLevel risk = analyzer.getRiskLevel(weather, traffic);

            System.out.printf(
                    "%-20s | Weather: %3d°C %-7s | Traffic: %2d/10 | Risk: %-6s%n",
                    location.getName(),
                    weather.getTemperature(),
                    weather.getCondition(),
                    traffic.getCongestionLevel(),
                    risk
            );
        }

        System.out.println("=====================\n");
    }
}
