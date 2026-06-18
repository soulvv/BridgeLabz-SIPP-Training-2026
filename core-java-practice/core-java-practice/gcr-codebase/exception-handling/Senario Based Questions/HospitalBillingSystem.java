
class InsufficientFundsException extends Exception {

    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class HospitalBillingSystem {

    public static void main(String[] args) {
        processBilling("1000", 0, 5, 4000);
        processBilling("abc", 5, 5, 4000);
        processBilling("1000", 5, 10, 4000);
        processBilling("5000", 5, 2, 4000);
    }

    public static void processBilling(String costPerItemStr, int numberOfItems, int patientIndex, double availableFunds) {
        String[] patients = {"A", "B", "C", "D"};
        try {
            int costPerItem = Integer.parseInt(costPerItemStr);
            if (numberOfItems == 0) {
                int error = costPerItem / numberOfItems;
            }
            String patient = patients[patientIndex];
            double totalCost = costPerItem * numberOfItems;
            if (totalCost > availableFunds) {
                throw new InsufficientFundsException("Payment failed: Insufficient funds for patient " + patient);
            }
            System.out.println("Billing successful for " + patient);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot process bill with zero items.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid patient index.");
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format for cost.");
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
