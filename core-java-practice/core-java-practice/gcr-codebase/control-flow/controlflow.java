import java.util.Scanner;

public class StudentIntro {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Student Details
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Marks (0-100): ");
        int marks = sc.nextInt();

        System.out.print("Enter Year (1-4): ");
        int year = sc.nextInt();

        System.out.println("\n===== STUDENT PROFILE =====");
        System.out.println("Name  : " + name);
        System.out.println("Age   : " + age);
        System.out.println("Marks : " + marks);

        // IF-ELSE: Check Voting Eligibility
        if (age >= 18) {
            System.out.println("Status: Adult Student");
        } else {
            System.out.println("Status: Minor Student");
        }

        // ELSE-IF LADDER: Grade Calculation
        if (marks >= 90) {
            System.out.println("Grade : A");
        } else if (marks >= 75) {
            System.out.println("Grade : B");
        } else if (marks >= 60) {
            System.out.println("Grade : C");
        } else if (marks >= 40) {
            System.out.println("Grade : D");
        } else {
            System.out.println("Grade : F");
        }

        // SWITCH: Academic Year
        switch (year) {

            case 1:
                System.out.println("Year  : First Year");
                break;

            case 2:
                System.out.println("Year  : Second Year");
                break;

            case 3:
                System.out.println("Year  : Third Year");
                break;

            case 4:
                System.out.println("Year  : Fourth Year");
                break;

            default:
                System.out.println("Invalid Year");
        }

        sc.close();
    }
}