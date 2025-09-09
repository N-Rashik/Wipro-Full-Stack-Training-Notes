package com.wipro;

// Interface
interface Discountable {
    double getDiscount();  // Only the method, no implementation
}

// Base class
class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

// Child class with unique variable + hybrid inheritance
class Cloth extends Product implements Discountable {
    String clothType;  // Unique variable

    Cloth(String name, double price, String clothType) {
        super(name, price);  // Call constructor of Product
        this.clothType = clothType;
    }

    // Implementing method from Discountable
    public double getDiscount() {
        return price * 0.15;  // 15% discount
    }

    public void showDetails() {
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Cloth Type: " + clothType);
        System.out.println("Discount: " + getDiscount());
    }
}

// Main class
public class HierarchialInheritance {
    public static void main(String[] args) {
        Cloth c = new Cloth("Raymond", 2000, "Cotton");
        c.showDetails();
    }
}
