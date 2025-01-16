package demo.Zlabs.Exercise4;

import java.awt.Color;
import java.awt.Point;

public class Shape {
    private Color colour;
    private Point position;

    // Constructor
    public Shape(Color colour, Point position) {
        this.colour = colour;
        this.position = position;
    }

    // Getters and Setters
    public Color getColour() {
        return colour;
    }

    public void setColour(Color colour) {
        this.colour = colour;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    // Method to get characteristics
    public String getCharacteristics() {
        return "Colour: " + colour + ", Position: (" + position.x + ", " + position.y + ")";
    }
}