package main;

import java.util.LinkedHashMap;
import java.util.Map;

public class RallyRaceResult implements RaceResult {
    private Map<String, Map<Driver, Integer>> raceResults = new LinkedHashMap<>();

    public void recordRace(String raceName, Driver[] results) {
        Map<Driver, Integer> racePoints = new LinkedHashMap<>();
        int[] points = {25, 18, 15, 12}; // Correct WRC-style points

        for (int i = 0; i < results.length; i++) {
            results[i].addPoints(points[i]);  // Update total championship points
            racePoints.put(results[i], points[i]); // Store points for this specific race
        }

        raceResults.put(raceName, racePoints);
    }

    public void displayResults() {
        for (String race : raceResults.keySet()) {
            System.out.println("Race: " + race);
            int position = 1;
            for (Map.Entry<Driver, Integer> entry : raceResults.get(race).entrySet()) {
                System.out.println("  Position " + position + ": " + entry.getKey().getName() 
                                   + " - " + entry.getValue() + " points");
                position++;
            }
        }
    }

    public int getTotalRaces() {
        return raceResults.size();
    }
}