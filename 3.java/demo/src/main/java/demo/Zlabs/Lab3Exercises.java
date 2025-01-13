package demo.Zlabs;

import java.util.Scanner;
//labs03
public class Lab3Exercises {
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

    public void theLunchQueue() {
        String mainCourse = getString("What main dish would you like (Fish, Burgers, or Veg)? ");
        int roastPotatoes = getInt("How many roast potatoes would you like? ");
        int brusselSprouts = getInt("How many Brussel Sprouts would you like? ");
        System.out.println("Hello, your lunch is " + mainCourse + " with " + roastPotatoes + " roast potatoes and " + brusselSprouts + " Brussel sprouts.");
    }

    public void convertInputToStonesPounds(int pounds){
        int stones = pounds / 14;
        int remainingPounds = pounds % 14;
        System.out.println(pounds + " pounds is " + stones + " stones and " + remainingPounds + " pounds.");
    }

    public void convertKgsToStonesPounds(int kg){
        double pounds = kg * 2.20462;
        int totalPounds = (int) Math.round(pounds);
        convertInputToStonesPounds(totalPounds);
    }
}
