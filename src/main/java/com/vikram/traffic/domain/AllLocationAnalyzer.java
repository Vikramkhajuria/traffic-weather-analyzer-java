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

        for (Location location : locations) {
            WeatherInfo weather = service.getWeatherInfo(location);
            TrafficInfo traffic = service.getTrafficInfo(location);
            RiskLevel risk = analyzer.getRiskLevel(weather, traffic);

            System.out.println(
                    location.getName() +
                            " -> " + risk +
                            " (" + weather.getTemperature() + "°C, " +
                            weather.getCondition() + ", traffic " +
                            traffic.getCongestionLevel() + ")"
            );


        }
    }
}
