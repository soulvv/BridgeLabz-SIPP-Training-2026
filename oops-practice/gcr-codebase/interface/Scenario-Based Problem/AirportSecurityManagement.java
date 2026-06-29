interface LuggageScanner {

    boolean scanLuggage(String passengerName, double luggageWeightKg);

    default void displaySecurityGuidelines() {
        System.out.println("[LuggageScanner Guidelines]");
        System.out.println("  - Maximum carry-on weight: 7 kg");
        System.out.println("  - Maximum checked luggage weight: 23 kg");
        System.out.println("  - Prohibited items: sharp objects, flammables, liquids > 100ml");
        System.out.println("  - All luggage must pass X-ray screening");
    }
}

interface PassportVerifier {

    boolean verifyPassport(String passengerName, String passportNo);

    default void displaySecurityGuidelines() {
        System.out.println("[PassportVerifier Guidelines]");
        System.out.println("  - Passport must be valid for at least 6 months");
        System.out.println("  - Name on passport must match boarding pass");
        System.out.println("  - Visa requirements must be fulfilled for destination");
        System.out.println("  - Biometric verification may be required");
    }

    static boolean isPassportNumberValid(String passportNo) {
        if (passportNo == null || passportNo.length() != 8) {
            return false;
        }
        if (!Character.isUpperCase(passportNo.charAt(0))) {
            return false;
        }
        for (int i = 1; i < passportNo.length(); i++) {
            if (!Character.isDigit(passportNo.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}

class AirportSecuritySystem implements LuggageScanner, PassportVerifier {

    private static final double MAX_LUGGAGE_WEIGHT = 23.0;

    private String[] registeredPassports = {"A1234567", "B9876543", "C5551234", "D7778899", "E1112233"};

    @Override
    public boolean scanLuggage(String passengerName, double luggageWeightKg) {
        System.out.println("  [Luggage Scan] " + passengerName + " -> Weight: " + luggageWeightKg + " kg");

        if (luggageWeightKg > MAX_LUGGAGE_WEIGHT) {
            System.out.println("  [Luggage Scan] FAILED - Exceeds max weight of " + MAX_LUGGAGE_WEIGHT + " kg");
            return false;
        }
        if (luggageWeightKg <= 0) {
            System.out.println("  [Luggage Scan] FAILED - Invalid luggage weight");
            return false;
        }
        System.out.println("  [Luggage Scan] PASSED - Weight within limits");
        return true;
    }

    @Override
    public boolean verifyPassport(String passengerName, String passportNo) {
        System.out.println("  [Passport Check] " + passengerName + " -> Passport: " + passportNo);

        if (!PassportVerifier.isPassportNumberValid(passportNo)) {
            System.out.println("  [Passport Check] FAILED - Invalid passport format");
            return false;
        }
        System.out.println("  [Passport Check] Format valid");

        for (String registered : registeredPassports) {
            if (registered.equals(passportNo)) {
                System.out.println("  [Passport Check] PASSED - Passport verified");
                return true;
            }
        }
        System.out.println("  [Passport Check] FAILED - Passport not found in system");
        return false;
    }

    @Override
    public void displaySecurityGuidelines() {
        System.out.println("========== AIRPORT SECURITY GUIDELINES ==========\n");
        LuggageScanner.super.displaySecurityGuidelines();
        System.out.println();
        PassportVerifier.super.displaySecurityGuidelines();
        System.out.println("\n=================================================\n");
    }

    public void processPassengers(String[] names, String[] passportNos, double[] luggageWeights) {
        System.out.println("========== PASSENGER BOARDING CLEARANCE ==========\n");

        int cleared = 0, denied = 0;

        for (int i = 0; i < names.length; i++) {
            System.out.println("--- Passenger #" + (i + 1) + ": " + names[i] + " ---");

            boolean passportOk = verifyPassport(names[i], passportNos[i]);
            boolean luggageOk = scanLuggage(names[i], luggageWeights[i]);

            if (passportOk && luggageOk) {
                System.out.println("  >> BOARDING STATUS: CLEARED - Proceed to gate.\n");
                cleared++;
            } else {
                String reason = "";
                if (!passportOk && !luggageOk) reason = "Passport invalid + Luggage overweight";
                else if (!passportOk) reason = "Passport verification failed";
                else reason = "Luggage exceeds weight limit";

                System.out.println("  >> BOARDING STATUS: DENIED - " + reason + "\n");
                denied++;
            }
        }

        System.out.println("=============== BOARDING SUMMARY ===============");
        System.out.println("  Total Passengers : " + names.length);
        System.out.println("  Cleared to Board : " + cleared);
        System.out.println("  Denied Boarding  : " + denied);
        System.out.println("================================================\n");
    }
}

public class AirportSecurityManagement {
    public static void main(String[] args) {
        System.out.println("===== AIRPORT SECURITY MANAGEMENT SYSTEM =====\n");

        String[] passengerNames = {"Alice Johnson", "Bob Smith", "Charlie Lee", "Diana Patel", "Eve Martinez"};
        String[] passportNumbers = {"A1234567", "INVALID1", "C5551234", "D7778899", "X9999999"};
        double[] luggageWeights = {18.5, 15.0, 25.0, 20.0, 22.0};

        AirportSecuritySystem security = new AirportSecuritySystem();

        security.displaySecurityGuidelines();

        security.processPassengers(passengerNames, passportNumbers, luggageWeights);

        System.out.println("--- Static Method: isPassportNumberValid() ---");
        System.out.println("\"A1234567\"  -> " + PassportVerifier.isPassportNumberValid("A1234567"));
        System.out.println("\"INVALID1\"  -> " + PassportVerifier.isPassportNumberValid("INVALID1"));
        System.out.println("\"12345678\"  -> " + PassportVerifier.isPassportNumberValid("12345678"));
        System.out.println("\"AB123456\"  -> " + PassportVerifier.isPassportNumberValid("AB123456"));
        System.out.println("null        -> " + PassportVerifier.isPassportNumberValid(null));
    }
}
