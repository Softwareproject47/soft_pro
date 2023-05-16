package testcases;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import model.Customer;

public class CustomerTest {


    public void testGetId() {
        Customer customer = new Customer(1, "John Smith", "123 Main St", "555-1234", "john@example.com");
        assertEquals(1, customer.getId());
    }


    public void testGetName() {
        Customer customer = new Customer(1, "John Smith", "123 Main St", "555-1234", "john@example.com");
        assertEquals("John Smith", customer.getName());
    }


    public void testGetAddress() {
        Customer customer = new Customer(1, "John Smith", "123 Main St", "555-1234", "john@example.com");
        assertEquals("123 Main St", customer.getAddress());
    }


    public void testGetPhone() {
        Customer customer = new Customer(1, "John Smith", "123 Main St", "555-1234", "john@example.com");
        assertEquals("555-1234", customer.getPhone());
    }


    public void testGetEmail() {
        Customer customer = new Customer(1, "John Smith", "123 Main St", "555-1234", "john@example.com");
        assertEquals("john@example.com", customer.getEmail());
    }


    public void testSetEmail() {
        Customer customer = new Customer(1, "John Smith", "123 Main St", "555-1234", "john@example.com");
        customer.setEmail("john.smith@example.com");
        assertEquals("john.smith@example.com", customer.getEmail());
    }

}
