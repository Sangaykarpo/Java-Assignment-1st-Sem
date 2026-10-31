import java.util.ArrayList;
import java.util.List;

// Guest class
class Guest {
    private String name;
    private int age;
    private String idProof;

    // Constructor
    Guest(String name, int age, String idProof) {
        this.name = name;
        this.age = age;
        this.idProof = idProof;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getIdProof() {
        return idProof;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setIdProof(String idProof) {
        this.idProof = idProof;
    }

    @Override
    public String toString() {
        return "Name: " + name +
               ", Age: " + age +
               ", ID Proof: " + idProof;
    }
}

// Reservation class
class Reservation {
    private int reservationId;
    private String roomType;
    private List<Guest> guests;

    // Constructor
    Reservation(int reservationId, String roomType) {
        this.reservationId = reservationId;
        this.roomType = roomType;
        this.guests = new ArrayList<>();
    }

    // Add guest
    public void addGuest(Guest guest) {
        guests.add(guest);
    }

    // Getters
    public int getReservationId() {
        return reservationId;
    }

    public String getRoomType() {
        return roomType;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    // Setters
    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    @Override
    public String toString() {
        String result = "Reservation ID: " + reservationId +
                        "\nRoom Type: " + roomType +
                        "\nGuests:\n";

        for (Guest guest : guests) {
            result += guest + "\n";
        }

        return result;
    }
}

// Main class
public class Main {
    public static void main(String[] args) {

        Guest guest1 = new Guest(
            "Sangay",
            25,
            "Passport"
        );

        Guest guest2 = new Guest(
            "Karma",
            28,
            "Citizenship Card"
        );

        Guest guest3 = new Guest(
            "Pema",
            30,
            "Passport"
        );

        Reservation reservation = new Reservation(
            1001,
            "Deluxe"
        );

        // Add multiple guests to one reservation
        reservation.addGuest(guest1);
        reservation.addGuest(guest2);
        reservation.addGuest(guest3);

        System.out.println(reservation);
    }
}