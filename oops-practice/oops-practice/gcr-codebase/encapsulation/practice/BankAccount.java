
public class BankAccount {

    private String accountNumber;
    private String holder;
    private double balance;

    private static int totalAccounts = 0;

    public BankAccount(String accountNumber, String holder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.holder = holder;
        this.balance = initialBalance >= 0 ? initialBalance : 0;
        totalAccounts++;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + " to account " + accountNumber + ". New balance: $" + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew $" + amount + " from account " + accountNumber + ". New balance: $" + balance);
        } else if (amount > balance) {
            System.out.println("Withdrawal failed for account " + accountNumber + ". Insufficient funds.");
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    public void getStatement() {
        System.out.println("Account Statement:");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + holder);
        System.out.println("Current Balance: $" + balance);
        System.out.println("-------------------------");
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }
}
