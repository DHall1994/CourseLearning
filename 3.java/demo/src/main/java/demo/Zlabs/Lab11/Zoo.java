package demo.Zlabs.Lab11;

import java.util.HashMap;

public class Zoo {
    private HashMap<String, Integer> animalMap;

    // Arrays for existing and new animals
    private String[] originalAnimals = {"Zebra", "Lion", "Buffalo"};
    private String[] newAnimals = {"Zebra", "Gazelle", "Buffalo", "Zebra"};

    // Constructor
    public Zoo() {
        // Instantiate HashMap
        animalMap = new HashMap<>();

        // Add animals from both arrays
        addAnimals(originalAnimals);
        addAnimals(newAnimals);

        // Display the animal data
        displayAnimalData();
    }

    // Method to add animals to the HashMap
    public void addAnimals(String[] animals) {
        for (String animal : animals) {
            if (animalMap.containsKey(animal)) {
                animalMap.put(animal, animalMap.get(animal) + 1);
            } else {
                animalMap.put(animal, 1);
            }
        }
    }

    // Method to display animal data
    public void displayAnimalData() {
        System.out.println("Animal Counts:");
        for (String animal : animalMap.keySet()) {
            System.out.printf("%s: %d%n", animal, animalMap.get(animal));
        }
    }
}