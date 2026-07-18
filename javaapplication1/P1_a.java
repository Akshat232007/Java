/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author IT-14
 */
class Product {
    private String name;
    private double price;
    private String category;
    private static String marketplaceName = "MegaCart";

    public Product() {
        this.name = "Unknown Product";
        this.price = 0.0;
        this.category = "General";
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.category = "General";
    }

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public double calculateDiscountedPrice(int percentageDiscount) {
        double discountAmount = this.price * (percentageDiscount / 100.0);
        return this.price - discountAmount;
    }

    public double calculateDiscountedPrice(double flatDiscount) {
        if (flatDiscount > this.price) {
            return 0.0;
        }
        return this.price - flatDiscount;
    }

    public static void displayMarketplaceInfo() {
        System.out.println("Welcome to " + marketplaceName + " Official Inventory System.");
    }

    public void displayDetails() {
        System.out.println("Product: " + name + " | Category: " + category + " | Base Price: $" + price);
    }
}

public class P1_a {
    public static void main(String[] args) {
        Product.displayMarketplaceInfo();
        System.out.println("----------------------------------------------");

        Product prod1 = new Product(); 
        Product prod2 = new Product("Wireless Mouse", 25.0);
        Product prod3 = new Product("Gaming Laptop", 1200.0, "Electronics");

        prod1.displayDetails();
        prod2.displayDetails();
        prod3.displayDetails();
        System.out.println("----------------------------------------------");

        System.out.println("Laptop price after 10% discount: $" + prod3.calculateDiscountedPrice(10));
        System.out.println("Laptop price after $150 flat discount: $" + prod3.calculateDiscountedPrice(150.0));
    }
}