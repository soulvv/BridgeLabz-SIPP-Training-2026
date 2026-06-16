import java.util.Scanner;
public class ShortestLongest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] w = split(s.nextLine());
        int[] res = find(get2D(w));
        System.out.println("Shortest: " + w[res[0]] + ", Longest: " + w[res[1]]);
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
    static int[] find(String[][] w) {
        int min = 0, max = 0;
        for(int i=1; i<w.length; i++) {
            int l = Integer.parseInt(w[i][1]);
            if(l < Integer.parseInt(w[min][1])) min = i;
            if(l > Integer.parseInt(w[max][1])) max = i;
        }
        return new int[]{min, max};
    }
}
