class InsufficientBalanceException extends Exception {
    private double currentBalance;
    private double withdrawalAmount;

    public InsufficientBalanceException(String message, double currentBalance, double withdrawalAmount) {
        super(message);
        this.currentBalance = currentBalance;
        this.withdrawalAmount = withdrawalAmount;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public double getWithdrawalAmount() {
        return withdrawalAmount;
    }
}

public class ATMWithdrawalSystem {
    public static void main(String[] args) {
        double accountBalance = 5000.0;
        double withdrawalRequest = 8000.0;
        try {
            withdraw(accountBalance, withdrawalRequest);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
            System.out.println("Current Balance: " + e.getCurrentBalance());
            System.out.println("Requested Amount: " + e.getWithdrawalAmount());
        }
    }

    public static void withdraw(double balance, double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Withdrawal failed: Insufficient balance.", balance, amount);
        }
        System.out.println("Withdrawal successful.");
    }
}
