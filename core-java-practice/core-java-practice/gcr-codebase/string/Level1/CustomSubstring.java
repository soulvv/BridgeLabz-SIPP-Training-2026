import java.util.Scanner;
public class CustomSubstring {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        int st = s.nextInt(), en = s.nextInt();
        String sub1 = sub(str, st, en), sub2 = str.substring(st, en);
        System.out.println(compare(sub1, sub2));
    }
    static String sub(String str, int st, int en) {
        StringBuilder sb = new StringBuilder();
        for(int i=st; i<en; i++) sb.append(str.charAt(i));
        return sb.toString();
    }
    static boolean compare(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        for(int i=0; i<s1.length(); i++) if(s1.charAt(i) != s2.charAt(i)) return false;
        return true;
    }
}
