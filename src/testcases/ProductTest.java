package testcases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Product;

public class ProductTest {

	@Test
	public void testGetId() {
		Product product = new Product(1, "Carpet Cleaning", 50.0);
		assertEquals(1, product.getId());
	}

	@Test
	public void testGetName() {
		Product product = new Product(1, "Carpet Cleaning", 50.0);
		assertEquals("Carpet Cleaning", product.getName());
	}
	
	@Test
	public void testGetPrice() {
		Product product = new Product(1, "Carpet Cleaning", 50.0);
		assertEquals(50.0, product.getPrice(), 0.01);
	}

	@Test
	public void testSetPrice() {
		Product product = new Product(1, "Carpet Cleaning", 50.0);
		product.setPrice(60.0);
		assertEquals(60.0, product.getPrice(), 0.01);
	}
}