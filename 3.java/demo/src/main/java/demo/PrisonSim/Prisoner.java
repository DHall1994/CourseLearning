package demo.PrisonSim;

public class Prisoner {
    private String id;
    private String name;
    private int riskLevel;
    private String block; // The block name (e.g., "A", "B", "C")
    private int cellNumber;
    private Crime crime;

    public Prisoner(String name, int riskLevel, String block, int cellNumber, Crime crime) {
        this.id = "P" + System.nanoTime(); // Unique ID
        this.name = name;
        this.riskLevel = riskLevel;
        this.block = block;
        this.cellNumber = cellNumber;
        this.crime = crime;
    }

    public int getRiskLevel() {
        return riskLevel;
    }

    public String getBlockName() {
        return block; // Provide access to the block name
    }

    @Override
    public String toString() {
        return name + " [ID: " + id + ", Risk Level: " + riskLevel + ", Block: " + block + ", Cell: " + cellNumber + ", Crime: " + crime + "]";
    }
}