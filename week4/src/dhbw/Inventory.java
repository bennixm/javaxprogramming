package dhbw;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Product> products;
    public Inventory() {
        products = new ArrayList<>();
    }
    public Inventory(ArrayList<Product> products) {
        this.products = products;
    }
    public void addProduct(Product product) {
        products.add(product);
    }
    public ArrayList<Product> getProducts() {
        return products;
    }
    public int getTotalQuantity(){
        int total = 0;
        for(Product product : products){
            total += 1;
        }
        return total;
    }
    public boolean isEmpty() {
        return products.isEmpty();
    }
}
