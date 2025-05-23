package javaclasses;

public class Car {
    String licensePlate;
    String brand;
    String model;
    boolean isAvailable;
    double pricePerDay;

    public Car(String licensePlate, String brand, String model, boolean isAvailable, double pricePerDay) {
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.model = model;
        this.isAvailable = isAvailable;
        this.pricePerDay = pricePerDay;
    }

}
