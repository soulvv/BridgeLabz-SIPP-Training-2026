public class MathWizard {
    int value = 10;

    void demonstrateScope() {
        int value = 20;
        System.out.println("Local value: " + value);
        System.out.println("Instance value: " + this.value);
    }

    static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) if (n % i == 0) return false;
        return true;
    }

    static long factorial(int n) {
        long f = 1;
        for (int i = 1; i <= n; i++) f *= i;
        return f;
    }

    static double factorial(double n) {
        double f = 1;
        for (int i = 1; i <= n; i++) f *= i;
        return f;
    }

    static int fibonacci(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    static double power(double base, double exp) {
        return Math.pow(base, exp);
    }

    public static void main(String[] args) {
        new MathWizard().demonstrateScope();
        System.out.println("Prime: " + isPrime(7));
        System.out.println("Factorial (int): " + factorial(5));
        System.out.println("Factorial (double): " + factorial(5.5));
        System.out.println("Fibonacci: " + fibonacci(6));
        System.out.println("GCD: " + gcd(12, 18));
        System.out.println("LCM: " + lcm(12, 18));
        System.out.println("Power: " + power(2, 3));
    }
}
