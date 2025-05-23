package javaclasses;

public class Vehicle extends Car{
    String type;

    public Vehicle(String type, String licensePlate, String brand, String model, boolean isAvailable, double pricePerDay) {
        super(licensePlate, brand, model, isAvailable, pricePerDay);
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }
    public String getLicensePlate() {
        return licensePlate;
    }
}
