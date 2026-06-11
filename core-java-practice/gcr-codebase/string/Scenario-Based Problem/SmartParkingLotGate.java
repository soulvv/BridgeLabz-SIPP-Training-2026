import java.util.Scanner;

/**
 * Scenario 3: Parking Lot Gate System
 * This program simulates a smart parking lot with a menu-driven interface.
 * 
 * Concepts Demonstrated:
 * - Variables, Primitive Data Types
 * - Basic I/O (Scanner)
 * - Conditional Logic (switch, if-else)
 * - Loops (do-while)
 * - Clean code practices
 */
public class SmartParkingLotGate {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        final int LOT_CAPACITY = 10;
        int currentOccupancy = 0;
        int choice;

        System.out.println("🚗 Welcome to the Smart Parking Lot Gate System 🚗");

        // do-while loop to show menu until the user explicitly exits
        do {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. Park a Car");
            System.out.println("2. Exit a Car");
            System.out.println("3. Show Occupancy");
            System.out.println("4. Exit System");
            System.out.print("Choose an option (1-4): ");
            
            choice = scanner.nextInt();

            // Switch statement for menu operations
            switch (choice) {
                case 1:
                    if (currentOccupancy >= LOT_CAPACITY) {
                        System.out.println("[Status] Sorry, the parking lot is FULL! Cannot park.");
                    } else {
                        currentOccupancy++;
                        System.out.println("[Status] Car parked successfully.");
                    }
                    break;
                    
                case 2:
                    if (currentOccupancy <= 0) {
                        System.out.println("[Status] The parking lot is already EMPTY! Cannot exit.");
                    } else {
                        currentOccupancy--;
                        System.out.println("[Status] Car exited successfully.");
                    }
                    break;
                    
                case 3:
                    System.out.println("[Status] Current Occupancy: " + currentOccupancy + " / " + LOT_CAPACITY);
                    System.out.println("Available Slots: " + (LOT_CAPACITY - currentOccupancy));
                    break;
                    
                case 4:
                    System.out.println("Exiting the Smart Parking Lot Gate System. Goodbye!");
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please select a valid option from the menu.");
                    break;
            }

            // Additional logic to warn if parking is full after an operation
            if (currentOccupancy == LOT_CAPACITY && choice != 4) {
                System.out.println("⚠️ Warning: The parking lot has reached its maximum capacity!");
            }

        } while (choice != 4);

        scanner.close();
    }
}
