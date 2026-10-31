class Account {
    private String accNo;
    private String holderName;
    private double balance;

    // Constructor
    Account(String accNo, String holderName, double balance) {
        this.accNo = accNo;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        }
    }

    // Get balance
    public double getBalance() {
        return balance;
    }

    // Display account details
    public void displayAccount() {
        System.out.println("Account Number: " + accNo);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
    }
}

// Main class
public class Main {
    public static void main(String[] args) {

        Account account = new Account(
            "ACC101",
            "Sangay",
            10000
        );

        account.displayAccount();

        System.out.println("\n--- Deposit ---");
        account.deposit(5000);

        System.out.println("\nBalance: " + account.getBalance());

        System.out.println("\n--- Withdrawal ---");
        account.withdraw(3000);

        System.out.println("\nBalance: " + account.getBalance());

        System.out.println("\n--- Final Account Details ---");
        account.displayAccount();
    }
}