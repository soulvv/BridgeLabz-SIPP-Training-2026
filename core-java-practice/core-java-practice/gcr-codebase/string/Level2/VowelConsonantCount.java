import java.util.Scanner;
public class VowelConsonantCount {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] res = count(s.next());
        System.out.println("Vowels: " + res[0] + ", Consonants: " + res[1]);
    }
    static String type(char c) {
        if(c>='A' && c<='Z') c=(char)(c+32);
        if(c>='a' && c<='z') {
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u') return "Vowel";
            return "Consonant";
        }
        return "Not a Letter";
    }
    static int[] count(String s) {
        int[] cnt = new int[2];
        for(int i=0; i<s.length(); i++) {
            String t = type(s.charAt(i));
            if(t.equals("Vowel")) cnt[0]++;
            else if(t.equals("Consonant")) cnt[1]++;
        }
        return cnt;
    }
}
