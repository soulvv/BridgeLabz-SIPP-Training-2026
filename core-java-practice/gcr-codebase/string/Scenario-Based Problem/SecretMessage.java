
import java.util.*;

public class SecretMessage {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a secret message: ");
        String msg = sc.nextLine();
        int vowels = 0;
        int consonants = 0;
        int digits = 0;
        int specialChars = 0;
        for (int i = 0; i < msg.length(); i++) {
            char ch = msg.charAt(i);
            if (Character.isLetter(ch)) {
                char lowerCh = Character.toLowerCase(ch);
                if (lowerCh == 'a' || lowerCh == 'e' || lowerCh == 'i' || lowerCh == 'o' || lowerCh == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            } else if (Character.isDigit(ch)) {
                digits++;
            } else if (!Character.isWhitespace(ch)) {
                specialChars++;
            }
        }
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        System.out.println("Digits: " + digits);
        System.out.println("Special Characters: " + specialChars);
        if (msg.length() >= 8 && digits >= 2 && specialChars >= 1) {
            System.out.println("Code Status: Strong");
        } else {
            System.out.println("Code Status: Weak");
        }
        sc.close();
    }
}
