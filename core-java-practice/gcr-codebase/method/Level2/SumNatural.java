import java.util.Scanner;

public class SumNatural {
    public static void main(String[] args) {
        int number = new Scanner(System.in).nextInt();
        if (number > 0) {
            int recursive = recursiveSum(number);
            int formula = formulaSum(number);
            System.out.println("Recursive: " + recursive + ", Formula: " + formula + ", Match: " + (recursive == formula));
        } else {
            System.out.println("Not a natural number");
        }
    }

    static int recursiveSum(int n) {
        return n == 1 ? 1 : n + recursiveSum(n - 1);
    }

    static int formulaSum(int n) {
        return n * (n + 1) / 2;
    }
}
