import java.util.Scanner;
public class NumberFormatDemo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        handle(str);
        generate(str);
    }
    static void generate(String str) {
        Integer.parseInt(str);
    }
    static void handle(String str) {
        try {
            Integer.parseInt(str);
        } catch(NumberFormatException e) {
            System.out.println(e);
        } catch(RuntimeException e) {
            System.out.println(e);
        }
    }
}
