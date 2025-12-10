package com.vikram.traffic.model;

public class WeatherInfo {

    private int temperature;
    private String condition;

    public WeatherInfo(int temperature, String condition) {
        this.temperature = temperature;
        this.condition = condition;
    }
    public int getTemperature() {
        return temperature;
    }
    public String getCondition() {return condition;   }


    public String toString() {
        return temperature + "°C, " + condition;
    }

}