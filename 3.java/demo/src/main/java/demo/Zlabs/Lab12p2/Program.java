package demo.Zlabs.Lab12p2;

import com.google.gson.Gson;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Program {

    public static void main(String[] args) throws Exception {
        // Create a Gson instance
        Gson gson = new Gson();

        // File path for customers.json (relative to your working directory)
        String fileName = "3.java/demo/src/customers.json";

        // Read the JSON file
        String content = new String(Files.readAllBytes(Paths.get(fileName)));

        // Deserialize JSON into an array of Customer objects
        Customer[] customers = gson.fromJson(content, Customer[].class);

        // Print details of all customers
        for (Customer customer : customers) {
            System.out.println(customer);
            System.out.println("----------------------");
        }

        // Writing JSON data to a new file
        String outputFileName = "3.java/demo/src/outputCustomers.json";
        Files.write(Paths.get(outputFileName), gson.toJson(customers).getBytes());
        System.out.println("Customer data written to outputCustomers.json");
    }
}