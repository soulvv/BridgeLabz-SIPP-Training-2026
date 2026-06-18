import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DailyExpenseLogger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("expenses.txt", true))) {
            String category = scanner.nextLine();
            String amount = scanner.nextLine();
            bw.write(category + " - " + amount);
            bw.newLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
