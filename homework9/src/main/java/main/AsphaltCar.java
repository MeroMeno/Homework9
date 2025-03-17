package main;

public class AsphaltCar extends RallyCar {
    public AsphaltCar(String make, String model, int horsepower) {
        super(make, model, horsepower);
    }
    public double calculatePerformance() {
        return horsepower * 1.7;
    }
}