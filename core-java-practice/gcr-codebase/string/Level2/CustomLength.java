import java.util.Scanner;
public class CustomLength {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        System.out.println(getLength(str) == str.length());
    }
    static int getLength(String str) {
        int c = 0;
        try {
            while(true) {
                str.charAt(c);
                c++;
            }
        } catch(StringIndexOutOfBoundsException e) {
            return c;
        }
    }
}
