import java.util.Scanner;
public class PalindromeCheck {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        System.out.println(l1(str) + " " + l2(str, 0, str.length()-1) + " " + l3(str));
    }
    static boolean l1(String s) {
        for(int i=0, j=s.length()-1; i<j; i++, j--) if(s.charAt(i) != s.charAt(j)) return false;
        return true;
    }
    static boolean l2(String s, int i, int j) {
        if(i >= j) return true;
        if(s.charAt(i) != s.charAt(j)) return false;
        return l2(s, i+1, j-1);
    }
    static boolean l3(String s) {
        char[] c = s.toCharArray(), r = rev(s);
        for(int i=0; i<c.length; i++) if(c[i] != r[i]) return false;
        return true;
    }
    static char[] rev(String s) {
        char[] r = new char[s.length()];
        for(int i=0; i<s.length(); i++) r[i] = s.charAt(s.length()-1-i);
        return r;
    }
}
