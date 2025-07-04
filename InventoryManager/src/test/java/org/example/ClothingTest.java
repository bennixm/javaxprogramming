package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClothingTest {

    @Test
    void testConstructorAndGetters() {
        Clothing clothing = new Clothing(202, "T-Shirt", 19.99, 50, "L");

        assertEquals("T-Shirt", clothing.getName());
        assertEquals(19.99, clothing.getPrice());
        assertEquals(50, clothing.getQuantity());
        assertEquals(202, clothing.getId());
        assertEquals("L", clothing.getSize());
    }

    @Test
    void testToStringContainsSize() {
        Clothing clothing = new Clothing(202, "T-Shirt", 19.99, 50, "L");
        String toString = clothing.toString();

        assertTrue(toString.contains("Type: Clothing"));
        assertTrue(toString.contains("Size: L"));
        assertTrue(toString.contains("T-Shirt"));
    }
}
