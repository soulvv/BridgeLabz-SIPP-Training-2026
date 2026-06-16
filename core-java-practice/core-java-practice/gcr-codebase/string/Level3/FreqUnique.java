import java.util.Scanner;
public class FreqUnique {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[][] f = freq(s.nextLine());
        for(String[] r : f) System.out.println(r[0] + " : " + r[1]);
    }
    static char[] unique(String str) {
        char[] t = new char[str.length()]; int idx = 0;
        for(int i=0; i<str.length(); i++) {
            boolean f = true;
            for(int j=0; j<idx; j++) if(str.charAt(i) == t[j]) f = false;
            if(f) t[idx++] = str.charAt(i);
        }
        char[] r = new char[idx];
        for(int i=0; i<idx; i++) r[i] = t[i];
        return r;
    }
    static String[][] freq(String s) {
        int[] f = new int[256];
        for(int i=0; i<s.length(); i++) f[s.charAt(i)]++;
        char[] u = unique(s);
        String[][] r = new String[u.length][2];
        for(int i=0; i<u.length; i++) {
            r[i][0] = String.valueOf(u[i]);
            r[i][1] = String.valueOf(f[u[i]]);
        }
        return r;
    }
}
