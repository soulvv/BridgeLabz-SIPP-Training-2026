import java.util.Scanner;
public class CustomSplit {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        String[] w1 = split(str), w2 = str.split(" ");
        System.out.println(compare(w1, w2));
    }
    static int len(String s) {
        int c=0; try{while(true){s.charAt(c);c++;}}catch(Exception e){return c;}
    }
    static String[] split(String str) {
        int l = len(str), c = 1;
        for(int i=0; i<l; i++) if(str.charAt(i) == ' ') c++;
        int[] sp = new int[c+1];
        sp[0] = -1;
        int idx = 1;
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
    static boolean compare(String[] a, String[] b) {
        if(a.length != b.length) return false;
        for(int i=0; i<a.length; i++) if(!a[i].equals(b[i])) return false;
        return true;
    }
}
