package demo.PrisonSim;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Prison {
    private static final int MAX_CAPACITY = 120;
    private static ArrayList<Prisoner> prisoners = new ArrayList<>();
    private static int incomingPrisoners = -1; // Tracks the incoming prisoners count (-1 means not calculated)
    private static final int DAYS_SINCE_LAST_RIOT = 224; // Fixed value for days since last riot
    private static final int LAST_RIOT_RISK_LEVEL = 144; // Fixed risk level for the last riot
    private static boolean incomingPrisonersAssigned = false;

    public static void main(String[] args) {
        generateRandomPrisoners();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                displayMenu();
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> System.out.println("Maximum capacity: " + MAX_CAPACITY);
                    case 2 -> System.out.println("Total prisoners: " + prisoners.size());
                    case 3 -> displayBlockPrisoners();
                    case 4 -> {
                        if (!incomingPrisonersAssigned) {
                            calculateIncomingPrisoners();
                            System.out.println("Incoming prisoners: " + incomingPrisoners);
                        } else {
                            System.out.println("All incoming prisoners have been assigned.");
                        }
                    }
                    case 5 -> {
                        if (!incomingPrisonersAssigned) {
                            calculateIncomingPrisoners();
                            assignNewPrisoners();
                            incomingPrisonersAssigned = true;
                        } else {
                            System.out.println("All incoming prisoners have already been assigned.");
                        }
                    }
                    case 6 -> handleRiotMenu(scanner);
                    case 7 -> {
                        System.out.println("Exiting...");
                        return;
                    }
                    default -> System.out.println("Invalid choice. Try again.");
                }
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n--- Prison Simulator ---");
        System.out.println("1. How many prisoners can we contain?");
        System.out.println("2. How many prisoners do we have?");
        System.out.println("3. How many prisoners are in each prison block?");
        System.out.println("4. How many incoming prisoners do we have?");
        System.out.println("5. Place the incoming prisoners");
        System.out.println("6. Riot Options");
        System.out.println("7. Exit");
    }

    private static void handleRiotMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Riot Options ---");
            System.out.println("1. How many days has it been since the last riot?");
            System.out.println("2. What was the combined prisoner risk level of the last riot?");
            System.out.println("3. How many guards were needed for the last riot?");
            System.out.println("4. Is a riot in progress?");
            System.out.println("5. Back");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> System.out.println("Days since last riot: " + DAYS_SINCE_LAST_RIOT);
                case 2 -> System.out.println("Combined risk level of last riot: " + LAST_RIOT_RISK_LEVEL);
                case 3 -> System.out.println("Guards needed for last riot: " + (int) Math.ceil(LAST_RIOT_RISK_LEVEL / 4.0));
                case 4 -> {
                    System.out.println("Is a riot in progress?");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    int riotChoice = scanner.nextInt();
                    if (riotChoice == 1) {
                        calculateCurrentRiot();
                    } else if (riotChoice == 2) {
                        System.out.println("No riot is currently in progress.");
                    } else {
                        System.out.println("Invalid choice. Try again.");
                    }
                }
                case 5 -> {
                    return; // Return to the main menu
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void calculateCurrentRiot() {
        int currentRiskLevel = prisoners.stream().mapToInt(Prisoner::getRiskLevel).sum();
        int guardsNeeded = (int) Math.ceil(currentRiskLevel / 4.0);

        System.out.println("Current prison risk level: " + currentRiskLevel);
        System.out.println("Guards needed to control the riot: " + guardsNeeded);
    }

    private static void generateRandomPrisoners() {
        Random random = new Random();
    
        // Generate random counts for each block
        int blockACount = random.nextInt(40 - 25 + 1) + 25; // 25 to 40 for Block A
        int blockBCount = random.nextInt(40 - 25 + 1) + 25; // 25 to 40 for Block B
        int blockCCount = random.nextInt(40 - 25 + 1) + 25; // 25 to 40 for Block C
    
        // Add prisoners to Block A
        for (int i = 0; i < blockACount; i++) {
            String name = "Prisoner" + (prisoners.size() + 1);
            Crime crime = Crime.values()[0]; // Assuming lowest risk crime corresponds to index 0
            int riskLevel = 1; // Low risk
            int cellNumber = random.nextInt(Block.A.getMaxCells()) + 1;
            Prisoner prisoner = new Prisoner(name, riskLevel, Block.A.getBlockName(), cellNumber, crime);
            prisoners.add(prisoner);
            Block.A.addPrisoner();
        }
    
        // Add prisoners to Block B
        for (int i = 0; i < blockBCount; i++) {
            String name = "Prisoner" + (prisoners.size() + 1);
            Crime crime = Crime.values()[1]; // Assuming medium risk crime corresponds to index 1
            int riskLevel = 2; // Medium risk
            int cellNumber = random.nextInt(Block.B.getMaxCells()) + 1;
            Prisoner prisoner = new Prisoner(name, riskLevel, Block.B.getBlockName(), cellNumber, crime);
            prisoners.add(prisoner);
            Block.B.addPrisoner();
        }
    
        // Add prisoners to Block C
        for (int i = 0; i < blockCCount; i++) {
            String name = "Prisoner" + (prisoners.size() + 1);
            Crime crime = Crime.values()[2]; // Assuming highest risk crime corresponds to index 2
            int riskLevel = 3; // High risk
            int cellNumber = random.nextInt(Block.C.getMaxCells()) + 1;
            Prisoner prisoner = new Prisoner(name, riskLevel, Block.C.getBlockName(), cellNumber, crime);
            prisoners.add(prisoner);
            Block.C.addPrisoner();
        }
    
        // Debug: Verify the totals match
        int totalBlockCount = Block.A.getCurrentPrisoners() + Block.B.getCurrentPrisoners() + Block.C.getCurrentPrisoners();
        System.out.println("Debug: Total prisoners in list: " + prisoners.size());
        System.out.println("Debug: Total prisoners across blocks: " + totalBlockCount);
    }    

    private static void displayBlockPrisoners() {
        // Reset current prisoners in each block
        for (Block block : Block.values()) {
            block.resetPrisoners();
        }
    
        // Recalculate block counts dynamically from the prisoners list
        for (Prisoner prisoner : prisoners) {
            switch (prisoner.getBlockName()) {
                case "A" -> Block.A.addPrisoner(); // Dynamically update block counts
                case "B" -> Block.B.addPrisoner();
                case "C" -> Block.C.addPrisoner();
                default -> System.out.println("Unknown block for prisoner: " + prisoner);
            }
        }
    
        // Print the dynamically updated counts
        System.out.println("Block A: " + Block.A.getCurrentPrisoners() + " prisoners");
        System.out.println("Block B: " + Block.B.getCurrentPrisoners() + " prisoners");
        System.out.println("Block C: " + Block.C.getCurrentPrisoners() + " prisoners");

        int totalBlockCount = Block.A.getCurrentPrisoners() + Block.B.getCurrentPrisoners() + Block.C.getCurrentPrisoners();
        System.out.println("Debug: Total prisoners in list: " + prisoners.size());
        System.out.println("Debug: Total prisoners across blocks: " + totalBlockCount);
    }    

    private static void calculateIncomingPrisoners() {
        if (incomingPrisoners == -1) {
            Random random = new Random();
            int remainingCapacity = MAX_CAPACITY - prisoners.size();
            incomingPrisoners = random.nextInt(remainingCapacity) + 1;
        }
    }

    private static void assignPrisonerToBlock(String name, int riskLevel, Block block, Crime crime, Random random) {
        int cellNumber = random.nextInt(block.getMaxCells()) + 1;
        Prisoner prisoner = new Prisoner(name, riskLevel, block.getBlockName(), cellNumber, crime);
        prisoners.add(prisoner); // Add prisoner to the list
        block.addPrisoner(); // Increment the block's prisoner count
        System.out.println(name + " assigned to Block " + block.getBlockName() +
                ", Cell " + cellNumber + " - (Risk Level: " + riskLevel + " for crime of: " + crime + ")");
    }    

    private static Block[] getLowerRiskBlocks(Block intendedBlock) {
        return switch (intendedBlock) {
            case C -> new Block[]{Block.B, Block.A};
            case B -> new Block[]{Block.A};
            case A -> new Block[]{}; // No lower-risk block for Block A
        };
    }

    private static void assignNewPrisoners() {
        System.out.println("Assigning " + incomingPrisoners + " new prisoners...");
        Random random = new Random();
    
        for (int i = 0; i < incomingPrisoners; i++) {
            String name = "NewPrisoner" + (prisoners.size() + 1);
            Crime crime = Crime.values()[random.nextInt(Crime.values().length)];
            int riskLevel = crime.getRiskLevel();
    
            // Determine the intended block based on risk level
            Block intendedBlock = switch (riskLevel) {
                case 1 -> Block.A;
                case 2 -> Block.B;
                case 3 -> Block.C;
                default -> throw new IllegalStateException("Unexpected risk level: " + riskLevel);
            };
    
            // Attempt to place the prisoner in the intended block
            if (intendedBlock.getCurrentPrisoners() < intendedBlock.getMaxCells()) {
                assignPrisonerToBlock(name, riskLevel, intendedBlock, crime, random);
            } else {
                // Reassign to a lower-risk block
                boolean assigned = false;
                for (Block alternativeBlock : getLowerRiskBlocks(intendedBlock)) {
                    if (alternativeBlock.getCurrentPrisoners() < alternativeBlock.getMaxCells()) {
                        assignPrisonerToBlock(name, riskLevel, alternativeBlock, crime, random);
                        System.out.println("WARNING: " + name + " reassigned to Block " + alternativeBlock.getBlockName() +
                                " (does not match risk level)");
                        assigned = true;
                        break;
                    }
                }
    
                // If no blocks can accommodate the prisoner
                if (!assigned) {
                    System.out.println("ERROR: No available cells for " + name + ". Risk level (" + riskLevel + ") too low for available blocks, find local prison for transfer.");
                }
            }
        }
        int totalBlockCount = Block.A.getCurrentPrisoners() + Block.B.getCurrentPrisoners() + Block.C.getCurrentPrisoners();
        System.out.println("Debug: Total prisoners in list: " + prisoners.size());
        System.out.println("Debug: Total prisoners across blocks: " + totalBlockCount);
    
        System.out.println();
        System.out.println("Total prisoners: " + prisoners.size());
        System.out.println();
        displayBlockPrisoners();
    }        
}