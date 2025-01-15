package demo.PrisonSim;

public enum Crime {
    THEFT(1), ASSAULT(2), MURDER(3);

    private final int riskLevel;

    Crime(int riskLevel) {
        this.riskLevel = riskLevel;
    }

    public int getRiskLevel() {
        return riskLevel;
    }
}
