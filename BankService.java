
import java.util.HashMap;

public class BankService {

    private HashMap<Integer, Account> accounts = new HashMap<>();

     public void displayTransactionHistory(int accountNumber)
        throws AccountNotFoundException {

    Account account = findAccount(accountNumber);

    if (account == null) {
        throw new AccountNotFoundException(
                "Account not found: " + accountNumber);
    }

    account.displayTransactionHistory();
}

    
public void createAccount(
        int accountNumber,
        String holderName,
        double initialBalance,
        String accountType
) throws InvalidAmountException {

    if (!Double.isFinite(initialBalance) || initialBalance < 0) {
        throw new InvalidAmountException(
                "Initial balance cannot be negative or invalid."
        );
    }

    if (accounts.containsKey(accountNumber)) {
        System.out.println("Account number already exists.");
        return;
    }

    Account account;

    if (accountType.equalsIgnoreCase("savings")) {
        account = new SavingsAccount(
                accountNumber, holderName, initialBalance
        );
    } else if (accountType.equalsIgnoreCase("current")) {
        account = new CurrentAccount(
                accountNumber, holderName, initialBalance
        );
    } else {
        System.out.println("Invalid account type.");
        return;
    }

    accounts.put(accountNumber, account);
    System.out.println("Account created successfully!");
}

    public void depositMoney(int accountNumber, double amount)
            throws AccountNotFoundException,
                   InvalidAmountException {

        Account account = findAccount(accountNumber);

        if (account == null) {
            throw new AccountNotFoundException(
                    "Account not found: " + accountNumber);
        }

        account.deposit(amount);
    }

    public void withdrawMoney(int accountNumber, double amount)
            throws AccountNotFoundException,
                   InvalidAmountException,
                   InsufficientBalanceException {

        Account account = findAccount(accountNumber);

        if (account == null) {
            throw new AccountNotFoundException(
                    "Account not found: " + accountNumber);
        }

        account.withdraw(amount);
    }

    public void checkBalance(int accountNumber)
            throws AccountNotFoundException {

        Account account = findAccount(accountNumber);

        if (account == null) {
            throw new AccountNotFoundException(
                    "Account not found: " + accountNumber);
        }

        System.out.println("Account Holder: "
                + account.getHolderName());
        System.out.println("Current Balance: Rs. "
                + account.getBalance());
    }

    public Account findAccount(int accountNumber) {
        return accounts.get(accountNumber);
    }

    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
            return;
        }

        for (Account account : accounts.values()) {
            account.displayDetails();
            System.out.println("----------------------");
        }


    }
}