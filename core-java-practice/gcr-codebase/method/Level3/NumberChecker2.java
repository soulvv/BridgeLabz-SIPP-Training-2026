import java.util.Arrays;
import java.util.Scanner;

public class NumberChecker2 {
    public static void main(String[] args) {
        int number = new Scanner(System.in).nextInt();
        int[] digits = storeDigits(number);
        System.out.println("Count: " + countDigits(number));
        System.out.println("Digits: " + Arrays.toString(digits));
        System.out.println("Duck: " + isDuck(digits));
        System.out.println("Armstrong: " + isArmstrong(number, digits));
        System.out.println("Largest 2: " + Arrays.toString(largestTwo(digits)));
        System.out.println("Smallest 2: " + Arrays.toString(smallestTwo(digits)));
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

    static boolean isDuck(int[] digits) {
        for (int x : digits) if (x == 0) return true;
        return false;
    }

    static boolean isArmstrong(int n, int[] digits) {
        int sum = 0;
        for (int x : digits) sum += Math.pow(x, digits.length);
        return sum == n;
    }

    static int[] largestTwo(int[] arr) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        for (int n : arr) {
            if (n > max1) { max2 = max1; max1 = n; }
            else if (n > max2 && n != max1) max2 = n;
        }
        return new int[]{max1, max2};
    }

    static int[] smallestTwo(int[] arr) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int n : arr) {
            if (n < min1) { min2 = min1; min1 = n; }
            else if (n < min2 && n != min1) min2 = n;
        }
        return new int[]{min1, min2};
    }
}
