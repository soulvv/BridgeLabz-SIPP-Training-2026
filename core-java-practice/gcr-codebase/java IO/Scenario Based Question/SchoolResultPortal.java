import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SchoolResultPortal {
    public static void main(String[] args) {
        String inputFile = "student_marks.txt";
        String outputFile = "report_cards.txt";
        
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, true))) {
             
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 1) {
                    String name = parts[0];
                    int total = 0;
                    int count = parts.length - 1;
                    for (int i = 1; i < parts.length; i++) {
                        total += Integer.parseInt(parts[i].trim());
                    }
                    double average = (double) total / count;
                    bw.write(name + " - Average: " + String.format("%.2f", average));
                    bw.newLine();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading or writing file - " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing marks - " + e.getMessage());
        }
    }
}
