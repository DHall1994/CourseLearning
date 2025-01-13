package demo.Zlabs;

import java.util.Scanner;

public class Lab5Exercises {
    public int getInt(String prompt) {
        Scanner s = new Scanner(System.in);
        System.out.print(prompt);
        return s.nextInt();
    }

    public String getString(String prompt) {
        Scanner s = new Scanner(System.in);
        System.out.print(prompt);
        return s.nextLine();
    }

    public void grades() {
        int mark = getInt("Enter the exam mark: ");

        if (mark < 1 || mark > 100) {
            System.out.println("Error: marks must be between 1..100");
        } else if (mark < 50) {
            System.out.println("Grade: Fail");
        } else if (mark <= 60) {
            System.out.println("Grade: Pass");
        } else if (mark <= 70) {
            System.out.println("Grade: Merit");
        } else {
            System.out.println("Grade: Distinction");
        }
    }

    public void Part2() {
        String summerInput = getString("Is it Summer time? (yes/no): ");
        boolean isSummer = summerInput.equalsIgnoreCase("yes");

        String eveningInput = getString("Is it a sunny evening? (yes/no): ");
        boolean isEvening = eveningInput.equalsIgnoreCase("yes");

        System.out.println("Actions:");
        System.out.println("- Take a shower");
        if (isSummer && isEvening) {
            System.out.println("- Eat outside");
            System.out.println("- Do outdoors hobby");
        } else if (isSummer) {
            System.out.println("- Eat inside");
            System.out.println("- Do outdoors hobby");
        } else if (isEvening) {
            System.out.println("- Eat inside");
            System.out.println("- Take a walk");
        } else {
            System.out.println("- Eat inside");
        }
        System.out.println("- Contact friends");
    }
}