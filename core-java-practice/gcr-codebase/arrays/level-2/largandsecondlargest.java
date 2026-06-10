import java.util.Scanner;

public class LargestSecondLargestDigit {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number: ");
        int number = sc.nextInt();

        int[] digits = new int[10];
        int index = 0;

        while(number != 0 && index < digits.length) {

            digits[index] = number % 10;
            number = number / 10;
            index++;
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for(int i = 0; i < index; i++) {

            if(digits[i] > largest) {

                secondLargest = largest;
                largest = digits[i];

            } else if(digits[i] > secondLargest && digits[i] != largest) {

                secondLargest = digits[i];
            }
        }

        System.out.println("Largest Digit = " + largest);
        System.out.println("Second Largest Digit = " + secondLargest);

        sc.close();
    }
}