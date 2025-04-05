package main.najah.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Test Suite for all unit tests in the main.najah.code package
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    CalculatorTest.class, 
    ProductTest.class, 
    UserServiceSimpleTest.class, 
    RecipeBookTest.class
})
public class TestSuite {
    // This class runs all the test classes in the specified list
}
