import java.util.Arrays;
import java.util.Scanner;

public class NumberChecker {
    public static void main(String[] args) {
        int number = new Scanner(System.in).nextInt();
        int[] digits = storeDigits(number);
        System.out.println("Count: " + countDigits(number));
        System.out.println("Digits: " + Arrays.toString(digits));
        System.out.println("Duck: " + isDuck(digits));
        System.out.println("Armstrong: " + isArmstrong(number, digits));
        System.out.println("Largest 2: " + Arrays.toString(largestTwo(digits)));
        System.out.println("Smallest 2: " + Arrays.toString(smallestTwo(digits)));
        System.out.println("Sum: " + sumDigits(digits));
        System.out.println("Sum Squares: " + sumSquaresDigits(digits));
        System.out.println("Harshad: " + isHarshad(number, digits));
        System.out.println("Frequencies: " + Arrays.deepToString(digitFrequencies(digits)));
        System.out.println("Reversed: " + Arrays.toString(reverseArray(digits)));
        System.out.println("Palindrome: " + isPalindrome(digits));
        System.out.println("Prime: " + isPrime(number));
        System.out.println("Neon: " + isNeon(number));
        System.out.println("Spy: " + isSpy(digits));
        System.out.println("Automorphic: " + isAutomorphic(number));
        System.out.println("Buzz: " + isBuzz(number));
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

    static int sumDigits(int[] arr) {
        int sum = 0;
        for (int n : arr) sum += n;
        return sum;
    }

    static int sumSquaresDigits(int[] arr) {
        int sum = 0;
        for (int n : arr) sum += Math.pow(n, 2);
        return sum;
    }

    static boolean isHarshad(int n, int[] digits) {
        return n % sumDigits(digits) == 0;
    }

    static int[][] digitFrequencies(int[] digits) {
        int[] counts = new int[10];
        for (int x : digits) counts[x]++;
        int unique = 0;
        for (int c : counts) if (c > 0) unique++;
        int[][] res = new int[unique][2];
        for (int i = 0, j = 0; i < 10; i++) {
            if (counts[i] > 0) {
                res[j][0] = i;
                res[j++][1] = counts[i];
            }
        }
        return res;
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

    static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) if (n % i == 0) return false;
        return true;
    }

    static boolean isNeon(int n) {
        return sumDigits(storeDigits(n * n)) == n;
    }

    static boolean isSpy(int[] digits) {
        int prod = 1;
        for (int x : digits) prod *= x;
        return sumDigits(digits) == prod;
    }

    static boolean isAutomorphic(int n) {
        return String.valueOf((long) n * n).endsWith(String.valueOf(n));
    }

    static boolean isBuzz(int n) {
        return n % 7 == 0 || n % 10 == 7;
    }
}
