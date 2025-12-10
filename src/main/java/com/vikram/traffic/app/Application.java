package com.vikram.traffic.app;

import com.vikram.traffic.data.FakeDataService;
import com.vikram.traffic.domain.RiskLevel;
import com.vikram.traffic.domain.TrafficAnalyzer;
import com.vikram.traffic.model.Location;
import com.vikram.traffic.model.TrafficInfo;
import com.vikram.traffic.model.WeatherInfo;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        FakeDataService service = new FakeDataService();
        TrafficAnalyzer analyzer = new TrafficAnalyzer();
        Scanner scanner = new Scanner(System.in);

        List<Location> locations = service.getLocations();

        boolean running = true;

        while (running) {
            System.out.println("\n*** Traffic & Weather Bottleneck Analyzer ***");
            System.out.println("Select a location:\n");

            // Print menu dynamically
            for (int i = 0; i < locations.size(); i++) {
                System.out.println((i + 1) + ". " + locations.get(i).getName());
            }

            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            String input = scanner.nextLine();
            int choice;

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.\n");
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

            WeatherInfo weather = service.getWeatherInfo(selected);
            TrafficInfo traffic = service.getTrafficInfo(selected);

            // Perform Risk Analysis
            RiskLevel risk = analyzer.getRiskLevel(weather, traffic);

            // Output
            System.out.println("\n=== Analysis Result ===");
            System.out.println("Location: " + selected.getName());
            System.out.println("Weather: " + weather.getTemperature() + "°C, " + weather.getCondition());
            System.out.println("Traffic level: " + traffic.getCongestionLevel());
            System.out.println("Bottleneck risk: " + risk);
            System.out.println("========================\n");
        }

        scanner.close();
    }
}