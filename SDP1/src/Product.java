import java.util.ArrayList;
import java.util.List;

// Product class
class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return price * quantity;
    }
}

// PaymentStrategy interface
interface PaymentStrategy {
    void processPayment(double amount);
}

// Concrete payment strategies
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String name;

    public CreditCardPayment(String cardNumber, String name) {
        this.cardNumber = cardNumber;
        this.name = name;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Paid $" + amount + " using credit card ending with " + cardNumber);
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Paid $" + amount + " using PayPal account " + email);
    }
}

// ShoppingCart class
class ShoppingCart {
    private List<Product> cartItems = new ArrayList<>();

    public void addProduct(Product product) {
        cartItems.add(product);
    }

    public double calculateTotalPrice() {
        double total = 0;
        for (Product product : cartItems) {
            total += product.getTotalPrice();
        }
        return total;
    }

    public void checkout(PaymentStrategy paymentStrategy) {
        double total = calculateTotalPrice();
        paymentStrategy.processPayment(total);
    }
}