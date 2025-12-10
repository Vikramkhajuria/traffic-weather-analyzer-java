# Traffic & Weather Bottleneck Analyzer  
A Java console application that evaluates simplified weather and traffic conditions for multiple locations and determines a bottleneck risk level (LOW, MEDIUM, HIGH).
Designed with clean OOP, domain-driven structure, and Gradle build support.

  
  ---

### Overview  
This project simulates a lightweight analysis system similar to real-world traffic infrastructure software.
It uses:

- Encapsulated domain models (Location, WeatherInfo, TrafficInfo)

- A reusable domain logic engine (TrafficAnalyzer)

- An extendable data provider (FakeDataService)

- A CLI interface for user interaction

- Batch analysis support (A option) using a dedicated class (AllLocationAnalyzer)

 -Gradle for building and running the application

---

### Purpose  
- Object-Oriented Programming at scale
- Multi-class architecture
- Separation of concerns (domain, data, UI layers) 
- Clean code and logical decomposition
-  Working with Gradle build systems
-  Using Git & GitHub professionally
  ---

### Features 
Core Functionality
- Predefined locations  
- Weather data (temperature + condition)  
- Traffic data (congestion level)
- Unified risk evaluation using RiskLevel enum
- CLI menu for selecting locations
- Analyze-all-locations mode (press A)

Under the Hood
- Domain-driven design
- Batch analyzer class (AllLocationAnalyzer)
- Extendable architechture (east to plug in real APIs later)
- Compact and readable domain logic

  ---

### Development Phases  
**Phase 1 — Data Model (Completed)**  
Created Location, WeatherInfo, and TrafficInfo classes.

**Phase 2 — TrafficAnalyzer Logic (Completed)**  
Implemented risk evaluation based on weather and congestion.

**Phase 3 — FakeDataService (Completed)**  
Provide predefined weather and traffic data.

**Phase 4 — Console Menu System (Completed)**  
Interactive menu for user-selected locations.

**Phase 5 — Enhancements (Under progress)**  
Gradle support, datasets, UML diagrams, real API integration.

---

### What I Learned  
- Multi-class Java design  
- Encapsulation and constructors  
- Domain modeling (location, weather, traffic)  
- Implementing logical decision rules  
- Testing behavior before UI  
- Using Git and GitHub professionally
- Enum-based logic & risk scoring

---

### Tech Used  
- Java  
- IntelliJ IDEA  
- Git & GitHub  

---

### Next Steps  
- Implement FakeDataService  
- Replace hardcoded test objects  
- Build full console menu  
- Add dataset support (CSV/JSON)  
- Convert to Gradle  
- Add UML diagrams  

---

### Future Vision  
- Real weather/traffic API integration  
- More advanced risk scoring  
- UI version (JavaFX or web)  
- Automated tests  
- Modular Gradle setup  
---


  



