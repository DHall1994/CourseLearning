package demo.Zlabs.Lab11;

public class ShoppingBasket {
    private String productName;
    private int quantity;
    private double price;

    // Constructor
    public ShoppingBasket(String productName, int quantity, double price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    // Method to display details
    public void displayDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price: $" + price);
        System.out.println();
    }
}