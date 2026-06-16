import java.util.Scanner;

public class SimpleInterest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double principal = scanner.nextDouble();
        double rate = scanner.nextDouble();
        double time = scanner.nextDouble();
        System.out.printf("The Simple Interest is %f for Principal %f, Rate of Interest %f and Time %f\n", 
            calculate(principal, rate, time), principal, rate, time);
    }

    static double calculate(double principal, double rate, double time) {
        return (principal * rate * time) / 100;
    }
}
