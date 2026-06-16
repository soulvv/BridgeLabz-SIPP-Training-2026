import java.util.Scanner;
public class CustomLower {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        System.out.println(compare(toLower(str), str.toLowerCase()));
    }
    static String toLower(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(c >= 'A' && c <= 'Z') c = (char)(c + 32);
            sb.append(c);
        }
        return sb.toString();
    }
    static boolean compare(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        for(int i=0; i<s1.length(); i++) if(s1.charAt(i) != s2.charAt(i)) return false;
        return true;
    }
}
