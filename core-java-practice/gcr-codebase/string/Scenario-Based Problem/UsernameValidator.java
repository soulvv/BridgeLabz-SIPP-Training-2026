
import java.util.*;

public class UsernameValidator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = sc.nextLine();

        System.out.println("Total characters: " + username.length());

        if (username.contains(" ")) {
            System.out.println("Invalid username! Spaces are not allowed.");
        } else {
            System.out.println("No spaces found.");

            username = username.toUpperCase();
            System.out.println("Username in uppercase: " + username);

            String reversed = new StringBuilder(username).reverse().toString();

            if (username.equals(reversed)) {
                System.out.println("The username is a palindrome.");
            } else {
                System.out.println("The username is not a palindrome.");
            }

            System.out.println("Username accepted.");
        }

        sc.close();
    }
}
