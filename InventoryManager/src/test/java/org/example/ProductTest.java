package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    void testConstructorAndGetters() {
        Product product = new Product("Laptop", 1200.50, 1001, 5);

        assertEquals(1001, product.getId());
        assertEquals("Laptop", product.name); // This field is private without getter, consider adding getter!
        assertEquals(1200.50, product.price); // Same here, add getter for price for better test
        assertEquals(5, product.getQuantity());
    }

    @Test
    void testSetQuantity() {
        Product product = new Product("Laptop", 1200.50, 1001, 5);
        product.setQuantity(10);
        assertEquals(10, product.getQuantity());
    }

    @Test
    void testToString() {
        Product product = new Product("Laptop", 1200.50, 1001, 5);
        String str = product.toString();
        assertTrue(str.contains("Product ID: 1001"));
        assertTrue(str.contains("Laptop"));
        assertTrue(str.contains("1200.5"));
        assertTrue(str.contains("Quantity: 5"));
    }
}
