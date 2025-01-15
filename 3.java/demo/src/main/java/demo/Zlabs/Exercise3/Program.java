package demo.Zlabs.Exercise3;

public class Program {
    public static void main(String[] args) {
        Account account = new Account(123, 100, "John Doe"); // Create an account with £100 balance

        try {
            // Withdraw £50 and display account details
            account.withdraw(50);
            System.out.println("After withdrawing £50: " + account.getDetails());

            // Attempt to withdraw £60
            account.withdraw(60);
            System.out.println("After withdrawing £60: " + account.getDetails());
        } catch (IllegalArgumentException e) {
            // Catch and display the exception
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Close the account
            account.close();
        }
    }
}
