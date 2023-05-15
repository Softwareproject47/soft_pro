package model;

public class Invoice {
    private int id;
    private Order order;
    private double discount;
    private double total;

    public Invoice(int id, Order order) {
        this.id = id;
        this.order = order;
        this.discount = 0.0;
        this.total = this.calculateTotal();
    }

    public int getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
        this.total = this.calculateTotal();
    }

    public double getTotal() {
        return total;
    }

    public double calculateTotal() {
        double totalPrice = order.calculateTotalPrice();
        double discountAmount = 0.0;
        if (totalPrice > 100.0) {
            discountAmount = totalPrice * 0.1;
            this.discount = discountAmount;
        }
        return totalPrice - this.discount;
    }
    
    public void displayDetails() {
         System.out.println("=============================================");
         System.out.println("                  INVOICE                    ");
         System.out.println("=============================================");

         System.out.println("Order ID: " + order.getId());
         System.out.println("Customer: " + order.getCustomer().getName());
         if (order.getAssignedWorker() != null) {
        	 System.out.println("Worker: " + order.getAssignedWorker().getName());
         }

         System.out.println("Products:");
         for (Product product : order.getProducts()) {
             System.out.println("- " + product.getName() + ": $" + product.getPrice());
         }

         System.out.println("Total price: $" + (total + discount));

         if (discount > 0) {
             System.out.println("Discount: $" + discount);
         }

         double finalPrice = calculateTotal();
         System.out.println("Final price: $" + finalPrice);
         
    }
}
