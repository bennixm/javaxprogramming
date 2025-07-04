package org.example;

import org.example.Clothing;
import org.example.Electronics;
import org.example.Warehouse;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        Inventory inventory = new Inventory();

        while(true){
            System.out.println("======= WELCOME TO THE WAREHOUSE =======");
            System.out.println("1. Add Electronic Stock");
            System.out.println("2. Add Clothing Stock");
            System.out.println("3. View Stock and buy item");
            System.out.println("4. View Inventory");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter product id: ");
                    int id = scanner.nextInt();
                    System.out.println("Enter product name: ");
                    String name = scanner.next();
                    System.out.println("Enter product price: ");
                    double price = scanner.nextDouble();
                    System.out.println("Enter product quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.println("Enter battery capacity: ");
                    double battery = scanner.nextDouble();
                    warehouse.addProduct(new Electronics(id,name,price,quantity,battery));
                    System.out.println("Electronic item added successfully");
                    break;
                case 2:
                    System.out.println("Enter product id: ");
                    int cid = scanner.nextInt();
                    System.out.println("Enter product name: ");
                    String cname = scanner.next();
                    System.out.println("Enter product price: ");
                    double cprice = scanner.nextDouble();
                    System.out.println("Enter product quantity: ");
                    int cquantity = scanner.nextInt();
                    System.out.println("Enter product size: ");
                    String size = scanner.next();
                    warehouse.addProduct(new Clothing(cid,cname,cprice,cquantity,size));
                    System.out.println("Clothing item added successfully");
                    break;
                case 3:
                    System.out.println("Our warehouse contains: ");
                    for(Product product : warehouse.getProducts()){
                        if(product.getQuantity() > 0) {
                            System.out.println("- " + product);
                        }
                    }
                    System.out.println("Select product (by ID): ");
                    int selectId = scanner.nextInt();
                    System.out.println("Quantity: ");
                    int selectedQuantity = scanner.nextInt();
                    for(Product product : warehouse.getProducts()){
                        if(product.getId() == selectId && product.getQuantity() >= selectedQuantity) {
                            int newQuantity = product.getQuantity() - selectedQuantity;
                            warehouse.updateProductQuantity(selectId, newQuantity);

                            for(int i=0; i<selectedQuantity; i++){
                                inventory.addProduct(product);
                            }
                            System.out.println("Product added to inventory with Quantity: " + selectedQuantity);
                            System.out.println("Stock left:" + newQuantity);
                        } else {
                            System.out.println("Product not existing or not in stock");
                        }
                    }
                    break;
                case 4:
                    System.out.println("My inventory:");
                    if(inventory.isEmpty()){
                        System.out.println("No items in your inventory");
                    } else {
                        System.out.println("You have " + inventory.getTotalQuantity() + " items in your inventory");
                        for (Product product : inventory.getProducts()) {
                            System.out.println(product);
                        }
                    }
                    break;
                case 5:
                    return;
            }
        }
    }
}