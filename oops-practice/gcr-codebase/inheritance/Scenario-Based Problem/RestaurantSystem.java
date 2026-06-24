interface Worker {
    void performDuties();
}

class RestaurantPerson {
    private String name;
    private int id;

    public RestaurantPerson(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() { return name; }
    public int getId() { return id; }

    public void displayDetails() {
        System.out.println("ID: " + id + ", Name: " + name);
    }
}

class Chef extends RestaurantPerson implements Worker {
    private String specialty;

    public Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    public String getSpecialty() { return specialty; }

    @Override
    public void performDuties() {
        System.out.println(getName() + " is cooking " + specialty + " dishes in the kitchen.");
    }
}

class Waiter extends RestaurantPerson implements Worker {
    private int[] assignedTables;

    public Waiter(String name, int id, int[] assignedTables) {
        super(name, id);
        this.assignedTables = assignedTables;
    }

    public int[] getAssignedTables() { return assignedTables; }

    @Override
    public void performDuties() {
        System.out.print(getName() + " is taking orders and serving tables: ");
        for (int table : assignedTables) {
            System.out.print(table + " ");
        }
        System.out.println();
    }
}

public class RestaurantSystem {
    public static void main(String[] args) {
        Chef chef = new Chef("Gordon", 101, "Italian");
        Waiter waiter = new Waiter("Alice", 102, new int[]{1, 2, 5});

        System.out.println("--- Restaurant Staff Duties ---");
        chef.displayDetails();
        chef.performDuties();

        System.out.println();

        waiter.displayDetails();
        waiter.performDuties();
    }
}
