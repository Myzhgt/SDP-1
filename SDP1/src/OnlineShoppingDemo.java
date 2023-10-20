import java.util.Scanner;

public class OnlineShoppingDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);

        // Add products to the cart
        System.out.println("Welcome to the Online Shopping Cart!");
        while (true) {
            System.out.println("Enter product name (or 'checkout' to complete the purchase):");
            String productName = scanner.nextLine();

            if ("checkout".equalsIgnoreCase(productName)) {
                break;
            }

            System.out.println("Enter the price of the product:");
            double price = Double.parseDouble(scanner.nextLine());

            System.out.println("Enter the quantity of the product:");
            int quantity = Integer.parseInt(scanner.nextLine());

            Product product = new Product(productName, price, quantity);
            cart.addProduct(product);
        }

        // Choose a payment strategy
        PaymentStrategy paymentStrategy = null;
        while (paymentStrategy == null) {
            System.out.println("Select a payment method (1 for Credit Card, 2 for PayPal):");
            int paymentChoice = Integer.parseInt(scanner.nextLine());

            if (paymentChoice == 1) {
                System.out.println("Enter credit card number:");
                String cardNumber = scanner.nextLine();
                System.out.println("Enter cardholder's name:");
                String cardName = scanner.nextLine();
                paymentStrategy = new CreditCardPayment(cardNumber, cardName);
            } else if (paymentChoice == 2) {
                System.out.println("Enter your PayPal email address:");
                String email = scanner.nextLine();
                paymentStrategy = new PayPalPayment(email);
            } else {
                System.out.println("Invalid choice. Please select a valid payment method.");
            }
        }

        // Complete the checkout using the selected payment strategy
        double total = cart.calculateTotalPrice();
        cart.checkout(paymentStrategy);
        System.out.println("Total amount paid: $" + total);

        scanner.close();
    }
}
