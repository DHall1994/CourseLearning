package demo.Dlabs;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Lab3Exercises myLab3 = new Lab3Exercises();

        myLab3.theLunchQueue();

        int pounds = myLab3.getInt("Enter weight in pounds: ");
        myLab3.convertInputToStonesPounds(pounds);

        int kg = myLab3.getInt("Enter weight in kilograms: ");
        myLab3.convertKgsToStonesPounds(kg);
    }
}
