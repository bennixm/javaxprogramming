package javaclasses;

public class Booking {
    int days;
    private User user;
    private Vehicle vehicle;

    public Booking(int days, User user, Vehicle vehicle) {
        this.days = days;
        this.user = user;
        this.vehicle = vehicle;
    }
    public int getDays() {
        return days;
    }

    public User getUser() {
        return user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

}
