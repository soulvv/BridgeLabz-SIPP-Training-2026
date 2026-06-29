abstract class Subscription {
    protected String subscriberName;
    protected String subscriptionId;

    public Subscription(String subscriberName, String subscriptionId) {
        this.subscriberName = subscriberName;
        this.subscriptionId = subscriptionId;
    }

    public String getSubscriberName() {
        return subscriberName;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public abstract double calculateMonthlyCharge();
}

class BasicPlan extends Subscription {
    public BasicPlan(String subscriberName, String subscriptionId) {
        super(subscriberName, subscriptionId);
    }

    @Override
    public double calculateMonthlyCharge() {
        return 9.99;
    }
}

class PremiumPlan extends Subscription {
    public PremiumPlan(String subscriberName, String subscriptionId) {
        super(subscriberName, subscriptionId);
    }

    @Override
    public double calculateMonthlyCharge() {
        return 15.99;
    }
}

class FamilyPlan extends Subscription {
    public FamilyPlan(String subscriberName, String subscriptionId) {
        super(subscriberName, subscriptionId);
    }

    @Override
    public double calculateMonthlyCharge() {
        return 19.99;
    }
}

public class StreamingPlatformSubscriptionAnalyzer {
    public static void searchById(Subscription[] list, String targetId) {
        boolean found = false;
        for (Subscription s : list) {
            if (s.getSubscriptionId().equalsIgnoreCase(targetId)) {
                System.out.println("Found: " + s.getSubscriberName() + " | ID: " + s.getSubscriptionId() + " | Monthly Charge: $" + s.calculateMonthlyCharge());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Subscription ID: " + targetId + " not found.");
        }
    }

    public static void displaySubscribersByPrefix(Subscription[] list, char letter) {
        System.out.println("Subscribers whose names start with '" + letter + "':");
        char lowerLetter = Character.toLowerCase(letter);
        for (Subscription s : list) {
            if (s.getSubscriberName().toLowerCase().startsWith(String.valueOf(lowerLetter))) {
                System.out.println("- " + s.getSubscriberName());
            }
        }
    }

    public static double calculateTotalRevenue(Subscription[] list) {
        double total = 0.0;
        for (Subscription s : list) {
            total += s.calculateMonthlyCharge();
        }
        return total;
    }

    public static void displayMostExpensiveSubscription(Subscription[] list) {
        if (list.length == 0) return;
        Subscription expensive = list[0];
        for (Subscription s : list) {
            if (s.calculateMonthlyCharge() > expensive.calculateMonthlyCharge()) {
                expensive = s;
            }
        }
        System.out.println("Most Expensive: " + expensive.getSubscriberName() + " (ID: " + expensive.getSubscriptionId() + ") - $" + expensive.calculateMonthlyCharge());
    }

    public static void main(String[] args) {
        Subscription[] subs = new Subscription[4];
        subs[0] = new BasicPlan("Alice Cooper", "SUB001");
        subs[1] = new PremiumPlan("Bob Ross", "SUB002");
        subs[2] = new FamilyPlan("Charlie Chaplin", "SUB003");
        subs[3] = new PremiumPlan("David Beckham", "SUB004");

        System.out.println("Total Monthly Revenue: $" + calculateTotalRevenue(subs));
        System.out.println();

        displayMostExpensiveSubscription(subs);
        System.out.println();

        searchById(subs, "SUB003");
        System.out.println();

        displaySubscribersByPrefix(subs, 'A');
    }
}
