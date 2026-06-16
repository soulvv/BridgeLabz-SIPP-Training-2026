public class RecursionTasks {
    public static void main(String[] args) {
        System.out.println("Total moves: " + solveHanoi(3, 'A', 'C', 'B'));
        
        int[] prices = {10, 20, 30, 40, 50};
        System.out.println("Binary Search (30): " + binarySearch(prices, 30, 0, prices.length - 1));
        
        System.out.println("Sum of Digits (12345): " + sumOfDigits(12345));
        System.out.println("Reverse String (hello): " + reverseString("hello"));
        System.out.println("Balanced Parentheses ((()())): " + isBalanced("(()())", 0));
    }

    static int solveHanoi(int n, char from, char to, char aux) {
        if (n == 0) return 0;
        int moves = solveHanoi(n - 1, from, aux, to);
        System.out.println("Move disk " + n + " from " + from + " to " + to);
        moves++;
        moves += solveHanoi(n - 1, aux, to, from);
        return moves;
    }

    static int binarySearch(int[] arr, int target, int left, int right) {
        if (left > right) return -1;
        int mid = left + (right - left) / 2;
        if (arr[mid] == target) return mid;
        return arr[mid] > target ? binarySearch(arr, target, left, mid - 1) : binarySearch(arr, target, mid + 1, right);
    }

    static int sumOfDigits(int n) {
        return n == 0 ? 0 : n % 10 + sumOfDigits(n / 10);
    }

    static String reverseString(String s) {
        return s.isEmpty() ? "" : reverseString(s.substring(1)) + s.charAt(0);
    }

    static boolean isBalanced(String s, int count) {
        if (count < 0) return false;
        if (s.isEmpty()) return count == 0;
        char c = s.charAt(0);
        if (c == '(') return isBalanced(s.substring(1), count + 1);
        if (c == ')') return isBalanced(s.substring(1), count - 1);
        return isBalanced(s.substring(1), count);
    }
}
