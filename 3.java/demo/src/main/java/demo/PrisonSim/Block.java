package demo.PrisonSim;

public enum Block {
    A("A", 1, 40),  // Block A: Low risk
    B("B", 2, 40),  // Block B: Medium risk
    C("C", 3, 40);  // Block C: High risk

    private final String blockName;
    private final int riskLevel;
    private final int maxCells;
    private int currentPrisoners;

    Block(String blockName, int riskLevel, int maxCells) {
        this.blockName = blockName;
        this.riskLevel = riskLevel;
        this.maxCells = maxCells;
        this.currentPrisoners = 0; // Initial prisoners count
    }

    public String getBlockName() {
        return blockName;
    }

    public int getRiskLevel() {
        return riskLevel;
    }

    public int getMaxCells() {
        return maxCells;
    }

    public int getCurrentPrisoners() {
        return currentPrisoners;
    }

    public void addPrisoner() {
        if (currentPrisoners < maxCells) {
            currentPrisoners++;
        }
    }

    public void resetPrisoners() {
        this.currentPrisoners = 0; // Reset the count
    }
}