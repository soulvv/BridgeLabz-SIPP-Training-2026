abstract class RescueTeam {
    protected String teamId;
    protected String location;

    public RescueTeam(String teamId, String location) {
        this.teamId = teamId;
        this.location = location;
    }

    public String getTeamId() {
        return teamId;
    }

    public String getLocation() {
        return location;
    }

    public abstract void performDuty();
}

class MedicalTeam extends RescueTeam {
    public MedicalTeam(String teamId, String location) {
        super(teamId, location);
    }

    @Override
    public void performDuty() {
        System.out.println("Medical Team " + teamId + " in " + location + " is treating injured survivors.");
    }
}

class FireRescueTeam extends RescueTeam {
    public FireRescueTeam(String teamId, String location) {
        super(teamId, location);
    }

    @Override
    public void performDuty() {
        System.out.println("Fire Rescue Team " + teamId + " in " + location + " is clearing rubble and fighting hazards.");
    }
}

class FoodSupplyTeam extends RescueTeam {
    public FoodSupplyTeam(String teamId, String location) {
        super(teamId, location);
    }

    @Override
    public void performDuty() {
        System.out.println("Food Supply Team " + teamId + " in " + location + " is distributing clean water and food packages.");
    }
}

public class DisasterRescueManagementSystem {
    public static void findTeamByLocation(RescueTeam[] teams, String location) {
        System.out.println("Searching teams at location: " + location);
        boolean found = false;
        for (RescueTeam t : teams) {
            if (t.getLocation().equalsIgnoreCase(location)) {
                System.out.println("- " + t.getTeamId() + " (" + t.getClass().getSimpleName() + ")");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No teams found at: " + location);
        }
    }

    public static void displayTeamsByPrefix(RescueTeam[] teams, String prefix) {
        System.out.println("Searching teams with ID prefix: " + prefix);
        for (RescueTeam t : teams) {
            if (t.getTeamId().toUpperCase().startsWith(prefix.toUpperCase())) {
                System.out.println("- " + t.getTeamId() + " located at " + t.getLocation());
            }
        }
    }

    public static void countAndDisplayDeployments(RescueTeam[] teams) {
        int medCount = 0;
        int fireCount = 0;
        int foodCount = 0;

        for (RescueTeam t : teams) {
            if (t instanceof MedicalTeam) {
                medCount++;
            } else if (t instanceof FireRescueTeam) {
                fireCount++;
            } else if (t instanceof FoodSupplyTeam) {
                foodCount++;
            }
        }

        System.out.println("Medical Teams: " + medCount);
        System.out.println("Fire Rescue Teams: " + fireCount);
        System.out.println("Food Supply Teams: " + foodCount);

        String maxCategory = "MedicalTeam";
        int maxVal = medCount;

        if (fireCount > maxVal) {
            maxVal = fireCount;
            maxCategory = "FireRescueTeam";
        }
        if (foodCount > maxVal) {
            maxVal = foodCount;
            maxCategory = "FoodSupplyTeam";
        }

        System.out.println("Category with Maximum Deployments: " + maxCategory + " (" + maxVal + " deployments)");
    }

    public static void main(String[] args) {
        RescueTeam[] deployments = new RescueTeam[6];
        deployments[0] = new MedicalTeam("MED-01", "Zone A");
        deployments[1] = new FireRescueTeam("FIRE-02", "Zone B");
        deployments[2] = new FoodSupplyTeam("FOOD-03", "Zone A");
        deployments[3] = new MedicalTeam("MED-04", "Zone C");
        deployments[4] = new FoodSupplyTeam("FOOD-05", "Zone B");
        deployments[5] = new FoodSupplyTeam("FOOD-06", "Zone A");

        System.out.println("--- Duty Allocations ---");
        for (RescueTeam t : deployments) {
            t.performDuty();
        }
        System.out.println();

        findTeamByLocation(deployments, "Zone A");
        System.out.println();

        displayTeamsByPrefix(deployments, "FOOD");
        System.out.println();

        System.out.println("--- Deployment Analysis ---");
        countAndDisplayDeployments(deployments);
    }
}
