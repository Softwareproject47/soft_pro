package testcases;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import model.Customer;

public class CustomerTest {

    @Test
    public void testGetId() {
        Customer customer = new Customer(1, "John Smith", "123 Main St", "555-1234", "john@example.com");
        assertEquals(1, customer.getId());
    }

    @Test
    public void testGetName() {
        Customer customer = new Customer(1, "John Smith", "123 Main St", "555-1234", "john@example.com");
        assertEquals("John Smith", customer.getName());
    }

    @Test
    public void testGetAddress() {
        Customer customer = new Customer(1, "John Smith", "123 Main St", "555-1234", "john@example.com");
        assertEquals("123 Main St", customer.getAddress());
    }

    @Test
    public void testGetPhone() {
        Customer customer = new Customer(1, "John Smith", "123 Main St", "555-1234", "john@example.com");
        assertEquals("555-1234", customer.getPhone());
    }

    @Test
    public void testGetEmail() {
        Customer customer = new Customer(1, "John Smith", "123 Main St", "555-1234", "john@example.com");
        assertEquals("john@example.com", customer.getEmail());
    }

    @Test
    public void testSetEmail() {
        Customer customer = new Customer(1, "John Smith", "123 Main St", "555-1234", "john@example.com");
        customer.setEmail("john.smith@example.com");
        assertEquals("john.smith@example.com", customer.getEmail());
    }

}
