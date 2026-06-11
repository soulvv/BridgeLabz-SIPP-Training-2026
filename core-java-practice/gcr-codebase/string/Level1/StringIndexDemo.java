import java.util.Scanner;
public class StringIndexDemo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        handle(str);
        generate(str);
    }
    static void generate(String str) {
        str.charAt(str.length() + 1);
    }
    static void handle(String str) {
        try {
            str.charAt(str.length() + 1);
        } catch(StringIndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }
}
