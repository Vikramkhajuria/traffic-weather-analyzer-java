import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FakeDataService {

    private List<Location> locations;
    private Map <String, WeatherInfo> weatherMap;
    private Map <String, TrafficInfo> trafficMap;

    public FakeDataService(){
        locations = new ArrayList<>();
        weatherMap = new HashMap<>();
        trafficMap = new HashMap<>();
    }


}