
public class SavingsAccount extends Account {

    private static final double MINIMUM_BALANCE = 1000.0;

    public SavingsAccount(int accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public void withdraw(double amount)
            throws InvalidAmountException, InsufficientBalanceException {

        if (!Double.isFinite(amount) || amount <= 0) {
            throw new InvalidAmountException(
                    "Withdrawal amount must be greater than zero."
            );
        }

        if (amount > getBalance() - MINIMUM_BALANCE) {
            throw new InsufficientBalanceException(
                    "Savings account must maintain a minimum balance of Rs. 1000."
            );
        }

        super.withdraw(amount);
    }

    @Override
    public void displayDetails() {
        System.out.println("Account Type: Savings Account");
        super.displayDetails();
    }
}