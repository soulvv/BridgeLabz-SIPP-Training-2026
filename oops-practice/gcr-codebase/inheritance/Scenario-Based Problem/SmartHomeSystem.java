class Device {
    private String deviceId;
    private boolean status; // true for ON, false for OFF

    public Device(String deviceId, boolean status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    public String getDeviceId() { return deviceId; }
    public boolean getStatus() { return status; }

    public void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + (status ? "ON" : "OFF"));
    }
}

class Thermostat extends Device {
    private double temperatureSetting;

    public Thermostat(String deviceId, boolean status, double temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    public double getTemperatureSetting() { return temperatureSetting; }

    @Override
    public void displayStatus() {
        super.displayStatus();
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
    }
}

public class SmartHomeSystem {
    public static void main(String[] args) {
        Thermostat livingRoomThermostat = new Thermostat("THM-1001", true, 22.5);

        System.out.println("--- Smart Home Device Status ---");
        livingRoomThermostat.displayStatus();
    }
}
