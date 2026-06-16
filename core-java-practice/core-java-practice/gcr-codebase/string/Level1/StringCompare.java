import java.util.Scanner;
public class StringCompare {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String s1 = s.next(), s2 = s.next();
        System.out.println(compare(s1, s2) == s1.equals(s2));
    }
    static boolean compare(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        for(int i=0; i<s1.length(); i++) if(s1.charAt(i) != s2.charAt(i)) return false;
        return true;
    }
}
