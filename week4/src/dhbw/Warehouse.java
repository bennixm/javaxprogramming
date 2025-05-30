package dhbw;

import java.util.ArrayList;

public class Warehouse {
    private ArrayList<Product> products;

    public Warehouse() {
        products = new ArrayList<>();
    }
    public ArrayList<Product> getProducts() {
        return products;
    }
    public void addProduct(Product product) {
        products.add(product);
    }
    public void removeProduct(Product product) {
        products.remove(product);
    }
    public void updateProductQuantity(int id,int newQuantity) {
        for(Product product : products) {
            if(product.getId()==id) {
                product.setQuantity(newQuantity);
                return;
            }
        }
    }

}
