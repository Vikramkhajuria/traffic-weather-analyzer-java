public class WeatherInfo {

    private int temperature;
    private String condition;

    WeatherInfo(int temperature, String condition) {
        this.temperature = temperature;
        this.condition = condition;
    }
    public int getTemperature() {
        return temperature;
    }
    public String getCondition() {
        return condition;
    }

}