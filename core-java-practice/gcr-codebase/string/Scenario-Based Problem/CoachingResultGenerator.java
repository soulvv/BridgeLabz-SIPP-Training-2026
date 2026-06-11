import java.util.Scanner;

/**
 * Scenario 2: Raj's Result Generator
 * This program accepts marks for 5 subjects, calculates average, and assigns a grade.
 * 
 * Concepts Demonstrated:
 * - Variables, Literals, Primitive Data Types
 * - Basic I/O (Scanner)
 * - Arrays (to utilize for-each loop)
 * - Conditional Logic (switch, if-else)
 * - Loops (for, for-each)
 * - Clean code practices
 */
public class CoachingResultGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        final int TOTAL_SUBJECTS = 5;
        double[] subjectMarks = new double[TOTAL_SUBJECTS];
        String[] subjectNames = {"Mathematics", "Science", "English", "History", "Computer"};
        double totalMarks = 0.0;

        System.out.println("🎓 Welcome to Raj's Coaching Center Result Generator 🎓");

        // for-loop to iterate over subjects for input
        for (int i = 0; i < TOTAL_SUBJECTS; i++) {
            System.out.print("Enter marks for " + subjectNames[i] + " (0-100): ");
            double marks = scanner.nextDouble();

            // Validation
            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks entered! Marks should be between 0 and 100.");
                i--; // Decrement index to re-enter marks for the same subject
                continue;
            }
            
            subjectMarks[i] = marks;
            totalMarks += marks;
        }

        System.out.println("\n--- Scorecard ---");
        // for-each loop to display marks
        int index = 0;
        for (double mark : subjectMarks) {
            System.out.println(subjectNames[index] + ": " + mark);
            index++;
        }

        // Calculate Average
        double average = totalMarks / TOTAL_SUBJECTS;
        System.out.println("\nTotal Marks: " + totalMarks + " / " + (TOTAL_SUBJECTS * 100));
        System.out.println("Average Percentage: " + average + "%");

        // Conditional Logic - Switch Statement to assign grades
        char grade;
        int gradeCategory = (int) (average / 10);

        switch (gradeCategory) {
            case 10: // 100%
            case 9:  // 90-99%
                grade = 'A';
                break;
            case 8:  // 80-89%
                grade = 'B';
                break;
            case 7:  // 70-79%
                grade = 'C';
                break;
            case 6:  // 60-69%
                grade = 'D';
                break;
            case 5:  // 50-59%
                grade = 'E';
                break;
            default: // below 50%
                grade = 'F';
                break;
        }

        System.out.println("Assigned Grade: " + grade);
        
        if (grade == 'F') {
            System.out.println("Remark: Needs Improvement.");
        } else {
            System.out.println("Remark: Excellent Work!");
        }

        scanner.close();
    }
}
