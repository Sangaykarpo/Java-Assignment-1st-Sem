import java.util.ArrayList;
import java.util.List;

// Product class
class Product {
    private String productName;
    private double price;
    private int quantity;

    // Constructor
    Product(String productName, double price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters
    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Setters
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // toString()
    @Override
    public String toString() {
        return productName + " x " + quantity +
               " = " + (price * quantity);
    }
}

// Order class
class Order {
    private int orderId;
    private List<Product> products;

    // Constructor
    Order(int orderId) {
        this.orderId = orderId;
        products = new ArrayList<>();
    }

    // Add product
    public void addProduct(Product product) {
        products.add(product);
    }

    // Calculate total
    public double calculateTotal() {
        double total = 0;

        for (Product product : products) {
            total += product.getPrice() * product.getQuantity();
        }

        return total;
    }

    // toString()
    @Override
    public String toString() {
        String result = "Order ID: " + orderId + "\n";
        result += "Products:\n";

        for (Product product : products) {
            result += product + "\n";
        }

        result += "Order Total: " + calculateTotal();

        return result;
    }
}

// Main class
public class Main {
    public static void main(String[] args) {

        // Products can exist independently
        Product p1 = new Product("Laptop", 50000, 1);
        Product p2 = new Product("Mouse", 1000, 2);
        Product p3 = new Product("Keyboard", 2000, 1);

        // Create an order
        Order order = new Order(101);

        // Add products to order
        order.addProduct(p1);
        order.addProduct(p2);
        order.addProduct(p3);

        // Display order summary
        System.out.println(order);
    }
}