import java.util.Scanner;
public class CharArrayCompare {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        System.out.println(compare(getChars(str), str.toCharArray()));
    }
    static char[] getChars(String str) {
        char[] arr = new char[str.length()];
        for(int i=0; i<str.length(); i++) arr[i] = str.charAt(i);
        return arr;
    }
    static boolean compare(char[] a1, char[] a2) {
        if(a1.length != a2.length) return false;
        for(int i=0; i<a1.length; i++) if(a1[i] != a2[i]) return false;
        return true;
    }
}
