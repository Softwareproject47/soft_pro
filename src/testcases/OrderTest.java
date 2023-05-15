package testcases;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import model.Customer;
import model.Order;
import model.Product;

public class OrderTest {

    @Test
    public void testGetId() {
        Customer customer = new Customer(1, "John Smith", "123 Main St", "555-1234", "john.smith@email.com");
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1, "Carpet Cleaning", 50.0));
        Order order = new Order(1, customer, products);
        assertEquals(1, order.getId());
    }

    @Test
    public void testGetCustomer() {
        Customer customer = new Customer(1, "John Smith", "123 Main St", "555-1234", "john.smith@email.com");
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1, "Carpet Cleaning", 50.0));
        Order order = new Order(1, customer, products);
        assertEquals(customer, order.getCustomer());
    }

    @Test
    public void testGetProducts() {
        Customer customer = new Customer(1, "John Smith", "123 Main St", "555-1234", "john.smith@email.com");
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1, "Carpet Cleaning", 50.0));
        Order order = new Order(1, customer, products);
        assertEquals(products, order.getProducts());
    }

    @Test
    public void testGetTotalPrice() {
        Customer customer = new Customer(1, "John Smith", "123 Main St", "555-1234", "john.smith@email.com");
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1, "Carpet Cleaning", 50.0));
        products.add(new Product(2, "Window Cleaning", 25.0));
        Order order = new Order(1, customer, products);
        assertEquals(75.0, order.calculateTotalPrice(), 0.01);
    }

    @Test
    public void testIsComplete() {
        Customer customer = new Customer(1, "John Smith", "123 Main St", "555-1234", "john.smith@email.com");
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1, "Carpet Cleaning", 50.0));
        Order order = new Order(1, customer, products);
        assertFalse
        (order.isComplete());
    }
    
    @Test
    public void testSetComplete() {
        Customer customer = new Customer(1, "John Smith", "123 Main St", "555-1234", "john.smith@email.com");
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1, "Carpet Cleaning", 50.0));
        Order order = new Order(1, customer, products);
        order.setComplete(true);
        assertTrue(order.isComplete());
    }

    @Test
    public void testCalculateTotalPrice() {
        Customer customer = new Customer(1, "John Smith", "123 Main St", "555-1234", "john.smith@email.com");
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1, "Carpet Cleaning", 50.0));
        products.add(new Product(2, "Window Cleaning", 25.0));
        Order order = new Order(1, customer, products);
        assertEquals(75.0, order.calculateTotalPrice(), 0.01);
    }

    @Test
    public void testDisplayOrderDetails() {
        Customer customer = new Customer(1, "John Smith", "123 Main St", "555-1234", "john.smith@email.com");
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1, "Carpet Cleaning", 50.0));
        products.add(new Product(2, "Window Cleaning", 25.0));
        Order order = new Order(1, customer, products);
        order.setComplete(true);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        order.displayOrderDetails();
        String expectedOutput = "Order #1\nCustomer: John Smith\nProducts:\n- Carpet Cleaning ($50.0)\n- Window Cleaning ($25.0)\nTotal Price: $75.0\nStatus: Complete\n";
       // assertEquals(expectedOutput, outContent.toString());
    }
}
