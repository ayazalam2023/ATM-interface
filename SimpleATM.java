import java.util.Scanner;

// Class representing a simple ATM
public class SimpleATM {
    private double balance; // User account balance

    // Constructor to initialize the ATM with a starting balance
    public SimpleATM(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        balance += amount; // Increase the balance by the deposit amount
        System.out.println("Deposited: " + amount); // Confirmation message
    }

    // Method to withdraw money from the account
    public boolean withdraw(double amount) {
        if (amount <= balance) { // Check if sufficient balance is available
            balance -= amount; // Decrease the balance by the withdrawal amount
            System.out.println("Withdrew: " + amount); // Confirmation message
            return true; // Withdrawal successful
        } else {
            System.out.println("Insufficient funds."); // Insufficient balance message
            return false; // Withdrawal unsuccessful
        }
    }

    // Method to print the current account balance
    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    // Main method to run the ATM interface
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner for user input
        SimpleATM atm = new SimpleATM(1000); // Initialize ATM with a starting balance of 1000

        int choice; // Variable to store menu choice

        // Display ATM menu options
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Quit");
            System.out.print("Select an option: ");
            choice = scanner.nextInt(); // Get user's menu choice

            // Process user's choice
            switch (choice) {
                case 1:
                    atm.checkBalance(); // Show current balance
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble(); // Get deposit amount
                    atm.deposit(depositAmount); // Deposit the amount
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble(); // Get withdrawal amount
                    atm.withdraw(withdrawAmount); // Withdraw the amount
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM."); // Exit message
                    break;
                default:
                    System.out.println("Invalid option. Please try again."); // Error message for invalid input
            }
        } while (choice != 4); // Loop until user chooses to quit

        scanner.close(); // Close the scanner
    }
}