interface FoodDelivery {

    void deliverFood(String customerName, String foodItem);

    default void trackOrder() {
        System.out.println("[FoodDelivery Tracking]");
        System.out.println("  Status: Order picked up from restaurant");
        System.out.println("  Estimated delivery: 25-35 minutes");
        System.out.println("  Live tracking: Enabled (GPS)");
    }
}

interface GroceryDelivery {

    void deliverGrocery(String customerName, String groceryItem);

    default void trackOrder() {
        System.out.println("[GroceryDelivery Tracking]");
        System.out.println("  Status: Items packed at warehouse");
        System.out.println("  Estimated delivery: 45-60 minutes");
        System.out.println("  Delivery slot: Scheduled");
    }

    static String generateDeliveryCode() {
        long timestamp = System.currentTimeMillis();
        int random = (int) (Math.random() * 9000) + 1000;
        return "DEL-" + (timestamp % 100000) + "-" + random;
    }
}

class DeliveryExecutive implements FoodDelivery, GroceryDelivery {

    private String executiveName;
    private String vehicleType;
    private int totalDeliveries;

    public DeliveryExecutive(String executiveName, String vehicleType) {
        this.executiveName = executiveName;
        this.vehicleType = vehicleType;
        this.totalDeliveries = 0;
    }

    @Override
    public void deliverFood(String customerName, String foodItem) {
        String code = GroceryDelivery.generateDeliveryCode();
        totalDeliveries++;

        System.out.println("  [Food Delivery]");
        System.out.println("    Customer    : " + customerName);
        System.out.println("    Food Item   : " + foodItem);
        System.out.println("    Delivery Code: " + code);
        System.out.println("    Executive   : " + executiveName + " (" + vehicleType + ")");
        System.out.println("    Status      : Delivered successfully!");
    }

    @Override
    public void deliverGrocery(String customerName, String groceryItem) {
        String code = GroceryDelivery.generateDeliveryCode();
        totalDeliveries++;

        System.out.println("  [Grocery Delivery]");
        System.out.println("    Customer    : " + customerName);
        System.out.println("    Grocery Item: " + groceryItem);
        System.out.println("    Delivery Code: " + code);
        System.out.println("    Executive   : " + executiveName + " (" + vehicleType + ")");
        System.out.println("    Status      : Delivered successfully!");
    }

    @Override
    public void trackOrder() {
        System.out.println("========== ORDER TRACKING - " + executiveName + " ==========\n");

        System.out.println("--- Food Order Tracking ---");
        FoodDelivery.super.trackOrder();

        System.out.println();

        System.out.println("--- Grocery Order Tracking ---");
        GroceryDelivery.super.trackOrder();

        System.out.println("\n--- Executive Info ---");
        System.out.println("  Driver: " + executiveName);
        System.out.println("  Vehicle: " + vehicleType);
        System.out.println("  Deliveries Completed: " + totalDeliveries);
        System.out.println("\n=====================================================\n");
    }

    public void processAllDeliveries(String[] customers, String[] foodOrders, String[] groceryOrders) {
        System.out.println("========== DELIVERY PROCESSING ==========\n");

        for (int i = 0; i < customers.length; i++) {
            System.out.println("--- Order #" + (i + 1) + " for " + customers[i] + " ---");

            if (i < foodOrders.length && foodOrders[i] != null && !foodOrders[i].isEmpty()) {
                deliverFood(customers[i], foodOrders[i]);
            } else {
                System.out.println("  [Food Delivery] No food order for this customer.");
            }

            System.out.println();

            if (i < groceryOrders.length && groceryOrders[i] != null && !groceryOrders[i].isEmpty()) {
                deliverGrocery(customers[i], groceryOrders[i]);
            } else {
                System.out.println("  [Grocery Delivery] No grocery order for this customer.");
            }

            System.out.println();
        }

        System.out.println("=========================================");
        System.out.println("  Total deliveries completed by " + executiveName + ": " + totalDeliveries);
        System.out.println("=========================================\n");
    }

    public int getTotalDeliveries() {
        return totalDeliveries;
    }
}

public class FoodDeliveryPartnerSystem {
    public static void main(String[] args) {
        System.out.println("===== FOOD DELIVERY PARTNER SYSTEM =====\n");

        String[] customers = {"Ananya Verma", "Rohan Mehta", "Kavya Nair", "Siddharth Joshi", "Meera Iyer"};

        String[] foodOrders = {"Paneer Tikka Masala", "Chicken Biryani", "", "Veg Thali", "Margherita Pizza"};

        String[] groceryOrders = {"Milk, Bread, Eggs", "", "Rice, Dal, Oil", "Fruits, Vegetables", "Chips, Juice"};

        DeliveryExecutive executive = new DeliveryExecutive("Ramesh Kumar", "Motorcycle");

        executive.trackOrder();

        executive.processAllDeliveries(customers, foodOrders, groceryOrders);

        executive.trackOrder();

        System.out.println("--- Static Method: generateDeliveryCode() ---");
        System.out.println("Code 1: " + GroceryDelivery.generateDeliveryCode());
        System.out.println("Code 2: " + GroceryDelivery.generateDeliveryCode());
        System.out.println("Code 3: " + GroceryDelivery.generateDeliveryCode());
    }
}
