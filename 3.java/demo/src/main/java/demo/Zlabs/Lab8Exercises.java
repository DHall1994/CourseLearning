package demo.Zlabs;

public class Lab8Exercises {
    private int id;
    private String owner;
    private double balance;

    // Constructor
    public Lab8Exercises(int id, String owner, double balance) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
    }

    // Deposit method
    public void Deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
        } else {
            balance += amount;
            System.out.println("Deposited: " + amount);
        }
    }

    // Withdraw method
    public void Withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance for withdrawal.");
        } else if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        }
    }

    // Get details method
    public String getDetails() {
        return "Account ID: " + id + ", Owner: " + owner + ", Balance: " + balance;
    }

    // Add interest method
    public void AddInterest() {
        balance += balance * 0.025; // Add 2.5% interest
        System.out.println("Interest added: 2.5%");
    }
}
