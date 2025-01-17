package demo.PrisonSim;

// Inheritance: Prisoner and Guard extend the Person class to inherit common attributes like name and ID.
// Polymorphism: Implementing the Behaviour interface in both Prisoner and Guard classes to define unique actions.
public class Prisoner extends Person implements Behaviour {
    // Encapsulation: Using private fields and public getter/setter methods to restrict direct access to class properties.
    private int riskLevel;
    private String block; // The block name (e.g., "A", "B", "C")
    private int cellNumber;
    private Crime crime;
    private Location location;

    public Prisoner(String name, int riskLevel, String block, int cellNumber, Crime crime) {
        super(name); // Call the constructor of the Person class
        this.riskLevel = riskLevel;
        this.block = block;
        this.cellNumber = cellNumber;
        this.crime = crime;
        this.location = Location.CELLS; // Default location
    }

    public int getRiskLevel() {
        return riskLevel;
    }

    public String getBlockName() {
        return block;
    }

    public int getCellNumber() {
        return cellNumber;
    }

    public Crime getCrime() {
        return crime;
    }

    public Location getLocation() { // Add this method to retrieve the location
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return getName() + " [ID: " + getId() + ", Risk Level: " + riskLevel + ", Block: " + block + 
               ", Cell: " + cellNumber + ", Crime: " + crime + ", Location: " + location.getLocationName() + "]";
    }

    @Override
    public void reportLocation() {
        System.out.println(getName() + " is currently in the " + location.getLocationName());
    }

    @Override
    public String performAction() {
        return switch (location) {
            case CELLS -> ", taking a nap.";
            case FOOD_HALL -> ", eating.";
            case PRISON_YARD -> ", working out.";
            case WORKSHOP -> ", building seats for the yard.";
            case VISITATION -> ", talking to their loved ones.";
        };
    }
}