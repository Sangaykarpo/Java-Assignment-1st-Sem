class Room {
    private int roomNumber;
    private String block;
    private String type;

    // Constructor
    Room(int roomNumber, String block, String type) {
        this.roomNumber = roomNumber;
        this.block = block;
        this.type = type;
    }

    // Getters
    public int getRoomNumber() {
        return roomNumber;
    }

    public String getBlock() {
        return block;
    }

    public String getType() {
        return type;
    }

    // Setters
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Room Number: " + roomNumber +
               "\nBlock: " + block +
               "\nType: " + type;
    }
}

// Student class
class Student {
    private String name;
    private int roll;
    private String course;
    private Room room;

    // Constructor
    Student(String name, int roll, String course, Room room) {
        this.name = name;
        this.roll = roll;
        this.course = course;
        this.room = room;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getRoll() {
        return roll;
    }

    public String getCourse() {
        return course;
    }

    public Room getRoom() {
        return room;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    // toString()
    @Override
    public String toString() {
        return "Student Name: " + name +
               "\nRoll Number: " + roll +
               "\nCourse: " + course +
               "\n" + room;
    }
}

// Main class
public class Main {
    public static void main(String[] args) {

        // Create a room
        Room room = new Room(
            101,
            "Block A",
            "Single"
        );

        // Assign the room to one student
        Student student = new Student(
            "Sangay",
            101,
            "MCA Data Science",
            room
        );

        // Display student details
        System.out.println(student);
    }
}