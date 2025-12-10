package com.vikram.traffic.data;

import com.vikram.traffic.model.TrafficInfo;
import com.vikram.traffic.model.Location;
import com.vikram.traffic.model.WeatherInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomDataService implements DataService {

    private final List<Location> locations = new ArrayList<Location>();
    private final Random random = new Random();

    public RandomDataService(){
        locations.add(new Location("Kristianstad Central"));
        locations.add(new Location("Åhus Central"));
        locations.add(new Location("Helsinborg Central"));

    }
    @Override
    public List<Location> getLocations() {
        return locations;
    }
    @Override
    public WeatherInfo getWeatherInfo(Location location) {
        int temp = random.nextInt(31) - 10;
        String[] conditions = {"Snow", "Rain", "Cloudy", "Clear"};
        String condition = conditions[random.nextInt(conditions.length)];
        return new WeatherInfo(temp, condition);
    }

    @Override
    public TrafficInfo getTrafficInfo(Location location) {
        int level = 1 + random.nextInt(10);
        return new TrafficInfo(level);
    }

}
