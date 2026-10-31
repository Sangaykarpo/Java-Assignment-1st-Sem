// Course class
class Course {
    private String courseName;
    private int duration;

    // Constructor
    Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Course: " + courseName +
               "\nDuration: " + duration + " months";
    }
}

// Student class
class Student {
    protected String name;
    protected Course enrolledCourse;

    // Constructor
    Student(String name, Course enrolledCourse) {
        this.name = name;
        this.enrolledCourse = enrolledCourse;
    }

    @Override
    public String toString() {
        return "Student: " + name +
               "\n" + enrolledCourse;
    }
}

// PremiumStudent inherits Student
class PremiumStudent extends Student {
    private double discount;

    // Constructor
    PremiumStudent(String name, Course enrolledCourse, double discount) {
        super(name, enrolledCourse);
        this.discount = discount;
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nPremium Discount: " + discount + "%";
    }
}

// Main class
public class Main {
    public static void main(String[] args) {

        // Create a Course
        Course course = new Course(
            "Java Programming",
            6
        );

        // Normal Student
        Student student = new Student(
            "Karma",
            course
        );

        // Premium Student
        PremiumStudent premiumStudent = new PremiumStudent(
            "Sangay",
            course,
            20
        );

        System.out.println("Normal Student:");
        System.out.println(student);

        System.out.println("\nPremium Student:");
        System.out.println(premiumStudent);
    }
}