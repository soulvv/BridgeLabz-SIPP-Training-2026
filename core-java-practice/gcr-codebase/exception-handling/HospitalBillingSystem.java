import java.util.Scanner;
public class HospitalBillingSystem {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            try {
                System.out.print("Enter number of items: ");
                int items = Integer.parseInt(sc.next());
                int c = 100 / items;
                System.out.println("Bill per person: " + c);
            } catch (ArithmeticException e) {
                System.out.println("Number of items cannot be zero");
            } catch (NumberFormatException e) {
                System.out.println("Bad input for items");
            }
            try {
                int[] p = {100, 200, 300, 400, 500};
                System.out.print("Enter patient index (0-4): ");
                int index = Integer.parseInt(sc.next());
                int x = p[index];
                System.out.println("Price at index " + index + ": " + x);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Index out of bounds");
            } catch (NumberFormatException e) {
                System.out.println("Bad input for index");
            }
            try {
                System.out.print("Enter payment amount: ");
                double payment = Double.parseDouble(sc.next());
                if (payment < 100.0) {
                    throw new InsufficientFundsException("Payment failed");
                }
                System.out.println("Payment successful");
            } catch (InsufficientFundsException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Bad input for payment");
            }
        }
    }
}
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String m) {
        super(m);
    }
}
