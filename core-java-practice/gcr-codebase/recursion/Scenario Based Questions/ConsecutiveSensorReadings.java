public class ConsecutiveSensorReadings {
    public static void main(String[] args) {
        System.out.println(isStrictlyIncreasing(new int[]{12, 15, 18, 22, 30}, 0));
    }

    static boolean isStrictlyIncreasing(int[] arr, int index) {
        return index >= arr.length - 1 || (arr[index] < arr[index + 1] && isStrictlyIncreasing(arr, index + 1));
    }
}
