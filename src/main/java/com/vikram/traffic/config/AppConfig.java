package com.vikram.traffic.config;

import com.vikram.traffic.data.DataService;
import com.vikram.traffic.data.FakeDataService;
import com.vikram.traffic.domain.TrafficAnalyzer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public DataService dataService() {
        return new FakeDataService();
    }

    @Bean
    public TrafficAnalyzer trafficAnalyzer() {
        return new TrafficAnalyzer();
    }
}

