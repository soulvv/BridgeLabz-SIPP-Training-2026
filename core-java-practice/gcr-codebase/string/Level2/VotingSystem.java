import java.util.Scanner;
public class VotingSystem {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        display(check(getAges(n)));
    }
    static int[] getAges(int n) {
        int[] a = new int[n];
        for(int i=0; i<n; i++) a[i] = (int)(Math.random() * 90) + 10;
        return a;
    }
    static String[][] check(int[] a) {
        String[][] res = new String[a.length][2];
        for(int i=0; i<a.length; i++) {
            res[i][0] = String.valueOf(a[i]);
            res[i][1] = String.valueOf(a[i] >= 18 && a[i] >= 0);
        }
        return res;
    }
    static void display(String[][] a) {
        for(String[] r : a) System.out.println(r[0] + "\t" + r[1]);
    }
}
