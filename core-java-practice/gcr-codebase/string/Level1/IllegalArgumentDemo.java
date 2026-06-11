import java.util.Scanner;
public class IllegalArgumentDemo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        handle(str);
        generate(str);
    }
    static void generate(String str) {
        str.substring(2, 1);
    }
    static void handle(String str) {
        try {
            str.substring(2, 1);
        } catch(IllegalArgumentException e) {
            System.out.println(e);
        } catch(RuntimeException e) {
            System.out.println(e);
        }
    }
}
