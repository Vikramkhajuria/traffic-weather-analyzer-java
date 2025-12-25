package com.vikram.traffic.app;

import com.vikram.traffic.data.DataService;
import com.vikram.traffic.data.FakeDataService;
import com.vikram.traffic.data.RandomDataService;
import com.vikram.traffic.domain.RiskLevel;
import com.vikram.traffic.domain.TrafficAnalyzer;
import com.vikram.traffic.model.Location;
import com.vikram.traffic.model.TrafficInfo;
import com.vikram.traffic.model.WeatherInfo;
import com.vikram.traffic.domain.AllLocationAnalyzer;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DataService dataService = new FakeDataService();
        TrafficAnalyzer analyzer = new TrafficAnalyzer();
        AllLocationAnalyzer allAnalyzer = new AllLocationAnalyzer(dataService, analyzer);
        List<Location> locations = dataService.getLocations();

        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("\n*** Traffic & Weather Bottleneck Analyzer ***");
            System.out.println("Select a location:\n");

            // Print menu dynamically
            for (int i = 0; i < locations.size(); i++) {
                System.out.println((i + 1) + ". " + locations.get(i).getName());
            }
            System.out.println("A. Analyze all locations");
            System.out.println("D. Switch data mode (Fake/Random)");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            String input = scanner.nextLine();
            int choice;
            if (input.equalsIgnoreCase("D")) {
                if (dataService instanceof FakeDataService) {
                    System.out.println("Data mode switched to: Random\n");
                    dataService = new RandomDataService();
                } else {
                    dataService = new FakeDataService();
                    System.out.println("Data mode switched to: Fake\n");

                }
                locations = dataService.getLocations();
                allAnalyzer = new AllLocationAnalyzer(dataService, analyzer);
                continue;
            }

                if (input.equalsIgnoreCase("A")) {
                    allAnalyzer.analyzeAll(locations);
                    continue;
                }

                try {
                    choice = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number or an alphabet.\n");
                    continue;
                }

                if (choice == 0) {
                    System.out.println("Exiting program... Goodbye!");
                    running = false;
                    continue;
                }

                if (choice < 1 || choice > locations.size()) {
                    System.out.println("Invalid choice. Try again.\n");
                    continue;
                }

                // Valid selection
                Location selected = locations.get(choice - 1);

                WeatherInfo weather = dataService.getWeatherInfo(selected);
                TrafficInfo traffic = dataService.getTrafficInfo(selected);

                // Perform Risk Analysis
                RiskLevel risk = analyzer.getRiskLevel(weather, traffic);

                // Output
                System.out.println("\n=== Analysis Result ===");
                System.out.println("Location: " + selected.getName());
                System.out.println("Weather: " + weather.getTemperature() + "°C, " + weather.getCondition());
                System.out.println("Traffic level: " + traffic.getCongestionLevel());
                System.out.println("Risk: " + risk.getMessage());
                System.out.println("========================\n");
            }

        scanner.close();
    }

    }
