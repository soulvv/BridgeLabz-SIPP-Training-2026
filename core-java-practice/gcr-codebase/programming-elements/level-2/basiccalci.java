import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double number1 = sc.nextDouble();

        System.out.print("Enter second number: ");
        double number2 = sc.nextDouble();

        double addition = number1 + number2;
        double subtraction = number1 - number2;
        double multiplication = number1 * number2;
        double division = number1 / number2;

        System.out.println("Addition       = " + addition);
        System.out.println("Subtraction    = " + subtraction);
        System.out.println("Multiplication = " + multiplication);
        System.out.println("Division       = " + division);

        sc.close();
    }
}