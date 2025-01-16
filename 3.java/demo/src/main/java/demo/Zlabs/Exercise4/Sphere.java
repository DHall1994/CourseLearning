package demo.Zlabs.Exercise4;

public class Sphere extends Circle {

    // Constructor
    public Sphere(double radius, java.awt.Color colour, java.awt.Point position) {
        super(radius, colour, position);
    }

    // Method to calculate volume
    public double getVolume() {
        return (4.0 / 3) * Math.PI * Math.pow(getRadius(), 3);
    }

    // Override getCharacteristics
    @Override
    public String getCharacteristics() {
        return super.getCharacteristics() +
                ", Volume: " + getVolume();
    }
}