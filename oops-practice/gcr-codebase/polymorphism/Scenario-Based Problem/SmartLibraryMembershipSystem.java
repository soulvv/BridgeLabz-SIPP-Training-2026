abstract class LibraryMember {
    protected String memberName;
    protected String memberId;

    public LibraryMember(String memberName, String memberId) {
        this.memberName = memberName;
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getMemberId() {
        return memberId;
    }

    public abstract double calculateFine(int overdueDays);

    public void printDetails() {
        System.out.println("ID: " + memberId + " | Name: " + memberName);
    }
}

class StudentMember extends LibraryMember {
    public StudentMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * 2.0;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Membership Type: Student");
    }
}

class FacultyMember extends LibraryMember {
    public FacultyMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * 0.5;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Membership Type: Faculty");
    }
}

class GuestMember extends LibraryMember {
    public GuestMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * 5.0;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Membership Type: Guest");
    }
}

public class SmartLibraryMembershipSystem {
    public static void findAndDisplayMember(LibraryMember[] members, String targetId) {
        boolean found = false;
        for (LibraryMember m : members) {
            if (m.getMemberId().equalsIgnoreCase(targetId)) {
                System.out.println("--- Match Found ---");
                m.printDetails();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No member found with ID: " + targetId);
        }
    }

    public static void main(String[] args) {
        LibraryMember[] members = new LibraryMember[3];
        members[0] = new StudentMember("Aria Stark", "S101");
        members[1] = new FacultyMember("Dr. John Watson", "F202");
        members[2] = new GuestMember("Sherlock Holmes", "G303");

        System.out.println("--- All Members and Fine Calculation ---");
        int overdue = 10;
        for (LibraryMember m : members) {
            m.printDetails();
            System.out.println("Fine for " + overdue + " overdue days: $" + m.calculateFine(overdue));
            System.out.println("-----------------------------------");
        }

        System.out.println("\nSearching for member with ID S101:");
        findAndDisplayMember(members, "S101");

        System.out.println("\nSearching for member with ID F500:");
        findAndDisplayMember(members, "F500");
    }
}
