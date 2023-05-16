package testcases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import model.Customer;
import model.Invoice;
import model.Order;
import model.Product;

public class InvoiceTest {


    public void testInvoiceCreation() {
        Customer customer = new Customer(1, "John Doe", "123 Main St", "555-1234", "john@example.com");
        Product product1 = new Product(1, "Carpet Cleaning", 50.0);
        Product product2 = new Product(2, "Window Cleaning", 25.0);
        Order order = new Order(1, customer, Arrays.asList(product1, product2));
        Invoice invoice = new Invoice(1, order);
        assertEquals(1, invoice.getId());
        assertEquals(order, invoice.getOrder());
        assertEquals(0.0, invoice.getDiscount());
        assertEquals(75.0, invoice.getTotal());

    public void testInvoiceWithDiscount() {
        Customer customer = new Customer(1, "Jane Smith", "456 Elm St", "555-5678", "jane@example.com");
        Product product1 = new Product(1, "Carpet Cleaning", 60.0);
        Product product2 = new Product(2, "Window Cleaning", 30.0);
        Order order = new Order(2, customer, Arrays.asList(product1, product2));
        Invoice invoice = new Invoice(2, order);
        invoice.setDiscount(5.0);
        assertEquals(2, invoice.getId());
        assertEquals(order, invoice.getOrder());
        assertEquals(5.0, invoice.getDiscount());
        assertEquals(80.0, invoice.getTotal() - invoice.getDiscount());
    }


    public void testInvoiceWithLargeDiscount() {
        Customer customer = new Customer(1, "Bob Johnson", "789 Oak St", "555-9012", "bob@example.com");
        Product product1 = new Product(1, "Carpet Cleaning", 120.0);
        Product product2 = new Product(2, "Window Cleaning", 60.0);
        Order order = new Order(3, customer, Arrays.asList(product1, product2));
        Invoice invoice = new Invoice(3, order);
        assertEquals(3, invoice.getId());
        assertEquals(order, invoice.getOrder());
        assertEquals(18.0, invoice.getDiscount());
        assertEquals(162.0, invoice.calculateTotal());
    }
}