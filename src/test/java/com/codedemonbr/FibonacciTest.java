package com.codedemonbr;

import org.junit.jupiter.api.Test;
import java.math.BigInteger;
import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    void testFibZero() {
        // fib(0) deve ser 0
        assertEquals(BigInteger.ZERO, Fibonacci.fib(BigInteger.ZERO));
    }

    @Test
    void testFibOne() {
        // fib(1) deve ser 1
        assertEquals(BigInteger.ONE, Fibonacci.fib(BigInteger.ONE));
    }

    @Test
    void testFibTwo() {
        // fib(2) = fib(1) + fib(0) = 1 + 0 = 1
        assertEquals(BigInteger.ONE, Fibonacci.fib(BigInteger.valueOf(2)));
    }

    @Test
    void testFibThree() {
        // fib(3) = fib(2) + fib(1) = 1 + 1 = 2
        assertEquals(BigInteger.valueOf(2), Fibonacci.fib(BigInteger.valueOf(3)));
    }

    @Test
    void testFibTen() {
        // fib(10) = 55
        assertEquals(BigInteger.valueOf(55), Fibonacci.fib(BigInteger.valueOf(10)));
    }

    @Test
    void testFibTwenty() {
        // fib(20) = 6765
        assertEquals(BigInteger.valueOf(6765), Fibonacci.fib(BigInteger.valueOf(20)));
    }

    @Test
    void testFibNegativeOne() {
        // fib(-1) deve seguir a regra: (-1)^(2) * fib(1) = 1 * 1 = 1
        assertEquals(BigInteger.ONE, Fibonacci.fib(BigInteger.valueOf(-1)));
    }

    @Test
    void testFibNegativeTwo() {
        // fib(-2): (-1)^(3) * fib(2) = -1 * 1 = -1
        assertEquals(BigInteger.valueOf(-1), Fibonacci.fib(BigInteger.valueOf(-2)));
    }

    @Test
    void testFibNegativeThree() {
        // fib(-3): (-1)^(4) * fib(3) = 1 * 2 = 2
        assertEquals(BigInteger.valueOf(2), Fibonacci.fib(BigInteger.valueOf(-3)));
    }

    @Test
    void testFibNegativeFour() {
        // fib(-4): (-1)^(5) * fib(4) = -1 * 3 = -3
        assertEquals(BigInteger.valueOf(-3), Fibonacci.fib(BigInteger.valueOf(-4)));
    }

    @Test
    void testFibLargePositive() {
        // fib(100) - valor conhecido
        BigInteger expected = new BigInteger("354224848179261915075");
        assertEquals(expected, Fibonacci.fib(BigInteger.valueOf(100)));
    }

    @Test
    void testFibLargeNegative() {
        // fib(-100) deve ser igual a -fib(100) (pois 101 é ímpar)
        BigInteger fib100 = new BigInteger("354224848179261915075");
        assertEquals(fib100.negate(), Fibonacci.fib(BigInteger.valueOf(-100)));
    }

    @Test
    void testFibVeryLargeInput() {
        // Teste conceitual: verifica se o método aceita um valor grande sem lançar exceção.
        // O limite do kata é 2.000.000, que cabe em int, mas passamos como BigInteger.
        assertDoesNotThrow(() -> Fibonacci.fib(BigInteger.valueOf(2_000_000)));
    }
}