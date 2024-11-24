package com.cora;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class PlantTest {

    @Test
    public void testPlantConstructor() {
        Plant plant = new Plant("Delicious Monster", "Monstera deliciosa", "Monstera", "Aroid", 120, 35.99);
        assertEquals("Delicious Monster", plant.getCommonName());
        assertEquals("Monstera deliciosa", plant.getScientificName());
        assertEquals("Monstera", plant.getGenusName());
        assertEquals("Aroid", plant.getCategory());
        assertEquals(120, plant.getSizeInCm());
        assertEquals(35.99, plant.getApproxPrice());
    }

    @Test
    public void testInvalidPlantConstructor() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Plant("", "Monstera deliciosa", "Monstera", "Aroid", 120, 35.99);
        });
    }
}