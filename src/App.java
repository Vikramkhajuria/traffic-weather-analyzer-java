public class App{
    public static void main(String[] args){

        Location location = new Location("Stockholm");
        System.out.println(location.getName());

        WeatherInfo weather = new WeatherInfo(30, "Raining");
        System.out.println(weather.getTemperature());
        System.out.println(weather.getCondition());

        TrafficInfo trafficInfo = new TrafficInfo(8);
        System.out.println(trafficInfo.getCongestionLevel());

    }
}