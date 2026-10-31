class Passport {
    private String passportNo;
    private String issueDate;
    private String expiryDate;

    // Constructor
    Passport(String passportNo, String issueDate, String expiryDate) {
        this.passportNo = passportNo;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
    }

    // Getters
    public String getPassportNo() {
        return passportNo;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    // Setters
    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "Passport Number: " + passportNo +
               "\nIssue Date: " + issueDate +
               "\nExpiry Date: " + expiryDate;
    }
}

// Citizen class
class Citizen {
    private String name;
    private String dob;
    private String address;
    private Passport passport;

    // Constructor
    Citizen(String name, String dob, String address, Passport passport) {
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.passport = passport;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public Passport getPassport() {
        return passport;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    // toString()
    @Override
    public String toString() {
        return "Citizen Name: " + name +
               "\nDate of Birth: " + dob +
               "\nAddress: " + address +
               "\n" + passport;
    }
}

// Main class
public class Main {
    public static void main(String[] args) {

        // Create one passport
        Passport passport = new Passport(
            "P1234567",
            "01-01-2025",
            "01-01-2035"
        );

        // Assign passport to one citizen
        Citizen citizen = new Citizen(
            "Sangay",
            "15-05-1995",
            "Thimphu",
            passport
        );

        // Display citizen details
        System.out.println(citizen);
    }
}