package demo.PrisonSim;

// Interface: Behaviour defines common actions (reportLocation, performAction)
public interface Behaviour {
    void reportLocation(); // Method to report the location
    String performAction();  // Method to perform an action based on role or location
}
