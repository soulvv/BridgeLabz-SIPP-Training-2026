abstract class TollVehicle {
    protected String vehicleNumber;
    protected String ownerName;

    public TollVehicle(String vehicleNumber, String ownerName) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public abstract double calculateToll();
}

class TollCar extends TollVehicle {
    public TollCar(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    @Override
    public double calculateToll() {
        return 50.0;
    }
}

class TollBus extends TollVehicle {
    public TollBus(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    @Override
    public double calculateToll() {
        return 100.0;
    }
}

class TollTruck extends TollVehicle {
    public TollTruck(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    @Override
    public double calculateToll() {
        return 150.0;
    }
}

public class SmartVehicleTollManagementSystem {
    public static double calculateTotalRevenue(TollVehicle[] vehicles) {
        double total = 0.0;
        for (TollVehicle v : vehicles) {
            total += v.calculateToll();
        }
        return total;
    }

    public static void searchVehicle(TollVehicle[] vehicles, String vehicleNumber) {
        boolean found = false;
        for (TollVehicle v : vehicles) {
            if (v.getVehicleNumber().equalsIgnoreCase(vehicleNumber)) {
                System.out.println("Vehicle Found: " + v.getVehicleNumber() + " | Owner: " + v.getOwnerName() + " | Toll Paid: " + v.calculateToll());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Vehicle with number " + vehicleNumber + " not found.");
        }
    }

    public static void displayHighestTollVehicle(TollVehicle[] vehicles) {
        if (vehicles.length == 0) return;
        TollVehicle highest = vehicles[0];
        for (TollVehicle v : vehicles) {
            if (v.calculateToll() > highest.calculateToll()) {
                highest = v;
            }
        }
        System.out.println("Highest Toll Paid By: " + highest.getVehicleNumber() + " (" + highest.getOwnerName() + ") - Paid: " + highest.calculateToll());
    }

    public static void countVehiclesByType(TollVehicle[] vehicles) {
        int carCount = 0;
        int busCount = 0;
        int truckCount = 0;
        for (TollVehicle v : vehicles) {
            if (v instanceof TollCar) {
                carCount++;
            } else if (v instanceof TollBus) {
                busCount++;
            } else if (v instanceof TollTruck) {
                truckCount++;
            }
        }
        System.out.println("Cars: " + carCount + " | Buses: " + busCount + " | Trucks: " + truckCount);
    }

    public static void main(String[] args) {
        TollVehicle[] vehicles = new TollVehicle[5];
        vehicles[0] = new TollCar("MH-12-AB-1234", "John");
        vehicles[1] = new TollBus("DL-01-CD-5678", "Alice");
        vehicles[2] = new TollTruck("KA-03-EF-9012", "Bob");
        vehicles[3] = new TollCar("MH-02-XY-9999", "Charlie");
        vehicles[4] = new TollTruck("UP-16-ZZ-4321", "Diana");

        System.out.println("Total Toll Revenue: $" + calculateTotalRevenue(vehicles));
        System.out.println();

        System.out.println("Vehicle Counts:");
        countVehiclesByType(vehicles);
        System.out.println();

        displayHighestTollVehicle(vehicles);
        System.out.println();

        System.out.println("Searching for vehicle MH-12-AB-1234:");
        searchVehicle(vehicles, "MH-12-AB-1234");
    }
}
