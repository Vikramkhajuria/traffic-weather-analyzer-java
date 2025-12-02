public class App {
    public static void main(String[] args) {

        Location location = new Location("Stockholm");
//        System.out.println(location.getName());

        WeatherInfo weather1 = new WeatherInfo(0, "Snow");
//        System.out.println(weather.getTemperature());
//        System.out.println(weather.getCondition());

        TrafficInfo trafficInfo1 = new TrafficInfo(9);
//        System.out.println(trafficInfo.getCongestionLevel());

        WeatherInfo weather2 = new WeatherInfo(15, "clear");
        TrafficInfo trafficInfo2 = new TrafficInfo(7);

        WeatherInfo weather3 = new WeatherInfo(20, "Sunny");
        TrafficInfo trafficInfo3 = new TrafficInfo(3);


        System.out.println(TrafficAnalyzer.getRiskLevel(weather1, trafficInfo1));
        System.out.println(TrafficAnalyzer.getRiskLevel(weather2, trafficInfo2));
        System.out.println(TrafficAnalyzer.getRiskLevel(weather3, trafficInfo3));



    }
}