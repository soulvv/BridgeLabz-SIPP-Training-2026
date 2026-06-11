
import java.util.Arrays;
import java.util.Scanner;

/**
 * Scenario: Spy Agency Message Encoding & Surveillance
 *
 * This program performs various string operations required by a spy agency: 1.
 * Reversing a secret message 2. Checking if it is a palindrome 3. Counting
 * vowels and consonants 4. Verifying if two intercepts are anagrams 5. Finding
 * the first non-repeating character in a surveillance log
 */
public class SpyMessageAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🕵️ Welcome to the Spy Agency Message Analyzer 🕵️\n");

        // --- Core Message Analysis ---
        System.out.print("Enter a secret message to analyze: ");
        String message = scanner.nextLine();

        // 1. Reverse the secret message
        String reversedMessage = reverseString(message);
        System.out.println("\n[1] Reversed Message: " + reversedMessage);

        // 2. Check if it is a palindrome
        boolean isPalindrome = checkPalindrome(message);
        System.out.println("[2] Is Palindrome? " + (isPalindrome ? "Yes" : "No"));

        // 3. Count vowels and consonants
        countVowelsAndConsonants(message);

        // --- Anagram Checking ---
        System.out.println("\n--- Intercept Verification ---");
        System.out.print("Enter first intercept: ");
        String intercept1 = scanner.nextLine();
        System.out.print("Enter second intercept: ");
        String intercept2 = scanner.nextLine();

        // 4. Verify if two intercepts are anagrams
        boolean isAnagram = checkAnagram(intercept1, intercept2);
        System.out.println("[4] Are Intercepts Anagrams? " + (isAnagram ? "Match Confirmed (Yes)" : "No Match (No)"));

        // --- Surveillance Log Analysis ---
        System.out.println("\n--- Surveillance Log Analysis ---");
        System.out.print("Enter surveillance log: ");
        String log = scanner.nextLine();

        // 5. Find the first non-repeating character
        char nonRepeatingChar = findFirstNonRepeatingCharacter(log);
        if (nonRepeatingChar != '\0') {
            System.out.println("[5] First non-repeating character found: '" + nonRepeatingChar + "'");
        } else {
            System.out.println("[5] No non-repeating character found in the log (all characters repeat).");
        }

        System.out.println("\n🕵️ Analysis Complete 🕵️");
        scanner.close();
    }

    /**
     * Method to reverse a string.
     */
    public static String reverseString(String str) {
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }

    /**
     * Method to check if a string is a palindrome. Ignores spaces and case
     * sensitivity for accurate checks.
     */
    public static boolean checkPalindrome(String str) {
        // Clean the string: remove spaces and make lowercase
        String cleanStr = str.replaceAll("\\s+", "").toLowerCase();

        // A palindrome is a string that reads the same forwards and backwards
        int left = 0;
        int right = cleanStr.length() - 1;

        while (left < right) {
            if (cleanStr.charAt(left) != cleanStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Method to count and display vowels and consonants in a string.
     */
    public static void countVowelsAndConsonants(String str) {
        int vowels = 0;
        int consonants = 0;
        String lowerStr = str.toLowerCase();

        for (int i = 0; i < lowerStr.length(); i++) {
            char ch = lowerStr.charAt(i);

            // Check if the character is an alphabet letter
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("[3] Total Vowels: " + vowels);
        System.out.println("[3] Total Consonants: " + consonants);
    }

    /**
     * Method to check if two strings are anagrams of each other. Ignores spaces
     * and case sensitivity.
     */
    public static boolean checkAnagram(String str1, String str2) {
        // Clean both strings
        String cleanStr1 = str1.replaceAll("\\s+", "").toLowerCase();
        String cleanStr2 = str2.replaceAll("\\s+", "").toLowerCase();

        // If lengths are different after cleaning, they can't be anagrams
        if (cleanStr1.length() != cleanStr2.length()) {
            return false;
        }

        // Convert to character arrays and sort them
        char[] charArray1 = cleanStr1.toCharArray();
        char[] charArray2 = cleanStr2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        // Compare the sorted arrays
        return Arrays.equals(charArray1, charArray2);
    }

    /**
     * Method to find the first non-repeating character in a string. Returns the
     * null character '\0' if no non-repeating character is found.
     */
    public static char findFirstNonRepeatingCharacter(String str) {
        // Loop through the string and check character occurrence
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // If we skip checking spaces, uncomment the following lines:
            // if (ch == ' ') continue;
            // If the first occurrence index matches the last occurrence index,
            // it means the character appears only once in the string.
            if (str.indexOf(ch) == str.lastIndexOf(ch)) {
                return ch;
            }
        }
        return '\0'; // Return null character if all characters repeat
    }
}
