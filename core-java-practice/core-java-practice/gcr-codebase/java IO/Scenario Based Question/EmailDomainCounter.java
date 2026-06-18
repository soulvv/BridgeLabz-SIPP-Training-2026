import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmailDomainCounter {
    public static void main(String[] args) {
        List<String> domainsList = new ArrayList<>();
        Map<String, Integer> domainCount = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("emails.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("@")) {
                    String domain = line.substring(line.indexOf("@") + 1);
                    domainsList.add(domain);
                    domainCount.put(domain, domainCount.getOrDefault(domain, 0) + 1);
                }
            }
            for (Map.Entry<String, Integer> entry : domainCount.entrySet()) {
                System.out.println(entry.getKey() + " Count = " + entry.getValue());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
