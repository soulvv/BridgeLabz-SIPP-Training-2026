import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CustomerFeedbackAnalyzer {
    public static void main(String[] args) {
        int goodCount = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            for (int i = 0; i < 5; i++) {
                String feedback = br.readLine();
                if (feedback != null && feedback.toLowerCase().contains("good")) {
                    goodCount++;
                }
            }
            System.out.println("Good Feedback Count = " + goodCount);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
