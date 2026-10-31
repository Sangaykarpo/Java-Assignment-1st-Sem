// Person class
class Person {
    protected String name;
    protected int age;

    // Constructor
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name: " + name +
               "\nAge: " + age;
    }
}

// Doctor extends Person
class Doctor extends Person {
    protected String specialization;

    // Constructor
    Doctor(String name, int age, String specialization) {
        super(name, age);
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nSpecialization: " + specialization;
    }
}

// Surgeon extends Doctor
class Surgeon extends Doctor {
    private String surgeryType;

    // Constructor
    Surgeon(String name, int age, String specialization,
            String surgeryType) {
        super(name, age, specialization);
        this.surgeryType = surgeryType;
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nSurgery Type: " + surgeryType;
    }
}

// Main class
public class Main {
    public static void main(String[] args) {

        Surgeon surgeon = new Surgeon(
            "Dr. Karma",
            45,
            "Cardiology",
            "Open Heart Surgery"
        );

        System.out.println(surgeon);
    }
}