package dhbw;

public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int id, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public int getId() {
        return id;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        return "Product ID: " + id + ", Name: " + name + ", Price: " + price + "€, Quantity: " + quantity;
    }

}
