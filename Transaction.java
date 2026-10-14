
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private String type;
    private double amount;
    private double balanceAfter;
    private LocalDateTime dateTime;

    public Transaction(String type, double amount,
                       double balanceAfter) {
        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
        this.dateTime = LocalDateTime.now();
    }

    public void displayTransaction() {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        System.out.println("Type: " + type);
        System.out.println("Amount: Rs. " + amount);
        System.out.println("Balance After: Rs. " + balanceAfter);
        System.out.println("Date & Time: "
                + dateTime.format(formatter));
        System.out.println("---------------------------");
    }
}