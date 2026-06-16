import java.util.Scanner;
public class Split2D {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[][] res = get2D(split(s.nextLine()));
        for(String[] r : res) System.out.println(r[0] + "\t" + Integer.parseInt(r[1]));
    }
    static int len(String s) {
        int c=0; try{while(true){s.charAt(c);c++;}}catch(Exception e){return c;}
    }
    static String[] split(String str) {
        int l = len(str), c = 1;
        for(int i=0; i<l; i++) if(str.charAt(i) == ' ') c++;
        int[] sp = new int[c+1];
        sp[0] = -1; int idx = 1;
        for(int i=0; i<l; i++) if(str.charAt(i) == ' ') sp[idx++] = i;
        sp[c] = l;
        String[] res = new String[c];
        for(int i=0; i<c; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=sp[i]+1; j<sp[i+1]; j++) sb.append(str.charAt(j));
            res[i] = sb.toString();
        }
        return res;
    }
    static String[][] get2D(String[] w) {
        String[][] res = new String[w.length][2];
        for(int i=0; i<w.length; i++) {
            res[i][0] = w[i];
            res[i][1] = String.valueOf(len(w[i]));
        }
        return res;
    }
}
