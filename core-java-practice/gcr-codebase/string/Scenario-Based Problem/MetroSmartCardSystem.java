import java.util.Scanner;

/**
 * Scenario 1: Metro Smart Card Fare Deduction
 * This program simulates a smart card fare deduction system for a Metro.
 * 
 * Concepts Demonstrated:
 * - Variables, Literals, Primitive Data Types (double, boolean)
 * - Basic I/O (Scanner)
 * - Operators (arithmetic, relational, assignment)
 * - Conditional Logic (if, else, ternary operator)
 * - Loops (while)
 * - Control flow (break, continue)
 * - Clean code practices (naming, comments, indentation)
 */
public class MetroSmartCardSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Variables, Literals, Primitive Data Types
        double cardBalance = 200.0; // Initial balance in rupees
        final double MINIMUM_FARE = 10.0;
        final double PER_KM_RATE = 2.0;

        System.out.println("🚇 Welcome to the Delhi Metro Smart Card System 🚇");
        System.out.println("Initial Card Balance: ₹" + cardBalance);

        // while loop to continue operations until balance is exhausted
        while (cardBalance > 0) {
            System.out.print("\nEnter travel distance in km (or enter -1 to quit): ");
            double distance = scanner.nextDouble();

            // Control flow - break to exit loop entirely
            if (distance == -1) {
                System.out.println("Exiting the system. Thank you for traveling with us!");
                break;
            }

            // Control flow - continue to skip the rest of the loop for invalid input
            if (distance < 0) {
                System.out.println("Error: Distance cannot be negative. Please try again.");
                continue;
            }

            // Conditional Logic (Ternary Operator)
            // Flat rate for first 5km, extra charge for beyond 5km
            double fare = (distance <= 5.0) ? MINIMUM_FARE : MINIMUM_FARE + ((distance - 5.0) * PER_KM_RATE);

            // Conditional Logic (if-else)
            if (fare > cardBalance) {
                System.out.println("Insufficient balance! Your fare is ₹" + fare + " but balance is ₹" + cardBalance);
                System.out.println("Please recharge your card to make this journey.");
            } else {
                // Deduct fare and update balance
                cardBalance -= fare;
                System.out.println("Journey completed successfully!");
                System.out.println("Fare Deducted: ₹" + fare);
                System.out.println("Remaining Balance: ₹" + cardBalance);
            }
        }

        if (cardBalance <= 0) {
            System.out.println("\nYour smart card balance is fully exhausted. Please recharge!");
        }

        scanner.close();
    }
}
