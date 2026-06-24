abstract class Vehicle {
    private String vehicleNumber;
    private String vehicleType;

    public Vehicle(String vehicleNumber, String vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() { return vehicleNumber; }
    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }
    public String getVehicleType() { return vehicleType; }
    public void setVehicleType(String vehicleType) { this.vehicleType = vehicleType; }

    public abstract double calculateRentalCost(int days);
}

class Car extends Vehicle {
    private double dailyRate;

    public Car(String vehicleNumber, String vehicleType, double dailyRate) {
        super(vehicleNumber, vehicleType);
        this.dailyRate = dailyRate;
    }

    public double getDailyRate() { return dailyRate; }
    public void setDailyRate(double dailyRate) { this.dailyRate = dailyRate; }

    @Override
    public double calculateRentalCost(int days) {
        return days * dailyRate;
    }
}

class Bike extends Vehicle {
    private double dailyRate;

    public Bike(String vehicleNumber, String vehicleType, double dailyRate) {
        super(vehicleNumber, vehicleType);
        this.dailyRate = dailyRate;
    }

    public double getDailyRate() { return dailyRate; }
    public void setDailyRate(double dailyRate) { this.dailyRate = dailyRate; }

    @Override
    public double calculateRentalCost(int days) {
        return days * dailyRate;
    }
}

class Truck extends Vehicle {
    private double dailyRate;
    private double loadingCharge;

    public Truck(String vehicleNumber, String vehicleType, double dailyRate, double loadingCharge) {
        super(vehicleNumber, vehicleType);
        this.dailyRate = dailyRate;
        this.loadingCharge = loadingCharge;
    }

    public double getDailyRate() { return dailyRate; }
    public void setDailyRate(double dailyRate) { this.dailyRate = dailyRate; }
    public double getLoadingCharge() { return loadingCharge; }
    public void setLoadingCharge(double loadingCharge) { this.loadingCharge = loadingCharge; }

    @Override
    public double calculateRentalCost(int days) {
        return (days * dailyRate) + loadingCharge;
    }
}

public class RentalSystem {
    public static void main(String[] args) {
        Car car = new Car("C123", "Sedan", 50.0);
        Bike bike = new Bike("B456", "Sport", 20.0);
        Truck truck = new Truck("T789", "Heavy Duty", 100.0, 50.0);

        int rentalDays = 5;

        System.out.println("--- Vehicle Rental Details for " + rentalDays + " days ---");
        System.out.println("Car (" + car.getVehicleNumber() + "): $" + car.calculateRentalCost(rentalDays));
        System.out.println("Bike (" + bike.getVehicleNumber() + "): $" + bike.calculateRentalCost(rentalDays));
        System.out.println("Truck (" + truck.getVehicleNumber() + "): $" + truck.calculateRentalCost(rentalDays));
    }
}
