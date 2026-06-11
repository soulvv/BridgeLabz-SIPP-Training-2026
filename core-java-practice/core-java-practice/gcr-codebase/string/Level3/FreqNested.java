import java.util.Scanner;
public class FreqNested {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] f = freq(s.nextLine());
        for(String r : f) System.out.println(r);
    }
    static String[] freq(String s) {
        char[] c = s.toCharArray();
        int[] f = new int[c.length];
        for(int i=0; i<c.length; i++) {
            f[i] = 1;
            for(int j=i+1; j<c.length; j++) {
                if(c[i] == c[j]) {
                    f[i]++;
                    c[j] = '0';
                }
            }
        }
        int cnt = 0;
        for(int i=0; i<c.length; i++) if(c[i] != '0') cnt++;
        String[] r = new String[cnt];
        int idx = 0;
        for(int i=0; i<c.length; i++) if(c[i] != '0') r[idx++] = c[i] + " : " + f[i];
        return r;
    }
}
