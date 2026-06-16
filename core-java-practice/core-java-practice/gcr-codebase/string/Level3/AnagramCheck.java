import java.util.Scanner;
public class AnagramCheck {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(check(s.next(), s.next()));
    }
    static boolean check(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        int[] f1 = new int[256], f2 = new int[256];
        for(int i=0; i<s1.length(); i++) {
            f1[s1.charAt(i)]++;
            f2[s2.charAt(i)]++;
        }
        for(int i=0; i<256; i++) if(f1[i] != f2[i]) return false;
        return true;
    }
}
