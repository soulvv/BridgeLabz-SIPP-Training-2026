import java.util.Scanner;

public class SquareSide {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter perimeter of square: ");
        double perimeter = sc.nextDouble();

        double side = perimeter / 4;

        System.out.println("Length of side = " + side);
        System.out.println("Perimeter = " + perimeter);

        sc.close();
    }
}