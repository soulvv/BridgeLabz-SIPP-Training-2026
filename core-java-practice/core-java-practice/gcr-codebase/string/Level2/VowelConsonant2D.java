import java.util.Scanner;
public class VowelConsonant2D {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        display(get(s.next()));
    }
    static String type(char c) {
        if(c>='A' && c<='Z') c=(char)(c+32);
        if(c>='a' && c<='z') {
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u') return "Vowel";
            return "Consonant";
        }
        return "Not a Letter";
    }
    static String[][] get(String s) {
        String[][] res = new String[s.length()][2];
        for(int i=0; i<s.length(); i++) {
            res[i][0] = String.valueOf(s.charAt(i));
            res[i][1] = type(s.charAt(i));
        }
        return res;
    }
    static void display(String[][] a) {
        for(String[] r : a) System.out.println(r[0] + "\t" + r[1]);
    }
}
