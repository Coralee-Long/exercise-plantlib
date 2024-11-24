package com.cora;

import static spark.Spark.*;
import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {

        staticFiles.location("/public"); // Serve static files from src/main/resources/public

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

        // Add route to fetch all plants as JSON
        get("/plants", (req, res) -> {
            res.type("application/json");
            return new Gson().toJson(plantList.listPlants());
        });

        post("/addPlant", (req, res) -> {
            // Parse the incoming JSON to create a Plant object
            Plant newPlant = new Gson().fromJson(req.body(), Plant.class);

            // Add the new plant to the PlantList
            plantList.addPlant(newPlant);

            // Return a success message or the added plant
            return new Gson().toJson(newPlant);
        });

        // Print all Plants
        System.out.println("All Plants:");
        for (Plant plant : plantList.listPlants()) {
            System.out.println(plant);
        }

        // Prevent the main thread from terminating
        awaitInitialization();

    }
}