package ch.divtec;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void add() {
        Calculator calculator = new Calculator();
        assertEquals(3, calculator.add(1.0, 2.0));
    }
    @Test
    void addNegative() {
        Calculator calculator = new Calculator();
        assertEquals(1,calculator.add(-1.0, 2.0));
    }
    @Test
    void addZero() {
        Calculator calculator = new Calculator();
        assertEquals(0, calculator.add(0, 0));
    }
    @Test
    void addMax() {
        Calculator calculator = new Calculator();
        assertEquals(200000, calculator.add(150000, 50000));
    }

    @Test
    void subtract() {
        Calculator calculator = new Calculator();
        assertEquals(1, calculator.subtract(2, 1));
    }
    @Test
    void subtractNegative() {
        Calculator calculator = new Calculator();
        assertEquals(-3, calculator.subtract(-1, 2));
    }

    @Test
    void subtractZero() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.subtract(2, 0));
    }

    @Test
    void subtractMax() {
        Calculator calculator = new Calculator();
        assertEquals(50000, calculator.subtract(100000, 50000));
    }

    @Test
    void multiply() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.multiply(1, 2));
    }

    @Test
    void multiplyNegative() {
        Calculator calculator = new Calculator();
        assertEquals(-2, calculator.multiply(-1, 2));
    }

    @Test
    void multiplyZero() {
        Calculator calculator = new Calculator();
        assertEquals(0, calculator.multiply(0, 2));
    }

    @Test
    void multiplyFirstZero() {
        Calculator calculator = new Calculator();
        assertEquals(0, Math.abs(calculator.multiply(0.0, -12345.0)));
    }

    @Test
    void multiplyMax() {
        Calculator calculator = new Calculator();
        assertEquals(50000, calculator.multiply(100, 500));
    }

    @Test
    void divide() {
        Calculator calculator = new Calculator();
        assertEquals(0.5, calculator.divide(1, 2));
    }

    @Test
    void divideNegative() {
        Calculator calculator = new Calculator();
        assertEquals(-0.5, calculator.divide(-1, 2));
    }

    @Test
    void divideZero() {
        Calculator calculator = new Calculator();
        assertThrows(ArithmeticException.class, () -> calculator.divide(0, 0));
    }

    @Test
    void divideMax() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.divide(100000, 50000));
    }

    @Test
    void factorial() {
        Calculator calculator = new Calculator();
        long result = calculator.factorial(5.0);
        assertEquals(120, result);
    }

    @Test
    void factorialNotInteger() {
        Calculator calculator = new Calculator();

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> calculator.factorial(5.2));

        assertEquals("Le factoriel est défini uniquement pour les entiers.",
                exception.getMessage());
    }
}