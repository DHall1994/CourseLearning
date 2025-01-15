package demo.Zlabs.Exercise2;

public class RegistrationPlateFactory {
    private static String[] regPlates = { "MRB1G", "RU16", "TOYS4US", "HNZ57", "PUT3", "JB007" };
    private static int currentIndex = 0; // Tracks the next registration plate

    // Static method to get the next registration plate
    public static RegistrationPlate getNextRegistrationPlate() throws RegistrationPlateException {
        if (currentIndex < regPlates.length) {
            return new RegistrationPlate(regPlates[currentIndex++]);
        } else {
            throw new RegistrationPlateException("No registration plates available!");
        }
    }
}