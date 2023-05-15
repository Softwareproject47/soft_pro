package model;

public class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public void displayProductDetails() {
        System.out.println("Product #" + this.id);
        System.out.println("Product Name: " + this.name);
        System.out.println("Product Price: " + this.price);
        System.out.println("=======================");

    }
}

