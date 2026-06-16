import java.util.Arrays;
import java.util.Scanner;

public class NumberChecker3 {
    public static void main(String[] args) {
        int number = new Scanner(System.in).nextInt();
        int[] digits = storeDigits(number);
        System.out.println("Count: " + countDigits(number));
        System.out.println("Digits: " + Arrays.toString(digits));
        System.out.println("Sum: " + sumDigits(digits));
        System.out.println("Sum Squares: " + sumSquaresDigits(digits));
        System.out.println("Harshad: " + isHarshad(number, digits));
        System.out.println("Frequencies: " + Arrays.deepToString(digitFrequencies(digits)));
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
}
