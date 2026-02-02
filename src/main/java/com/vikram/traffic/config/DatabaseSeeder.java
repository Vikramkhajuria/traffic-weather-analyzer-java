package com.vikram.traffic.config;

import com.vikram.traffic.data.LocationEntity;
import com.vikram.traffic.data.LocationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final LocationRepository repo;

    public DatabaseSeeder(LocationRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) {
        List<String> initial = List.of(
                "Stockholm Central",
                "Malmö Center",
                "E4 Northbound",
                "Gothenburg Ring Road"
        );

        for (String name : initial) {
            if (!repo.existsByNameIgnoreCase(name)) {
                repo.save(new LocationEntity(name));
            }
        }
    }
}
