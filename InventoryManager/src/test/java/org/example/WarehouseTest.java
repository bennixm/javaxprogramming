package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class WarehouseTest {

    @Test
    void testAddProduct() {
        Warehouse warehouse = new Warehouse();
        Product product = new Product("Laptop", 1200.0, 1, 10);
        warehouse.addProduct(product);

        assertFalse(warehouse.getProducts().isEmpty());
        assertEquals(1, warehouse.getProducts().size());
        assertEquals(product, warehouse.getProducts().get(0));
    }

    @Test
    void testRemoveProduct() {
        Warehouse warehouse = new Warehouse();
        Product product = new Product("Laptop", 1200.0, 1, 10);
        warehouse.addProduct(product);
        warehouse.removeProduct(product);

        assertTrue(warehouse.getProducts().isEmpty());
    }

    @Test
    void testUpdateProductQuantity() {
        Warehouse warehouse = new Warehouse();
        Product product1 = new Product("Laptop", 1200.0, 1, 10);
        Product product2 = new Product("Mouse", 25.0, 2, 50);
        warehouse.addProduct(product1);
        warehouse.addProduct(product2);

        warehouse.updateProductQuantity(1, 20);
        warehouse.updateProductQuantity(2, 30);

        assertEquals(20, product1.getQuantity());
        assertEquals(30, product2.getQuantity());
    }

    @Test
    void testUpdateProductQuantityNonExistent() {
        Warehouse warehouse = new Warehouse();
        Product product = new Product("Laptop", 1200.0, 1, 10);
        warehouse.addProduct(product);

        warehouse.updateProductQuantity(999, 50);  // id not found

        // Quantity should remain unchanged
        assertEquals(10, product.getQuantity());
    }
}
