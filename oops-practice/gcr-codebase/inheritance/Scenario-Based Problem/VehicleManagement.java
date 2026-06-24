interface Refuelable {
    void refuel();
}

class Vehicle {
    private String model;
    private int maxSpeed;

    public Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public String getModel() { return model; }
    public int getMaxSpeed() { return maxSpeed; }

    public void displayVehicleInfo() {
        System.out.println("Model: " + model + ", Max Speed: " + maxSpeed + " km/h");
    }
}

class ElectricVehicle extends Vehicle {
    private int batteryCapacity;

    public ElectricVehicle(String model, int maxSpeed, int batteryCapacity) {
        super(model, maxSpeed);
        this.batteryCapacity = batteryCapacity;
    }

    public void charge() {
        System.out.println(getModel() + " is charging its " + batteryCapacity + " kWh battery.");
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {
    private int fuelCapacity;

    public PetrolVehicle(String model, int maxSpeed, int fuelCapacity) {
        super(model, maxSpeed);
        this.fuelCapacity = fuelCapacity;
    }

    @Override
    public void refuel() {
        System.out.println(getModel() + " is refueling its " + fuelCapacity + " liter tank.");
    }
}

public class VehicleManagement {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle("Tesla Model S", 250, 100);
        PetrolVehicle pv = new PetrolVehicle("Ford Mustang", 280, 60);

        System.out.println("--- Electric Vehicle ---");
        ev.displayVehicleInfo();
        ev.charge();

        System.out.println("\n--- Petrol Vehicle ---");
        pv.displayVehicleInfo();
        pv.refuel();
    }
}
