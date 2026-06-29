interface Trackable {
    void logActivity(String activity, int durationMinutes);

    default void resetData() {
        System.out.println("[Trackable] Resetting all tracked fitness data to defaults...");
        System.out.println("[Trackable] Steps: 0 | Calories: 0 | Distance: 0.0 km");
        System.out.println("[Trackable] Data reset complete.\n");
    }
}

interface Reportable {
    void generateReport();
}

interface Notifiable {
    void sendAlert(String message);
}

class FitnessDevice implements Trackable, Reportable, Notifiable {

    private String deviceName;
    private String[] activityLog;
    private int logCount;
    private int totalSteps;
    private double totalCalories;

    public FitnessDevice(String deviceName) {
        this.deviceName = deviceName;
        this.activityLog = new String[100];
        this.logCount = 0;
        this.totalSteps = 0;
        this.totalCalories = 0.0;
    }

    @Override
    public void logActivity(String activity, int durationMinutes) {
        int stepsEstimate = durationMinutes * 120;
        double caloriesEstimate = durationMinutes * 7.5;

        totalSteps += stepsEstimate;
        totalCalories += caloriesEstimate;

        String logEntry = activity + " | Duration: " + durationMinutes + " min | Steps: "
                + stepsEstimate + " | Calories: " + String.format("%.1f", caloriesEstimate);
        activityLog[logCount++] = logEntry;

        System.out.println("[FitnessDevice] Activity logged: " + logEntry);

        if (durationMinutes > 60) {
            sendAlert("Intense workout detected! " + activity + " lasted " + durationMinutes + " minutes.");
        }
    }

    @Override
    public void generateReport() {
        System.out.println("\n========== FITNESS REPORT: " + deviceName + " ==========");
        System.out.println("Total Activities Logged: " + logCount);
        System.out.println("Total Steps: " + totalSteps);
        System.out.println("Total Calories Burned: " + String.format("%.1f", totalCalories));
        System.out.println("---------- Activity History ----------");
        for (int i = 0; i < logCount; i++) {
            System.out.println("  " + (i + 1) + ". " + activityLog[i]);
        }
        System.out.println("======================================\n");
    }

    @Override
    public void sendAlert(String message) {
        System.out.println("[ALERT - " + deviceName + "] " + message);
    }

    @Override
    public void resetData() {
        Trackable.super.resetData();
        this.logCount = 0;
        this.totalSteps = 0;
        this.totalCalories = 0.0;
        this.activityLog = new String[100];
        System.out.println("[FitnessDevice] " + deviceName + " internal data cleared.\n");
    }
}

public class FitnessTracker {
    public static void main(String[] args) {
        System.out.println("===== FITNESS TRACKER - Multiple Interface Implementation Demo =====\n");

        FitnessDevice myBand = new FitnessDevice("SmartBand Pro X");

        System.out.println("--- Logging Activities ---");
        myBand.logActivity("Morning Jog", 30);
        myBand.logActivity("Cycling", 45);
        myBand.logActivity("Swimming", 25);
        myBand.logActivity("Marathon Training", 90);

        myBand.generateReport();

        myBand.sendAlert("Heart rate elevated! Take a break.");

        System.out.println("\n--- Resetting Device Data ---");
        myBand.resetData();

        myBand.generateReport();

        System.out.println("--- Polymorphism via Interface References ---");
        Trackable tracker = myBand;
        Reportable reporter = myBand;
        Notifiable notifier = myBand;

        tracker.logActivity("Evening Walk", 20);
        reporter.generateReport();
        notifier.sendAlert("Goal reached: 10,000 steps!");
    }
}
