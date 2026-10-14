
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankService bank = new BankService();

        int choice = 0;

        do {
            
        System.out.println("\n===== BANKING MANAGEMENT SYSTEM =====");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Check Balance");
        System.out.println("5. Display All Accounts");
        System.out.println("6. View Transaction History");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    
case 1:
    System.out.print("Enter Account Number: ");
    int accountNumber = Integer.parseInt(sc.nextLine());

    System.out.print("Enter Account Holder Name: ");
    String holderName = sc.nextLine();

    System.out.print("Enter Initial Balance: ");
    double initialBalance = Double.parseDouble(sc.nextLine());

    System.out.print("Enter Account Type (Savings/Current): ");
    String accountType = sc.nextLine();

    bank.createAccount(
            accountNumber,
            holderName,
            initialBalance,
            accountType
    );
    break;

                    case 2:
                        System.out.print("Enter Account Number: ");
                        accountNumber = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter Deposit Amount: ");
                        double deposit =
                                Double.parseDouble(sc.nextLine());

                        bank.depositMoney(accountNumber, deposit);
                        break;

                    case 3:
                        System.out.print("Enter Account Number: ");
                        accountNumber = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter Withdrawal Amount: ");
                        double withdrawal =
                                Double.parseDouble(sc.nextLine());

                        bank.withdrawMoney(accountNumber, withdrawal);
                        break;

                    case 4:
                        System.out.print("Enter Account Number: ");
                        accountNumber = Integer.parseInt(sc.nextLine());

                        bank.checkBalance(accountNumber);
                        break;

                    case 5:
                        bank.displayAllAccounts();
                        break;

                    case 6:
                         System.out.print("Enter Account Number: ");
                         accountNumber = Integer.parseInt(sc.nextLine());

                         bank.displayTransactionHistory(accountNumber);
                         break;

                    case 7:
                         System.out.println("Thank you for using our bank!");
                         break;
                    default:
                        System.out.println("Invalid menu choice!");
                }

            } catch (NumberFormatException e) {
                System.out.println(
                        "Invalid input! Please enter a valid number.");

            } catch (InvalidAmountException
                     | InsufficientBalanceException
                     | AccountNotFoundException e) {

                System.out.println("Transaction failed: "
                        + e.getMessage());
            }

        } while (choice != 7);

        sc.close();
    }
}