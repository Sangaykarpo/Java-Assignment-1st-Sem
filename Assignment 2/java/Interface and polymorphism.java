interface Device {
    void turnOn();
    void turnOff();
}

// Fan implements Device
class Fan implements Device {

    @Override
    public void turnOn() {
        System.out.println("Fan is turned ON.");
    }

    @Override
    public void turnOff() {
        System.out.println("Fan is turned OFF.");
    }
}

// Light implements Device
class Light implements Device {

    @Override
    public void turnOn() {
        System.out.println("Light is turned ON.");
    }

    @Override
    public void turnOff() {
        System.out.println("Light is turned OFF.");
    }
}

// Main class
public class Main {
    public static void main(String[] args) {

        // Polymorphism
        Device fan = new Fan();
        Device light = new Light();

        fan.turnOn();
        fan.turnOff();

        light.turnOn();
        light.turnOff();
    }
}