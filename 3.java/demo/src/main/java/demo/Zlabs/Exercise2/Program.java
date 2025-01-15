package demo.Zlabs.Exercise2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Program {
    // Logging method
    private static void log(String msg) throws IOException {
        File file = new File("3.java/demo/src/main/java/demo/Zlabs/Exercise2/log.txt");
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter br = new BufferedWriter(fr);
        br.write(msg + "\r\n");
        br.close();
        fr.close();
    }
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        try {
            // Create vehicles
            vehicles.add(new Vehicle(0, 1)); // Lane 1
            vehicles.add(new Vehicle(0, 2)); // Lane 2
            vehicles.add(new Vehicle(0, 3)); // Lane 3

            log("Vehicles created successfully.");
        } catch (VehicleCreationException e) {
            System.out.println("Error: " + e.getMessage());
            try {
                log("Error creating vehicles: " + e.getMessage());
            } catch (IOException ioException) {
                System.out.println("Logging failed: " + ioException.getMessage());
            }
            return;
        } catch (IOException e) {
            System.out.println("Log error: " + e.getMessage());
            return;
        }

        // Start race simulation
        Random rand = new Random();
        boolean raceFinished = false;

        while (!raceFinished) {
            for (Vehicle vehicle : vehicles) {
                int acceleration = rand.nextInt(10) + 1; // Random acceleration between 1 and 10
                vehicle.accelerate(acceleration); // Accelerate the vehicle

                // Print vehicle progress to console
                String details = vehicle.getDetails();
                System.out.println(details);

                // Log vehicle progress to file
                try {
                    log(details);
                } catch (IOException e) {
                    System.out.println("Failed to log vehicle details: " + e.getMessage());
                }

                // Check if any vehicle has traveled more than 1000m
                if (vehicle.getDistanceTravelled() >= 1000) {
                    System.out.println("\nWinner: Vehicle in Lane " + vehicle.getLane());
                    try {
                        log("Winner: Vehicle in Lane " + vehicle.getLane());
                    } catch (IOException e) {
                        System.out.println("Failed to log winner: " + e.getMessage());
                    }
                    raceFinished = true;
                    break;
                }
            }
            System.out.println("----------------------------"); // Delimiter for each iteration
        }
    }
}