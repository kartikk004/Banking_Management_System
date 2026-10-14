
import java.util.ArrayList;

public class Account {

    private int accountNumber;
    private String holderName;
    private double balance;

    private ArrayList<Transaction> transactions =
            new ArrayList<>();

    public Account(int accountNumber, String holderName,
                   double initialBalance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = initialBalance;
    }

    public void deposit(double amount)
            throws InvalidAmountException {

        if (!Double.isFinite(amount) || amount <= 0) {
            throw new InvalidAmountException(
                    "Deposit amount must be positive.");
        }

        balance += amount;

        transactions.add(
                new Transaction("DEPOSIT", amount, balance));

        System.out.println("Deposit successful!");
    }

    public void withdraw(double amount)
            throws InvalidAmountException,
                   InsufficientBalanceException {

        if (!Double.isFinite(amount) || amount <= 0) {
            throw new InvalidAmountException(
                    "Withdrawal amount must be positive.");
        }

        if (amount > balance) {
            throw new InsufficientBalanceException(
                    "Insufficient balance!");
        }

        balance -= amount;

        transactions.add(
                new Transaction("WITHDRAWAL", amount, balance));

        System.out.println("Withdrawal successful!");
    }

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: Rs. " + balance);
    }

    public void displayTransactionHistory() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }

        System.out.println("\n===== TRANSACTION HISTORY =====");

        for (Transaction transaction : transactions) {
            transaction.displayTransaction();
        }
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }
}