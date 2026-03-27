package ch.divtec;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void add() {
        Calculator calculator = new Calculator();
        int result = calculator.add(1, 2);
        assertEquals(3, result);
    }
    @Test
    void addNegative() {
        Calculator calculator = new Calculator();
        int result = calculator.add(-1, 2);
    }
    @Test
    void addZero() {
        Calculator calculator = new Calculator();
        int result = calculator.add(0, 0);
        assertEquals(0, result);
    }
    @Test
    void addMax() {
        Calculator calculator = new Calculator();
        int result = calculator.add(150000, 50000);
        assertEquals(200000, result);
    }

    @Test
    void subtract() {
        Calculator calculator = new Calculator();
        int result = calculator.subtract(2, 1);
        assertEquals(1, result);
    }
    @Test
    void subtractNegative() {
        Calculator calculator = new Calculator();
        int result = calculator.subtract(-1, 2);
        assertEquals(-3, result);
    }

    @Test
    void subtractZero() {
        Calculator calculator = new Calculator();
        int result = calculator.subtract(2, 0);
        assertEquals(2, result);
    }

    @Test
    void subtractMax() {
        Calculator calculator = new Calculator();
        int result = calculator.subtract(100000, 50000);
        assertEquals(50000, result);
    }

    @Test
    void multiply() {
        Calculator calculator = new Calculator();
        int result = calculator.multiply(1, 2);
        assertEquals(2, result);
    }

    @Test
    void multiplyNegative() {
        Calculator calculator = new Calculator();
        int result = calculator.multiply(-1, 2);
        assertEquals(-2, result);
    }

    @Test
    void multiplyZero() {
        Calculator calculator = new Calculator();
        int result = calculator.multiply(0, 2);
        assertEquals(0, result);
    }

    @Test
    void multiplyMax() {
        Calculator calculator = new Calculator();
        int result = calculator.multiply(100, 500);
        assertEquals(50000, result);
    }

    @Test
    void divide() {
        Calculator calculator = new Calculator();
        int result = calculator.divide(1, 2);
        assertEquals(0, result);
    }

    @Test
    void divideNegative() {
        Calculator calculator = new Calculator();
        int result = calculator.divide(-1, 2);
        assertEquals(0, result);
    }

    @Test
    void divideZero() {
        Calculator calculator = new Calculator();
        int result = calculator.divide(0, 2);
        assertEquals(0, result);
    }

    @Test
    void divideMax() {
        Calculator calculator = new Calculator();
        int result = calculator.divide(100000, 50000);
        assertEquals(2, result);
    }
}