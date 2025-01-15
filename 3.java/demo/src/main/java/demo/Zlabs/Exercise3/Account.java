package demo.Zlabs.Exercise3;

public class Account {
    private int id;
    private double balance;
    private String owner;

    // Constructor
    public Account(int id, double balance, String owner) {
        this.id = id;
        this.balance = balance;
        this.owner = owner;
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (balance - amount < 0) {
            throw new IllegalArgumentException("Insufficient balance for withdrawal.");
        }
        balance -= amount;
    }

    // Deposit method
    public void deposit(double amount) {
        balance += amount;
    }

    // Close method
    public void close() {
        System.out.println("Account " + id + " is closed.");
    }

    // Get account details
    public String getDetails() {
        return "ID: " + id + ", Balance: £" + balance + ", Owner: " + owner;
    }
}
