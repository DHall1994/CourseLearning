package demo.Zlabs.Exercise2;

public class Vehicle {
    private int speed;
    private int lane;
    private int distanceTravelled;
    private static int count = 0; // Static counter for vehicles
    private RegistrationPlate registrationPlate;

    // Constructor
    public Vehicle(int speed, int lane) throws VehicleCreationException {
        this.speed = speed;
        this.lane = lane;
        this.distanceTravelled = 0;

        // Assign a registration plate
        try {
            this.registrationPlate = RegistrationPlateFactory.getNextRegistrationPlate();
        } catch (RegistrationPlateException e) {
            throw new VehicleCreationException("Vehicle creation failed: " + e.getMessage());
        }

        count++; // Increment vehicle count
    }

    // Accelerate method: Increases speed and updates distance traveled
    public void accelerate(int amount) {
        if (speed + amount > 200) {
            speed = 200; // Max speed is 200
        } else {
            speed += amount;
        }
        distanceTravelled += speed; // Add current speed to the total distance
    }

    // Brake method: Reduces speed by a given amount
    public void brake(int amount) {
        speed = Math.max(0, speed - amount); // Ensure speed doesn't go below 0
    }

    // Get vehicle details
    public String getDetails() {
        return "Speed: " + speed + ", Lane: " + lane + ", Distance: " + distanceTravelled +
               ", Plate: " + registrationPlate.getRegPlate();
    }

    // Getter for lane
    public int getLane() {
        return lane;
    }

    // Getter for distance travelled
    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    // Static method to get the count of vehicles created
    public static int getCount() {
        return count;
    }
}
