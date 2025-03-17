package main;

public class GravelCar extends RallyCar {
    public GravelCar(String make, String model, int horsepower) {
        super(make, model, horsepower);
    }
    public double calculatePerformance() {
        return horsepower * 1.5;
    }
}