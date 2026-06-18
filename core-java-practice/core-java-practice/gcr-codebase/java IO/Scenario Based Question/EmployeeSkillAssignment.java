import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

class Employee implements Serializable {
    int employeeId;
    String name;
    String department;
    double salary;

    public Employee(int employeeId, String name, String department, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    
    @Override
    public String toString() {
        return employeeId + " " + name + " " + department + " " + salary;
    }
}

public class EmployeeSkillAssignment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int id = Integer.parseInt(scanner.nextLine());
            String name = scanner.nextLine();
            String dept = scanner.nextLine();
            double salary = Double.parseDouble(scanner.nextLine());
            
            Employee emp = new Employee(id, name, dept, salary);
            
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.ser"));
            out.writeObject(emp);
            out.close();
            
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee.ser"));
            Employee recovered = (Employee) in.readObject();
            in.close();
            
            System.out.println(recovered);
        } catch (IOException | ClassNotFoundException | NumberFormatException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
