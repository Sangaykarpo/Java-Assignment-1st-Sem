class Employee {
    String name;
    int id;
    double basicSalary;

    // Default constructor
    Employee() {
        name = "Unknown";
        id = 0;
        basicSalary = 0.0;
    }

    // Parameterized constructor
    Employee(String name, int id, double basicSalary) {
        this.name = name;
        this.id = id;
        this.basicSalary = basicSalary;
    }

    // Calculate salary
    double calculateSalary() {
        return basicSalary;
    }

    // Override toString()
    @Override
    public String toString() {
        return "Employee Name: " + name +
               "\nEmployee ID: " + id +
               "\nSalary: " + calculateSalary();
    }
}

// Manager inherits Employee
class Manager extends Employee {
    double bonus;

    // Constructor chaining using super()
    Manager(String name, int id, double basicSalary, double bonus) {
        super(name, id, basicSalary);
        this.bonus = bonus;
    }

    // Method overriding
    @Override
    double calculateSalary() {
        return basicSalary + bonus;
    }

    @Override
    public String toString() {
        return "Manager Name: " + name +
               "\nManager ID: " + id +
               "\nBasic Salary: " + basicSalary +
               "\nBonus: " + bonus +
               "\nTotal Salary: " + calculateSalary();
    }
}

// Main class
public class Main {
    public static void main(String[] args) {

        Employee emp = new Employee("Sangay", 101, 40000);

        Manager manager = new Manager("Karma", 102, 60000, 15000);

        System.out.println("Employee Details:");
        System.out.println(emp);

        System.out.println("\nManager Details:");
        System.out.println(manager);
    }
}