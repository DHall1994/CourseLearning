package demo.Zlabs;

public class Lab8Program {
    public static void main(String[] args) {
        // Step 7: Create an Account instance
        Lab8Exercises myAccount = new Lab8Exercises(1, "John Doe", 100.0);

        // Step 8: Call Deposit and Withdraw
        myAccount.Deposit(50);
        myAccount.Withdraw(30);
        System.out.println(myAccount.getDetails());

        // Step 9: Add interest and check balance
        myAccount.AddInterest();
        System.out.println("After interest: " + myAccount.getDetails());

        // Step 10: Experiment with references
        Lab8Exercises partnerAccount = myAccount;
        partnerAccount.AddInterest();
        System.out.println("After partner interest: " + myAccount.getDetails());

        // Step 11: Process Account with a method
        processAccount(myAccount);
        System.out.println("After processAccount: " + myAccount.getDetails());

        // Step 12: Experiment with primitives
        int k = 100;
        incInt(k);
        System.out.println("After incInt: k = " + k); // k will not change
    }

    // Step 8: Process Account method
    static void processAccount(Lab8Exercises acc) {
        acc.AddInterest();
    }

    // Step 13: Experiment with primitive type
    private static void incInt(int x) {
        x++;
    }
}