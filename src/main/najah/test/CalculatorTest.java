package main.najah.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Disabled;

import main.najah.code.Calculator;

import java.util.concurrent.TimeUnit;

@DisplayName("Calculator Tests")
public class CalculatorTest {
	
    Calculator calc;

    // This method is executed before each test to initialize the Calculator instance.
    @BeforeEach
    void setUp() {
        calc = new Calculator();
    }

    @Test
    @DisplayName("Test Addition with Positive Numbers")
    @Order(1)
    void testAddPositiveNumbers() {
        assertEquals(5, calc.add(2, 3), "2 + 3 should equal 5");
    }

    @Test
    @DisplayName("Test Addition with Negative and Positive Numbers")
    @Order(2)
    void testAddNegativeAndPositive() {
        assertEquals(1, calc.add(-2, 3), "-2 + 3 should equal 1");
    }


    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    @DisplayName("Test Timeout for a Simple Test")
    void testTimeout() throws InterruptedException {
        // Simulate a long-running task
        Thread.sleep(1000); // This should pass as the timeout is set to 2 seconds
    }

    @Test
    @DisplayName("Test Division")
    @Order(3)
    void testDivide() {
        assertEquals(2, calc.divide(10, 5), "10 / 5 should equal 2");
    }

    @Test
    @DisplayName("Test Division by Zero")
    @Order(4)
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calc.divide(10, 0), "Cannot divide by zero");
    }

    @Test
    @DisplayName("Test Factorial of Positive Number")
    @Order(5)
    void testFactorialPositive() {
        assertEquals(120, calc.factorial(5), "Factorial of 5 should be 120");
    }

    @Test
    @DisplayName("Test Factorial of Zero")
    @Order(6)
    void testFactorialZero() {
        assertEquals(1, calc.factorial(0), "Factorial of 0 should be 1");
    }

    @Test
    @DisplayName("Test Factorial of Negative Number")
    @Order(7)
    void testFactorialNegative() {
        assertThrows(IllegalArgumentException.class, () -> calc.factorial(-5), "Negative input should throw IllegalArgumentException");
    }

   
}
