abstract class Flight {

    private String flightNumber;
    private String airline;
    private double fare;

    // Constructor
    public Flight(String flightNumber, String airline, double fare) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.fare = fare;
    }

    // Getters
    public String getFlightNumber() {
        return flightNumber;
    }

    public String getAirline() {
        return airline;
    }

    public double getFare() {
        return fare;
    }

    // Abstract method
    public abstract double calculateFare();

    // toString()
    @Override
    public String toString() {
        return "Flight Number: " + flightNumber +
               ", Airline: " + airline +
               ", Final Fare: " + calculateFare();
    }
}


// Domestic Flight
class DomesticFlight extends Flight {

    public DomesticFlight(String flightNumber, String airline, double fare) {
        super(flightNumber, airline, fare);
    }

    @Override
    public double calculateFare() {
        return getFare() + (getFare() * 0.10);
    }
}


// International Flight
class InternationalFlight extends Flight {

    public InternationalFlight(String flightNumber, String airline, double fare) {
        super(flightNumber, airline, fare);
    }

    @Override
    public double calculateFare() {
        return getFare() + (getFare() * 0.25);
    }
}


// Main class
public class Main {

    public static void main(String[] args) {

        DomesticFlight domestic = new DomesticFlight(
            "AI101",
            "Air India",
            5000
        );

        InternationalFlight international = new InternationalFlight(
            "AI202",
            "Air India",
            20000
        );

        System.out.println(domestic);
        System.out.println(international);
    }
}