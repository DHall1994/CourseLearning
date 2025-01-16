package demo.Zlabs.Exercise4;

public class Circle extends Shape {
    private double radius;

    // Constructor
    public Circle(double radius, java.awt.Color colour, java.awt.Point position) {
        super(colour, position);
        this.radius = radius;
    }

    // Getters and Setters
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Method to calculate area
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // Method to calculate circumference
    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    // Override getCharacteristics
    @Override
    public String getCharacteristics() {
        return super.getCharacteristics() +
                ", Radius: " + radius +
                ", Area: " + getArea() +
                ", Circumference: " + getCircumference();
    }
}