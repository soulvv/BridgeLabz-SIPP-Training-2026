import java.util.Scanner;
public class CharFrequency {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[][] f = freq(s.nextLine());
        for(String[] r : f) System.out.println(r[0] + " : " + r[1]);
    }
    static String[][] freq(String s) {
        int[] f = new int[256];
        for(int i=0; i<s.length(); i++) f[s.charAt(i)]++;
        int c = 0;
        for(int i=0; i<256; i++) if(f[i] > 0) c++;
        String[][] r = new String[c][2];
        int idx = 0;
        for(int i=0; i<256; i++) if(f[i] > 0) {
            r[idx][0] = String.valueOf((char)i);
            r[idx++][1] = String.valueOf(f[i]);
        }
        return r;
    }
}
