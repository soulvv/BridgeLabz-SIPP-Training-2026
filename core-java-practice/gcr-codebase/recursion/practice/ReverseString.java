import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverse(new Scanner(System.in).next()));
    }

    static String reverse(String s) {
        return s.isEmpty() ? "" : reverse(s.substring(1)) + s.charAt(0);
    }
}
