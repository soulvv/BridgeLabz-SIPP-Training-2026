//A warehouse stores item quantities in an array. Find the max, min, total stock, and detect duplicates. Extend: rotate the stock array by k positions (simulate daily shift handover), and transpose a 2D shelf grid.

public class q3 {
    public static void main(String[] args) {

        int[] stock = {10, 20, 30, 20, 40, 50, 10};

        // Find Max and Min
        int max = stock[0];
        int min = stock[0];
        for (int quantity : stock) {
            if (quantity > max) {
                max = quantity;
            }
            if (quantity < min) {
                min = quantity;
            }
        }
        System.out.println("Max Stock: " + max);
        System.out.println("Min Stock: " + min);

        // Calculate Total Stock
        int totalStock = 0;
        for (int quantity : stock) {
            totalStock += quantity;
        }
        System.out.println("Total Stock: " + totalStock);

        // Detect Duplicates
        System.out.println("Duplicate Quantities:");
        for (int i = 0; i < stock.length; i++) {
            for (int j = i + 1; j < stock.length; j++) {
                if (stock[i] == stock[j]) {
                    System.out.println(stock[i]);
                    break;
                }
            }
        }

        // Rotate the stock array by k positions
        int k = 2; // Example rotation
        rotateArray(stock, k);
        System.out.print("Rotated Stock: ");
        for (int quantity : stock) {
            System.out.print(quantity + " ");
        }
    }

    private static void rotateArray(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // Handle cases where k > n

        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}