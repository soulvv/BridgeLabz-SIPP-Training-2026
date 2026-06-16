import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(new Scanner(System.in).nextInt()));
    }

    static int factorial(int n) {
        return n <= 1 ? 1 : n * factorial(n - 1);
    }
}
