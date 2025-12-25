package com.vikram.traffic.data;

import com.vikram.traffic.model.Location;
import com.vikram.traffic.model.TrafficInfo;
import com.vikram.traffic.model.WeatherInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FakeDataService implements DataService {

    private List<Location> locations;
    private Map <String, WeatherInfo> weatherMap;
    private  Map <String, TrafficInfo> trafficMap;

    public FakeDataService(){
        locations = new ArrayList<>();
        weatherMap = new HashMap<>();
        trafficMap = new HashMap<>();

        // Location 1
        Location stockholm = new Location("Stockholm Central");
        locations.add(stockholm);

        WeatherInfo stockholmWeather = new WeatherInfo(0, "Snow");
        TrafficInfo stockholmTraffic = new TrafficInfo(9);

        weatherMap.put(stockholm.getName(), stockholmWeather);
        trafficMap.put(stockholm.getName(), stockholmTraffic);

        // Location 2
        Location malmo = new Location("Malmö Center");
        locations.add(malmo);

        WeatherInfo malmoWeather = new WeatherInfo(14, "Cloudy");
        TrafficInfo malmoTraffic = new TrafficInfo(5);

        weatherMap.put(malmo.getName(), malmoWeather);
        trafficMap.put(malmo.getName(), malmoTraffic);

        // Location 3
        Location e4 = new Location("E4 Northbound");
        locations.add(e4);

        WeatherInfo e4Weather = new WeatherInfo(5, "Rain");
        TrafficInfo e4Traffic = new TrafficInfo(7);

        weatherMap.put(e4.getName(), e4Weather);
        trafficMap.put(e4.getName(), e4Traffic);

        // Location 4
        Location goth = new Location("Gothenburg Ring Road");
        locations.add(goth);

        WeatherInfo gothWeather = new WeatherInfo(10, "Clear");
        TrafficInfo gothTraffic = new TrafficInfo(3);

        weatherMap.put(goth.getName(), gothWeather);
        trafficMap.put(goth.getName(), gothTraffic);

    }
    @Override
    public List<Location> getLocations() {
        return locations;
    }
    @Override
    public WeatherInfo getWeatherInfo(Location location){
        String name = location.getName();
        return weatherMap.get(name);
    }
    @Override
    public TrafficInfo getTrafficInfo(Location location){
        String name = location.getName();
        return trafficMap.get(name);
    }
}