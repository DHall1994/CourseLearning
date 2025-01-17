package demo.PrisonSim;

// Enum: Representing predefined constant sets, such as different prison locations and crimes.
public enum Location {
    CELLS("Cells"),
    FOOD_HALL("Food Hall"),
    PRISON_YARD("Prison Yard"),
    WORKSHOP("Workshop"),
    VISITATION("Visitation");

    private final String locationName;

    Location(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationName() {
        return locationName;
    }
}
