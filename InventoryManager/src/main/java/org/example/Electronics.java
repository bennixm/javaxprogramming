package org.example;

public class Electronics extends Product {
    private double battery;

    public Electronics(int id, String name, double price, int quantity, double battery) {
        // Fix parameter order: super(name, price, quantity, id)
        super(name, price, quantity, id);
        this.battery = battery;
    }

    @Override
    public String toString() {
        return super.toString() + ", Type: Electronics, Battery: " + battery;
    }

    public double getBattery() {
        return battery;
    }
}
