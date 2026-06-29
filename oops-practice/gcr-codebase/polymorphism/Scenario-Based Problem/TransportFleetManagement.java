abstract class Vehicle {
    private String model;

    public Vehicle(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public abstract double fuelCost(double km);
}

class Car extends Vehicle {
    private double ratePerKm;

    public Car(String model, double ratePerKm) {
        super(model);
        this.ratePerKm = ratePerKm;
    }

    @Override
    public double fuelCost(double km) {
        return km * ratePerKm;
    }
}

class Bus extends Vehicle {
    private double ratePerKm;

    public Bus(String model, double ratePerKm) {
        super(model);
        this.ratePerKm = ratePerKm;
    }

    @Override
    public double fuelCost(double km) {
        return km * ratePerKm;
    }
}

class Bike extends Vehicle {
    private double ratePerKm;

    public Bike(String model, double ratePerKm) {
        super(model);
        this.ratePerKm = ratePerKm;
    }

    @Override
    public double fuelCost(double km) {
        return km * ratePerKm;
    }
}

class ElectricCar extends Vehicle {
    private double electricityRatePerKm;

    public ElectricCar(String model, double electricityRatePerKm) {
        super(model);
        this.electricityRatePerKm = electricityRatePerKm;
    }

    @Override
    public double fuelCost(double km) {
        return km * electricityRatePerKm;
    }

    public void plugIn() {
        System.out.println(getModel() + " is plugged in and charging.");
    }
}

public class TransportFleetManagement {
    public static void main(String[] args) {
        Vehicle[] fleet = new Vehicle[4];
        fleet[0] = new Car("Sedan X", 8.5);
        fleet[1] = new Bus("City Coach", 25.0);
        fleet[2] = new Bike("Sport 150", 2.0);
        fleet[3] = new ElectricCar("Tesla Model 3", 1.5);

        double distance = 120.0;

        for (Vehicle v : fleet) {
            System.out.println("Vehicle: " + v.getModel());
            System.out.println("Fuel Cost for " + distance + " km: " + v.fuelCost(distance));

            if (v instanceof ElectricCar) {
                ElectricCar ec = (ElectricCar) v;
                ec.plugIn();
            }
            System.out.println();
        }
    }
}
