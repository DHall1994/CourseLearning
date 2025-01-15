package demo.Zlabs.Lab9_10;

import java.awt.Color;

public class Shape {
    public int x, y, w, h; // Shape position and size
    private int dirX, dirY; // Shape direction
    private SHAPE_TYPE shapeType; // Shape type
    private Color colour; // Shape colour

    // Static world dimensions
    public static int worldW;
    public static int worldH;

    // Constructor to set all fields
    public Shape(int x, int y, int w, int h, int dirX, int dirY, SHAPE_TYPE shapeType, Color colour) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.dirX = dirX;
        this.dirY = dirY;
        this.shapeType = shapeType;
        this.colour = colour;
    }

    // Constructor with default direction
    public Shape(int x, int y, int w, int h, SHAPE_TYPE shapeType, Color colour) {
        this(x, y, w, h, 1, 1, shapeType, colour); // Constructor chaining
    }

    // Static method to set world dimensions
    public static void setWorld(int w, int h) {
        worldW = w;
        worldH = h;
    }

    // Getter for shape type
    public SHAPE_TYPE getShapeType() {
        return shapeType;
    }

    // Getter for colour
    public Color getColour() {
        return colour;
    }

    // Move the shape and ensure it stays within the world
    public void move() {
        x += dirX;
        y += dirY;

        // Check boundaries and reverse direction if needed
        if (x < 0) {
            x = 0;
            dirX = -dirX;
        }
        if (y < 0) {
            y = 0;
            dirY = -dirY;
        }
        if (x > worldW - w) {
            x = worldW - w;
            dirX = -dirX;
        }
        if (y > worldH - h) {
            y = worldH - h;
            dirY = -dirY;
        }
    }
}