package com.vikram.traffic.service;

import com.vikram.traffic.data.DataService;
import com.vikram.traffic.domain.TrafficAnalyzer;
import com.vikram.traffic.model.Location;
import com.vikram.traffic.model.TrafficInfo;
import com.vikram.traffic.model.WeatherInfo;
import com.vikram.traffic.web.LocationNotFoundException;
import org.springframework.stereotype.Service;

import com.vikram.traffic.data.LocationRepository;
import com.vikram.traffic.data.LocationEntity;

import java.util.List;

@Service
public class RiskService {

    private final LocationRepository locationRepository;
    private final DataService dataService;
    private final TrafficAnalyzer trafficAnalyzer;

    public RiskService(DataService dataService, TrafficAnalyzer trafficAnalyzer, LocationRepository locationRepository) {
        this.dataService = dataService;
        this.trafficAnalyzer = trafficAnalyzer;
        this.locationRepository = locationRepository;
    }


    public List<Location> getLocations() {
        return locationRepository.findAll().stream()
                .map(e -> new Location(e.getName()))
                .toList();
    }

    public RiskResult calculateRisk(String locationName) {
        Location location = dataService.getLocations().stream()
                .filter(l -> l.getName().equalsIgnoreCase(locationName))
                .findFirst()
                .orElseThrow(() -> new LocationNotFoundException(locationName));

        WeatherInfo weather = dataService.getWeatherInfo(location);
        TrafficInfo traffic = dataService.getTrafficInfo(location);
        var evaluation = trafficAnalyzer.evaluate(weather, traffic);

        return new RiskResult(
                location.getName(),
                weather.getTemperature(),
                weather.getCondition(),
                traffic.getCongestionLevel(),
                evaluation.level().toString(),
                evaluation.score(),
                evaluation.reasons()
        );

    }
}

