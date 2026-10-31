// Author class
class Author {
    private String name;
    private String email;
    private String gender;

    // Constructor
    Author(String name, String email, String gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    // toString()
    @Override
    public String toString() {
        return "Author Name: " + name +
               "\nEmail: " + email +
               "\nGender: " + gender;
    }
}

// Book class
class Book {
    private String title;
    private double price;
    private Author author;

    // Constructor
    Book(String title, double price, Author author) {
        this.title = title;
        this.price = price;
        this.author = author;
    }

    // toString()
    @Override
    public String toString() {
        return "Book Title: " + title +
               "\nPrice: " + price +
               "\n" + author;
    }
}

// Main class
public class Main {
    public static void main(String[] args) {

        // Create an Author
        Author author = new Author(
            "James Smith",
            "james@gmail.com",
            "Male"
        );

        // Create a Book with the Author
        Book book = new Book(
            "Java Programming",
            599.0,
            author
        );

        // Display book details
        System.out.println(book);
    }
}