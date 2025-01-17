package demo.PrisonSim;

// Inheritance: Prisoner and Guard extend the Person class to inherit common attributes like name and ID.
// Polymorphism: Implementing the Behaviour interface in both Prisoner and Guard classes to define unique actions.
public class Guard extends Person implements Behaviour {
    private Location location; // Guard's assigned location

    public Guard(String name) {
        super(name); // Call the constructor of the Person class
        this.location = null; // Default: Not working today
    }

    public Guard(String name, Location location) {
        super(name); // Call the constructor of the Person class
        this.location = location; // Set the guard's location
    }

    @Override
    public void reportLocation() {
        String locationName = location != null ? location.getLocationName() : "Not working today";
        System.out.println(getName() + " is currently in the " + locationName);
    }

    @Override
    public String performAction() {
        return location != null ? ", Supervising the " + location.getLocationName() : ", N/A";
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }
}