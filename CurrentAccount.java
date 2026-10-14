
public class CurrentAccount extends Account {

    private static final double MAX_WITHDRAWAL = 50000.0;

    public CurrentAccount(int accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public void withdraw(double amount)
            throws InvalidAmountException, InsufficientBalanceException {

        if (amount > MAX_WITHDRAWAL) {
            throw new InvalidAmountException(
                    "Maximum withdrawal per transaction is Rs. 50000."
            );
        }

        super.withdraw(amount);
    }

    @Override
    public void displayDetails() {
        System.out.println("Account Type: Current Account");
        super.displayDetails();
    }
}