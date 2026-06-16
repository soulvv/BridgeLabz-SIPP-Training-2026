import java.util.Scanner;

public class NumberCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(check(scanner.nextInt()));
    }

    static int check(int number) {
        return Integer.compare(number, 0);
    }
}
