public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(123, 0));
    }

    static int reverse(int n, int rev) {
        if (n == 0) return rev;
        if (rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10) return 0;
        return reverse(n / 10, rev * 10 + n % 10);
    }
}
