package javaclasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<User> users = new ArrayList<>();
    public static List<Vehicle> cars = new ArrayList<>();
    public static List<Booking> bookings = new ArrayList<>();

    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    boolean running = true;

    while(running){
        System.out.println("Car Rental System ");
        System.out.println("1. Create User");
        System.out.println("2. Create Car");
        System.out.println("3. Login User");
        System.out.println("4. Exit");
        System.out.print("Enter your choice : ");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter Name:");
                scanner.nextLine();
                String name = scanner.nextLine();
                System.out.println("Enter Budget:");
                double budget = scanner.nextDouble();
                users.add(new User(name, budget));
                System.out.println("User added successfully!");
                break;
            case 2:
                System.out.println("Enter License PLate:");
                scanner.nextLine();
                String licensePlate = scanner.nextLine();
                System.out.println("Enter Brand:");
                String brand = scanner.nextLine();
                System.out.println("Enter Model:");
                String model = scanner.nextLine();
                System.out.println("Enter Price Per Day:");
                double pricePerDay = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter Type:");
                String type = scanner.nextLine();
                boolean isAvailable = true;
                cars.add(new Vehicle(type,licensePlate,brand,model,isAvailable,pricePerDay));
                System.out.println("Car added successfully!");
                break;
            case 3:
                if(users.isEmpty()){
                    System.out.println("No users found!");
                }
                else {
                    System.out.println("Select one User");

                    for(User user : users){
                        System.out.println("Name: "+user.name +" with budget "+ user.wallet);
                    }
                    System.out.println("Select user (enter the name):");
                    scanner.nextLine();
                    String selectedName = scanner.nextLine();

                    User selectedUser = null;
                    for(User user : users){
                        if(user.name.equals(selectedName)){
                            selectedUser = user;
                            break;
                        }
                    }
                    if(selectedUser == null){
                        System.out.println("User not found!");
                        break;
                    }
                    boolean userMenu = true;

                    while(userMenu){
                        System.out.println("Book a car");
                        System.out.println("1. Book a car");
                        System.out.println("2. View my bookings");
                        System.out.println("3. Go back");
                        System.out.print("Enter your choice : ");

                        choice = scanner.nextInt();
                        switch (choice) {
                            case 1:
                                System.out.println("Available vehicles");
                                for(Vehicle car : cars){
                                    if(car.isAvailable){
                                        System.out.println(car.brand + " " + car.model + " with license plate: " + car.licensePlate);
                                    }
                                }
                                System.out.println("Select one car (enter license plate)");
                                scanner.nextLine();
                                String selectedCar = scanner.nextLine();

                                System.out.println("How many days?:");
                                int days = Integer.parseInt(scanner.nextLine());

                                Vehicle selectedCarVehicle = null;
                                for(Vehicle car : cars){
                                    if(car.licensePlate.equals(selectedCar)){
                                        selectedCarVehicle = car;
                                    }
                                }

                                if(selectedCarVehicle == null){
                                    System.out.println("Car not found!");
                                } else if(selectedUser.wallet<selectedCarVehicle.pricePerDay*days){
                                    System.out.println("You do not have money to book the car!");
                                } else{
                                    selectedCarVehicle.isAvailable = false;
                                    bookings.add(new Booking(days,selectedUser,selectedCarVehicle));
                                    double newWallet = selectedUser.wallet-selectedCarVehicle.pricePerDay*days;
                                    selectedUser.wallet = newWallet;
                                    System.out.println("Booking added successfully, you have now " + selectedUser.wallet + " euro left!");
                                }
                                break;

                            case 2:
                                System.out.println("Bookings for user" + selectedUser.name + " with wallet " + selectedUser.wallet+ " euro");
                                boolean hasBookings = false;

                                for (Booking booking : bookings) {
                                    if (booking.getUser().equals(selectedUser)) {
                                        System.out.println("Booked car: " + booking.getVehicle().getBrand() + " " + booking.getVehicle().getModel());
                                        System.out.println("License Plate: " + booking.getVehicle().getLicensePlate());
                                        System.out.println("Days: " + booking.getDays());
                                        hasBookings = true;
                                    }
                                }

                                if (!hasBookings) {
                                    System.out.println("No bookings found for this user.");
                                }
                                break;

                            case 3:
                                userMenu = false;
                            default:
                        }
                    }

                }
                break;
            case 4:
                return;
            default:
        }
    }


    }
}