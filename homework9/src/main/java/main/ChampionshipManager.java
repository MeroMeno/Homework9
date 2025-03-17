package main;

// ChampionshipManager.java (Singleton)
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChampionshipManager {
    private static ChampionshipManager instance;
    private List<Driver> drivers = new ArrayList<>();
    private RallyRaceResult raceResult = new RallyRaceResult();

    private ChampionshipManager() {}

    public static ChampionshipManager getInstance() {
        if (instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }

    public void registerDriver(Driver driver) { drivers.add(driver); }
    public void conductRace(String raceName, Driver[] raceDrivers) { raceResult.recordRace(raceName, raceDrivers); }
    public void showStandings() {
        drivers.sort((d1, d2) -> Integer.compare(d2.getTotalPoints(), d1.getTotalPoints()));
        for (Driver d : drivers) {
            System.out.println(d.getName() + " (" + d.getCountry() + "): " + d.getTotalPoints() + " points");
        }
        System.out.println("===== CHAMPIONSHIP LEADER =====\n" + drivers.get(0).getName() + " with " + drivers.get(0).getTotalPoints() + " points");
    }

    public int getTotalDrivers() {
        return drivers.size();
    }
    
    public int getTotalRaces() {
        return raceResult.getTotalRaces();  // Ensure RallyRaceResult has getTotalRaces()
    }
    
    public double getAveragePoints() {
        int totalPoints = drivers.stream().mapToInt(Driver::getTotalPoints).sum();
        return (double) totalPoints / drivers.size();
    }
    
    public String getMostSuccessfulCountry() {
        Map<String, Integer> countryPoints = new HashMap<>();
        for (Driver driver : drivers) {
            countryPoints.put(driver.getCountry(), countryPoints.getOrDefault(driver.getCountry(), 0) + driver.getTotalPoints());
        }
        return countryPoints.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
    }
    
    public int getTotalChampionshipPoints() {
        return drivers.stream().mapToInt(Driver::getTotalPoints).sum();
    }
    
    public void showRaceResults() {
        raceResult.displayResults();
    }
}