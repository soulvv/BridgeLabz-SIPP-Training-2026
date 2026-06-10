import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] arr = new double[10];

        int index = 0;
        double total = 0;

        while(true) {

            System.out.print("Enter number: ");
            double num = sc.nextDouble();

            if(num <= 0)
                break;

            arr[index] = num;
            index++;

            if(index == 10)
                break;
        }

        System.out.println("\nNumbers Entered:");

        for(int i = 0; i < index; i++) {
            System.out.println(arr[i]);
            total += arr[i];
        }

        System.out.println("Total Sum = " + total);

        sc.close();
    }
}