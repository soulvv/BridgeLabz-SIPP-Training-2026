public class arr {
    public static void main(String[] args) {

        int[] arr = {0, 1, 3, 1, 2, 3, 0, 1, 3, 2, 1, 0};

        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }

        int[] freq = new int[max + 1];

        for (int num : arr) {
            freq[num]++;
        }

        for (int i = 0; i < freq.length; i++) {
            System.out.println(i + " -> " + freq[i]);
        }
    }
}