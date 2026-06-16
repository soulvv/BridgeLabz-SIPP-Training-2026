import java.util.Scanner;
public class ArrayIndexDemo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] arr = new String[2];
        arr[0] = s.next();
        arr[1] = s.next();
        handle(arr);
        generate(arr);
    }
    static void generate(String[] arr) {
        System.out.println(arr[5]);
    }
    static void handle(String[] arr) {
        try {
            System.out.println(arr[5]);
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        } catch(RuntimeException e) {
            System.out.println(e);
        }
    }
}
