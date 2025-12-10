package com.vikram.traffic.data;

// polymorphism


import com.vikram.traffic.model.Location;
import com.vikram.traffic.model.TrafficInfo;
import com.vikram.traffic.model.WeatherInfo;

import java.util.List;

public interface DataService {

    List<Location> getLocations();
    WeatherInfo getWeatherInfo(Location location);
    TrafficInfo getTrafficInfo(Location location);
}
