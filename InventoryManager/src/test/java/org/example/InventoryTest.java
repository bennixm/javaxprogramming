package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {

    @Test
    void testEmptyInventory() {
        Inventory inventory = new Inventory();
        assertTrue(inventory.isEmpty());
        assertEquals(0, inventory.getTotalQuantity());
        assertTrue(inventory.getProducts().isEmpty());
    }

    @Test
    void testAddProductIncreasesQuantity() {
        Inventory inventory = new Inventory();
        Product product = new Product("Sample", 10.0, 5, 1); // Use appropriate constructor parameters
        inventory.addProduct(product);

        assertFalse(inventory.isEmpty());
        assertEquals(1, inventory.getTotalQuantity());
        assertEquals(1, inventory.getProducts().size());
        assertEquals(product, inventory.getProducts().get(0));
    }

    @Test
    void testInventoryConstructorWithList() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Sample1", 10.0, 5, 1));
        products.add(new Product("Sample2", 20.0, 3, 2));

        Inventory inventory = new Inventory(products);
        assertEquals(2, inventory.getTotalQuantity());
        assertEquals(products, inventory.getProducts());
    }
}
