package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ElectronicsTest {

    @Test
    void testConstructorAndGetters() {
        Electronics electronics = new Electronics(101, "Smartphone", 799.99, 10, 4000);

        assertEquals("Smartphone", electronics.getName());
        assertEquals(799.99, electronics.getPrice());
        assertEquals(10, electronics.getQuantity());
        assertEquals(101, electronics.getId());
        assertEquals(4000, electronics.getBattery());
    }

    @Test
    void testToStringContainsBattery() {
        Electronics electronics = new Electronics(101, "Smartphone", 799.99, 10, 4000);
        String toString = electronics.toString();

        assertTrue(toString.contains("Type: Electronics"));
        assertTrue(toString.contains("Battery: 4000"));
        assertTrue(toString.contains("Smartphone"));
    }
}
