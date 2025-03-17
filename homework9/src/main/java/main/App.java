package main;


public class App 
{
    public static void main( String[] args ) {
        ChampionshipManager manager = ChampionshipManager.getInstance();

        Driver driver1 = new Driver("Sébastien Ogier", "France");
        Driver driver2 = new Driver("Kalle Rovanperä", "Finland");
        Driver driver3 = new Driver("Ott Tänak", "Estonia");
        Driver driver4 = new Driver("Thierry Neuville", "Belgium");

        manager.registerDriver(driver1);
        manager.registerDriver(driver2);
        manager.registerDriver(driver3);
        manager.registerDriver(driver4);

        // Simulate Races
        manager.conductRace("Rally Finland (Jyväskylä)", new Driver[]{driver1, driver3, driver2, driver4});
        manager.conductRace("Monte Carlo Rally (Monaco)", new Driver[]{driver2, driver4, driver1, driver3});

        // Display Standings
        manager.showStandings();

        // Print Championship Statistics
        System.out.println("\n===== CHAMPIONSHIP STATISTICS =====");
        System.out.println("Total Drivers: " + manager.getTotalDrivers());
        System.out.println("Total Races: " + manager.getTotalRaces());
        System.out.printf("Average Points Per Driver: %.2f%n", manager.getAveragePoints());
        System.out.println("Most Successful Country: " + manager.getMostSuccessfulCountry());
        System.out.println("Total Championship Points: " + manager.getTotalChampionshipPoints());

        // Show Race Results
        System.out.println("\n===== RACE RESULTS =====");
        manager.showRaceResults();

        // Show Car Performance Ratings
        System.out.println("\n===== CAR PERFORMANCE RATINGS =====");
        RallyCar gravelCar = new GravelCar("Toyota", "Yaris WRC", 280);
        RallyCar asphaltCar = new AsphaltCar("Hyundai", "i20 Coupe WRC", 280);
        System.out.println("Gravel Car Performance: " + gravelCar.calculatePerformance());
        System.out.println("Asphalt Car Performance: " + asphaltCar.calculatePerformance());
    }
}
