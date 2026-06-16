import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        int year = new Scanner(System.in).nextInt();
        System.out.println(isLeapYear(year) ? "Leap Year" : "Not a Leap Year");
    }

    static boolean isLeapYear(int year) {
        return year >= 1582 && (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
    }
}
