public class AddDigits {
    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }

    static int addDigits(int num) {
        return num < 10 ? num : addDigits(sum(num));
    }

    static int sum(int n) {
        return n == 0 ? 0 : n % 10 + sum(n / 10);
    }
}
