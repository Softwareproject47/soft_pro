package model;

import java.util.List;

public class Order {
    private int id;
    private Customer customer;
    private List<Product> products;
    private boolean complete;
    private Worker assignedWorker;

    public Order(int id, Customer customer, List<Product> products) {
        this.id = id;
        this.customer = customer;
        this.products = products;
        this.complete = false;
    }

    public int getId() {
        return this.id;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public boolean isComplete() {
        return this.complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
        if (complete) {
            System.out.println("Order #" + this.id + " is complete. Thank you for your business, " + this.customer.getName() + "!");
        }
    }

    public double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (Product product : this.products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    public void displayOrderDetails() {
        System.out.println("Order #" + this.id);
        System.out.println("Customer: " + this.customer.getName());
        System.out.println("Products:");
        for (Product product : this.products) {
            System.out.println("- " + product.getName() + " ($" + product.getPrice() + ")");
        }
        System.out.println("Total Price: $" + this.calculateTotalPrice());
        if (this.assignedWorker != null) {
            System.out.println("Assigned Worker: " + this.assignedWorker.getName());
        }
        System.out.println("Status: " + (this.complete ? "Complete" : "Incomplete"));
        System.out.println("=======================");

    }

    public void setAssignedWorker(Worker worker) {
        this.assignedWorker = worker;
    }

    public Worker getAssignedWorker() {
        return this.assignedWorker;
    }
}
