package dhbw;

public class Clothing extends Product {
    private String size;
    public Clothing(int id, String name, double price, int quantity, String size) {
        super(name, price, id, quantity);
        this.size = size;
    }

    @Override
    public String toString() {
        return super.toString() + ", Type: Clothing, Size: " + size ;
    }
}
