import java.util.Scanner;
public class FirstNonRepeating {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(first(s.nextLine()));
    }
    static char first(String s) {
        int[] f = new int[256];
        for(int i=0; i<s.length(); i++) f[s.charAt(i)]++;
        for(int i=0; i<s.length(); i++) if(f[s.charAt(i)] == 1) return s.charAt(i);
        return 0;
    }
}
