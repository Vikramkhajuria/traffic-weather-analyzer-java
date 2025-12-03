import java.util.List;

public class App {
    public static void main(String[] args) {

        FakeDataService service = new FakeDataService();

        List<Location> locations = service.getLocations();

        for (Location loc : locations) {
            WeatherInfo weather = service.getWeatherInfo(loc);
            TrafficInfo traffic = service.getTrafficInfo(loc);

            String risk = TrafficAnalyzer.getRiskLevel(weather, traffic);

            System.out.println("Location: " + loc.getName());
            System.out.println("  Weather: " + weather.getCondition()
                    + ", " + weather.getTemperature() + "°C");
            System.out.println("  Congestion: " + traffic.getCongestionLevel());
            System.out.println("  Risk: " + risk);
            System.out.println();
        }


    }
}