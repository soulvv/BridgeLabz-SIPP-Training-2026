import java.util.Scanner;

public class KingdomTaxSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] incomes = new double[10];
        double totalTax = 0;

        for (int i = 0; i < incomes.length; i++) {

            System.out.print("Enter income of Citizen " + (i + 1) + ": ");
            incomes[i] = sc.nextDouble();

            double tax;

            if (incomes[i] < 10000) {

                tax = incomes[i] * 0.05;
                System.out.println("Tax Bracket: 5%");

            } else if (incomes[i] <= 50000) {

                tax = incomes[i] * 0.15;
                System.out.println("Tax Bracket: 15%");

            } else {

                tax = incomes[i] * 0.30;
                System.out.println("Tax Bracket: 30%");
            }

            System.out.println("Tax Amount: ₹" + tax);
            System.out.println("----------------------");

            totalTax += tax;
        }

        System.out.println("\n===== TAX SUMMARY =====");
        System.out.println("Total Tax Collected: ₹" + totalTax);

        sc.close();
    }
}