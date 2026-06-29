interface HeartRateMonitor {

    int readHeartRate(String patientName);

    boolean isHeartRateNormal(int heartRate);

    default void displayHealthTips() {
        System.out.println("[Heart Health Tips]");
        System.out.println("  - Normal resting heart rate: 60-100 bpm");
        System.out.println("  - Regular cardiovascular exercise is recommended");
        System.out.println("  - Avoid excessive caffeine and stress");
        System.out.println("  - Monitor heart rate during exercise sessions");
    }

    static boolean isPatientIdValid(String patientId) {
        if (patientId == null || patientId.length() != 7) {
            return false;
        }
        if (!patientId.startsWith("PAT")) {
            return false;
        }
        for (int i = 3; i < patientId.length(); i++) {
            if (!Character.isDigit(patientId.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}

interface TemperatureMonitor {

    double readTemperature(String patientName);

    boolean isTemperatureNormal(double temperature);

    default void displayHealthTips() {
        System.out.println("[Temperature Health Tips]");
        System.out.println("  - Normal body temperature: 36.1°C - 37.2°C (97°F - 99°F)");
        System.out.println("  - Fever is typically above 38°C (100.4°F)");
        System.out.println("  - Stay hydrated and rest if temperature is elevated");
        System.out.println("  - Seek medical attention if fever persists over 3 days");
    }
}

class HealthMonitoringSystem implements HeartRateMonitor, TemperatureMonitor {

    private int[] simulatedHeartRates = {72, 110, 55, 88, 130};
    private double[] simulatedTemperatures = {36.5, 38.8, 37.0, 39.5, 36.9};

    private int patientIndex = 0;

    @Override
    public int readHeartRate(String patientName) {
        int heartRate = simulatedHeartRates[patientIndex % simulatedHeartRates.length];
        System.out.println("  [Heart Rate] " + patientName + " -> " + heartRate + " bpm");
        return heartRate;
    }

    @Override
    public boolean isHeartRateNormal(int heartRate) {
        return heartRate >= 60 && heartRate <= 100;
    }

    @Override
    public double readTemperature(String patientName) {
        double temp = simulatedTemperatures[patientIndex % simulatedTemperatures.length];
        System.out.println("  [Temperature] " + patientName + " -> " + String.format("%.1f", temp) + "°C");
        return temp;
    }

    @Override
    public boolean isTemperatureNormal(double temperature) {
        return temperature >= 36.1 && temperature <= 37.2;
    }

    @Override
    public void displayHealthTips() {
        System.out.println("========== HEALTH TIPS & GUIDELINES ==========\n");
        HeartRateMonitor.super.displayHealthTips();
        System.out.println();
        TemperatureMonitor.super.displayHealthTips();
        System.out.println("\n===============================================\n");
    }

    private String getHealthStatus(boolean heartOk, boolean tempOk) {
        if (heartOk && tempOk) return "HEALTHY";
        if (!heartOk && !tempOk) return "CRITICAL - Abnormal heart rate AND temperature";
        if (!heartOk) return "WARNING - Abnormal heart rate";
        return "WARNING - Abnormal temperature";
    }

    public void monitorAllPatients(String[] patientNames, String[] patientIds) {
        System.out.println("========== PATIENT HEALTH MONITORING ==========\n");

        int healthyCount = 0, warningCount = 0, criticalCount = 0, invalidIdCount = 0;

        String[] statuses = new String[patientNames.length];
        int[] heartRates = new int[patientNames.length];
        double[] temperatures = new double[patientNames.length];
        boolean[] idValid = new boolean[patientNames.length];

        for (int i = 0; i < patientNames.length; i++) {
            patientIndex = i;
            System.out.println("--- Patient #" + (i + 1) + ": " + patientNames[i] + " (ID: " + patientIds[i] + ") ---");

            idValid[i] = HeartRateMonitor.isPatientIdValid(patientIds[i]);
            System.out.println("  [ID Validation] " + (idValid[i] ? "VALID" : "INVALID"));

            if (!idValid[i]) {
                System.out.println("  >> SKIPPED - Invalid patient ID. Cannot proceed.\n");
                statuses[i] = "INVALID ID";
                invalidIdCount++;
                continue;
            }

            heartRates[i] = readHeartRate(patientNames[i]);
            temperatures[i] = readTemperature(patientNames[i]);

            boolean heartOk = isHeartRateNormal(heartRates[i]);
            boolean tempOk = isTemperatureNormal(temperatures[i]);
            statuses[i] = getHealthStatus(heartOk, tempOk);

            System.out.println("  [Heart Rate Status] " + (heartOk ? "Normal" : "ABNORMAL"));
            System.out.println("  [Temperature Status] " + (tempOk ? "Normal" : "ABNORMAL"));
            System.out.println("  >> STATUS: " + statuses[i] + "\n");

            if (statuses[i].equals("HEALTHY")) healthyCount++;
            else if (statuses[i].startsWith("CRITICAL")) criticalCount++;
            else warningCount++;
        }

        System.out.println("\n============================================================");
        System.out.println("           FINAL HEALTH REPORT - ALL PATIENTS");
        System.out.println("============================================================");
        System.out.printf("%-5s %-18s %-10s %-8s %-8s %-20s%n",
                "#", "Name", "ID", "HR(bpm)", "Temp(°C)", "Status");
        System.out.println("------------------------------------------------------------");

        for (int i = 0; i < patientNames.length; i++) {
            if (idValid[i]) {
                System.out.printf("%-5d %-18s %-10s %-8d %-8.1f %-20s%n",
                        (i + 1), patientNames[i], patientIds[i],
                        heartRates[i], temperatures[i], statuses[i]);
            } else {
                System.out.printf("%-5d %-18s %-10s %-8s %-8s %-20s%n",
                        (i + 1), patientNames[i], patientIds[i],
                        "N/A", "N/A", statuses[i]);
            }
        }

        System.out.println("------------------------------------------------------------");
        System.out.println("  Healthy : " + healthyCount + " | Warning : " + warningCount
                + " | Critical : " + criticalCount + " | Invalid ID : " + invalidIdCount);
        System.out.println("============================================================\n");
    }
}

public class SmartHealthcareMonitoring {
    public static void main(String[] args) {
        System.out.println("===== SMART HEALTHCARE MONITORING SYSTEM =====\n");

        String[] patientNames = {"Rahul Sharma", "Priya Gupta", "Arjun Patel", "Sneha Reddy", "Vikram Singh"};
        String[] patientIds = {"PAT1001", "PAT2002", "INVALID", "PAT4004", "PAT5005"};

        HealthMonitoringSystem system = new HealthMonitoringSystem();

        system.displayHealthTips();

        system.monitorAllPatients(patientNames, patientIds);

        System.out.println("--- Static Method: isPatientIdValid() ---");
        System.out.println("\"PAT1001\"  -> " + HeartRateMonitor.isPatientIdValid("PAT1001"));
        System.out.println("\"INVALID\"  -> " + HeartRateMonitor.isPatientIdValid("INVALID"));
        System.out.println("\"PAT12\"    -> " + HeartRateMonitor.isPatientIdValid("PAT12"));
        System.out.println("\"PAT123A\"  -> " + HeartRateMonitor.isPatientIdValid("PAT123A"));
        System.out.println("null       -> " + HeartRateMonitor.isPatientIdValid(null));
    }
}
