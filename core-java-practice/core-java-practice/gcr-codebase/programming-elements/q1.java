//DAY-1: Ravi just joined a coding guild. Store his name, age, rank, salary, and
//membership fee (float) using correct data types. Compute his
//annual bonus (12% of salary), cast it to int, and print a formatted
//welcome card.

import java.util.Scanner;

public class q1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Rank: ");
        String rank = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        System.out.print("Enter Membership Fee: ");
        float membershipFee = sc.nextFloat();

        double bonus = salary * 0.12;

        // Type casting double to int
        int annualBonus = (int) bonus;

        System.out.println("\n================================");
        System.out.println("  Welcome to the Coding Guild!   ");
        System.out.println("================================");
        System.out.println("Name           : " + name);
        System.out.println("Age            : " + age);
        System.out.println("Rank           : " + rank);
        System.out.println("Salary         : ₹" + salary);
        System.out.println("Membership Fee : ₹" + membershipFee);
        System.out.println("Annual Bonus   : ₹" + annualBonus);

        sc.close();
    }
}