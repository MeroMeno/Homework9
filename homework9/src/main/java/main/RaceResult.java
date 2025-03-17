package main;

public interface RaceResult {
    void recordRace(String raceName, Driver[] results);
    void displayResults();
}