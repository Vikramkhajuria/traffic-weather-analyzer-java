# Traffic & Weather Bottleneck Analyzer – Class Guide

This project is a small console app that scores traffic risk for multiple locations. Below is a quick map of every class and how they work together.

## Packages and Classes

**app**
- `src/main/java/com/vikram/traffic/app/Main.java` – Entry point. Builds a `DataService` (defaults to `RandomDataService`), a `TrafficAnalyzer`, and an `AllLocationAnalyzer`. Presents a CLI menu, fetches data for the chosen location (or all), and prints the risk result.

**domain**
- `src/main/java/com/vikram/traffic/domain/TrafficAnalyzer.java` – Core rule engine. Returns `RiskLevel` based on congestion and weather (snow with high congestion escalates to HIGH; medium congestion yields MEDIUM; otherwise LOW).
- `src/main/java/com/vikram/traffic/domain/AllLocationAnalyzer.java` – Batch runner. Loops over all provided `Location`s, pulls data from a `DataService`, calls `TrafficAnalyzer`, and prints a per-location summary.
- `src/main/java/com/vikram/traffic/domain/RiskLevel.java` – Enum for LOW, MEDIUM, HIGH with a human-readable message via `getMessage()`.

**data**
- `src/main/java/com/vikram/traffic/data/DataService.java` – Interface defining the data contract: provide locations plus weather and traffic info for a given location.
- `src/main/java/com/vikram/traffic/data/FakeDataService.java` – Deterministic, in-memory dataset using maps keyed by location name. Good for demos or predictable outputs.
- `src/main/java/com/vikram/traffic/data/RandomDataService.java` – Generates random temperatures, conditions, and congestion levels on each request; includes a small fixed list of locations.

**model**
- `src/main/java/com/vikram/traffic/model/Location.java` – Simple value object holding a location name.
- `src/main/java/com/vikram/traffic/model/WeatherInfo.java` – Weather reading with `temperature` and `condition`; provides getters and a display-friendly `toString()`.
- `src/main/java/com/vikram/traffic/model/TrafficInfo.java` – Traffic reading with `congestionLevel`; includes getters and a `toString()` rendering the level.

## How Data Flows
1) `Main` gets all `Location`s from a `DataService`.  
2) For each chosen location, it requests `WeatherInfo` and `TrafficInfo`.  
3) `TrafficAnalyzer` evaluates those readings and returns a `RiskLevel`.  
4) `Main` (or `AllLocationAnalyzer` for batch mode) prints the result to the console.

## Running the App
- From the project root: `./gradlew run` (or `gradlew.bat run` on Windows).  
- Choose a numbered location or press `A` to analyze all. Exit with `0`.
