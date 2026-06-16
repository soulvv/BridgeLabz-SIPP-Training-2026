public class NullPointerDemo {
    public static void main(String[] args) {
        handle();
        generate();
    }
    static void generate() {
        String text = null;
        text.length();
    }
    static void handle() {
        String text = null;
        try {
            text.length();
        } catch(NullPointerException e) {
            System.out.println(e);
        }
    }
}
