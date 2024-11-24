package com.cora;

import java.util.ArrayList;
import java.util.List;

public class PlantList {
    // An ArrayList is part of the Java Collections Framework and can grow or shrink dynamically as needed.
    private List<Plant> plants = new ArrayList<>();

    // Add a Plant (Method that adds a Plant object to plants Array):
    public void addPlant(Plant plant){
        plants.add(plant);
    }

    // List all Plants (Method that returns plants array, made up of Plant objects):
    public List<Plant> listPlants(){
        return plants;
    }
}
