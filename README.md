# JUnit5 Software Testing Homework Assignment #2

## Overview
This repository contains the solution for the **Software Testing and Quality Assurance** homework assignment for the second semester of 2024/2025. The tasks are focused on **JUnit 5** testing techniques for classes in the `main.najah.code` package. 

## Tasks Completed:
1. **Test Classes**: 
   - `CalculatorTest`
   - `ProductTest`
   - `UserServiceTest`
   - `RecipeBookTest`
   
2. **Test Features**:
   - Valid and invalid input tests.
   - Descriptive test names using `@DisplayName`.
   - Parameterized tests.
   - Timeout tests.
   - Multiple assertions in each test.
   
3. **Test Suite**: Created a test suite that runs all test classes together.
4. **Ordered Test Execution**: Demonstrated ordered test execution using `@Order` in `CalculatorTest`.
5. **Lifecycle Hooks**: Used `@BeforeAll`, `@AfterAll`, `@BeforeEach`, and `@AfterEach` in test classes.
6. **Intentionally Failing Test**: Included one failing test disabled with `@Disabled`.
7. **Test Coverage**: Measured test coverage using EclEmma, aiming for over 85%.
8. **Parallel Execution**: Enabled parallel test execution in JUnit 5.

## How to Run Tests:
1. Clone the repository.
2. Open the project in Eclipse IDE.
3. Run the tests using the JUnit test runner.

## Testing Strategy
- **Unit Tests**: For each class, both valid and invalid scenarios are tested.
- **Parameterized Tests**: A few test cases use parameters to verify functionality across multiple inputs.
- **Timeout Tests**: Some tests are executed with a time limit to check performance.
- **Assertions**: Multiple assertions are included in tests to check different aspects of the output.

## Tools Used:
- JUnit 5
- Eclipse IDE
- EclEmma (for test coverage)
- Git & GitHub for version control

---

## Contributing
Feel free to contribute by creating an issue or submitting a pull request. If you have suggestions for improvements, please submit them!


