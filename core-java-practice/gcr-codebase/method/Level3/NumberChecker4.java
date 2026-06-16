import java.util.Arrays;
import java.util.Scanner;

public class NumberChecker4 {
    public static void main(String[] args) {
        int number = new Scanner(System.in).nextInt();
        int[] digits = storeDigits(number);
        System.out.println("Count: " + countDigits(number));
        System.out.println("Digits: " + Arrays.toString(digits));
        System.out.println("Reversed: " + Arrays.toString(reverseArray(digits)));
        System.out.println("Palindrome: " + isPalindrome(digits));
        System.out.println("Duck: " + isDuck(digits));
    }

    static int countDigits(int n) {
        return String.valueOf(n).length();
    }

    static int[] storeDigits(int n) {
        String s = String.valueOf(n);
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) arr[i] = s.charAt(i) - '0';
        return arr;
    }

    static int[] reverseArray(int[] arr) {
        int[] rev = new int[arr.length];
        for (int i = 0; i < arr.length; i++) rev[i] = arr[arr.length - 1 - i];
        return rev;
    }

    static boolean arraysEqual(int[] a, int[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) if (a[i] != b[i]) return false;
        return true;
    }

    static boolean isPalindrome(int[] digits) {
        return arraysEqual(digits, reverseArray(digits));
    }

    static boolean isDuck(int[] digits) {
        for (int x : digits) if (x == 0) return true;
        return false;
    }
}
