package com.cora;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // Create a PlantList Object
        PlantList plantList = new PlantList();

        // Create some Plant Objects
        Plant monsteraDel = new Plant("Delicious Monster", "Monstera deliciosa", "Monstera", "Aroid", 120, 35.99);
        Plant monkeyLeaf = new Plant("Monkey Leaf", "Monstera adansonii", "Monstera", "Aroid", 80, 25.50);
        Plant obliqua = new Plant("Obliqua", "Monstera obliqua", "Monstera", "Aroid", 70, 300.00);

        // Add Plant objects to PlantList
        plantList.addPlant(monsteraDel);
        plantList.addPlant(monkeyLeaf);
        plantList.addPlant(obliqua);

        // List all Plants
        System.out.println("All Plants:");
        for (Plant plant : plantList.listPlants()) {
            System.out.println(plant);
        }

    }
}