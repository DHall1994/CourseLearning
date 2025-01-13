package demo.Zlabs;

import java.util.Scanner;

public class Lab6Exercises {
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

    public void part1() {
        grades();
    }

    private void grades() {
        String[] names = new String[5];
        int[] marks = new int[5];

        for (int i = 0; i < 5; i++) {
            names[i] = getString("Enter the name of student " + (i + 1) + ": ");
            marks[i] = getInt("Enter the mark for " + names[i] + ": ");
        }

        System.out.println("\nStudent Results:");
        for (int i = 0; i < 5; i++) {
            String grade;
            if (marks[i] < 1 || marks[i] > 100) {
                grade = "Error: Invalid marks";
            } else if (marks[i] < 50) {
                grade = "Fail";
            } else if (marks[i] <= 60) {
                grade = "Pass";
            } else if (marks[i] <= 70) {
                grade = "Merit";
            } else {
                grade = "Distinction";
            }
            System.out.printf("%s: Mark = %d, Grade = %s%n", names[i], marks[i], grade);
        }
    }

    public void account() {
        double initialMoney = 100;
        double currentMoney = initialMoney;
        double interestRate = 0.05;
        int years = 0;

        while (currentMoney < 200) {
            currentMoney += currentMoney * interestRate;
            years++;
        }

        System.out.println("It takes " + years + " years to double your money from £100 to £200 at 5% interest.");
    }

    public void multiplicationTable() {
        System.out.println("Multiplication Table:");
        for (int row = 1; row <= 10; row++) {
            for (int col = 1; col <= 10; col++) {
                System.out.printf("%5d", row * col);
            }
            System.out.println();
        }
    }
}
