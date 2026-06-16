import java.util.Scanner;

public class NumberChecker5 {
    public static void main(String[] args) {
        int number = new Scanner(System.in).nextInt();
        System.out.println("Prime: " + isPrime(number));
        System.out.println("Neon: " + isNeon(number));
        System.out.println("Spy: " + isSpy(number));
        System.out.println("Automorphic: " + isAutomorphic(number));
        System.out.println("Buzz: " + isBuzz(number));
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

    static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) if (n % i == 0) return false;
        return true;
    }

    static boolean isNeon(int n) {
        return sumDigits(storeDigits(n * n)) == n;
    }

    static boolean isSpy(int n) {
        int[] d = storeDigits(n);
        int prod = 1;
        for (int x : d) prod *= x;
        return sumDigits(d) == prod;
    }

    static boolean isAutomorphic(int n) {
        return String.valueOf((long) n * n).endsWith(String.valueOf(n));
    }

    static boolean isBuzz(int n) {
        return n % 7 == 0 || n % 10 == 7;
    }
}
