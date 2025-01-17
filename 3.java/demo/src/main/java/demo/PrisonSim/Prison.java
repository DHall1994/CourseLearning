package demo.PrisonSim;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Prison {
    private static final int MAX_CAPACITY = 120;
    private static final ArrayList<Prisoner> prisoners = new ArrayList<>();
    // Composition: The Prison class uses an ArrayList to manage multiple Guard objects.
    private static final ArrayList<Guard> guards = new ArrayList<>();
    private static final HashMap<Location, ArrayList<Guard>> locationAssignments = new HashMap<>();
    private static final ArrayList<Guard> offDutyGuards = new ArrayList<>();
    private static int incomingPrisoners = -1; // Tracks the incoming prisoners count (-1 means not calculated)
    private static final int DAYS_SINCE_LAST_RIOT = 224; // Fixed value for days since last riot
    private static final int LAST_RIOT_RISK_LEVEL = 144; // Fixed risk level for the last riot
    private static boolean incomingPrisonersAssigned = false;

    public static void main(String[] args) {
        generateRandomPrisoners();
        generateGuards();

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
                    case 7 -> searchUser(scanner); // Search for a prisoner or guard
                    case 8 -> displayGuardAssignments(); // Show guard assignments
                    case 9 -> {
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
        System.out.println("7. Search for Prisoner or Guard");
        System.out.println("8. Display Guard Assignments");
        System.out.println("9. Exit");
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

    private static void generateGuards() {
        for (int i = 1; i <= 40; i++) {
            // Use the single-argument constructor
            guards.add(new Guard("Guard" + i));
        }
    
        Collections.shuffle(guards); // Randomize guard assignments
    
        int guardIndex = 0;
        for (Location location : Location.values()) {
            ArrayList<Guard> assignedGuards = new ArrayList<>();
            for (int j = 0; j < 5; j++) { // Assign 5 guards per location
                if (guardIndex < guards.size()) {
                    Guard guard = guards.get(guardIndex);
                    guard.setLocation(location); // Set the location for the guard
                    assignedGuards.add(guard);
                    guardIndex++;
                }
            }
            locationAssignments.put(location, assignedGuards);
        }
    
        while (guardIndex < guards.size()) {
            offDutyGuards.add(guards.get(guardIndex));
            guards.get(guardIndex).setLocation(null); // Mark guard as off-duty
            guardIndex++;
        }
    }    

    private static void searchUser(Scanner scanner) {
        System.out.println("Search for (1) Prisoner or (2) Guard:");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
    
        if (choice == 1) {
            System.out.print("Enter prisoner number (Example: Prisoner1): ");
            String name = scanner.nextLine();
            // Substitution: Stream uses a lambda to filter Prisoner objects, dynamically interacting with subclass instances through the Behaviour interface.
            prisoners.stream()
                    .filter(prisoner -> prisoner.getName().equalsIgnoreCase(name))
                    .findFirst()
                    .ifPresentOrElse(
                            prisoner -> {
                                // Assign a random location to the prisoner for display purposes
                                Location randomLocation = Location.values()[new Random().nextInt(Location.values().length)];
                                // Dynamic Behavior: The prisoner's location is updated at runtime to reflect their current state dynamically.
                                prisoner.setLocation(randomLocation); // Update location dynamically
                                System.out.println("Found: " + prisoner);
                                System.out.println("Current Location: " + prisoner.getLocation().getLocationName() + prisoner.performAction());
                            },
                            () -> System.out.println("No prisoner found with that name.")
                    );
        } else if (choice == 2) {
            System.out.print("Enter guard number (Example: Guard1): ");
            String name = scanner.nextLine();
            // Substitution: Stream uses a lambda to filter Prisoner objects, dynamically interacting with subclass instances through the Behaviour interface.
            guards.stream()
                    .filter(guard -> guard.getName().equalsIgnoreCase(name))
                    .findFirst()
                    .ifPresentOrElse(
                            guard -> {
                                int age = new Random().nextInt(43) + 25; // Random age between 25 and 67
                                Location location = locationAssignments.entrySet().stream()
                                        .filter(entry -> entry.getValue().contains(guard))
                                        .map(Map.Entry::getKey)
                                        .findFirst()
                                        .orElse(null);
    
                                System.out.println("Found: " + guard.getName());
                                System.out.println("Age: " + age);
                                System.out.println("Current Location: " +
                                        (location != null ? location.getLocationName() + guard.performAction() : "Not working today" + guard.performAction()));
                            },
                            () -> System.out.println("No guard found with that name.")
                    );
        } else {
            System.out.println("Invalid choice. Returning to main menu.");
        }
    }    

    private static void displayGuardAssignments() {
        System.out.println("--- Guard Assignments ---");
        for (Location location : locationAssignments.keySet()) {
            System.out.println(location.getLocationName() + ":");
            for (Guard guard : locationAssignments.get(location)) {
                System.out.println("  - " + guard.getName());
            }
        }

        System.out.println("\n--- Guards Not Working Today ---");
        for (Guard guard : offDutyGuards) {
            System.out.println("  - " + guard.getName());
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