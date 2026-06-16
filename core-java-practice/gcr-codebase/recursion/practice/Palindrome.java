import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(new Scanner(System.in).next()) ? "Palindrome" : "Not Palindrome");
    }

    static boolean isPalindrome(String s) {
        return s.length() <= 1 || (s.charAt(0) == s.charAt(s.length() - 1) && isPalindrome(s.substring(1, s.length() - 1)));
    }
}
