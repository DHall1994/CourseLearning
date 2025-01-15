package demo.Zlabs.Lab12;

import java.io.*;
import java.nio.file.*;
import java.util.Arrays;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Program {

    public static void main(String[] args) throws Exception {
        System.out.println("Current Working Directory: " + System.getProperty("user.dir"));

        // Read the files and capture the result in variables
        String[] courses = readCSV("3.java/demo/src/course.txt");
        String[] trainers = readCSV("3.java/demo/src/trainer.txt");

        // Create or append data to the trainersAndCourses.txt file
        appendToFile("3.java/demo/src/trainersAndCourses.txt", "Courses:", courses);
        appendToFile("3.java/demo/src/trainersAndCourses.txt", "Trainers:", trainers);

        System.out.println("Data appended to trainersAndCourses.txt successfully.");

        // New Functionality: Process trainerCourse.txt and generate a report
        List<String> report = generateTrainerCourseReport("3.java/demo/src/trainerCourse.txt", trainers, courses);

        // Write the report to a new file
        writeReport("3.java/demo/src/trainerCourseReport.txt", report);

        System.out.println("Trainer-Course Report generated successfully.");
    }

    // Method to read a CSV file and return its contents as a String array
    private static String[] readCSV(String inFile) throws IOException {
        // Read all lines from the file
        String content = Files.readString(Paths.get(inFile));

        // Split the content using "," as a delimiter
        return content.split(",");
    }

    // Method to append data to a file
    private static void appendToFile(String fileName, String header, String[] data) throws IOException {
        // Create or append to the file using BufferedWriter
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(header); // Write the header
            writer.newLine(); // Add a new line
            for (String item : data) {
                writer.write(item); // Write each item
                writer.newLine(); // Add a new line after each item
            }
            writer.newLine(); // Add an extra new line at the end
        }
    }

    // New Method: Generate a report from trainerCourse.txt
    private static List<String> generateTrainerCourseReport(String fileName, String[] trainers, String[] courses) throws IOException {
        List<String> report = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(fileName)); // Read all lines from trainerCourse.txt

        for (String line : lines) {
            String[] parts = line.split(",");
            int trainerIndex = Integer.parseInt(parts[0]) - 1; // Convert to zero-based index
            int courseIndex = Integer.parseInt(parts[1]) - 1;  // Convert to zero-based index

            String trainer = trainers[trainerIndex];
            String course = courses[courseIndex];

            report.add(trainer + " teaches " + course);
        }
        return report;
    }

    // New Method: Write the report to a file
    private static void writeReport(String fileName, List<String> report) throws IOException {
        Files.write(Paths.get(fileName), report);
    }
}