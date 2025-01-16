package demo.Zlabs.Exercise4;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        // Create shapes
        Shape rectangle = new Shape(Color.RED, new Point(10, 20));
        Circle circle = new Circle(5, Color.BLUE, new Point(15, 25));
        Sphere sphere = new Sphere(7, Color.GREEN, new Point(20, 30));

        // Print characteristics of each shape
        System.out.println("Rectangle: " + rectangle.getCharacteristics());
        System.out.println("Circle: " + circle.getCharacteristics());
        System.out.println("Sphere: " + sphere.getCharacteristics());

        // Create an ArrayList of Shapes
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(rectangle);
        shapes.add(circle);
        shapes.add(sphere);

        // Enhanced for loop to print colour and position of each shape
        System.out.println("\nShapes in the ArrayList:");
        for (Shape shape : shapes) {
            System.out.println("Colour: " + shape.getColour() + ", Position: (" + shape.getPosition().x + ", " + shape.getPosition().y + ")");
        }
    }
}