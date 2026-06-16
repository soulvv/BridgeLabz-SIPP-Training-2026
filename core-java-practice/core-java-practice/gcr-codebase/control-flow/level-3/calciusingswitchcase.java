import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double firstNumber = sc.nextDouble();

        System.out.print("Enter second number: ");
        double secondNumber = sc.nextDouble();

        System.out.print("Enter operator (+,-,*,/): ");
        char operator = sc.next().charAt(0);

        switch (operator) {

            case '+':
                System.out.println("Result = " + (firstNumber + secondNumber));
                break;

            case '-':
                System.out.println("Result = " + (firstNumber - secondNumber));
                break;

            case '*':
                System.out.println("Result = " + (firstNumber * secondNumber));
                break;

            case '/':
                if (secondNumber != 0) {
                    System.out.println("Result = " + (firstNumber / secondNumber));
                } else {
                    System.out.println("Division by zero not allowed");
                }
                break;

            default:
                System.out.println("Invalid Operator");
        }

        sc.close();
    }
}