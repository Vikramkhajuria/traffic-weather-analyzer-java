package com.vikram.traffic.web;

import com.vikram.traffic.data.DataService;
import com.vikram.traffic.data.FakeDataService;
import com.vikram.traffic.domain.RiskLevel;
import com.vikram.traffic.domain.TrafficAnalyzer;
import com.vikram.traffic.model.Location;
import com.vikram.traffic.model.TrafficInfo;
import com.vikram.traffic.model.WeatherInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RiskController {


    private final DataService dataService = new FakeDataService();
    private final TrafficAnalyzer analyzer = new TrafficAnalyzer();

    @GetMapping("/api/risk")
    public RiskResponse risk(@RequestParam String location) {
        Location loc = dataService.getLocations().stream()
                .filter(l -> l.getName().equalsIgnoreCase(location))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown location: " + location));

        WeatherInfo weather = dataService.getWeatherInfo(loc);
        TrafficInfo traffic = dataService.getTrafficInfo(loc);


        String riskLevel = analyzer.getRiskLevel(weather, traffic).toString();


        return new RiskResponse(
                loc.getName(),
                weather.getTemperature(),
                weather.getCondition(),
                traffic.getCongestionLevel(),
                riskLevel
        );
    }
}

