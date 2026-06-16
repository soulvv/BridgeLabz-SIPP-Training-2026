import java.util.Scanner;
public class CustomTrim {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int[] t = trimRange(str);
        String res = sub(str, t[0], t[1]);
        System.out.println(compare(res, str.trim()));
    }
    static int[] trimRange(String s) {
        int st = 0, en = s.length() - 1;
        while(st <= en && s.charAt(st) == ' ') st++;
        while(en >= st && s.charAt(en) == ' ') en--;
        return new int[]{st, en + 1};
    }
    static String sub(String s, int st, int en) {
        StringBuilder sb = new StringBuilder();
        for(int i=st; i<en; i++) sb.append(s.charAt(i));
        return sb.toString();
    }
    static boolean compare(String a, String b) {
        if(a.length() != b.length()) return false;
        for(int i=0; i<a.length(); i++) if(a.charAt(i) != b.charAt(i)) return false;
        return true;
    }
}
