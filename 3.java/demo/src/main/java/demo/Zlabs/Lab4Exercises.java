package demo.Zlabs;

import java.util.Scanner;

public class Lab4Exercises {
    public int getInt(String prompt) {
        Scanner s = new Scanner(System.in);
        System.out.print(prompt);
        return s.nextInt();
    }

    public void part1() {
        // Prompt for the price of a bag
        int price = getInt("Price of a bag please? ");
        if (price <= 0) {
            System.out.println("Price must be a positive value.");
            return;
        }

        // Prompt for the amount of money
        int money = getInt("How much money do you have? ");
        if (money <= 0) {
            System.out.println("Money must be a positive value.");
            return;
        }

        // Calculate the number of bags they can afford
        int numBags = money / price;

        // Display the result
        System.out.println("If the price is '" + price + "p' and you have '" + money +
                "p', then you will be able to buy '" + numBags + "' bags.");
    }
}
