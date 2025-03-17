package main;

import java.util.List;

public class ChampionshipStatistics {
    public static double averagePoints(List<Driver> drivers) {
        int totalPoints = drivers.stream().mapToInt(Driver::getTotalPoints).sum();
        return (double) totalPoints / drivers.size();
    }
}