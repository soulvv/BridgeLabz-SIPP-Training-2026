public class UsernameValidator {
    public static void main(String[] args) {
        System.out.println(isValid("abcdxyz"));
    }

    static boolean isValid(String s) {
        return s.isEmpty() || (s.charAt(0) >= 'a' && s.charAt(0) <= 'z' && isValid(s.substring(1)));
    }
}
