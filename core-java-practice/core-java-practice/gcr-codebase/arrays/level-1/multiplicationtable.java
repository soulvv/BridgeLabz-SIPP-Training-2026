import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int num = sc.nextInt();

        int[] table = new int[10];

        for(int i = 1; i <= 10; i++) {
            table[i - 1] = num * i;
        }

        System.out.println("\nMultiplication Table:");

        for(int i = 0; i < table.length; i++) {
            System.out.println(num + " x " + (i + 1) + " = " + table[i]);
        }

        sc.close();
    }
}