import java.util.ArrayList;
import java.util.List;

// Professor class
class Professor {
    // Private attributes
    private String name;
    private String employeeId;
    private String specialization;

    // Default constructor
    public Professor() {
    }

    // Parameterized constructor
    public Professor(String name, String employeeId, String specialization) {
        this.name = name;
        this.employeeId = employeeId;
        this.specialization = specialization;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    // toString()
    @Override
    public String toString() {
        return "Professor Name: " + name +
               ", Employee ID: " + employeeId +
               ", Specialization: " + specialization;
    }
}


// Department class
class Department {
    // Private attributes
    private String deptName;
    private String hodName;
    private List<Professor> professors;

    // Default constructor
    public Department() {
        professors = new ArrayList<>();
    }

    // Parameterized constructor
    public Department(String deptName, String hodName) {
        this.deptName = deptName;
        this.hodName = hodName;
        this.professors = new ArrayList<>();
    }

    // Getters and Setters
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getHodName() {
        return hodName;
    }

    public void setHodName(String hodName) {
        this.hodName = hodName;
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
    }

    // Add professor
    public void addProfessor(Professor p) {
        professors.add(p);
    }

    // toString()
    @Override
    public String toString() {
        return "Department: " + deptName +
               "\nHOD: " + hodName +
               "\nProfessors: " + professors;
    }
}


// Main class
public class Main {
    public static void main(String[] args) {

        // Create Department
        Department dept = new Department(
                "Computer Science",
                "Dr. Sharma"
        );

        // Create Professors
        Professor p1 = new Professor(
                "Dr. Amit Kumar",
                "P101",
                "Data Science"
        );

        Professor p2 = new Professor(
                "Dr. Priya Singh",
                "P102",
                "Database Management"
        );

        Professor p3 = new Professor(
                "Dr. Rahul Verma",
                "P103",
                "Artificial Intelligence"
        );

        // Add professors to department
        dept.addProfessor(p1);
        dept.addProfessor(p2);
        dept.addProfessor(p3);

        // Display department details
        System.out.println(dept);
    }
}