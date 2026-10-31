class Vehicle {
    protected String regNo;
    protected String brand;
    protected double baseRate;

    // Constructor
    Vehicle(String regNo, String brand, double baseRate) {
        this.regNo = regNo;
        this.brand = brand;
        this.baseRate = baseRate;
    }

    // Method to be overridden
    double calculateRate() {
        return baseRate;
    }

    @Override
    public String toString() {
        return "Registration No: " + regNo +
               "\nBrand: " + brand +
               "\nRental Rate: " + calculateRate();
    }
}

// Car class
class Car extends Vehicle {

    Car(String regNo, String brand, double baseRate) {
        super(regNo, brand, baseRate);
    }

    @Override
    double calculateRate() {
        return baseRate * 1.5;
    }
}

// Bike class
class Bike extends Vehicle {

    Bike(String regNo, String brand, double baseRate) {
        super(regNo, brand, baseRate);
    }

    @Override
    double calculateRate() {
        return baseRate * 1.2;
    }
}

// Main class
public class Main {
    public static void main(String[] args) {

        Vehicle car = new Car(
            "CAR101",
            "Toyota",
            2000
        );

        Vehicle bike = new Bike(
            "BIKE101",
            "Honda",
            1000
        );

        System.out.println("Car Details:");
        System.out.println(car);

        System.out.println("\nBike Details:");
        System.out.println(bike);
    }
}