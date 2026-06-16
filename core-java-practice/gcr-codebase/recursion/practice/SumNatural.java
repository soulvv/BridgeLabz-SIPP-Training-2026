import java.util.Scanner;

public class SumNatural {
    public static void main(String[] args) {
        System.out.println(sum(new Scanner(System.in).nextInt()));
    }

    static int sum(int n) {
        return n <= 0 ? 0 : n + sum(n - 1);
    }
}
