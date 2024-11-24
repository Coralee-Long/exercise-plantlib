package com.cora;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class PlantListTest {

    @Test
    public void testAddPlant() {
        PlantList plantList = new PlantList();
        Plant plant = new Plant("Delicious Monster", "Monstera deliciosa", "Monstera", "Aroid", 120, 35.99);

        plantList.addPlant(plant);
        List<Plant> plants = plantList.listPlants();

        assertEquals(1, plants.size());
        assertEquals("Delicious Monster", plants.get(0).getCommonName());
    }

    @Test
    public void testListPlants() {
        PlantList plantList = new PlantList();
        Plant plant1 = new Plant("Delicious Monster", "Monstera deliciosa", "Monstera", "Aroid", 120, 35.99);
        Plant plant2 = new Plant("Monkey Leaf", "Monstera adansonii", "Monstera", "Aroid", 80, 25.50);

        plantList.addPlant(plant1);
        plantList.addPlant(plant2);

        List<Plant> plants = plantList.listPlants();
        assertEquals(2, plants.size());
    }
}
