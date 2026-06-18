public class PasswordStrengthChecker {
    public static void main(String[] args) {
        PasswordStrengthChecker checker = new PasswordStrengthChecker();
        checker.checkPassword("");
        checker.checkPassword("Short1!");
        checker.checkPassword("Notspecial1");
        checker.checkPassword("lowercase@1");
        checker.checkPassword("NoDigit@x");
        checker.checkPassword(null);
        checker.checkPassword("Valid@Pass1");
    }

    public void checkPassword(String password) {
        try {
            if (password == null) {
                throw new IllegalArgumentException("Password cannot be null.");
            }
            if (password.isEmpty()) {
                throw new IllegalArgumentException("Password cannot be empty.");
            }
            if (password.length() < 8) {
                throw new IllegalArgumentException("Password must be at least 8 characters long.");
            }
            if (!Character.isUpperCase(password.charAt(0))) {
                throw new IllegalArgumentException("First character must be uppercase.");
            }
            if (!Character.isDigit(password.charAt(password.length() - 1))) {
                throw new IllegalArgumentException("Last character must be a digit.");
            }
            if (!password.matches(".*[@#\\$%&\\*].*")) {
                throw new IllegalArgumentException("Password must contain at least one special character (@, #, $, %, &, *).");
            }
            System.out.println("Password is valid.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }
}
