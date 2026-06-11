import java.util.Scanner;
public class CalendarDisplay {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        disp(s.nextInt(), s.nextInt());
    }
    static String mName(int m) {
        String[] n = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return n[m];
    }
    static boolean isLeap(int y) {
        return y % 4 == 0 && (y % 100 != 0 || y % 400 == 0);
    }
    static int days(int m, int y) {
        int[] d = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(m == 2 && isLeap(y)) return 29;
        return d[m];
    }
    static int first(int m, int y) {
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0/4 - y0/100 + y0/400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        return (1 + x + 31 * m0 / 12) % 7;
    }
    static void disp(int m, int y) {
        System.out.println(mName(m) + " " + y);
        System.out.println(" S  M  T  W  T  F  S");
        int f = first(m, y), d = days(m, y);
        for(int i=0; i<f; i++) System.out.print("   ");
        for(int i=1; i<=d; i++) {
            System.out.printf("%2d ", i);
            if((i + f) % 7 == 0) System.out.println();
        }
    }
}
