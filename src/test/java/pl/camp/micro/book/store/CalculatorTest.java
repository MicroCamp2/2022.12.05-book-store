package pl.camp.micro.book.store;

import org.junit.jupiter.api.*;

public class CalculatorTest {

    private final static Calculator calculator = new Calculator();

    public CalculatorTest() {
        System.out.println("Konstruktor klaksy testujacej");
    }

    @BeforeAll
    public static void prepareForAll() {
        System.out.println("przygotowanie przed wszystkimi testami !!");
    }

    @AfterAll
    public static void cleanAfterAll() {
        System.out.println("sprzatanie po wszystkich testach !!");
    }

    @BeforeEach
    public void prepare() {
        System.out.println("przygotowanie !!!");
    }

    @AfterEach
    public void clean() {
        System.out.println("sprzatanie !!!");
    }

    @Test
    void addTwoPositivesTest() {
        int a = 6;
        int b = 8;
        int expectedResult = 14;

        int actual = calculator.add(a, b);

        Assertions.assertEquals(expectedResult, actual);
    }

    @Test
    void addTwoNegativesTest() {
        int a = -6;
        int b = -8;
        int expectedResult = -14;

        int actual = calculator.add(a, b);

        Assertions.assertEquals(expectedResult, actual);
    }

    @Test
    void addNegativeAndPositiveTest() {
        int a = -6;
        int b = 8;
        int expectedResult = 2;

        int actual = calculator.add(a, b);

        Assertions.assertEquals(expectedResult, actual);
    }

    @Test
    void addZerosTest() {
        int a = 0;
        int b = 0;
        int expectedResult = 0;

        int actual = calculator.add(a, b);

        Assertions.assertEquals(expectedResult, actual);
    }

    @Test
    void addTwoZerosNegativeCaseTest() {
        int a = 0;
        int b = 0;
        int notExpectedResult = 3;

        int actual = calculator.add(a, b);

        Assertions.assertNotEquals(notExpectedResult, actual);
    }

    @Test
    void divideTwoPositivesTest() {
        int a = 6;
        int b = 3;
        int expectedResult = 2;

        double actual = calculator.divide(a, b);

        Assertions.assertEquals(expectedResult, actual);
    }

    @Test
    void divideTwoPositivesWithDecimalResultTest() {
        int a = 7;
        int b = 2;
        double expectedResult = 3.5;

        double actual = calculator.divide(a, b);

        Assertions.assertEquals(expectedResult, actual, 0.001);
    }

    @Test
    void divideByZeroTest() {
        int a = 7;
        int b = 0;

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> calculator.divide(a, b)
        );
    }
}
