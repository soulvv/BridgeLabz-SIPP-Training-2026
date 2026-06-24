class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return "Person[Name=" + name + ", Age=" + age + "]";
    }
}

class Student extends Person {
    private final String studentId;
    private double gpa;

    public Student(String name, int age, String studentId, double gpa) {
        super(name, age);
        this.studentId = studentId;
        this.gpa = gpa;
    }

    public String getStudentId() { return studentId; }
    public double getGpa() { return gpa; }

    @Override
    public String toString() {
        return "Student[" + super.toString() + ", StudentID=" + studentId + ", GPA=" + gpa + "]";
    }
}

class GradStudent extends Student {
    private String thesisTitle;

    public GradStudent(String name, int age, String studentId, double gpa, String thesisTitle) {
        super(name, age, studentId, gpa);
        this.thesisTitle = thesisTitle;
    }

    public String getThesisTitle() { return thesisTitle; }

    @Override
    public String toString() {
        return "GradStudent[" + super.toString() + ", Thesis=" + thesisTitle + "]";
    }
}

public class UniversitySystem {
    public static void main(String[] args) {
        GradStudent gradStudent = new GradStudent("Alice", 25, "S12345", 3.8, "Quantum Computing Applications");
        
        System.out.println("--- Demonstrating IS-A Relationship ---");
        System.out.println("Is GradStudent a Student? " + (gradStudent instanceof Student));
        System.out.println("Is GradStudent a Person? " + (gradStudent instanceof Person));
        
        System.out.println("\n--- Displaying toString() overrrides ---");
        System.out.println(gradStudent.toString());
    }
}
