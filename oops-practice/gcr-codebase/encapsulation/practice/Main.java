
public class Main {

    public static void main(String[] args) {
        System.out.println("--- Creating Accounts ---");
        BankAccount acc1 = new BankAccount("A1001", "Alice Smith", 500.0);
        BankAccount acc2 = new BankAccount("A1002", "Bob Johnson", 1000.0);
        BankAccount acc3 = new BankAccount("A1003", "Charlie Brown", 200.0);

        System.out.println("Total Accounts Created: " + BankAccount.getTotalAccounts());
        System.out.println("-------------------------\n");

        // Transactions for Account 1 (5 transactions)
        System.out.println("--- Transactions for Alice ---");
        acc1.deposit(200.0);
        acc1.withdraw(100.0);
        acc1.withdraw(800.0); // Should fail due to insufficient funds
        acc1.deposit(50.0);
        acc1.withdraw(250.0);
        acc1.getStatement();

        // Transactions for Account 2 (5 transactions)
        System.out.println("--- Transactions for Bob ---");
        acc2.withdraw(200.0);
        acc2.withdraw(300.0);
        acc2.deposit(100.0);
        acc2.withdraw(500.0);
        acc2.deposit(400.0);
        acc2.getStatement();

        // Transactions for Account 3 (5 transactions)
        System.out.println("--- Transactions for Charlie ---");
        acc3.deposit(500.0);
        acc3.deposit(300.0);
        acc3.withdraw(1000.0);
        acc3.withdraw(50.0);
        acc3.deposit(100.0);
        acc3.getStatement();
    }
}
