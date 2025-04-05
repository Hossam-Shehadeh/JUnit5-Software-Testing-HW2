package main.najah.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.najah.code.Product;

public class ProductTest {
    Product product;

    // This method runs before each test, initializing the Product object
    @BeforeEach
    void setUp() {
        product = new Product("Laptop", 1000.00);
    }

    // Test case for checking the product initialization
    @Test
    void testProductInitialization() {
        assertNotNull(product, "Product should be initialized");
        assertEquals("Laptop", product.getName(), "Product name should match");
        assertEquals(1000.00, product.getPrice(), "Product price should match");
    }

    // Test case for applying a valid discount
    @Test
    void testApplyDiscountValid() {
        product.applyDiscount(10);  // Apply 10% discount
        assertEquals(900.00, product.getFinalPrice(), "Price should be 900 after 10% discount");

        product.applyDiscount(50);  // Apply 50% discount
        assertEquals(500.00, product.getFinalPrice(), "Price should be 500 after 50% discount");
    }

    // Test case for applying an invalid discount (greater than 50%)
    @Test
    void testApplyDiscountInvalid() {
        assertThrows(IllegalArgumentException.class, () -> product.applyDiscount(60),
                "Discount greater than 50% should throw an exception");
    }

    // Test case for applying an invalid discount (negative value)
    @Test
    void testApplyDiscountNegative() {
        assertThrows(IllegalArgumentException.class, () -> product.applyDiscount(-10),
                "Negative discount should throw an exception");
    }

    // Test case to check the final price calculation after applying a discount
    @Test
    void testFinalPriceAfterDiscount() {
        product.applyDiscount(20);
        assertEquals(800.00, product.getFinalPrice(), "Final price should be 800 after 20% discount");
    }

    // Test case for product with zero price
    @Test
    void testZeroPriceProduct() {
        product = new Product("Free Product", 0);
        assertEquals(0.00, product.getFinalPrice(), "Product with price 0 should return a final price of 0");
    }

    // Test case for initializing product with negative price
    @Test
    void testNegativePriceProduct() {
        assertThrows(IllegalArgumentException.class, () -> new Product("Invalid Product", -100),
                "Product with negative price should throw an exception");
    }

    // Intentionally failing test to demonstrate how to disable it
    @Test
    @org.junit.jupiter.api.Disabled("This test is failing intentionally. The discount calculation method is incorrect.")
    void testFailingDiscountCalculation() {
        product.applyDiscount(50);
        assertEquals(600.00, product.getFinalPrice(), "Discount calculation is intentionally incorrect, this test will fail.");
    }
}
