import java.util.Scanner;
public class UniqueChars {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char[] u = unique(s.nextLine());
        for(char c : u) System.out.print(c + " ");
    }
    static int len(String s) {
        int c=0; try{while(true){s.charAt(c);c++;}}catch(Exception e){return c;}
    }
    static char[] unique(String str) {
        int l = len(str); char[] t = new char[l]; int idx = 0;
        for(int i=0; i<l; i++) {
            boolean f = true;
            for(int j=0; j<idx; j++) if(str.charAt(i) == t[j]) f = false;
            if(f) t[idx++] = str.charAt(i);
        }
        char[] r = new char[idx];
        for(int i=0; i<idx; i++) r[i] = t[i];
        return r;
    }
}
