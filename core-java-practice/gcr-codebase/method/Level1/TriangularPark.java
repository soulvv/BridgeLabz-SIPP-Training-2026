import java.util.Scanner;

public class TriangularPark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(calculateRounds(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble()));
    }

    static int calculateRounds(double side1, double side2, double side3) {
        return (int) Math.ceil(5000 / (side1 + side2 + side3));
    }
}
